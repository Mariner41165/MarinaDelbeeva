package ru.training.at.hw9;

import static constants.Answers.INVALID_ID;
import static constants.Answers.INVALID_KEY;
import static core.TrelloServiceObject.badResponseSpecification;
import static core.TrelloServiceObject.getBoardFromResponse;
import static core.TrelloServiceObject.goodResponseSpecification;
import static core.TrelloServiceObject.requestBuilder;
import static core.TrelloServiceObject.unauthorizedSpecification;

import beans.Board;
import constants.ParameterName;
import core.DataProviders;
import core.TrelloServiceObject;
import io.restassured.http.Method;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import properties.TrelloTestProperties;
import ru.training.at.hw9.steps.BoardsSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class TrelloApiTests {
    TrelloTestProperties props = new TrelloTestProperties();
    Board board;
    String receivedAnswer;

    @Test (dataProvider = "trelloBoardDataProvider", dataProviderClass = DataProviders.class)
    public void createSimpleBoard(String boardName) {
        board = BoardsSteps.createBoard(boardName);

        assertThat("the board was successfully created", board,
            Matchers.hasProperty(ParameterName.BOARD_NAME, Matchers.is(board.getName())));
    }

    @Test
    public void createBoardWithoutParams() {
        receivedAnswer = (requestBuilder()
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(unauthorizedSpecification())
            .extract().response())
            .asPrettyString();

        assertThat(receivedAnswer, hasToString(INVALID_KEY));
    }

    @Test (dataProvider = "trelloBoardDataProvider", dataProviderClass = DataProviders.class)
    public void getExistingBoard(String boardName) {
        String existingBoardId = BoardsSteps.createBoard(boardName).getId();

        board = getBoardFromResponse(TrelloServiceObject.requestBuilder()
            .setParameters()
            .buildRequest()
            .sendRequestWithPathParameter(existingBoardId)
            .then().assertThat()
            .spec(goodResponseSpecification())
            .extract().response());
        assertThat("Board exists", board, hasProperty(ParameterName.ID, is(existingBoardId)));
    }

    @Test (dataProvider = "trelloBoardDataProvider", dataProviderClass = DataProviders.class)
    public void getBoardByNonexistentId(String id) {
        receivedAnswer = (requestBuilder()
            .setParameters()
            .buildRequest()
            .sendRequestWithPathParameter(id)
            .then().assertThat()
            .spec(badResponseSpecification())
            .extract().response())
            .asPrettyString();
        assertThat("There is no boards with provided id", receivedAnswer, hasToString(INVALID_ID));
    }

    @Test (dataProvider = "trelloBoardWithUpdatesDataProvider", dataProviderClass = DataProviders.class)
    public void updateExistingBoard(String initBoardName, String newBoardName) {
        String existingBoardId = BoardsSteps.createBoard(initBoardName).getId();

        board = getBoardFromResponse(requestBuilder()
            .setMethod(Method.PUT)
            .setName(newBoardName)
            .setParameters()
            .buildRequest()
            .sendRequestWithPathParameter(existingBoardId)
            .then().assertThat()
            .spec(TrelloServiceObject.goodResponseSpecification())
            .extract().response());

        assertThat(board, hasProperty(ParameterName.ID, is(existingBoardId)));
        assertThat(board, hasProperty(ParameterName.BOARD_NAME, is(newBoardName)));
    }

    @Test (dataProvider = "trelloBoardWithUpdatesDataProvider", dataProviderClass = DataProviders.class)
    public void updateNonexistentBoard(String boardId, String newBoardName) {
        receivedAnswer = (requestBuilder()
            .setMethod(Method.PUT)
            .setName(newBoardName)
            .setParameters()
            .buildRequest()
            .sendRequestWithPathParameter(boardId)
            .then().assertThat()
            .spec(TrelloServiceObject.badResponseSpecification())
            .extract().response())
            .asPrettyString();

        assertThat("the board does not exist", receivedAnswer, hasToString(INVALID_ID));;
    }

    @Test (dataProvider = "trelloBoardDataProvider", dataProviderClass = DataProviders.class)
    public void getBoardFullInformation(String name) {
        board = BoardsSteps.createBoard(name);

        Board receivedBoard = getBoardFromResponse(TrelloServiceObject
            .requestBuilder()
            .setParameters()
            .buildRequest()
            .sendRequestWithPathParameter(board.getId())
            .then().assertThat()
            .spec(goodResponseSpecification())
            .extract().response());
        assertThat(receivedBoard, is(board));
    }

    @Test (dataProvider = "trelloBoardDataProvider", dataProviderClass = DataProviders.class)
    public void deleteBoard(String boardName) {
        board = BoardsSteps.createBoard(boardName);

        receivedAnswer = BoardsSteps.deleteBoard(boardName, board.getId()).path("_value");

        assertThat("The board was successfully deleted", receivedAnswer, nullValue());
    }

    @Test (dataProvider = "trelloBoardWithUpdatesDataProvider", dataProviderClass = DataProviders.class)
    public void deleteNonexistentBoard(String boardName, String id) {
        board = BoardsSteps.createBoard(boardName);

        receivedAnswer = (BoardsSteps
            .deleteBoard(boardName, id)
            .then().assertThat()
            .spec(badResponseSpecification())
            .extract().response())
            .asPrettyString();

        assertThat("It is impossible to delete non existent board", receivedAnswer, hasToString(INVALID_ID));;
    }

    @Test (dataProvider = "getFieldOnBoard", dataProviderClass = DataProviders.class)
    public void getIdMemberCreator(String boardName, String field) {
        board = BoardsSteps.createBoard(boardName);

        receivedAnswer = requestBuilder()
            .setParameters()
            .buildRequest()
            .sendRequestWithTwoPathParams(board.getId(), field)
            .then().assertThat()
            .spec(goodResponseSpecification())
            .extract().response().path("_value");

        assertThat(receivedAnswer, equalTo(TrelloTestProperties.getId()));
    }

}

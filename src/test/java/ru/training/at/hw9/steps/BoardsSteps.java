package ru.training.at.hw9.steps;

import static core.TrelloServiceObject.getBoardFromResponse;
import static core.TrelloServiceObject.requestBuilder;

import beans.Board;
import core.TrelloServiceObject;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class BoardsSteps {

    public static Board createBoard(String boardName) {
        return getBoardFromResponse(requestBuilder()
            .setMethod(Method.POST)
            .setName(boardName)
            .setParameters()
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(TrelloServiceObject.goodResponseSpecification())
            .extract().response());
    }

    public static Response deleteBoard(String boardName, String id) {
        return requestBuilder()
            .setMethod(Method.DELETE)
            .setName(boardName)
            .setParameters()
            .buildRequest()
            .sendRequestWithBoardId(id);
    }

}

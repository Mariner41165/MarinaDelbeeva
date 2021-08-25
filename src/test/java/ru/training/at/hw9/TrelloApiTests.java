package ru.training.at.hw9;

import static core.TrelloServiceObject.getBoardFromResponse;
import static core.TrelloServiceObject.goodResponseSpecification;
import static core.TrelloServiceObject.requestBuilder;
import static io.restassured.RestAssured.given;

import beans.Board;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import lombok.var;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import properties.TrelloTestProperties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class TrelloApiTests {
    TrelloTestProperties props = new TrelloTestProperties();

    @Test
    public void getBoard() {
        var response = given()
            .baseUri(props.getTrelloUrl() + "/boards/" + TrelloTestProperties.getId())
            .contentType(ContentType.JSON)
            .when().get()
            .then().statusCode(200);
        response.log().body();
    }

    @Test /*(dataProviderClass = DataProviders.class,
           dataProvider = "createListDataProvider")*/
    public void createBoard() {
        String generatedBoardName = TrelloTestProperties.getBoardName() + (int) (Math.random() * 100);
        Board board = getBoardFromResponse(requestBuilder()
            .setMethod(Method.POST)
            .setParameters()
            .setName(generatedBoardName)
            .buildRequest()
            .sendRequest()
            .then().assertThat()
            .spec(goodResponseSpecification())
            .extract().response());

        assertThat("the board was successfully created", board.getName().equals(generatedBoardName));
        assertThat(board, Matchers.hasProperty("name", notNullValue()));
    }
}
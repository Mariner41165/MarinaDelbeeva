package core;

import properties.TrelloTestProperties;

import beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;

import static org.hamcrest.Matchers.lessThan;

public class TrelloServiceObject {
    public static final URI TRELLO_BOARD_URI = URI.create("https://api.trello.com/1/boards/");
    private Method requestMethod;
    private Map<String, String> parameters;

    private TrelloServiceObject(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setName(String name) {
            parameters.put("name", name);
            return this;
        }

        public ApiRequestBuilder setId(String id) {
            parameters.put("id", id);
            return this;
        }

        public ApiRequestBuilder setParameters() {
            parameters.put("key", TrelloTestProperties.getKey());
            parameters.put("token", TrelloTestProperties.getToken());
            return this;
        }

        public TrelloServiceObject buildRequest() {
            return new TrelloServiceObject(parameters, requestMethod);
        }
    }

    public Response sendRequest() {
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParams(parameters)
            .request(requestMethod, TRELLO_BOARD_URI)
            .prettyPeek();
    }

    public Response sendRequestWithPathParameter(String id) {
        return RestAssured
            .given(requestSpecification()).log().all()
            .pathParam("id", id)
            .queryParams(parameters)
            .request(requestMethod, TRELLO_BOARD_URI + "{id}")
            .prettyPeek();
    }

    public Response sendRequestWithTwoPathParams(String id, String field) {
        return RestAssured
            .given(requestSpecification()).log().all()
            .pathParam("id", id)
            .pathParam("field", field)
            .queryParams(parameters)
            .request(requestMethod, TRELLO_BOARD_URI + "{id}/{field}")
            .prettyPeek();
    }

    public static Board getBoardFromResponse (Response response) {
        Board myBoard = new Gson()
            .fromJson(response.asString().trim(), new TypeToken<Board>(){}.getType());
        return myBoard;
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .setBaseUri(TRELLO_BOARD_URI)
            .build();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    public static ResponseSpecification badResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
            .build();
    }

    public static ResponseSpecification unauthorizedSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_UNAUTHORIZED)
            .build();
    }

}

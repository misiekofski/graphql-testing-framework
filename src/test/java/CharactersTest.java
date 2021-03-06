import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class CharactersTest {
    @Test
    public void should_return_list_of_characters() {
        String requestBody = null;

        try {
            requestBody = GraphqlParser.parseFileWithParams("characters.graphql", null);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(requestBody);

        given()
                .header("Content-Type","application/json")
                .body(requestBody)
                .when()
                .post("https://rickandmortyapi.com/graphql")
                .prettyPrint();
    }
}

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class CharactersTest {
    @Test
    public void should_return_list_of_characters() {
        String requestBody = GraphqlParser.parseFile("characters.graphql");
        System.out.println(requestBody);

        given()
                .header("Content-Type","application/json")
                .body(requestBody)
                .when()
                .post("https://rickandmortyapi.com/graphql")
                .prettyPrint();
    }
}

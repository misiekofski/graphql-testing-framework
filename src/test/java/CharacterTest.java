import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CharacterTest {
    @Test
    public void should_return_details_of_characters() {
        String requestBody = null;
        Map<String, String> variables = new HashMap<>();
        variables.put("id", "2");

        try {
            requestBody = GraphqlParser.parseFileWithParams("character.graphql", variables);
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

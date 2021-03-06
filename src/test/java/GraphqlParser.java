import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GraphqlParser {
    // prevent instantiating GraphQl
    private GraphqlParser() {
    }

    //TODO: Allow user not to pass params as null, without overloading this method
    public static String parseFileWithParams(String fileName, Map<String, String> params) throws JsonProcessingException {
        String query;
        ObjectMapper mapper = new ObjectMapper();

        Path filePath = Paths.get("src", "test", "resources", fileName);
        try {
            query = Files.readString(filePath);
        } catch (Exception e) {
            System.out.println("GraphQL file not found by name:" + fileName);
            return null;
        }

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("query", query);

       if (params != null) {
            queryMap.put("variables", mapper.writeValueAsString(params));
        }

        return mapper.writeValueAsString(queryMap);
    }
}

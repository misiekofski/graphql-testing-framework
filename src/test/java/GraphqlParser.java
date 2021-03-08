import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphqlParser {
    // prevent instantiating GraphQl
    private GraphqlParser() {
    }

    public static String parseFile(String fileName) throws JsonProcessingException {
        return parseFileWithParams(fileName, null);
    }

    public static <K, V> String parseFileWithParams(String fileName, Map<K, V> params) throws JsonProcessingException {
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

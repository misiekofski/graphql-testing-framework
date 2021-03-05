import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GraphqlParser {
    private GraphqlParser() {
    }

    public static String parseFile(String fileName) {
        try {
            Path filePath = Paths.get("src", "test", "resources", fileName);
            String query = Files.readString(filePath);
            Map<String, String> queryMap = new HashMap<>();
            queryMap.put("query", query);

            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(queryMap);
        } catch (Exception e) {
            System.out.println("GraphQL file not found by name:" + fileName);
            Assert.fail();
            return null;
        }
    }

    public static String parseFileWithParams(String fileName, String... params) {
        return "";
    }
}

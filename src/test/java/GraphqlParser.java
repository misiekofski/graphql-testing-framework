import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GraphqlParser {
    private GraphqlParser() {
    }

    public static String parseFile(String fileName) {
        try {
            Path filePath = Paths.get("src", "test", "resources", fileName);
            String result = Files.readString(filePath).replace("\n", "\\n");
            result = result + ", \"variables\":{}}";
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TrelloTestProperties {
    private static final Properties properties = new Properties();
    private static final File file = new File("src/test/resources/Config.properties");

    static {
        try (InputStream input = new FileInputStream(file)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read property file");
        }
    }

    public static String getKey() {
        return properties.getProperty("key");
    }

    public static String getToken() {
        return properties.getProperty("token");
    }

    public static String getId() {
        return properties.getProperty("id");
    }

}
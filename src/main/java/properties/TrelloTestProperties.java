package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TrelloTestProperties {
    private static final Properties PROPERTIES = new Properties();
    private static final File FILE = new File("src/test/resources/Config.properties");

    static {
        try (InputStream input = new FileInputStream(FILE)) {
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read property file");
        }
    }

    public static String getKey() {
        return PROPERTIES.getProperty("key");
    }

    public static String getToken() {
        return PROPERTIES.getProperty("token");
    }

    public static String getId() {
        return PROPERTIES.getProperty("id");
    }

}
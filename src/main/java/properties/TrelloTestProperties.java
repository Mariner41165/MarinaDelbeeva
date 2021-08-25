package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TrelloTestProperties {
    private static final Properties properties = new Properties();
    private static final File file = new File("src/test/resources/Config.properties");

    public TrelloTestProperties() {
        InputStream input = null;
        try {
            input = new FileInputStream(file);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getKey() {
        return properties.getProperty("key");
    }

    public static String getToken() {
        return properties.getProperty("token");
    }

    public String getTrelloUrl() {
        return properties.getProperty("trellourl");
    }

    public static String getId() {
        return properties.getProperty("id");
    }

    public static String getBoardName() {
        return properties.getProperty("boardName");
    }

}
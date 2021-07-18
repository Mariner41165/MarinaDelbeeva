package ru.training.at.hw7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
    private static final Properties properties = new Properties();
    private static final File file = new File("src/test/resources/Config.properties");

    public PropertiesFile() {
        try {
            InputStream input = new FileInputStream(file);
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getName() {
        return properties.getProperty("name");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getJsonFile() { return properties.getProperty("jsonFile"); }
}

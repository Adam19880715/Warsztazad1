package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String url() {
        return readProperty(readPropertyFile()).getProperty("test.app.url");
    }

    public static String login() {
        return readProperty(readPropertyFile()).getProperty("test.user.login");
    }

    public static String password() {
        return readProperty(readPropertyFile()).getProperty("test.user.password");
    }

    public static String firstName() {
        return readProperty(readPropertyFile()).getProperty("test.user.firstName");
    }

    public static String lastName() {
        return readProperty(readPropertyFile()).getProperty("test.user.lastName");
    }

    public static String screenShotsPath() {
        return readProperty(readPropertyFile()).getProperty("screen.shots.path");
    }

    private static FileReader readPropertyFile() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/test/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileReader;
    }

    private static Properties readProperty(FileReader fileReader) {
        Properties properties = new Properties();
        try {
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}

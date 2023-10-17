package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static FileInputStream fileInputStream;
    static Properties properties;
    public static Properties readData(){
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/global.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}

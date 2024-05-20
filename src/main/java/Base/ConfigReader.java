package Base;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

        private static Properties properties = new Properties();

        static {
            try (FileInputStream fileInputStream = new FileInputStream("src/main/java/config/config.properties")) {
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String get(String key) {
            return properties.getProperty(key);
        }
    }



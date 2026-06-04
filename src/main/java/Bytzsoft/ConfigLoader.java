package Bytzsoft;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private Properties urls;
    private Properties config;

    public ConfigLoader() {
        urls = new Properties();
        config = new Properties();

        try {
            // Load URLs from urls.properties
            FileInputStream fisUrls = new FileInputStream("src/main/resources/urls.properties");
            urls.load(fisUrls);
            fisUrls.close();

            // Load username/password from config.properties
            FileInputStream fisConfig = new FileInputStream("src/main/resources/config.properties");
            config.load(fisConfig);
            fisConfig.close();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties files.");
        }
    }

    // Returns array of client URLs (split by comma)
    public String[] getClientUrls() {
        String urlList = urls.getProperty("client.urls");
        if (urlList == null) {
            throw new RuntimeException("client.urls not specified in urls.properties");
        }
        return urlList.split(",");
    }

    // Returns username from config.properties
    public String getUsername() {
        String username = config.getProperty("username");
        if (username == null) {
            throw new RuntimeException("username not specified in config.properties");
        }
        return username;
    }

    // Returns password from config.properties
    public String getPassword() {
        String password = config.getProperty("password");
        if (password == null) {
            throw new RuntimeException("password not specified in config.properties");
        }
        return password;
    }
}
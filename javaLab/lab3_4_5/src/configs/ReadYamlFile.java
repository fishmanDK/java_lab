package configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadYamlFile {
    public static Properties Read() {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/configs/config.yaml");
            props.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
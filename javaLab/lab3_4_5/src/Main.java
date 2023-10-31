import configs.ReadYamlFile;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Main {
    public static void main(String[] args) throws IOException {

        ReadYamlFile reader = new ReadYamlFile();
        Properties cfg = reader.Read();

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;



        fh = new FileHandler("src/logs.log", true);
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        Level level;
        String lev = cfg.getProperty("env");
//        String lev = "prod";
        level = switch (lev) {
            case "info" -> Level.INFO;
            case "prod" -> Level.SEVERE;
            default -> Level.INFO;
        };

        String autoTest = cfg.getProperty("autoTests");

        Menu menu = new Menu(logger, level, autoTest);
        menu.Start();

    }
}
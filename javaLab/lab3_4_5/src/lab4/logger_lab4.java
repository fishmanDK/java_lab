package lab4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class logger_lab4 {
    Logger logger;
    Level level;
    public logger_lab4(Logger logger, Level level){
        this.logger = logger;
        this.level = level;
    }

    public void log(String str){
        this.logger.log(this.level, str);
    }
}

package helpers;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/*
     Класс логгирования
     о настройке логгов log4j2 в этой статье http://javastudy.ru/log4j/log4j-hello-world-example/

 */
public class TestLogger {

    private static final Logger log = LogManager.getLogger(TestLogger.class);
    public static Logger getLog() {
        return log;
    }
}

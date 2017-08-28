package helpers;

import java.util.logging.Logger;

import static java.lang.String.valueOf;

/*
     Класс логгирования
     о настройке логгов в этой статье http://artamonov.ru/2007/04/06/vvedenie-v-log4j/
 */
public class TestLogger {

    private static final Logger log = Logger.getLogger(valueOf(TestLogger.class));

    public static Logger getLog() {
        return log;
    }
}

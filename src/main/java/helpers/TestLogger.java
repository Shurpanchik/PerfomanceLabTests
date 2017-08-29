package helpers;


import org.apache.log4j.Logger;

/*
     Класс логгирования
     о настройке логгов в этой статье http://artamonov.ru/2007/04/06/vvedenie-v-log4j/
 */
public class TestLogger {

    private static final Logger log = Logger.getLogger(TestLogger.class);

    public static Logger getLog() {
        return log;
    }
}

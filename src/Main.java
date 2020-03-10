/* У нас есть логгеры, у которых могут быть несколько уровней, хендлеры, можем вывыодит в консоль, файл и т.д., использовать фильтры  */

import java.io.IOException;
import java.util.logging.*;

public class Main {
    // лог с указанием имени класса
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        // можно добавлять хендлеры (обработчики я так понял)
        // для сохранения
        Handler consoleHandler = new ConsoleHandler();
        // cохранение в файл с указанием паттерна
        // Handler fileHandler = new FileHandler("%h/myJavaLog.log");
        // это фильтр
        consoleHandler.setFilter(new MyFilter());
        // а это форматирование
        consoleHandler.setFormatter(new MyFormatter());
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
        logger.info("info");
        logger.info("info max");
    }

    static class MyFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("max");
        }
    }

    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + ": " + record.getMessage();
        }
    }
}

/* Сохранение глобальных параметров настройки приложений
Пользователи приложений обычно ожидают,что предпочитаемые ими настройки глобальных параметров будут сохранены, а припоследующем запуске приложения восстановлены */


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TablesProperies {
    public static void main(String[] args) throws IOException {

        /* Все значениея, устанавливаемые по умолчанию можно вывести в спомогательную таблицу свойств и переедать ее конструктору основной таблицы свойств */
        Properties defaultSettings = new Properties();
        defaultSettings.put("width", "300");
        defaultSettings.put("height", "200");
        defaultSettings.put("title", "Default title");

        // Таблица свойств представляет собой структуру данных, в которой хранятся пары "ключ-значение".
        Properties settings = new Properties(defaultSettings);
        settings.put("width", "200");
        settings.put("title", "Hello, World!");
        // Для записи списка свойств в файл служит метод store().
        FileOutputStream out = new FileOutputStream("program.properties");
        settings.store(out, "Program Properties");

        // Для загрузки этих свойств из файла служит приведенный ниж ефрагмент кода.
        Properties getSettings = new Properties();
        // FileInputStream in = new FileInputStream("my.properites");
        // getSettings.load(in);

        /* Обычно свойства программы принятo осохранять в подкаталоге начального каталога пользователя
        Имя такого каталога зачастую начинается с точки — в систем еUNIX это соглашение указывает на системный каталог, скрытый от пользователя */
        String userDir = System.getProperty("user.home");  // начальный каталог
        System.out.println(userDir);

        /* Указание значение по умолчанию, в случае отсутствия соотвтетсвующего клуюча */
        String title = settings.getProperty("title", "Default title");


    }
}

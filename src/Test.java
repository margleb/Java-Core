import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws IOException {

        // экз. properies по умолчанию
        Properties defaultProperty = new Properties();
        // устанавлием значение по умолчанию
        defaultProperty.setProperty("check", "my default");

        //  экз. properties, передаем defaultProperties в качестве значения по умолчанию
        Properties properties = new Properties();
        // устанавливаем значение
        properties.setProperty("One", "1");
        // получаем значение в sysout
        System.out.println(properties.getProperty("One"));

        // создаем новый файл FileOutputStream и сохраняем его
        FileOutputStream out = new FileOutputStream("my.properites");
        properties.store(out, "MyStore");

        // получаем значение файла FileInputStream
        Properties properties1 = new Properties(defaultProperty);
        FileInputStream in = new FileInputStream("my.properites");
        properties1.load(in);
        // получаем несуществующее значение (cмотрим, работает ли default)
        System.out.println(properties1.getProperty("check"));

    }
}

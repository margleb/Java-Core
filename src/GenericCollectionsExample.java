/* Generics используются только на этапе компиляции, после компиляции подставляется стандартные типы данных */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenericCollectionsExample {

    void method(List list) {
        list.add(new Main());
    }

    public static void main(String[] args) throws Exception {

        /* не параметизированый список ( не рекомендуется) */
        // List list2 = new ArrayList();
        // list2.add("");
        // list2.add(new Object());
        // list2.add(new File(""));
        // возникнут проблемы, так как разные типы данных в списке
        // for(Object o: list2) {
            // File f = (File) o;
        // }

        /* параметизированый список */
        // List<File> list = new ArrayList<>();
        // list.add("String"); // допускается добавление только файлов
        // list.add(new File(""));
        // list.add(new File(""));
        // list.add(new File(""));
        // for(File f: list) {
            // File file = f;
        // }

        List<File> list = new ArrayList<>();
        new GenericCollectionsExample().method(list);

        for(File file: list) {
            /* Из за пропущенного Generic File, мы случайно добавили Main вместо file, из за этого возникла ошибка */
            // System.out.println(file.getAbsoluteFile());
        }
    }

}

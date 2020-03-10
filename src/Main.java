import example.Example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class Main {
    public static void main(String[] args) throws IOException, BackingStoreException {
        // Поиск требуемого узла в дереве начинается с пользовательского или системного корня
        // Preferences root = Preferences.systemRoot();
        Preferences user = Preferences.userRoot();
        // положить ключ значение
        user.put("key", "value");
        // при получении значения можно указать дефолтное значение
        System.out.println(user.get("key", "default value"));
        // для достуа к узлу достаточно указать соответствующий путь
        Preferences node = user.node("myPackage");
        // данные в хранилище можно записать используя методы
        node.put("one", "1");
        // получить доступ к узлу можжно обратившись к таблице с парами "ключ-значение"
        System.out.println(node.getInt("one", 2));
        // Для быстрого и удобного доступа к узлу дерева путь к нему приравнивается к имени пакета его класса
        // Preferences systemPackage = Preferences.systemNodeForPackage(Example.class);
        Preferences userPackage = Preferences.userNodeForPackage(Example.class);
        // Данные можно экспортировать в поддерево, а в некторых случая в отдельны узел, вызвав один из приведенных ниже методов
        user.exportSubtree(new FileOutputStream("myProperies.xml"));
    }
}

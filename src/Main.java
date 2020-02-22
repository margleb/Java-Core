import java.util.*;

public class Main {
    public static void main(String[] args) {
        // хранит обьекты на основании хеша
        Map hasMap = new HashMap();
        hasMap.put("1", "one");
        hasMap.put("3", "three");
        hasMap.put("2", "two");
        System.out.println(hasMap.get("1"));

        System.out.println();

        // все методы синхронизированы
        Map hashtable = new Hashtable();
        // упорядочный список
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("1", "one");
        linkedHashMap.put("3", "three");
        linkedHashMap.put("2", "two");
        Set set = linkedHashMap.entrySet();
        for(Object obj: set) {
            System.out.println(obj);
        }

        System.out.println();

        // отсортированный список
        // Red-Black алгоритм сортировки (погуглить)
        Map treeMap = new TreeMap();
        treeMap.put("1", "one");
        treeMap.put("3", "three");
        treeMap.put("2", "two");
        Set set1 = treeMap.entrySet();
        for(Object obj: set1) {
            System.out.println(obj);
        }
    }
}
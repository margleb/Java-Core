import java.util.*;

public class Main {
    public static void main(String[] args) {
        // не упорядочная
        Set set = new HashSet();
        // упорядочная
        Set set2 = new LinkedHashSet();
        // сортированая
        Set set3 = new TreeSet();
        set.add("1");
        set.add("2");
        set.add("2");
        set.add("1");
        for(Object obj: set) {
            System.out.println(0);
        }
    }
}
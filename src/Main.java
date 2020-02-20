import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    private int age;

    Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person obj) {
        return this.age - obj.age;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{age = " + age + "}";
    }

}

// В случае, если мы не можем импламентировать интерфейс Comparable
// Например, если у нас класс Person недоступен, т.к. он является бибилиотекой
// То мы можем использовать интерфейс Comparator
class СomparePerson implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    };
}


public class Main {
    public static void main(String[] args) {
        // ComparableInterface();
        ComaparatorInterface();

    }

    public static void ComparableInterface() {
        // Уже импламентирует интерфейс Comparable
        // Integer integer;
        Set set = new TreeSet();
        set.add(new Person(4));
        set.add(new Person(6));
        set.add(new Person(4));
        set.add(new Person(2));
        set.add(new Person(3));
        for(Object obj: set) {
            System.out.println(obj);
        }
    }

    public static void ComaparatorInterface() {
        СomparePerson comparePerson = new СomparePerson();
        Set set = new TreeSet(comparePerson);
        set.add(new Person(4));
        set.add(new Person(6));
        set.add(new Person(4));
        set.add(new Person(2));
        set.add(new Person(3));
        for(Object obj: set) {
            System.out.println(obj);
        }
    }
};

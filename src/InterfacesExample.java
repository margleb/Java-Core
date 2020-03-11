public class InterfacesExample {
    public static void main(String[] args) {

    }
}

interface Rozetka {
    int getVolts();
}

// интерфейсы
interface Animal {
    // публичное статическое
    enum E {

    }

    interface MyInnerInterface {
        int i = 5;
        void eat();
    }

    // допускается добавление класса
    class MyInnerClass {

    }

    // public static final
    int i = 5;
    // public abstract
    void eat();
}

interface Cat extends Animal {

    void move();
}


class Tiger implements Animal, Cat {
    @Override
    public void eat() {

    }
    @Override
    public void move() {

    }
}

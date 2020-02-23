class Popcorn {
    void doSomething() {
        System.out.println("popcorn");
    }
    void secondMethod() {
        System.out.println("second");
    }
};

public class Main {
    public static void main(String[] args) {
        // #1
        // создается анонимный класс, расширяемый Popcorn()
        Popcorn popcorn = new Popcorn() {
            void doSomething() {
                System.out.println("main");
            }
        };
        popcorn.doSomething();
        popcorn.secondMethod();

        // #2
        // С помочью анонимных классов можно переопределить метод Comparable
        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
        comparable.compareTo(new Object());

        // #3
        // Анонимный класс в качестве аргумента
        method(new Popcorn() {
           void doSomething() {
            System.out.println("Ананимный класс работает");
           }
        });

    }
    static void method(Popcorn popcorn) {
        popcorn.doSomething();
    }
}
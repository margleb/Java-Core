/*
Существуют статические и внутренние классы
Обычные (inner) классы имеют доступ до всех полей (даже приватных)
Cтатические внутренние классы
Локальные классы (внутренние классы на уровне методов)
 */

public class Main {

    private int i = 5;
    static int q = 5;

    static class StaticClass {
        static void methodStatic() {
            // статические классы не имеют доступа до полей
            // System.out.println(i);
            System.out.println(q);
        }
    }

    public static void main(String[] args) {
        // #1
        // Inner inner = new Inner();
        Main main = new Main();
        main.innerInit();

        // #2
        // пример создания экз. внутреннего класса
        Inner inner = main.new Inner();
        inner.innerMethod();

        // #3
        StaticClass.methodStatic();

        // #4
        new Main().methodWithClass();

    }

    void innerInit() {
        // Не может быть вызван в статическом контексте
        Inner inner = new Inner();
        inner.innerMethod();
        // локальная переменная класса Inner
        System.out.println(inner.k);
    }

    void methodWithClass() {
        // перед классом я не могу создать экземпляр
        // я также не могу его возращать из метода
        // NewInner newInner = new NewInner();
        class NewInner {
            void newMethod() {
                System.out.println("Hi!");
            }
        }
        NewInner newInner = new NewInner();
        newInner.newMethod();
    }

    class Inner {
        private int k = 6;
        void innerMethod() {
            // имеет доступ до до поля i (даже приватного)
            System.out.println(i);
            System.out.println(q);
        }
    }
}

class OuterClass {
    void method() {
        // #3 Пример создания из внешнего класса экз.класса inner
        Main.Inner inner  = new Main().new Inner();
        inner.innerMethod();
    }
}
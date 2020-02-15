/* Статический класс может рабтать только со статическими полями */

public class StaticExample {
    int j;
    static int i = 5;
    // cтатическое поле инициализации
    static {
        i = 6;
        System.out.println("static initializer");
    }
    // инициализаторы
    {
        System.out.println("initializer 1");
    }
    {
        System.out.println("initializer 2");
    }
    // конструктор
    StaticExample() {
        i++;
        System.out.println("Constructor");
    }

    static void staticMethod() {
        i = 7;
        System.out.println("static method");
        // статический класс может работать только с статическими полями
        // System.out.println(i);
        // System.out.println(j);
    }

    public static void main(String[] args) {
        // StaticExample staticExample1 = new StaticExample();
        // StaticExample staticExample2 = new StaticExample();

        // экземпляры
        // staticExample1.j = 1;
        // staticExample2.j = 2;
        // System.out.println(staticExample1.j);
        // System.out.println(staticExample2.j);
        // System.out.println();

        // классовая переменная (везде 2)
        // staticExample1.i = 1;
        // staticExample2.i = 2;
        // System.out.println(staticExample1.j);
        //System.out.println(staticExample2.j);

        // К классовым переменным лучше обращаться через класс
        // System.out.println(StaticExample.i);
        // StaticExample.staticMethod();
        /* При вызове, сначала инициализируется статический инициализиатор,
        затем выводится значение полe */
        // System.out.println(StaticExample.i);
        /* При вызове, сначала инициализируется статический инициализиатор,
        затем инициализаторы, и в конце конструктор */
        new StaticExample();
    }
}



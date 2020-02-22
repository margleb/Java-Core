/*
Обобщения или generics (обобщенные типы и методы) позволяют нам уйти от жесткого определения используемых типов.
Generics применяются в о сновном в коллекциях, дабы избежать случайного добавления в список не того типа данных
*/

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        // #1
        // main.<String>GenericExampleMethodOne("123");
        // main.GenericExampleMethodOne(123);
        // main.GenericExampleMethodOne(new Main());

        // #2
        // main.GenericExampleMethodTwo("123", 123, new Object());
    }

    // обобщенный метод, работает с любыми типами
    <A> A GenericExampleMethodOne (A type) {
        System.out.println(type);
        return type;
    }

    // обобщенный метод, c передачей нескольких типов
    <B, C, D> void GenericExampleMethodTwo(B t, C u, D k) {
        System.out.println(t);
        System.out.println(u);
        System.out.println(k);
    }
}
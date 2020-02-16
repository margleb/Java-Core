/*
Статические инициализаторы запускаются при первом обращении классу
Обычные инциализаторы при создании какого либо экземпляра и после SUPER()!

Этапы вызова:
1. Статический блок инициализации
2. Конструктор род.класса (super)
3. Блоки инициализации
4. Конструктор
*/

class Parent {
    static {
        System.out.println("static parent block");
    }
    Parent() {
        System.out.println("parent constructor");
    }
}

public class InitExample extends Parent {
    static {
        System.out.println("static init block 1");
    }
    {
        System.out.println("init block 1");
    }
    {
        System.out.println("init block 2");
    }
    InitExample() {
        // super();
        System.out.println("constructor");
    }
    public static void main(String[] args) {
        new InitExample();
    }
    {
        System.out.println("init block 3");
    }
    static {
        System.out.println("static init block 2");
    }
}





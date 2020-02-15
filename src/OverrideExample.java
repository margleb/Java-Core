/*
При перезаписывании метода, можно расщирить его модификатор доступа по области видимости, но не сузить ее
Некоторые модификтары при переопределении не имеет никакого значения, например synchronized и strictfp
В перезаписываемом методе возможно указание final
Полиморфизм не работает для статических методов
Допускается указывать в качестве типа дочений класс
Допускается переопределение Exceptions, расширение не допустимо!
*/

class Parent {

    int parent;

    protected void methodOne() {
        System.out.println("Исходный");
    }

    synchronized int method() {
        return 1;
    }

    public void methodWidthFinal() {
        System.out.println("Без final");
    }

    static void staticMethod() {
        System.out.println("Метод из родительского класса");
    }

    Parent getObject()  throws Exception {
        return new Parent();
    }

}

class Child extends Parent {
    // допускается только расширение модификаторами доступа!
    @Override
    public void methodOne() {
        System.out.println("Перезаписанный");
    }
    // некоторые модификаторы не имеют значения
    @Override
    strictfp int method() {
        return 2;
    }
    // В перезаписываемом методе возможно указание final
    @Override
    public final void methodWidthFinal() {
        System.out.println("C final");
    }
    // Полиморфизм не работает для статических методов
    // @Override
    static void staticMethod() {
        System.out.println("Метод из дочернего класса");
    }

    // Допускается указывать в качестве типа дочений класс
    // Допускается переопределение Exceptions, расширение не допустимо!
    @Override
    Child getObject() throws RuntimeException {
        return new Child();
    }
}

public class OverrideExample {
    public static void main(String[] args) throws Exception {
        Parent parent = new Parent();
        Parent child = new Child();

        // методы родителя
        parent.methodOne();
        System.out.println(parent.method());
        parent.methodWidthFinal();
        parent.staticMethod();
        System.out.println(parent.getObject());

        System.out.println();

        // методы потомка
        child.methodOne();
        System.out.println(child.method());
        child.methodWidthFinal();
        child.staticMethod();
        System.out.println(child.getObject());

    }
}



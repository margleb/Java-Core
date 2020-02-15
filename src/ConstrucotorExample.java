/*
Конструтор всегда есть по умолчания, наследуется из суперкласса Object
Нет возращаемых значений
Коснструкторов может быть несколько
*/

public class ConstrucotorExample {
    int i;
    // конструктор 1
    ConstrucotorExample() {
        this.i = 5;
        System.out.println("Constructor №1");
    }
    // конструктор 2
    ConstrucotorExample(String constTwo) {
        System.out.println(constTwo);
    }
    // конструктор 3
    ConstrucotorExample(String constTree, int i) {
        this.i = i;
        System.out.println(constTree);
    }

    // метод
    void methodLikeConstructor(String hello, int i) {
        this.i = i;
        System.out.println(hello + ", " + i);
    }
}

class Run {
    public static void main(String[] run) {
        // конструктор 1
        ConstrucotorExample constructorExample1 = new ConstrucotorExample();
        // конструктор 2
        ConstrucotorExample constructorExample2 = new ConstrucotorExample("Constructor №2");
        // конструтор 3
        ConstrucotorExample constructorExample3 = new ConstrucotorExample("Constructor №3", 5);
        constructorExample3.methodLikeConstructor("Method Like Constructor!", 5);
        // System.out.println(constructorExample3.i);
    }
}
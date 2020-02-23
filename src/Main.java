/*
Cуществует два вида клонирования:
1. Поверхностное - копирует примитивные типы данных
2. Глубокое - требует копирование всех ссылочных обьектов

 */

public class Main {
    public static void main(String[] args) throws Exception {
        MyObject1 myObject1 = new MyObject1();
        myObject1.a = 1;
        MyObject2 myObject2 = new MyObject2();
        myObject2.b = 3;

        myObject1.LinkToMyObject2 = myObject2;
        // MyObject1 copyMyObject1 = myObject1;
        // создается новый обьект и копируется
        MyObject1 copyMyObject1 = myObject1.clone();

        copyMyObject1.a = 2;
        System.out.println(myObject1.a);
        copyMyObject1.LinkToMyObject2.b = 4;
        System.out.println(myObject1.LinkToMyObject2.b);
    }
}

// указываем маркерный интерфейс Clonable
class MyObject1 implements Cloneable {
    int a;
    MyObject2 LinkToMyObject2;

    @Override
    protected MyObject1 clone() throws CloneNotSupportedException {
        // return (MyObject1) super.clone();
        MyObject1 myObject1 = (MyObject1) super.clone();
        myObject1.LinkToMyObject2 = LinkToMyObject2.clone();
        return myObject1;
    }
}

class MyObject2 implements Cloneable {
    int b;
    @Override
    protected MyObject2 clone() throws CloneNotSupportedException {
        return (MyObject2) super.clone();
    }
}
/*
1. Generics не могут быть статическими
2. Мы не можем создавать массивы из generics
3. В списках определенного типа, должен быть только этот тип
 */

import java.util.ArrayList;
import java.util.List;

class Parent <T> {
    // # 1
    // не допускается создание generic cтатических полей
    // static T t;
}
class Child1 extends Parent {}
class Child2 extends Parent {}
class Child3 extends Child2 {}

public class GenericLimitations {
    public static void main(String[] args) {
        // # 1
        // тип generics должен быть одинаковым
        // List<Child1> list = new ArrayList<Parent>();
        // не допускается создание массивов
        //  List<Child1>[] genericArr = new ArrayList<Child1>

        // #2
        // List<Parent> list2 = new ArrayList<Parent>();
        // допускается полиморфическое добавление
        // list2.add(new Parent());
        // list2.add(new Child1());
        // for (Parent parent: list2) {
            // System.out.println(parent);
        // }

        // #3
        // List<Child1> list3 = new ArrayList<Child1>();
        // new GenericLimitations().method1(list3);

        // #4
        // List<GenericLimitations> list4 = new ArrayList<>();
        // list4.add(new GenericLimitations());
        // new GenericLimitations().method2(list4);

        // #5
        List<Parent> list5 = new ArrayList<>();
        list5.add(new Parent());
        // Ошибка, так как принемается только обьекты по иерархии выше
        new GenericLimitations().method3(list5);

    }

    // #3
    // мы можем сюда передать List любого класса, который наследуется от Parent
    // идет ВНИЗ по иерархии
    void method1(List<? extends Parent> list) {
        for(Parent parent: list) {
            System.out.println(parent);
        }
        // при сигнатуре List<? extends Parent>, мы не можем добавлять новые элементы в список
        // list.add(new Child2());
    }

    // #4
    // мы можем передать список любых обьектов, унаследованных от object
    void method2(List<?> list) {
        for(Object obj: list) {
            System.out.println(obj);
        }
    }

    // #5
    // мы можем передать любой обьект, который находится ВЫШЕ иерархии Child2 класса
    // идет ВВЕРХ по иерархии
    void method3(List<? super Child2> list) {
        // допускается передача только nип суперкласса Object
        for(Object obj: list) {
            // можно сделать кастинг для преобразования к Parent
            System.out.println((Parent) obj);
        }
        // допускается добавление обьектов, которые НИЖЕ Сhild2
        list.add(new Child3());
    }

}

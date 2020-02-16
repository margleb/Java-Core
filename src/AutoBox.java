/*
== → является ссылочным сравнением, то есть оба объекта указывают на одно и то же место памяти
Obj.equals(Obj o) → оценивает сравнение значений в объектах

Если у нас значения до 128, то значения будут положены в пул integer, если больше 128 то в разные участки памяти

 */

import java.util.ArrayList;
import java.util.List;

public class AutoBox {
    public static void main(String[] args) {
        int i;
        byte b;
        short l;
        boolean bl;
        char ch;
        float f;
        double d;

        // обертки
        Byte bt;
        Short sh;
        Integer integer;
        Long lng;
        Boolean bool;
        Character сhr;
        Float fl;
        Double dbl;

        // обертки используются для создания списков
        List<Integer> list;

        // обертки используются для преобразования сторок в значения типа int
        // Метод возвращает ОБЬЕКТ Integer, содержащий значение, представленное строковым аргументом.
        Integer intObject = Integer.valueOf("5");
        // Мета возращает ПРИМИТИВНЫЙ ТИП данных int, содержащий значение, представленное строковым аргументом.
        int intPrimitive = Integer.parseInt("6");
        // Конвертация из int в другой примитив данных
        short s = intObject.shortValue();
        double db = intObject.doubleValue();

        // Автобоксинг
        Integer intBox = 5;
        // Integer intBox = Integer.valueOf("3");
        intBox++;
        // int tempVar = intBox.intValue();
        // tempVar++;
        // intBox = Integer.valueOf(tempVar);
        System.out.println(intBox);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        for(int k: list2) {
            System.out.println(k);
        }

        // Cравнение

        String s1 = "String";
        // String s2 = "String";
        String s2 = new String("String");
        if(s1 == s2) {
            // если стороки одинаковые, то они будут положены в одно и то же место в памяти!
            System.out.println("String один и тот же обьект, они хранятся в пуле!");
        }
        Object o1 = new Object();
        Object o2 = new Object();
        //
        if(o1.equals(o2)) {
            System.out.println("Object и тот же обьект!");
        }


        Integer int3 = 5;
        // Integer j = 5;
        Integer j = new Integer(5);

        if(int3.equals(j)) {
            System.out.println("Интегер значения эквивалентны");
        }
        if(int3 == j) {
            System.out.println("Они лежат в одном участке памятия (одинаковый адрес)");
        }

    }

    // благодаря обертки вернет Integer обьект со значением 1
    Object method() {
        return 1;
    }
}


import reflection.MyClass;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args)  throws Exception {
        MyClass myClass = new MyClass();
        // Способы получения доступа до класса
        Class class1 = myClass.getClass();
        // Class class2 = MyClass.class;
        // Class class3 = Class.forName("reflection.MyClass");

        // Получаем экземпляр класса (если например приватный конструтор)
        MyClass someClass1 = (MyClass) class1.newInstance();
        // получаем имя класса
        System.out.println("Имя класса: " + class1.getName() + "\n");

        // Выводим все конструкторы
        System.out.println("КОНСТРУКТОРЫ:");
        // getConstructors() - выводит все публичные конструкторы
        // getDeclared - выводит все конструторы (включая не публичные)
        Constructor[] constructors = class1.getConstructors();

        for(int i = 0; i < constructors.length; i++) {
            // Выводит имя конструктора
            System.out.println("Конструктор № "+i+": \n" + constructors[i].getName());
            // получаем параметры конструктора
            Parameter[] parameters = constructors[i].getParameters();
            if(parameters.length != 0) {
                // System.out.println("Параметры и их типы конструктора №"+i+": \n");
                for(Parameter parameter: parameters) {
                    // имя параметра и его тип (во время компиляция все имена параметров заменяются на arg0, arg1 и т.д.)
                    System.out.println(parameter.getType().getName() + ", " + parameter.getName());
                }
            }
        }

        System.out.println();
        System.out.println("МЕТОДЫ:");
        Method[] methods = class1.getDeclaredMethods();
        for(Method method: methods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for(Parameter p: parameters) {
                System.out.println(p.getType().getName() + ", " + p.getName());
            }
            // Выводим модификаторы метода
            System.out.println(Modifier.toString(method.getModifiers()));
            // Получаем возращаемый тип методом
            System.out.println(method.getReturnType().getName());
            // Запускаем метод
            method.invoke(someClass1, "test");
        }

        System.out.println();
        System.out.println("ПОЛЯ:");
        Field[] fields = class1.getDeclaredFields();
        for(Field field: fields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getName());
            System.out.println(Modifier.toString(field.getModifiers()));
            // меняем значение модификатора доступа
            field.setAccessible(true);
            System.out.println(field.getInt(someClass1));
            // Устанавливаем новое значение приватного свойства
            field.setInt(someClass1, 5);
            System.out.println(field.getInt(someClass1));
        }
    }
}

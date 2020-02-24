import reflection.MyClass;
// библиотека рефлексии
import java.lang.reflect.Field;

public class FieldReflectionExample {
    public static void main(String[] args) {
        // cоздаем экземляр класса
        MyClass myClass = new MyClass();
        // получаем номер
        int number = myClass.getNumber();
        // у данного поля нет getter в MyClass
        String name = null;
        // выведет 0null
        System.out.println(number + name);
        try {
            // возращаем поле класса
            Field field = myClass.getClass().getDeclaredField("name");
            // делаем его публичным
            field.setAccessible(true);
            // устанавливаем новое значение
            field.set(myClass, (String) "new value");
            // получаем его значение
            name = (String) field.get(myClass);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(number + name); // выведет 0default
    }
}

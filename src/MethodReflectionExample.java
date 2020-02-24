import reflection.MyClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodReflectionExample {
    public static void main(String[] args) {
        // инициализируем класс
        MyClass myClass = new MyClass();
        // выводит 0default
        printData(myClass);
    }
    public static void printData(Object myClass){
        try {
            // получаем нужный метод по имени
            Method method = myClass.getClass().getDeclaredMethod("printData");
            // даем ему доступ
            method.setAccessible(true);
            // вызываем обьект
            method.invoke(myClass);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

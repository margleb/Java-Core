import reflection.MyClass;

// Данный метод работает только с конструктором по умолчанию (без параметров)
public class СlassReflectionExample {
    public static void main(String[] args) {
        MyClass myClass = null;
        try {
            // загружаем и получаем описание класса в виде переменной типа Class
            Class clazz = Class.forName(MyClass.class.getName());
            // получаем экземпляр класса MyClass
            myClass = (MyClass) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(myClass); // выводит созданный обьект reflection.MyClass@60e53b93
    }
}

import java.io.Serializable;

// обобщенный класс
// обьект K, расширен классом Main, и импломентированы интерфейсы Сomparable и Serializable;
// расширяемый класс всегда идет первым!
public class GenericClass<T, U, K extends GenericClass & Comparable & Serializable> {

    // обобщенное поле
    T genericT;
    U genericU;
    K genericK;

    public static void main(String[] args) throws Exception {
        // передаем несколько типов данных
        GenericClass<String, Integer, Car> genericClass = new GenericClass<>();

        genericClass.genericT = "Gleb";
        genericClass.genericU = 123;
        genericClass.genericK = new Car();

        System.out.println(genericClass.genericT);
        System.out.println(genericClass.genericU);
        System.out.println(genericClass.genericK);
        genericClass.method(new Car());
    }

     K method (K type) {
        // метод от comparable
        // type.compareTo(new Object());
        type.helloMethod();
        return type;
     }

    void helloMethod() {
        System.out.println("Hello");
    }
}

class Car extends GenericClass implements Comparable, Serializable {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
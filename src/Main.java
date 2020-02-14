// классы верхнего уровня бывают public или пакетно-приватными (без модификатора)
// может быть только один публичный класс и он должен совпадать с именем файла!!
public class Main {
    public static void main(String[] args) {
        // Абстрактный класс не может быть инициализирован
        // Car car = new Car();
        // Ball ball = new Ball();

        Ferrary ferrary = new Ferrary();
        ferrary.Run();
        ferrary.Stop();
    }
}

class MySecondClass {

}

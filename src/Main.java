/* Полиморфизм (polymorphism) - это свойство, которое позволяет одно и то же имя использовать для решения двух или более схожих, но технически разных задач */
public class Main {
    void useCar(Car car) {
        car.driving();
        System.out.println(car.getNumOfSeats());
    };
    public static void main(String[] args) {
        Main main = new Main();
        // Car car = new Car();
        // пример полиморфизам seats == 2;
        Car car = new Toyota();
        main.useCar(car);
    }
}
  
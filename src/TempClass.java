public class TempClass {
    public static void main(String[] args) {
        Сar car = new Сar();
        // не инициализированые поля имеют значения по умочанию
        System.out.println(car.maxSpeed);
        // car.maxSpeed = 250;
        // System.out.println(car.maxSpeed);
        System.out.println(car.var);

        // по умолчанию ссылочные типы равный 0
        System.out.println(car.magnitophon);

        car.method();

    }
}

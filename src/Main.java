public class Main extends Object {
    // используется для передачи параметров через консоль
    // можно также передавать параметры через IDE, (конфигурации Main)
    public static void main(String[] args) {
        for(String s : args) {
            System.out.println(s);
        }
    }
}

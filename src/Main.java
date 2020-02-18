// В командной строке пишем:
// 1. В компиляторе прописываем - javac -ea (либо enableassesion) Main
// 2. Запускаем лаунчер java -ea Main
// В настройках IntelliJ IDEA в VM Options прописываем -ea

public class Main {
    public static void main(String[] args) {
    new Main().someMethod(-5);
    }
    private void someMethod(int a) {
        // ошибка assession error
        assert (a > 0);
        System.out.println(a);
    }
}

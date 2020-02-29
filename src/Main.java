import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
        public static void main(String[] args) throws InterruptedException {
            System.out.println(Math.random());
            // для многопточных приложений используем данный класс
            System.out.println(ThreadLocalRandom.current().nextInt());
            // Количество миллисекунд в днях
            System.out.println(TimeUnit.DAYS.toMillis(14));
        };
}

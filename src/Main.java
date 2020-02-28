import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        // 2 мойщика
        new Washer(phaser);
        new Washer(phaser);
    }
    // мойшик машины
    static class Washer extends Thread {
        Phaser phaser;
        public Washer(Phaser phaser) {
            this.phaser = phaser;
            start();
        }
        @Override
        public void run() {
            // 3 автомабиля
            for(int i = 0; i < 3; i++) {
                System.out.println(getName() + " washing the car");
                // ожидание завершения всех потоков
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
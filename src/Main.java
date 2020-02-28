import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        new Mike(exchanger);
        new Anket(exchanger);
    }
    static class Mike extends Thread {
      Exchanger<String> exchanger;
      public Mike(Exchanger<String> excanger) {
          this.exchanger = excanger;
          start();
      }
        @Override
        public void run() {
            try {
                exchanger.exchange("I'm 20 years old");
                sleep(3000);
                exchanger.exchange("Hi my name is Mike");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Anket extends Thread {
        Exchanger<String> exchanger;
        public Anket(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }
        @Override
        public void run() {
            try {
                // Выводится информация из другого потока
                System.out.println(exchanger.exchange(null));
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

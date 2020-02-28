import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        // метод run запуститься только тогда, когда три потока, вернут await()
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());
        new Sportman(cyclicBarrier);
        new Sportman(cyclicBarrier);
        new Sportman(cyclicBarrier);
    }

    static class Run extends Thread {
        CyclicBarrier barrier;
        @Override
        public void run() {
            System.out.println("Run is begin");
        }
    }

    static class Sportman extends Thread {
        CyclicBarrier barrier;
        public Sportman(CyclicBarrier barrier) {
            this.barrier = barrier;
            start();
        }

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }

}

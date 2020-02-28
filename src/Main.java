import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {
        // Блокирующая очердь (эл. невозможно достать, пока его не положат)
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();
        // достает элемент
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        // кладем элемент
        new Thread() {
            @Override
            public void run() {
                queue.add("This is string");
            }
        }.start();
    }
}
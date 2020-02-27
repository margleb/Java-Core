import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.i = 5;
        resource.j = 5;

        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread1 = new MyThread();

        myThread.resource = resource;
        myThread1.resource = resource;

        myThread.start();
        myThread1.start();

        myThread.join();
        myThread1.join();

        System.out.println(resource.i);
        System.out.println(resource.j);
    }
    static class MyThread extends Thread {
        Resource resource;
        @Override
        public void run() {
            resource.changeI();
            // resource.changeJ();
        }
    }
}
class Resource {
    int i;
    int j;

    // более гибкий способ локинга, позволяет блокировать стразу несколько методов
    Lock lock = new ReentrantLock();

    void changeI() {
        // аналог synchronized
        lock.lock(); // блокируем
        int k = this.i;
        if(Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        k++;
        this.i = k;
        changeJ();
        // lock.unlock();
    }

    void changeJ() {
        int k = this.j;
        if(Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        k++;
        this.j = k;
        lock.unlock(); // разблокируем
    }
}
/* Синхронизация позволяет определенить последовательность выполнение кода одного ресурса несколькими потоками.
Если поток заходит в один из синхронизированных методов, по он блокирует ОБЬЕКТ */

public class ThreadSynchronizedExample {
    public static void main(String[] args) throws InterruptedException {
        Counter cnt = new Counter();
        for(int i =0; i < 200; i++) {
            Process p = new Process(cnt);
            new Thread(p).start();
        }
        Thread.sleep(1000);
        System.out.println(cnt.getCounter());
    }
}

class Counter {
    private long counter = 0;
    // благодаря слову synchronized потоки выстраиваются в очередь
    // поток не зайдет в данный метод, пока не выйдет следующий
    public synchronized void increase() {
        // 1. Прочитать переменную из памяти - 100;
        // 2. Увеличить на 101;
        // 3. Поместить в память новое значение - 101;
        counter++;
    }
    public long getCounter() {
        return counter;
    }
}

class Process implements Runnable {
    private Counter  cnt;
    public Process(Counter counter) {
        this.cnt = counter;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            cnt.increase();
        }
    }
}
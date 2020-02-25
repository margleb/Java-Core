/*
Все потоки запускаются паралельно, поэтому нет никакой гарантии какой из них запуститься первее других
Поток создается только при вызове метода start()
Поток можно вызвать только один раз
*/

public class Main {
    public static void main(String[] args) {
        // Основной поток main;
        // System.out.println(Thread.currentThread().getName());

        // #1 Создание потока с помочью расширения класса Thread
        MyThread myThread = new MyThread();
        myThread.start();
        // поток можно вызвать только один раз!
        // myThread.start();

        // #2 С помочью импломентации интерфейса
        MyRunnalble myRunnalble = new MyRunnalble();
        Thread thread2 = new Thread(myRunnalble);
        thread2.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        // имя отока
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnalble implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
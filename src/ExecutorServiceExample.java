/*
Благдоаря классу ExceutorService:
1. Я могу управлять запуском потока
2. Могу узнать степень готовоности потока (isDone)
3. У данного потока могу дождаться результата (ошибки или его завершения)
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // предоставляет методы для отслеживания хода выполнения одной или нескольких асинхронных задач,
        // а также методы для их завершения.
        ExecutorService es = Executors.newSingleThreadExecutor();
        // предоставляет результат асинхронного вычесления
        Future<?> s = es.submit(new SingleProcess2());
        // завершен ли поток?
        boolean done = s.isDone();
        System.out.println(done);
        try {
            // дожидаемся результата
            System.out.println("Before get");
            // ожиает завершение вычесления и извлекает его результат
            s.get();
            System.out.println("After get");
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
        }
        // завершает выполнение прошлых задач, не принимая новые
        es.shutdown();
    }
}

class SingleProcess2 implements Runnable {
    private String name = null;
    @Override
    public void run() {
        try {
            System.out.println("START");
            // Временно приостанавливает выполнение текущего потока
            Thread.sleep(3000);
            // System.out.println(name.length());
            // System.out.println("OK");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



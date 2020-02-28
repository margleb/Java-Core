import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
*  Если в программе создается большое количество кратковременных потоков,тоимеет смысл использовать пулп отоков
*  Другая причина для использования пула потоков — необходимость ограничить количество параллельно выполняющихся потоков
*/

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Executors executor; // класс для создания пула потоков
        // Executors.newSingleThreadExecutor(); // Пул с единственным потоком, выполняющим переданные ему задачи поочередно
        // Executors.newCachedThreadPool(); // Новые потоки создаются по мере необходимости, а проста¬ ивающие потокисохраняютсявтечение 60 секунд

        // Пул содержит фиксированное множество наборов потоков,а простаивающие потоки сохраняются в течение 60 секунд
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);

        // В результате вызова метода submit() возвращается объект типа Future, позволяющий оценить состояние задачи
        newFixedThreadPool.submit(new MyRunnable()); // перадача задачи обьекту типа ExecutorService c помочью метода submit
        System.out.println(newFixedThreadPool.submit(new MyCallable()).get()); // вернет Feture и вызовет метод get()

        // Останавливает службу, завершая все запущенные задачи ине принимая новых.
        newFixedThreadPool.shutdown();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
/*
ForkJoinPool - реализация ExecutorService , которая управляет рабочими потоками и предоставляет нам инструменты для получения информации о состоянии и производительности пула потоков.
помогает ускорить параллельную обработку, пытаясь использовать все доступные ядра процессора
*/


import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

    static long numOfOperations = 10_000_000_000L;
    // Возвращает количество процессоров, доступных для виртуальной машины Java.
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        // System.out.println(new Date());
        // System.out.println(numOfThreads);
        // Cоздает экземпляр с указанным уровнем параллелизма
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        // Выполняет заданное задание, возвращая его результат по завершении
        System.out.println(pool.invoke(new MyFork(0, numOfOperations)));
        // System.out.println(new Date());
    }

    // Рекурсивный результат
    static class MyFork extends RecursiveTask<Long> {
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        // Основные вычесления выполняемые данной операцией
        protected Long compute() {
            // если операция разбита на достаточное кол-во частей
            if ((to - from) <= numOfOperations / numOfThreads) {
                // выполняем операцию
                long j = 0;
                for(long i = from; i < to; i++) {
                    j+=i;
                }
                return j;
            } else {
                // разбиваем на части по меншьешу
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle + 1, to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}

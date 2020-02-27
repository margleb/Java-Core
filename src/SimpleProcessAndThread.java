/*
Thread - oсновной базовый класс для запуска потоков
run() - основной метод выполняемый при запуске потока на выполнение

В стаором варианте потоки могут запускаться одним из следующих способов:
- С помочью интерфейса Runnable
- С помочью метода Thread

В новом варанте можно использовать следующие cпособы
Executors // класс
ExcutorService // интерфейс
Сallable // интерфейс
*/

import java.math.BigInteger;
import java.security.SecureRandom;

public class SimpleProcessAndThread {
    public static final int TASK_COUNT = 50000;
    public static void main(String[] args) throws InterruptedException {
        Long summa = 0L;
        // System.out.println(System.currentTimeMillis());
        for(int i = 0; i < 10; i++) {
            SingleProcess sp = new SingleProcess("ID:" + i);
            // summa += sp.process();
            Thread t = new Thread(sp);
            t.start();
        }
        // System.out.println(System.currentTimeMillis());
        Thread.sleep(5000);
    }
}

class SingleProcess implements Runnable {

    private String name;
    private Long summa = 0L;

    public SingleProcess(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        process();
    }

    public Long getSumma() {
        return summa;
    }

    public Long process() {
        Long summa = 0L;
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < SimpleProcessAndThread.TASK_COUNT; i++) {
            String g = new BigInteger(500, random).toString(32);
            for (char c : g.toCharArray()) {
                summa += c;
            }
        }
        System.out.println(name);
        return summa;
    }
}

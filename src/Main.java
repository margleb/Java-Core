/*
Concurrency это работа с многопоточным кодом.
Обычно под этим понимают:
1. Управление (создание/запуск/остановка) потоками виртуальной машины Java.
2. Управление потоком выполнения программы (синхронизация потоков).
3. Управление доступом к памяти (к данным) в многопоточной среде
https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/package-summary.html


Главное правило -- синхронизировать любой доступ к ресурсу (в данном случае коллекции), будь то чтение или запись. Как именно -- на первых порах не столько важно. Методы-обертки с модификатором synchronizhed -- как один из вариантов. Чем больше опыт работы с многопоточностью -- тем больше вариантов, в зависимости от требований.
Также нужно помнить, что даже специализированные потокобезопасные коллекции (из java.util.concurrent.*) при определенных сценариях тоже могут нуждаться в дополнительной синхронизации.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    //
    List list = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        NameList nameList = new NameList();
        nameList.add("first");
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }
        MyThread myThread =  new MyThread();
        myThread.setName("one");
        myThread.start();
        new MyThread().start();
    }

    static class NameList {
        List list = Collections.synchronizedList(new ArrayList<>());
        public void add(String name) {
            list.add(name);
        }
        // Даже используя synchronizedList, операции по работе с возвращенной коллекцией всё равно надо заворачивать в synchronized.
        public synchronized String removeFirst() {
            if(list.size() > 0) {
                if(Thread.currentThread().getName().equals("one")) {
                    Thread.yield();
                }
                // без синхронизации тут выйдет ошибка
                return (String) list.remove(0);
            }
            return null;
        }
    }
}

/*
В статических синхронизирует на уровне класса
Статический и обычные метод синхронизации могут выполняться одновременно, так как у них разные локи!
Совмещение статической и обычной синхронизации одного поля НЕ ДОПУСКАЕТСЯ!!
*/

public class Main {
    public static void main(String[] args) throws Exception {
        Resource.i = 5;
        // создаем 2 потока
        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread2 = new MyThread();

        // запускаем потоки
        myThread.start();
        myThread2.start();

        // Ожидает когда данный поток завершится
        myThread.join();
        myThread2.join();

        System.out.println(Resource.i);
    }
}

class MyThread extends Thread {
    Resource resource;
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        Resource.changeStaticI();
        new Resource().сhangeI();
    }
}

class Resource {
    // это поле нужно использовать только в статическом методе!!
    static int i;

    public int getI() {
        return i;
    }

    // методы меняющие значение должны быть синхронизированы
    public synchronized void setI(int i) {
        this.i = i;
    }

    public synchronized static void changeStaticI() {
        // синхронизация на уровня класса
        synchronized (Resource.class) {
            int i = Resource.i;
            if(Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            Resource.i = i;
        }
    }

    public void сhangeI() {
        // синхронизация на уровня класса
        synchronized (Resource.class) {
            int i = Resource.i;
            if(Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            Resource.i = i;
        }
    }
}
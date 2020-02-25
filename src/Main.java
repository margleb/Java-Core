/*
По аналогии с транспортным движением
Thread.yeild() -  знак главная дорога (притормози, уступи дорогу тс на главной дороге)
synchronized - светофор, пока процесс (автомобиль) не доедет до конца дороги, не влкючиться зеленый свет (работает с помочью локов, иногда называются мониторами)
Thread.sleep() - на подобии пешеходного перехода, притормози и продолжи движение через определенное время
myThread.join() - можно привести аналогию с пробкой, (пока не проедут одни, ты не сможешь продожлжить движение)
myThread.setPriority() - установить приоритет движения для определенного потока
Synchronized необходим тогда, когда несколько потоков используют один и тот же обьект
 */

public class Main {
    public static void main(String[] args) throws Exception {
        // создаем обьект resource, задаем изн. значение i
        // synchronized работает с каким то одним обьектом, в данном случае resource
        Resource resource = new Resource();
        resource.setI(5);
        // создаем 2 потока
        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread2 = new MyThread();

        // заносим в них ресурсы
        myThread.setResource(resource);
        myThread2.setResource(resource);

        // запускаем потоки
        myThread.start();
        myThread2.start();

        // Ожидает когда данный поток завершится
        myThread.join();
        myThread2.join();

        System.out.println(resource.getI());
    }
}

class MyThread extends Thread {
    Resource resource;
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        resource.changeI();
    }
}

class Resource {
    private int i;

    public int getI() {
        return i;
    }

    // методы меняющие значение должны быть синхронизированы
    public synchronized void setI(int i) {
        this.i = i;
    }

    // synchronized - метод не должен прерываться (локи)
    public synchronized void changeI() {
        // можно синхронизировать какой то блок кода
        synchronized (this) {
            int i = this.i;
            // Без synchronized может прерваться первый поток и начаться второй
            if(Thread.currentThread().getName().equals("one")) {
                // прекращается выполнение потока и он возращается в пулл потоков
                // далее java, начинает выбирать какой либо поток из пулла
                Thread.yield();
            }
            i++;
            this.i = i;
        }
    }
}
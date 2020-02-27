/* Deadlock или дедлок или взаимная блокировка — это ошибка, которая происходит когда нити имеют циклическую зависимость от пары синхронизированных объектов. */

public class Main {
    public static void main(String[] args) {
        ResourceOne resourceOne = new ResourceOne();
        ResourceTwo resourceTwo = new ResourceTwo();

        resourceOne.resourceTwo = resourceTwo;
        resourceTwo.resourceOne = resourceOne;

        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();

        threadOne.resourceTwo = resourceTwo;
        threadTwo.resourceOne = resourceOne;

        threadOne.start();
        threadTwo.start();

    }
}

class ThreadOne extends Thread {
    ResourceTwo resourceTwo;
    @Override
    public void run() {
        System.out.println(resourceTwo.getValue());
    }
}

class ThreadTwo extends Thread  {
    ResourceOne resourceOne;
    @Override
    public void run() {
        System.out.println(resourceOne.getValue());
    }
}

class ResourceOne {
    ResourceTwo resourceTwo;
    public synchronized int getValue() {
        return resourceTwo.getInt();
    }
    int getInt() {
        return 1;
    }
}

class ResourceTwo {
    ResourceOne resourceOne;

    public synchronized int getValue() {
        return resourceOne.getInt();
    }
    int getInt() {
        return 2;
    }
}
/*
Thread.sleep - можно представить как скорость потока аватомобилей
С помочью ключевого слова volotile мы говорим всем потокам о том, чтобы они читали и писали из одного и того же места, то есть не кешировали
Используется для нескольких потоков
volotile - можно сравнимть с многополосной дорогой для автомобилей (потоков)
 */

public class VolotileMain {
    // не кеширует переменную и использует ее во всех потоках
    volatile static int i = 0;

    public static void main(String[] args) {
        new MyThreadRead().start();
        new MyThreadWrite().start();
    }
    static class MyThreadWrite extends Thread {
        @Override
        public void run() {
            while(i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class MyThreadRead extends Thread {
        @Override
        public void run() {
            int localVar = i;
            while(localVar < 5) {
                if(localVar != i) {
                    System.out.println("new value of i is " + i);
                    localVar = i;
                }
            }
        }
    }
}

/*
  Thread.sleep(1000);  - усы пляет ТЕКУЩИЙ ПОТОК поток на одну секунду
  myThread.setPriority() - выставление приоритетов потоков, если хотим чтобы один из них выполнялся чаще остальных (не гарантировано)
  Tread.yeild() - ТЕКУЩИЙ ПОТОК Уступает другому потоку. Планировщик может игнорировать данный процесс
  myThread.join() - ожидает заврешение определенного потока, и лишь потом выполнить что либо в другом
  Голодание потоков - когда какие то потоки выполняются чаще, чем остальные

  У потоков есть несколько состояний:
  1. new - инициализация потока
  2. runnable - пул потоков
  3. running - запущенный поток, в этом состоянии находится только один поток, остальные находятся в пуле. (могут переходить из одного сосотояния в другое)
  4. waiting/blocked/sleeping - состояния блокировки, когда потоки можно приостановить на время
  5. dead - окончание потока
*/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        // Thread.sleep(1000); // усыпляет текущий поток на одну cек
        // выставление приоритетов потоков, если хотим чтобы один из них выполнялся чаще остальных
        // myThread.setPriority(Thread.MAX_PRIORITY);
        // Thread.yield(); // текущий поток уступает другому потоку
        myThread.join(); // ожидает заврешение определенного потока
        System.out.println("thrad main");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
      for(int i = 0; i < 20; i++) {
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println(i);
      }
    }
}


import java.util.*;

public class Main {
    public static void main(String[] args) {

      // связанный список выводится в порядке добавляения
      Queue queue = new LinkedList();
      queue.offer("1");
      queue.offer("2");
      queue.offer("3");
      queue.offer("4");

      List list = (List) queue;
      Collections.sort(list);

      while(queue.size() > 0) {
          System.out.println(queue.poll());
      }

     // отсортированная очередь
     Queue queue2 = new PriorityQueue();
     queue2.offer("1");
     queue2.offer("5");
     queue2.offer("3");
     queue2.offer("4");
     queue2.offer("2");
     while(queue2.size() > 0) {
       System.out.println(queue2.poll());
     }
    }
}
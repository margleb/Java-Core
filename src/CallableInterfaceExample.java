import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableInterfaceExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        // Future представляет результат асинхронного вычисления
        // submit() подтверждает задачу и возращает значение funture
        Future<String> s = es.submit(new SingleProcess3());
        // завершен ли поток?
        boolean done = s.isDone();
        System.out.println(done);
        try {
            // System.out.println("Before get");
            // При необходимости ожидает завершения вычисления, а затем * извлекает его результат.
            String answer = s.get();
            // System.out.println("After get: " + answer);
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
        }
        // закрываем
        es.shutdown();
    }
}

// Задача, которая возвращает результат и может вызвать исключение.
class SingleProcess3 implements Callable<String> {
    private String name = null;
    @Override
    public String call() {
        try {
            System.out.println("START");
            // заставляет текущий поток временно прекратить выполнение
            Thread.sleep(3000);
            // System.out.println(name.length());
            // System.out.println("OK");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "STRING";
    }
}
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        // вернет результат
        System.out.println(futureTask.get());
    }
    // интерфейс callable позволяет запустить метод call в отдельном потоке и при этом получить результат
    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int j = 0;
            for(int i = 0; i < 10; i++, j++) {
                Thread.sleep(500);
            }
            return j;
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceListExample {
    public static void main(String[] args) throws Exception {

        // возвращает количество процессоров, доступных для виртуальной машины Java.
        int app = Runtime.getRuntime().availableProcessors();
        // System.out.println(app);

        // ExecutorService позволяет регулировать количество исполняемых потоков
        ExecutorService es = Executors.newFixedThreadPool(app);

        List<Future<String>> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            SingleProcess4 sp = new SingleProcess4("ID:" + i);
            Future<String> ft = es.submit(sp);
            list.add(ft);
        }

        for(Future<String> f : list) {
            String answer = f.get();
        }

        es.shutdown();
    }
}

class SingleProcess4 implements Callable<String> {
    private String name = null;

    public SingleProcess4(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        try {
            System.out.println("START:" + name);
            Thread.sleep(3000 + ((int) (Math.random() * 1000)));
            System.out.println("STOP:" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "STRING";
    }
}

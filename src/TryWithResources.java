import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TryWithResources {
    // благодаря AutoCloseable можнно закрыть без finally
    static class MyLaptop implements AutoCloseable {
        @Override
        public void close() {

        }
    }
    public static void main(String[] args) {
        Reader reader = null;
//        try {
//            new FileReader(new File("someFileName"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                reader.close();
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//        }

        // а также не нужен блок catch
        try(MyLaptop myClass = new MyLaptop()) {
        }

        // cюда можно добавлять все классы, которые расширяются интерфейсом Closeable
        // нет необходимости в добавлении finally для закрытия
        try(Reader reader1 = new FileReader(new File("someFileName"))) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        // streams
        Reader reader3;
        Writer writer;
        InputStream inputStream;
        OutputStream outputStream;
        // gdbc
        Connection connection;
        Statement statement;
        ResultSet resultSet;

    }
}

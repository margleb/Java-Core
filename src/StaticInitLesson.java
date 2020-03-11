import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StaticInitLesson {
        static int i;
        static int[] arr = new int[3];
        static int getI() throws FileNotFoundException {
            InputStream inputStream = new FileInputStream("");
            return 5;
        }
        // статический инициализатор позволяет получить значение
        // static {
            // try {
                // i = getI();
            // } catch(FileNotFoundException e) {
                // e.printStackTrace();
            // }
       // статический блок инициализации позволяют проинициализировать массив
        // arr[0] = 0;
        // arr[1] = 1;
        // arr[2] = 3;
        // }

        // статические блоки инициализации собираются в один
        // static int i = 0;
        // static {
          // i = 10;
          // i = 0;
          // ++i;
        // };
        static {
            i2 = 10;
        }
        static int i2 = 0;
        static {
            ++i2;
        }
        public static void main(String[] args) {
            new StaticInitLesson();
            System.out.println(i);
        };

        static class Student {

        }
        interface Car {
            int k = i;
        }
}


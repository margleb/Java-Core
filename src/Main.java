
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // создаем класс файл
        File file = new File("temp.txt");

        if(!file.exists()) {
            // создаем директорию
            // file.mkdir();
            // создаем файл
            file.createNewFile();
        }

        // записываем
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("str1\n");
        fileWriter.write("str2\n");
        // Очищает поток
        fileWriter.flush();
        // Закрывает поток
        fileWriter.close();

        // прочитываем
        FileReader fileReader = new FileReader(file);
        char[] chars  = new char[20];
        fileReader.read(chars);
        System.out.println("Записи из temp:");
        System.out.println(chars);

        // проверка директория или файл;
        if(file.isDirectory()) {
            System.out.println(file.getName() + "Дериктория");
        } else if(file.isFile()) {
            System.out.println(file.getName() + ": Файл");
        }
        System.out.println();

        /* Более удобные способ */

        File BufferedFile = new File("BufferedTemp.txt");

        // записываем
        FileWriter bufferedFileWriter = new FileWriter(BufferedFile);
        BufferedWriter  bufferWriter = new BufferedWriter(bufferedFileWriter);
        bufferWriter.write("str3");
        bufferWriter.newLine();
        bufferWriter.write("str4");
        // Очищает поток
        bufferWriter.flush();
        // Закрывает поток
        bufferWriter.close();

        // прочитываем
        FileReader bufferedFileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(bufferedFileReader);
        System.out.println("Записи из BufferedTemp:");
        while(bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }

    }
}

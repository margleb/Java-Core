/*
// текстовые файлы
Reader
Writer
// для байтов
InputStream
OutStream
 */

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        // используются для текстовых файлов
        // Reader reader;
        // Writer writer;
        // для работы с байтовыми файлами (потоковые стримы чтение из файла, сети и т.д)
        // InputStream inputStream;
        // OutputStream outputStream;

        // Reader reader = new FileReader("temp.txt");
        // int i = 0;
        // while((i = reader.read()) != -1 ) {
            // System.out.println((char)i);
        // }
        // char[] chars = new char[50];
        // while(reader.read(chars) != -1) {
            // for(int i = 0; i < chars.length; i++) {
                // if(Character.isAlphabetic(chars[i]) || Character.isWhitespace(chars[i])) {
                    // System.out.println(chars[i]);
                // }
            // }
            // System.out.println(chars);
        // }

        //
//        Writer writer = new FileWriter("temp.txt");
//        // запись в память
//        writer.write("str1\n");
//        writer.write("str2\n");
//        // запись в текстовый докумет
//        writer.flush();
//        writer.close(); // закрывает (автоматом вызывает flush)
//
//
//        // читает в буфер, в отличии от прочтениея каждого символа из файла
//        BufferedReader reader = new BufferedReader(new FileReader("temp.txt"));
//        while(reader.ready()) {
//            // читаем по строчно
//            System.out.println(reader.readLine());
//        }
//
//        // нет необходимости вызывать close
//        try(BufferedWriter writer1 = new BufferedWriter(new FileWriter("temp.txt"))) {
//            writer1.write("str1");
//            writer1.newLine();
//            writer1.write("str2");
//        }
//
//
//        // возможно читать только байты!! Buffered позволяет читать в буфер
//        BufferedInputStream inputSteam = new BufferedInputStream(new FileInputStream("temp.txt"));
//        int i = 0;
//        while((i = inputSteam.read()) != -1) {
//              System.out.println(i);
//        }
//        inputSteam.read();
//
//        // прочтение в массив (кол-во доступных байтов)
//        byte[] bytes = new byte[inputSteam.available()];
//        while(inputSteam.read(bytes) != -1) {
//            for(int j = 0; j < bytes.length; i++) {
//                // if(bytes[j] == 0) {
//                    // break;
//                // }
//                System.out.println(bytes[j]);
//            }
//        }

        // прочитывает байты, буферезированный быстрее считывает
        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("temp.txt"))) {
            byte[] bytes = new byte[] {49, 10, 50};
            outputStream.write(bytes);
        }


        // можно создатвать цепочку стримов
        ZipInputStream zipInputStream = new ZipInputStream(new DataInputStream(new BufferedInputStream(new FileInputStream(""))));
    }
}

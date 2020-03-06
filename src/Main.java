/*
BufferedImage - буфер данных изображения после прочтения
ImageIO - основной класс для кодирования/декодирования прочтения и записи изображений
*/

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {

        // # 1 Чтение и запись изображений с помочью пакета ImageIO

        // абстрактное представление имен файла
        File file = new File("img/java.jpg");
        // для загрузки изображения из файла применяется статический метод read() из класса ImageIO
        BufferedImage image = ImageIO.read(file);
        // для записи используется метод write
        ImageIO.write(image, "png",  new File("java.png"));


        // # 2 Получение средств чтения и записи изображений по типам файлов

        /*
        Для выполнения расширенных операций записи и чтения изображений,которые выходят за пределы простого использования статических методов read() и write() из класса ImagelO,
        нужно прежде всего получить объекты типа ImageReader и ImageWriter соответственно. В классе ImagelO перечисляются средства и записи, отвечающиео дному из следующих условий.

        • Форматизображения,например JPEG.
        • Расширениефайла,например jpg.
        • ТипMIME,например image/jpeg.
        */

        //  расширения файлов для всех доступных средств чтения
        String[] extensions = ImageIO.getWriterFileSuffixes();
        for(String ext: extensions) {
            System.out.printf(ext + " ");
        }

        // Класс ImagelO может обнаружить несколько средств чтения, каждое изкоторых способно обработать файлы данного типа
        ImageReader reader = null;
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("JPEG");
        if(iterator.hasNext()) reader = iterator.next();

        //  # 3 чтение и запись файлов с несколькими изображениями

        // Для чтения нескольких изображений нужно преобразовать сначала источник входных данных (например, поток ввода или файл) в объект потока ввода изображений типа ImagelnputStream следующим образом:
        InputStream inputSteam = new FileInputStream(new File("img/java.jpg"));
        ImageInputStream imagein = ImageIO.createImageInputStream(inputSteam);
        // Затем поток ввода следует присоединить к средству чтения, вызвав следующий метод:
        // поток ввода находится в режиме просмотра данных только в прямом направлении
        reader.setInput (imagein, true);
        // Прочитать изображение непосредственно из файла
        ImageInputStream imageIn = ImageIO.createImageInputStream(new File("img/java.jpg"));
        // Вводим из этого потока изображение, вызывав метод read с передачей кол-ва изображений
        // параметр true разраешает поиск и подсчет количесвтва изображений
        BufferedImage image1 = reader.read(reader.getNumImages(true));


        // # 4 Некоторые файлы могут содержать миниатюрные виды изображений

        // Выясняем количество миниатюрных видов изображей,
        int count = reader.getNumThumbnails(0);
        // Извлечь конкретный миниатюрный вид по его индексу можно следующим образом
        BufferedImage image2 = reader.readThumbnail(0, 0);
        // Для получения размеров изображения по указанному индексу вызываются следующие методы:
        System.out.println(reader.getHeight(0));
        System.out.println(reader.getWidth(0));

        // Для записи нескольких изображений в файл нужно создать сначала объект типа ImageWriter:
        ImageWriter writer = null;
        // Затем с помощью класса IOImage перечислить все средства,способные записывать изображения в конкретном формате:
        Iterator<ImageWriter> iterator1 = ImageIO.getImageWritersByFormatName("JPEG");
        if(iterator1.hasNext()) writer = iterator1.next();
        // Затем поток ввода следует преобразовать в объект типа ImageOutputStream:
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(new File("img/java.jpg"));
        // и присоединить его к средству записи следующим образом:
        writer.setOutput(imageOutputStream)

    }
}

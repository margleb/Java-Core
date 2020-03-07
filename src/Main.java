import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        // Получаем изображение для его дальнешего форматирования
        BufferedImage image = ImageIO.read(new File("img/java.jpg"));
        // Получение обьекта для доступа к писклелям изображния с целью внесения в них изменения
        WritableRaster raster = image.getRaster();

        // для каждого пикселя по ширине
         for(int i = 0; i < raster.getWidth(); i++) {
             // получаем цветовую гамму пиксля (r/g/b/альфа)
             int[] pixel = raster.getPixel(i, 25, new int[4]);
             // устанавливаем цвет пикселей о верху
             int[] black = {0, 0, 0, 255 };
             raster.setPixel(i, 0, black);
         }

        // Значения цветов группы пикселей изображения
        // int[] ArrayOFRGB = raster.getPixels(0,0,image.getHeight(), image.getWidth(), new int[4 * image.getHeight() * image.getWidth()]);

         int numOfImagePixels = 4 * image.getHeight() * image.getWidth();
         int[] newPixels = new int[numOfImagePixels];
         for(int i = 0; i < 4 * image.getHeight() * image.getWidth(); i++) {
             newPixels[i] = 0;
         }
         // задание значения пикселей определенной области
         raster.setPixels(0,0,image.getHeight(), image.getWidth(), newPixels);

        /*
        Манипулировать изображением немного сложнее, если его тип заранее неизвестен. У каждого типа изображений имеется своя цветовая модель,
        в соответствии с которой выборочные значения цвета пикселей можно привести к стандартной цветовой моделиRGB.
        */

        // получение цветовой модели
        ColorModel colorModel = image.getColorModel();
        // определение цвета пикселя, возращает обьект с описанием цвета в соответсвии с конерктной цветовой моделью
        Object data = raster.getDataElements(32, 24, null);
        // Метод getRGB() из класса Color возвращает целочисленное значение, состоящее из значений прозрачности в альфа-канале,красной,зеленой и синей составляющих цвета
        Color color = new Color(colorModel.getRGB(data), true);
        // Задает выборочные данные для точки растра. Параметр data обозначает массив выборочных значений цвета пикселя. Тип элементов и длина этого массива зависят от конкретной цветовой модели.
        raster.setDataElements(0,0, data);

        image.setData(raster);

        ImageIO.write(image, "png", new File("example.png"));

    }
}

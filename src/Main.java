import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, UnsupportedFlavorException
    {
        // системный буфер обмена
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // создаем изображение
        Image image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

        // получаем графику изображения
        Graphics g = image.getGraphics();
        // устанавлиеваем цвет
        g.setColor(Color.BLUE);
        // рисуем прямоугольник
        g.fillRect(0, 0, 100, 100);
        // устанвливаем цвет
        g.setColor(Color.RED);
        // рисуем овал
        g.fillOval(100 / 4, 100 / 4, 100 / 2, 100 / 2);


        // cоздаем экземпля класса ImageTransferable
        ImageTransferable selection = new ImageTransferable(image);
        // заносим его в буфер
        clipboard.setContents(selection, null);

        // список доступных разноваидностей данных
        // DataFlavor[] flavors = clipboard.getAvailableDataFlavors();
        // for(DataFlavor df: flavors) {
            // System.out.println(df);
        // }

    }
}

// Объекты,которые требуется передать через буфер обмена,должны реализовывать интерфейс Transferable.
class ImageTransferable implements Transferable {

    private Image thelmage;

    // конструктор с передачей изображения
    public ImageTransferable(Image image) {
        thelmage = image;
    }

    @Override
    // Предоставляет мета информацию о данных
    // mimetype=image/x-java-image;representationclass=java.awt.Image
    public DataFlavor[] getTransferDataFlavors() {
        // DataFlavor.imageFlavor - константа, выполняющая все необходимые действия по преобразованиию изображений
        return new DataFlavor[]{DataFlavor.imageFlavor};
    }

    @Override
    // Проверка на поддержку данных
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.imageFlavor);
    }

    @Override
    // получает обьект
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        // если данные поддерживаются, вернуть изображение и наче ошибка
        if (flavor.equals(DataFlavor.imageFlavor)) {
            return thelmage;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
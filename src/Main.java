import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedFlavorException {
        // системный буфер обмена
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // Cтроки передаваемые в буфер обмена
        String text = "Cтрока №1";
        // Оболочка строки для передачи в буфер обмена
        StringSelection selection = new StringSelection(text);
        // Передача данных с помочью метода setContents()
        // Владелец буфера обмена не имеет значения (null)
        clipboard.setContents(selection, null);

        // Класс DataFlavor описывает разновидности данных, которы емогут быть размещены в буферео обмена
        DataFlavor flavor = DataFlavor.stringFlavor;
        // Ecли строка доступна в буфере обмена
        if(clipboard.isDataFlavorAvailable(flavor)) {
            // Получить данные и вывести их
            String getText = (String) clipboard.getData(flavor);
            System.out.println(getText);
        }

    }
}

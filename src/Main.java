import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedFlavorException {

        //  #1 Копируем в буфер обмена
        // создаем clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // создаем рандомный текст
        StringSelection stringSelection = new StringSelection("some text");
        // заносим его в буфер обмена
        clipboard.setContents(stringSelection, null);
        // засыпаем на нескольк секунд
        // Thread.sleep(100000);

        // #2 Копируем из буфера обмена
        DataFlavor flavor = DataFlavor.stringFlavor;
        if(clipboard.isDataFlavorAvailable(flavor)) {
            System.out.println(clipboard.getData(flavor));
        }

    }
};
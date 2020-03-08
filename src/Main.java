import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        if(Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            for(Desktop.Action action : Desktop.Action.values()) {
                System.out.println(action);
            }
            // если можно что либо открывать
            if(desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(new File("img/flower.jpg"));
            }
            if(desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI("https://www.google.com"));
            }
        }
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException, AWTException {
            // Если поддерживается систесный трей
            if(SystemTray.isSupported()) {
                // Создаем трей
                SystemTray tray = SystemTray.getSystemTray();
                // Получаем изображение
                Image image = new ImageIcon("img/jpg.png", "desc").getImage();

                // Создаем попaп меню
                PopupMenu popupMenu = new PopupMenu();
                // добавляем 3 элемента, один из которых по событию клик вывыодит в консоль какое либо сообщение
                popupMenu.add(new MenuItem("one")).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("one");
                    }
                });
                popupMenu.add(new MenuItem("two"));
                popupMenu.add(new MenuItem("three"));

                // Добавляем иконку в трей
                tray.add(new TrayIcon(image, "tray description", popupMenu));
            }
        }
    }


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // jFrame.setSize(500, 300);
        // jFrame.setLocation(500, 400);

        // дефолтные инструменты
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // получаем размер нашего окна
        Dimension dimension = toolkit.getScreenSize();
        // Устанавливаем координаты и ширину/высоту окна
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 300);
        jFrame.setTitle("This is my app");
    }
}

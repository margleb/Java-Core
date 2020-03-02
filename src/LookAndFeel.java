import javax.swing.*;
import java.awt.event.*;

public class LookAndFeel {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();
        // Абстрактный класс адаптера для того, чтобы получить события окна. Методы в этом классе пусты. Этот класс существует как удобство для того, чтобы создать объекты слушателя
        // WindowListener - Интерфейс слушателя для того, чтобы получить события окна
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int i = 0;
            }
        });
    }

    static JFrame getFrame() {
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(20, 20, 300, 500);
        jframe.setTitle("Example");
        return jframe;
    }
}

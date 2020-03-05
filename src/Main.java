import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;

public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        jframe.add(new MyComponent());
        jframe.revalidate();
    }

    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2D = (Graphics2D) g;

            Rectangle2D rectangle2D = new Rectangle2D.Double(0, 0, 100, 100);
            // увеличение в 2 раза
            g2D.scale(2, 2);
            // передвинуть
            // g2D.translate(50, 50);
            // трансформация
            // g2D.shear(0.1, 0.1);
            // вращение (поворот в радианах)
            // g2D.rotate(45);

            g2D.draw(rectangle2D);

        }
    }

    static JFrame getFrame() {
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jframe.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 550, 300);
        jframe.setTitle("Example");
        return jframe;
    }
}

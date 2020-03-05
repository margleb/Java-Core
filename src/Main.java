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

            // g2D.setPaint(Color.red);
            // g2D.setPaint(new GradientPaint(new Point(0, 0), Color.red, new Point(200, 100), Color.yellow));

            try {
                g2D.setPaint(new TexturePaint(ImageIO.read(new File("img/java.png")), new Rectangle2D.Double(0, 0, 200, 100)));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Ellipse2D ellipse2D = new Ellipse2D.Double(0, 0, 200,100);

            g2D.fill(ellipse2D);

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

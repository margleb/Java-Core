import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Example {

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

           // жирность линии + закругленный наконечник + тире
           g2D.setStroke(new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10f, new float[]{5, 10}, 0));

           Line2D line = new Line2D.Double(0, 0, 100, 200);
           g2D.draw(line);

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

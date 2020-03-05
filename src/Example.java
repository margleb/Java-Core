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

           Area area  = new Area(new Rectangle2D.Double(0,0,100,100));

           // area.add(new Area(new Ellipse2D.Double(50, 50, 150, 150)));
           // area.subtract(new Area(new Ellipse2D.Double(50, 50, 150, 150)));
           // area.intersect(new Area(new Ellipse2D.Double(50, 50, 150, 150)));
           area.exclusiveOr(new Area(new Ellipse2D.Double(50, 50, 150, 150)));
           
           g2D.fill(area);

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

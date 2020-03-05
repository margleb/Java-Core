import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

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
            Graphics2D gr2d = (Graphics2D) g;
            Rectangle2D rectangle2D = new Rectangle2D.Double(50, 50, 100, 100);
            Color color =  new Color(0f, 0f, 0f);
            gr2d.setColor(color);
            gr2d.fill(rectangle2D);

            Rectangle2D rectangle2D2 = new Rectangle2D.Double(150, 50, 100, 100);
            Color color2 =  new Color(0f, 0f, 0f, 0.5f);
            gr2d.setColor(color2);
            // установить композицию цветов
            // gr2d.setComposite(AlphaComposite.SrcOver);
            gr2d.fill(rectangle2D2);

            Rectangle2D rectangle2D3 = new Rectangle2D.Double(250, 50, 100, 100);
            Color color3 =  new Color(0f, 0f, 0f, 0.1f);
            gr2d.setColor(color3);
            gr2d.fill(rectangle2D3);


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

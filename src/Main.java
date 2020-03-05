import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        jframe.add(new MyComponent());
    }
    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D gr2d = (Graphics2D) g;

            // более высокое качество проприросвки
            gr2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Ellipse2D ellipse2D = new Ellipse2D.Double(50, 50, 100, 100);
            gr2d.draw(ellipse2D);

            // более низское качество прорисовки
            RenderingHints renderingHints1 = new RenderingHints(null);
            renderingHints1.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            gr2d.setRenderingHints(renderingHints1);
            Ellipse2D ellipse2D1 = new Ellipse2D.Double(150, 50, 100,100);
            gr2d.draw(ellipse2D1);

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

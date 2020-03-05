import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.io.File;

public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        jframe.add(new MyComponent());
        jpanel.revalidate();
    }

    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            // рисуем линию
            // g.drawLine(0, 0, 100, 100);

            // усовершенствованный класс
            Graphics2D g2 = (Graphics2D) g;

            // точки
            Point2D point = new Point2D.Double(50, 0);
            Point2D point2 = new Point2D.Double(100, 50);

            // Line2D line = new Line2D.Double(0,0, 100, 100);
            Line2D line = new Line2D.Double(point, point2);
            g2.draw(line);

            // рисуем прямоугольник
            Rectangle2D rectangle2D = new Rectangle2D.Double(100, 0, 100, 50);
            g2.draw(rectangle2D);

            // прямоугольник с закругленными краями
            RoundRectangle2D rectangle2D1 = new RoundRectangle2D.Double(200, 0, 100, 50, 20, 20);
            g2.draw(rectangle2D1);

            // элипсы
            Ellipse2D ellipse2D = new Ellipse2D.Double(300, 0, 100, 50);
            g2.draw(ellipse2D);

            // кривая
            QuadCurve2D quadCurve2d = new QuadCurve2D.Double(400, 0, 425,100,450,0);
            g2.draw(quadCurve2d);

            // кривая
            CubicCurve2D cubicCurve2D  = new CubicCurve2D.Double(450, 50, 475, 150, 525, -50, 550, 50);
            g2.draw(cubicCurve2D);

            // обрезанный элепс
            Arc2D arc2d = new Arc2D.Double(0, 100,100, 100, 0,90, Arc2D.PIE);
            g2.draw(arc2d);

            // самостоятельная прорисовка обьтектов
            GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo(100, 100);
            generalPath.lineTo(200, 100);
            generalPath.quadTo(250, 200, 300, 100);
            generalPath.curveTo(325, 200,375, 0, 400, 100);
            // замыкание линии
            generalPath.closePath();
            g2.draw(generalPath);

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

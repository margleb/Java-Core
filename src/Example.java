import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.net.MalformedURLException;
import java.net.URL;

public class Example {

    public static void main(String[] args) {
        JFrame jframe = getFrame();
        // список доступных шрифтов
        // String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        // for(String s: fonts) {
            // System.out.println(s);
        // }
        jframe.add(new MyComponent());
    }

    static class MyComponent extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            // шрифт
            Font font = new Font("Bahnschrift", Font.BOLD, 20);
            // болеее расширенный класс
            Graphics2D g2 = (Graphics2D)g;

            g2.setFont(font);
            g2.drawString("hello world!", 50, 50);
            // установить цвет
            g2.setPaint(Color.red);

            // координаты рисования линии
            // Line2D l1 = new Line2D.Double(70, 70, 190, 190);
            // проиросовка линии
            // g2.draw(l2);

            // Рисование линии по точкам
            Point2D p1 = new Point2D.Double(70, 70);
            Point2D p2 = new Point2D.Double(170, 170);
            Line2D l2 = new Line2D.Double(p1, p2);
            g2.draw(l2);

            // Элипсы
            // Ellipse2D el = new Ellipse2D.Double(70, 70, 170, 170);

            // Элипс помочью points
            Ellipse2D el = new Ellipse2D.Double();
            el.setFrameFromDiagonal(p1, p2);

            g2.draw(el);
            // закрашиваем территорию
            // g2.fill(el);

            // Прямоугольники
            // Rectangle2D r2 = new Rectangle2D.Double(70, 70, 170, 170);

            // Прямоугольник с помочью points
            Rectangle2D r2 = new Rectangle2D.Double();
            r2.setFrameFromDiagonal(p1, p2);

            g2.draw(r2);

            // получаем изображение
            // URL url = new URL("https://c7.hotpng.com/preview/151/285/75/plain-old-java-object-spring-framework-java-virtual-machine-javascript-others-thumbnail.jpg");
            Image image = new ImageIcon("img/java.jpg").getImage();
            g2.drawImage(image, 220, 50, null);

        }
    }

    static JFrame getFrame() {
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        // jframe.setSize(500, 200);
        // jframe.setLocation(200,400);
        jframe.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 300);
        // jframe.setTitle("Hi there!");
        return jframe;
    }
}

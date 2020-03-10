import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
      JFrame jframe = getFrame();
      JPanel jpanel = new JPanel();
      jframe.add(jpanel);
      JButton button = new JButton("submit");
      button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              jframe.setTitle(jframe.getTitle() + "1");
          }
      });
      jpanel.add(button);
      JButton jbutton2 = new JButton("click submit");
        jpanel.add(jbutton2);
        jbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice device = environment.getDefaultScreenDevice();
                try {
                    // перемещение мыши и нажатие
                    Robot robot = new Robot(device);
                    robot.mouseMove(750 + 200, 250 + 50);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    // фокус кнопки
                    robot.keyPress(KeyEvent.VK_TAB);
                    robot.keyRelease(KeyEvent.VK_TAB);

                    // printscreen
                    // Rectangle rectangle = new Rectangle(0,0,1000,1000);
                    // BufferedImage image = robot.createScreenCapture(rectangle);

                } catch (AWTException el) {
                    el.printStackTrace();
                }
            }
        });
        jpanel.revalidate();
    }

    private static JFrame getFrame() {
        JFrame jframe = new JFrame() {};
        jframe.setVisible(true);
        jframe.setBounds(750, 250, 500, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jframe;
    }
}

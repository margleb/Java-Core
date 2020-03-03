import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static JFrame jframe = getFrame();
    // cоздаем панель
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        // создаем кнопку
        JButton jbutton = new JButton(new MyAction());
        jbutton.setText("Кнопка");
        jpanel.add(jbutton);
    }

    // класс AbstractAction можно переиспользовать в других местах
    static class MyAction extends AbstractAction {

        MyAction() {
            // возможность создания экшенов (краткое описание)
            putValue(AbstractAction.SHORT_DESCRIPTION, "My small action");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            jpanel.setBackground(Color.blue);
        }
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

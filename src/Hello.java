import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

public class Hello {
    public static void main(String[] args) {
        JFrame jframe = setFrame();
        // cоздаем панель
        JPanel jpanel = new JPanel();
        jframe.add(jpanel);
        // создаем кнопку
        JButton jbutton = new JButton("Hello");
        jpanel.add(jbutton);
//        jbutton.addActionListener(new ActionListener() {
//            @Override
//             public void actionPerformed(ActionEvent e) {
//                 // getSource - откуда пришло (ресурс)
//                 // getText() - получаем текст и отображаем как тайтл
//                 jframe.setTitle(((JButton)e.getSource()).getText());
//             }
//        });
        // jbutton.addActionListener(EventHandler.create(ActionListener.class, jframe, "title", "source.text"));
    }

    public static JFrame setFrame() {
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(20,20, 300, 500);
        jframe.setTitle("Example");
        return jframe;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame jFrame = getFrame();
        // создаем панель
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        // создаем кнопку
        JButton jButton = new JButton("submit");
        jPanel.add(jButton);
        // cоздаем событие
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPanel.setBackground(Color.blue);
            }
        });
    }



    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setBounds(750, 250, 500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        JButton jButton = new JButton("Show Modal");
        jpanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyModal().setVisible(true);
            }
        });
    }

    static class MyModal extends JDialog {
        public MyModal() {
            super(jframe, "title", true);
            add(new JTextField(), BorderLayout.NORTH);
            add(new JButton("Кнопка"), BorderLayout.SOUTH);
            setBounds(0, 0, 500,300);
        }
    }

    static JFrame getFrame() {
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(750, 250, 500, 500);
        jframe.setTitle("Example");
        return jframe;
    }

}

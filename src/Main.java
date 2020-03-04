import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        JButton jButton = new JButton("show dialog");
        jpanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog myDialog = new MyDialog();
                myDialog.setVisible(true);
            }
        });

    }
    
    static class MyDialog extends JDialog {
        public MyDialog() {
            super(jframe, "Title", true);
            add(new JTextField(), BorderLayout.NORTH);
            add(new JButton("button"), BorderLayout.SOUTH);
            setBounds(500, 500, 250, 150);
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

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
                Color color = JColorChooser.showDialog(jpanel, "title", Color.blue);
                jpanel.setBackground(color);
            }
        });

        jpanel.revalidate();
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        JButton jbutton = new JButton("show dialog");
        jpanel.add(jbutton);
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // высплывающее окно со значком error
                // JOptionPane.showMessageDialog(jpanel, "this is my dialog", "title", JOptionPane.ERROR_MESSAGE);
                // окно conformation, возращает значение, с кастомные кнопками
                //System.out.println(JOptionPane.showConfirmDialog(jpanel, "some massage", "title", JOptionPane.YES_OPTION));
                // окно с выбором параметров
                // JOptionPane.showOptionDialog(jpanel, "message", "title", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, new Object[] {"one", "two", "three"}, "two" );
                // поле для ввода
                System.out.println(JOptionPane.showInputDialog(jpanel, "some message"));
            }
        });
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

import javax.swing.*;
import java.awt.*;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        jpanel.add(new JButton("One"));
        // у данного элемента фокуса не будет
        jpanel.add(new JButton("Two")).setFocusable(false);
        // в самом начале фокус будет на 3тьем элементе
        jpanel.add(new JButton("Three")).requestFocusInWindow();
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

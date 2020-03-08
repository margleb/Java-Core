import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    static JFrame jframe = addWindow();
    static JPanel jPanel = new JPanel();
    public static void main(String[] args) throws IOException {
        jframe.add(jPanel);

        JTextField jTextField = new JTextField(10);
        JTextField jTextField1 = new JTextField(10);

        jTextField.setDragEnabled(true);
        jTextField1.setDragEnabled(true);

        jPanel.add(jTextField);
        jPanel.add(jTextField1);

        jframe.revalidate();
    }

    static public JFrame addWindow() {
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Toolkit toolkit = Toolkit.getDefaultToolkit();
        // Dimension dimension = toolkit.getScreenSize();
        jframe.setBounds(0,0, 500,300);
        jframe.setTitle("Окно");
        return jframe;
    }
}


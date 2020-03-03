import javax.swing.*;
import javax.swing.border.Border;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);

        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 20);
        jpanel.add(jSlider);
        jSlider.setMinorTickSpacing(10);
        jSlider.setMajorTickSpacing(20);
        jSlider.setPaintTicks(true);
        // привязка
        jSlider.setSnapToTicks(true);
        // лейблы
        jSlider.setPaintLabels(true);

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

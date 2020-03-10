import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JFrame jframe = getFrame();
        JPanel jPanel = new JPanel();
        jframe.add(jPanel);
        JButton button = new JButton("submit");
        // логирование кнопки
        // button.setDebugGraphicsOptions(DebugGraphics.LOG_OPTION);
        // медленная прорисовка
        // RepaintManager.currentManager(jframe.getRootPane()).setDoubleBufferingEnabled(true);
        // ((JComponent)jframe.getContentPane()).setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
        jPanel.add(button);
    }

    private static JFrame getFrame() {
        JFrame jframe = new JFrame() {};
        jframe.setVisible(true);
        jframe.setBounds(750, 250, 500, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jframe;
    }
}

import javax.swing.*;
import java.awt.*;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        jpanel.setLayout(gridBagLayout);

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridheight = 2;
        constraints1.gridwidth = 2;
        jpanel.add(new JTextArea(4, 20), constraints1);

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.weightx = 0;
        constraints2.weighty = 0;
        // координаты (смещаемся на 2)
        constraints2.gridx = 2;
        constraints2.gridy = 0;
        // занимаемые элементы по высоте/ширине
        constraints2.gridheight = 1;
        constraints2.gridwidth = 2;
        jpanel.add(new JButton("submitVeryLong name"), constraints2);

        GridBagConstraints constraints3 = new GridBagConstraints();
        // ширина высота
        constraints3.weightx = 0;
        constraints3.weighty = 0;
        // координаты (смещаемся на 2)
        constraints3.gridx = 2;
        constraints3.gridy = 1;
        // занимаемые элементы по высоте/ширине
        constraints3.gridheight = 1;
        constraints3.gridwidth = 1;
        jpanel.add(new JButton("submit11"), constraints3);

        GridBagConstraints constraints4 = new GridBagConstraints();
        // ширина высота
        constraints4.weightx = 0;
        constraints4.weighty = 0;
        // координаты (смещаемся на 2)
        constraints4.gridx = 3;
        constraints4.gridy = 1;
        // занимаемые элементы по высоте/ширине
        constraints4.gridheight = 1;
        constraints4.gridwidth = 1;
        jpanel.add(new JButton("submit11"), constraints4);

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

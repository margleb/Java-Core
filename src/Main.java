import javax.swing.*;
import javax.swing.border.Border;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        // чекбокс
        jpanel.add(new JCheckBox("check box label"));
        // радиокнопки
        JRadioButton jRadioButton1 = new JRadioButton("one");
        JRadioButton jRadioButton2 = new JRadioButton("two");
        jpanel.add(jRadioButton1);
        jpanel.add(jRadioButton2);
        // группируем радиокнопки
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);

        // поумолчанию выбрано
        jRadioButton2.setSelected(true);
        // список
        JComboBox<String> comboBox = new JComboBox();
        comboBox.addItem("one");
        comboBox.addItem("two");
        comboBox.addItem("three");
        // бордер 
        Border border = BorderFactory.createEtchedBorder();
        Border border1 = BorderFactory.createTitledBorder(border, "title");
        jpanel.add(comboBox);

        jpanel.setBorder(border1);


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

import javax.swing.*;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);

        // Поле с видимостью в 20 символов
        jpanel.add(new JTextField("default value",  20));
        // JTextField jTextField = new JTextField();
        // jTextField.getText();

        // Добавляем лейбл к полю
        jpanel.add(new JLabel("this is label"));

        // Поле для паролей видимостью в 20 символов
        jpanel.add(new JPasswordField(20));

        // Текстовое поле
        JTextArea JTextArea = new JTextArea(5, 20);
        // Отменяем расширение в ширину
        JTextArea.setLineWrap(true);

        // Добавляем cкролл для текстового поля
        JScrollPane jScrollPane = new JScrollPane(JTextArea);
        jpanel.add(jScrollPane);

        // Поддерживает отложенный автоматический макет
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

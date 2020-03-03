import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static JFrame jframe = getFrame();
    // cоздаем панель
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        // абстрактный экшн
        AbstractAction myAction = new MyAction();
        // создаем кнопку
        JButton jbutton = new JButton(myAction);
        jbutton.setText("Кнопка");
        jpanel.add(jbutton);

        // создаем сочетание клавиш
        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");
        // создаем Map, c указанием при каком условии будет срабатывать сочетание клавиш (например, при фокусе)
        InputMap inputMap = jpanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        // индентифицируем какой либо обьект и его событие
        inputMap.put(keyStroke, "changeColor");
        // при вызове определенного обьекта, вызывается action
        ActionMap actionMap = jpanel.getActionMap();
        actionMap.put("changeColor", myAction);
    }

    static class MyAction extends AbstractAction {

        // MyAction() {
            // putValue(AbstractAction.SHORT_DESCRIPTION, "This is gleb");
        // }

        @Override
        public void actionPerformed(ActionEvent e) {
            jpanel.setBackground(Color.blue);
        }
    }


    static JFrame getFrame() {
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(20, 20, 300, 500);
        jframe.setTitle("Example");
        return jframe;
    }
}

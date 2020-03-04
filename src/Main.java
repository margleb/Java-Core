import javax.swing.*;
import javax.swing.border.Border;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        JToolBar jToolBar = new JToolBar("title");
        JButton one = new JButton("first");
        jToolBar.add(one);
        jToolBar.add(new JButton("two"));
        jToolBar.addSeparator();
        jToolBar.add(new JButton("three"));
        jpanel.add(jToolBar);
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

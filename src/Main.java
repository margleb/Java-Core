import javax.swing.*;
import java.awt.*;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        jpanel.setLayout(new MyComponentManager());
        jpanel.add(new JButton("One"));
        jpanel.add(new JButton("Two"));
        jpanel.add(new JButton("Three"));

    }

    static class MyComponentManager implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
            for(int i = 0; i < parent.getComponentCount(); i++) {
                parent.getComponent(i).setBounds(100 * i,40 * i, 100,40);
            }
        }
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

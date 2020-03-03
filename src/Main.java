/*
У нас есть 2 основных интерфейса:
1. MouseMotionListener
2. MouseListener
Которые имплементят множество разных методов для работы с мышью, все они присутсвуют в MouseAdapter и мы можем переписать те, которые нам нужны


 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    static JFrame jframe = getFrame();

    // cоздаем панель
    // static JPanel jpanel = new JPanel();

    public static void main(String[] args) {

        // jframe.add(jpanel);
        // jpanel.addMouseListener(new MouseAdapter() {
            // @Override
            // public void mouseClicked(MouseEvent e) {
                // super.mouseClicked(e);
                // jpanel.setBackground(Color.blue);
            // }
        // });

        // Отслеживание координат мыши
        JComponent jComponent = new MyComponent();
        jframe.add(jComponent);
        jframe.addMouseMotionListener(new MouseAdapter() {
            @Override
            // при движении мыши будет происходить событие
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                MyComponent.xCoord = e.getX();
                MyComponent.yCoord = e.getY();
                // repaint() перерисует координаты
                jComponent.repaint();
            }
        });
    }


    static class MyComponent extends JComponent {
        public static int xCoord;
        public static int yCoord;
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D)g).drawString("Coorinates x: " + xCoord + " y " + yCoord, 50, 50);
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

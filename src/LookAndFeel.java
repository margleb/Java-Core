import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookAndFeel {
    public static void main(String[] args) {
        // основные мотивы
        // UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
        // for(UIManager.LookAndFeelInfo lookAndFeelInfo : lookAndFeelInfos) {
        // System.out.println(lookAndFeelInfo.getName());
        // System.out.println(lookAndFeelInfo.getClassName());
        // }

        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);

        JButton jButton1 = new JButton("Metal");
        JButton jButton2 = new JButton("Nimbus");
        JButton jButton3 = new JButton("CDE/Motif");
        JButton jButton4 = new JButton("Windows");
        JButton jButton5 = new JButton("Windows Classic");

        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jButton4);
        jPanel.add(jButton5);


        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


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

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;


public class Main {

    static JFrame jframe = getFrame();
    static JPanel jpanel = new JPanel();

    public static void main(String[] args) {
        jframe.add(jpanel);
        JButton jButton = new JButton("show file dialog");
        jpanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                // setMultiSelectionEnabled - возможность выбора нескольких файлов
                
                fileChooser.setMultiSelectionEnabled(true);
                // выбор по умолчанию (файлы и дериетории)
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                // фильтр только gif файлы
//                fileChooser.setFileFilter(new FileFilter() {
//                    @Override
//                    public boolean accept(File f) {
//                        if(f.getName().endsWith("gif")) {
//                            return true;
//                        }
//                        return false;
//                    }
//                    @Override
//                    public String getDescription() {
//                        return "only gif giles!";
//                    }
//                });

                // добавляем текстовое поле
                // TextField textField = new TextField("Раз два три");
                // fileChooser.add(textField);

//                fileChooser.addPropertyChangeListener(new PropertyChangeListener() {
//                    @Override
//                    public void propertyChange(PropertyChangeEvent evt) {
//                        // при изменении файла в проводнике, меняется его название
//                        textField.setText(evt.getNewValue().toString());
//                    }
//                });


                // показать диалоговое окно
                fileChooser.showDialog(jpanel, "save as");


                File file = fileChooser.getSelectedFile();
                // получить имя выбранного файла
                System.out.println(file.getName());

            }
        });

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

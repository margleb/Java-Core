/*
Aпплет - эта прикладная программа на Java, включаемая в cостав HTML-cтраниц. Сама HTML-страница должна сообщать браузеру, какой именно аплет следует загрузить и где разместить каждый аплет на странице

Прежде чем просматривать аплет в окне барузера, желательно проверить его с помочью утилиты appletviewer, специально предназначенной для просмотра аплетов. Эта утилита входит в состав JDK
Чтобы проверить аплет с помочью утилиты appletviewer, выполните следюдующую команду
appletviewer NotHelloWorldApplet.html

*/

import java.awt.*;
import javax.swing.*;

//  JApplet, являющийся суперклассом для всех аплетов, создаваемых средствами библиотеки Swing
public class NotHelloWorld extends JApplet {
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
                add(label);
            }
        });
    }
}
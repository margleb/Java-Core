// Для работы необходимо скачать бибилиотеку JavaMail API Reference!
// www.oracle.com/technetwork/ java/javamail

import java.io.IOException;
import java.util.Properties;

public class EmailExample {
    public static void main(String[] args) throws IOException {
        // получаем св-ва из файла properties
        final Properties properties = new Properties();
        properties.load(EmailExample.class.getClassLoader().getResourceAsStream("mail.properies"));

        // настройка сообщения
        Session mailSession = Session.getDefaultInstance(properies);
        MimeMessage message = new MineMessage(mailSession);
        // от кого
        message.setFrom(new InternetAddress("myemail"));
        // кому
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("youremail@mail.ru"));
        // заголовок сообщения
        message.setSubject("hello");
        // текст
        message.setText("Hi this is my test message");

        Transport tr = mailSession.getTransport();
        tr.connect(null, "123"); // пароль
        // отправляем сообщение
        tr.sendMessage(message, message.getAllRecipiens());
        tr.close();


    }
}

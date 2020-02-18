/* Cериализация - запись обьектов в файл */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.liveLevel = 55;
        user.staticField =  45;

        Sword sword = new Sword();
        sword.level = 5;
        user.sword = sword;

        // сереиализуем файл
        FileOutputStream fileOutputStream = new FileOutputStream("tempFile");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        user.staticField =  35;

        // прочитываем файл
        FileInputStream fileInputStream = new FileInputStream("tempFile");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User newUser = (User) objectInputStream.readObject();
        objectOutputStream.close();

        // 0 - значение по-умолчанию, так как не сериализуемое поле
        System.out.println(newUser.liveLevel);
        // значение прочиталось не из файла
        System.out.println(newUser.staticField);
        // null - значение по-умолчанию, так как не сериализуемое поле
        System.out.println(newUser.sword);
    }
}

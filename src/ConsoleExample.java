/*

 */

import java.io.Console;

public class ConsoleExample {
    public static void main(String[] args) {
        // получаем консоль
        Console console = System.console();
        if(console!=null){
            // считываем данные с консоли
            String login = console.readLine("Enter Login:");
            char[] password = console.readPassword("Enter Password:");

            console.printf("Login: %s \n", login);
            console.printf("Password: %s \n", new String(password));
        }
    }
}

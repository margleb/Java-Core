import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Программа на стороне сервера
public class ServerSocketExample {
    public static void main(String[] args) throws IOException {
        // реализация сервера и ожидания подключения клиентов к заданному порту
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            // данный метод возращает обьект типа Socket как только какой-нибудль клиент подлключится к данному порту
            Socket socket = serverSocket.accept();
            // заносим в сканнер полученные данные от сокета
            // чтение и запись данных в потоки ввода-вывода
            /* Обмен текстовыми данными осуществляется через сокеты.
            Поэтому соответствующие потоки ввода-вывода через сокет преобразуются в сканирующие и записывающие потоки типа Scanner и Writer следующим образом:*/
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            // выводим hello
            // writer.println("hello");
            while(scanner.hasNextLine()) {
                String str = scanner.nextLine();
                System.out.println("you've send: " + str);
                // если передаем exit (закрывается)
                if(str.equals("exit")) {
                    break;
                }
            }
        }
    }
}

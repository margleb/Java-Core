/*
Сокет — это абстрактное понятие, обозначающее возможность для программ устанавливать соединения для обмена данными по сети.
Порт - номер программы
*/

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

// Программа на стророне клиента
public class Main {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket()) {
            // соеденился с сервером
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8189), 2000);
            // получил стрим данных и просканировал их
            Scanner scanner = new Scanner(socket.getInputStream());
            while(scanner.hasNextLine()) {
                // вывел
                System.out.println(scanner.nextLine());
            }
        }
    }
}
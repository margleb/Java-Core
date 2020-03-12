/*
Сокет — это абстрактное понятие, обозначающее возможность для программ устанавливать соединения для обмена данными по сети.

*/

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket()) {
            // cоединяем и получаем ответ
            socket.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13), 200);
            Scanner scanner = new Scanner(socket.getInputStream());
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
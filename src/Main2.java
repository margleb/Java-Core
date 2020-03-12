import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IOException {
        // позволяет по http проктолу получить html
        URLConnection connection = new URL("http://www.goole.com").openConnection();
        Scanner scanner = new Scanner(connection.getInputStream());
        // без делимитра не выведит текст
        scanner.useDelimiter("\\Z");
        System.out.println(scanner.nextLine());

        // список заголовков
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        for(Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

    }
}

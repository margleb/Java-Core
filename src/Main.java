import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        // Path path;
        // Files files;
        // File file = new File("some.file");
        // if(file.exists()) {
            // file.createNewFile();
        // }

        // в абсолютный путь
        Path path = Paths.get("temp.txt").toAbsolutePath();
        File file = new File("temp.txt");
        // path = file.toPath(); // Возвращает объект Path, созданный из * этого абстрактного пути.

        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.isAbsolute());

        // cкопировать
        Files.copy(Paths.get("temp.txt"), Paths.get("temp2.txt"), StandardCopyOption.REPLACE_EXISTING);
        // меняем имя либо перемещаем
        Files.move(Paths.get("temp2.txt"), Paths.get("temp3.txt"));
        // удлаем, если существует
        Files.deleteIfExists(Paths.get("temp3.txt"));
        // выводим размер файла
        System.out.println(Files.size(path));
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.getAttribute(path, "size", LinkOption.NOFOLLOW_LINKS));

        // атрибуты
        // BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        // PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class, LinkOption.NOFOLLOW_LINKS);

        // прочитываем все байты из файла
        byte[] bytes = Files.readAllBytes(path);
        for(int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        // Кодирует эту  строку в последовательность байтов, используя кодировку латформы по умолчанию, сохраняя результат в новом байтовом массиве.
        Files.write(path, "bla".getBytes());

        // прочитать все строки и вывести в список
        java.util.List<String> list = Files.readAllLines(Paths.get("temp.txt"));
        for(String s: list) {
            // Читать построчно
            System.out.println(s);
        }

        java.util.List<String> list1 = new ArrayList<String>();
        list1.add("new");
        // можно записывать
        Files.write(path, list1);
        // Можно получать Input/Output stream и Reader/Writer
        InputStream inputStream = Files.newInputStream(path);
        OutputStream outputStream = Files.newOutputStream(path);
        Reader reader = Files.newBufferedReader(path);
        Writer writer  = Files.newBufferedWriter(path);

        // Пробегает по списку дерикторий
        try(DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get(".")))  {
            for(Path path1: entries) {
                System.out.println(path1.getFileName());
            }
        }

        // пробегаемся по файлам и видоизменем их при необходимости
        Files.walkFileTree(Paths.get("."), new HashSet<FileVisitOption>(), 1, new MyFileVisitor());

    }
}

// экстендим SimpleFileVisitor (ecmь еще FileVisitor)
class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}
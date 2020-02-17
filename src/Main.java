/*

Исключения делятся на два вида
1. Проверяемые (сhecked) - то есть те, которые не проверяет компилятор
2. Непроверяемые (unchecked) - те, которые требуют обработки (например, try/catch) или выбрашена в методе

Разница в том, что проверяемые (checked) ошибки компилятор может ожидать. Например при считывании дынных из файла может легко возникнуть ситуация, что файл не существует.
Соответственно непроверяемые (unchecked) это те, которые компилятор не может ожидать, они являются чаще всего СЛЕДСВИЕМ ОШИБОК программиста


Иерархия:
1. В самом начале у нас стоит класс Throwable, который является суперклассом всех еrrors и exceptions (Сhecked).
    1.1 Errors - это критические ошибки во время исполнения программы, связанные с работой виртуальной машины Java. Их обработка (try/catch и т.д.) НЕ ТРЕБУЕТСЯ (Unchececked)
            Пример:
            - StackOverflowError - возникает когда метод бесконечно вызывает сам себя
            - OutOfMemoryError - возникает когда недостаточно памяти для создания новых объектов.
    1.2 Exceptions - это, собственно, исключения: исключительная, незапланированная ситуация, которая произошла при работе программы (Checked).
        1.2.1 RuntimeExceptions(Unchecked) - cуперкласс всех исключений, бросаемых в процессе нормальных операций JRE, т.е непроверяемые (Unchececked) ошибки.
            Пример
            - ArithmeticException -  возникает при делении на ноль
            - ArrayIndexOutOfBoundsException - возникает при попытке обратиться к ячейке за пределами массива.
            - NullPointerException - Выбрасывается, когда приложение пытается вызвать несуществующий обьект (т.е. ссылку null)
        1.2.2 IOExceptions (Input-Out) - в этот блок входят проверяемые (Checked)  ошибки
            Пример
            - FileNotFoundException - возникает, когда файла по указанному пути не существует
            - SocketException - есть ошибка, создающая или получающая доступ к Сокету.

 */

import java.io.IOException;

public class Main extends Object {

    public static void main(String[] args) throws Exception, IOException {
        // 1ый пример
        // System.out.println(new Main().exampleOne());

        // 2ой пример (предотвращение вызова finally)
        new Main().exampleTwo();
        System.out.println("after exampleTwo exit");

        // 3ий пример (пример с Сatch)
        // new Main().exampleThree();

        // 4ий пример
        new Main().exampleFour();

    }

    String exampleOne() {
        // у блока try обязательно должен быть finally или catch
        try {
            Object obj = null;
            obj.hashCode(); // бросается исключение
            System.out.println("try");
            return "return try";
        } catch(NullPointerException e) {
            // печатаем стек
            // e.printStackTrace();
            System.out.println("catch");
            return "return catch";
        // выполняется всегда в независимости от брошенна ошибка или нет
        // finally блоков не может быть 2
        } finally {
            System.out.println("finally");
            return "return finally";
        }
    }

    void exampleTwo() {
        // у блока try обязательно должен быть finally или catch
        try {
            // 1. finally блок можно прервать при необходимости
            // System.exit(0);
            // 2. либо бесконечный цикл
            // while(true) {}
            throw new NullPointerException("Demo");
        } finally {
            System.out.println("before exit");
            // 1. finally блок можно прервать при необходимости
            // System.exit(0);
            // 2. либо бесконечный цикл
            // while(true) {}
            // 3. либо вызов error или exception
            // throw new Error();
            // throw new RuntimeException();
            System.out.println("after exit");
        }
    }

    void exampleThree() {
        try {
        System.out.println("try");
        // сatch может быть несколько
        // catch не могут повторятся
        /* вызов exceptions в сatch должны соблюдать иерархию вложенности,
        а именно сначала более мелкие ошибки, затем более общие */
        } catch(ArrayIndexOutOfBoundsException e) {
            // Внутри catch допускается выбрасвать снова ошибки
            try { throw new RuntimeException();
            } catch (ArrayIndexOutOfBoundsException err) { }
        } catch(RuntimeException e) { }
    }

    void exampleFour() throws IOException {
        // Unchecked Exception, т.е тот который не проверяет компилятор
        // throw new RuntimeException();
        // Checked Exception, требует обработки (либо try/catch либо наверх)
        // try { throw new IOException(); } catch(IOException e) {}
        throw new IOException();
    }

}

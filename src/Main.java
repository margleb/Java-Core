/*
toString() метод в Java используется для предоставления ясной и достаточной информации об объектаx ( Object ) в удобном для человека виде.
Правильное переопределение метода toString() может помочь в ведении журнала работы и в отладке Java программы предоставляя ценную и важную информацию.

Map - обьект, хранящий ключи к значениям. Map не может содержать дубликаты ключей, каждый ключ может соответсвовать только одному значению
HashMap - хранит значения в произвольном порядке, но позволяет быстро искать элементы карты. Позволяет задавать ключ или значение ключевым словом null.

object.hashCode() -  отображает место(адрес) объекта в памяти в виде int значения.
Xеширование — преобразование входного массива данных произвольной длины в выходную битовую строку фиксированной длины.

Если у обьектов hashCode равноы, то это не значит что они равны по equals, но если они равны по equals, то их hashCode должны быть равны
При переопределении одного из этих методов, требуется переопределение и второго

При использовании в Maps обьекта в качестве ключа, всегда необходимо переопределять его equals() и hashCode()

*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Book {
    String author, name;
}

class LibraryCard {

    int number;

    @Override
    // int значение позволяет нам записать не более 2*32 уникальных номеров
    // в случае, если количество элементов в массиве превышает эту цифру,
    // то уникальные номера могут повторятся, для того, чтобы их различить
    // используется дополнительно метод equals
    public boolean equals(Object o) {
        // если это один и тот же обьект
        if (this == o) return true;
        // если объект равен null, или название текщуего класса, не равно
        // названию класса передаваемого обьекта
        if (o == null || getClass() != o.getClass()) return false;
        // проверяем схожесть номеров
        LibraryCard that = (LibraryCard) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}

public class Main {
    int value;
    @Override
    public String toString() {
        return "Вывод информации об обьекте: " + getClass().getName();
    }

    public static void getBooksList() {
        // 1ая книга
        Book book1 = new Book();
        book1.author = "Рей Бредбери";
        book1.name = "451° по Фаренгейту";
        // 2ая книга
        Book book2 = new Book();
        book2.author = "Михаил Булгаков";
        book2.name = "Мастер и Маргарита";
        // 3я книга
        Book book3 = new Book();
        book2.author = "Даниел Киз";
        book2.name = "Цветы для Элджернона";

        // создаем ассоциативный массив
        Map<String, Book> books = new HashMap<>();
        books.put(book1.name, book1);
        books.put(book2.name, book2);
        books.put(book3.name, book3);

        System.out.println("Список книг в массиве: \n" + books + "\n");

        // получаем конкретную книгу из ассоциативного массива
        Book getBook1 = books.get("Мастер и Маргарита");
        System.out.println("Автор книги " + getBook1.name + ": " + getBook1.author + ", a ee хеш-код " + getBook1.hashCode());

    }

    public static void GetBookByCard() {

        // 1ая книга
        Book book4 = new Book();
        book4.author = "Федор Достоевский";
        book4.name = "Преступление и наказание";

        // Пример получения книг по id читательского билета
        Map<LibraryCard, Book> booksByCard = new HashMap<>();

        // Читательский билет №1
        LibraryCard libraryCard1 = new LibraryCard();
        libraryCard1.number = 12345;

        booksByCard.put(libraryCard1, book4);

        // Читательский билет №2
        LibraryCard libraryCard2 = new LibraryCard();
        libraryCard2.number = 12345;
        booksByCard.get(libraryCard2);

        System.out.println("Список книг в массиве: \n" + booksByCard);

        // мы не можем получить по аналогичному читатьельскому билету
        // так как он находится в другом участке памяти
        Book getBook4 = (Book) booksByCard.get(libraryCard2);
        System.out.println(getBook4.name);

    }

    public static void main(String[] args) {
        // toString() метод вызывается неявно
        // System.out.println(new Main() + "\n");

        // Получаем список книг
        // getBooksList();

        // Получаем номер паспорта по имени
        GetBookByCard();

    }
}

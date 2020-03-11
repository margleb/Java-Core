public class Main {
    public static void main(String[] args) {
        Book x = new Book("one");
        Book y = new Book("one");
        Book z = new Book("one");

        // Рефлексия
        System.out.println("reflexive");
        System.out.println(x.equals(x)); // всегда true
        System.out.println("");

        // Симетрия
        System.out.println("symmetric");
        System.out.println(x.equals(y));
        System.out.println(y.equals(x));
        System.out.println("");

        // Транзитивность
        System.out.println("transitive");
        System.out.println(x.equals(y));
        System.out.println(y.equals(z));
        System.out.println(x.equals(z));
        System.out.println("");

        // Постояннство
        System.out.println("consistent");
        System.out.println(x.equals(y));
        System.out.println(x.equals(y));
        System.out.println(x.equals(y));
        System.out.println(x.equals(y));
        System.out.println("");

        // Не нулевое
        System.out.println("not null");
        System.out.println(x.equals(null)); // всегда false

    }
}

class Book {
    String title;
    public Book(String title) {
        this.title = title;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Book) {
            return obj != null && this.title.equals(((Book)obj).title);
        }
        return false;
    }
}

/*
Компилятор создает для каждого класса свой конструктор по умолчанию наследуемый из Object
super() - ключевое слово super в Java используется когда подклассу требуется сослаться на его непосредственный суперкласс.

*/

class MyParent {
    MyParent(String arg) {
        // здесь тоже есть super(), но мы его не видим
        System.out.println("MyParentConstructor " + arg);
    }
    MyParent() {
        System.out.println("Default Contructor!");
    }
}

class ConstructorExample extends MyParent  {
    int i;

    ConstructorExample(int i) {
        // идет всегда первой строкой!
        // super("for Parent");
        System.out.println("First Constructor");
    }
    ConstructorExample() {
        // вызывается конструктор c аргументом i
        this(4);
        System.out.println("Second Constructor");
    }

    public static void main(String[] args) {
        // инициализация
        new ConstructorExample();
    }
}
/*
 Object.equqls(Ojbect obj) - сравнивает два обьекта. Работает по тому же принципу что и оператор сравнение ==, для
 Чтобы сравнить содержимое объекта для равенства, equals() должно быть переопределено.

 +-/*
 %
 = != -=
 < > <= >=
 string +
 ++ --
 ?:
 & | ^ ! && ||

 */



public class Main extends Object {
    public static void main(String[] args) {
        int a = 12;
        int b = 5;
        double j = 5.0;
        int c = a;
        a += 6;
        a++;

        Object obj1  = new Object();
        Object obj2 = new Object();
        Byte b1 = 2;
        Short sh = 123;

        // System.out.println(a + b);
        // System.out.println(a / b);
        // System.out.println(a * b);
        // System.out.println(a - b);
        // System.out.println(a % b);

        // Операторы сравнения
        // System.out.println(5 >= 6);
        // System.out.println(5 <= 5);
        // System.out.println(5 == 5.0);
        // разные обьекты с разными адресами
        // System.out.println(obj1 == obj2);
        // System.out.println(5 != 5.0);

        // Main main = new Main();
        // переменная main экземпляр класса Object
        // System.out.println(main instanceof Object);
        // System.out.println(main instanceof Main);

        // String s = "bla";
        // System.out.println(s + " yohoho");
        // выведит 56
        // System.out.println("" + 5 + 6);
        // выведит 11
        // System.out.println(5 + 6 + "");

        // Оператор п
        int n = 5;
        int y = 5;
        // n++ - cначала выводится n, затем увеличивается на 1
        // ++n - cначала увеличивается на 1, затем выводится n
        // 5, 6
        // System.out.println(n++);
        // System.out.println(n);
        // 6, 6
        // System.out.println(++y);
        // System.out.println(y);
        // 14, 8
        // System.out.println(n++ + ++n);
        // System.out.println(n);

        // тернарный оператор
        int z = (5 > 6) ? 1 : 2;
        // System.out.println(z);

        // логические операторы

        // проверяет либо одно условие, либо второе
        System.out.println(5 > 4 || returnBool());
        // проверяет оба условия, запускает returnBool()
        System.out.println(5 > 4 | returnBool());
        System.out.println();

        // проверяет либо одно условие, либо второе
        System.out.println(5 < 4 && returnBool());
        // проверяет оба условия, запускает returnBool()
        System.out.println(5 > 4 & returnBool());
        System.out.println();
        // оператор нет
        System.out.println(!(3 > 4));
        System.out.println();
        // оператор галочка (проверяет что наши операторы разные)
        // false
        System.out.println(true ^ false);
        // true
        System.out.println(true ^ true);

    }

    private static boolean returnBool() {
        System.out.println("returnBoolean");
        return true;
    }

}

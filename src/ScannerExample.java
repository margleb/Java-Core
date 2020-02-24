import java.util.Scanner; // импорт сканера

public class ScannerExample {
    public static void main(String args[]){

        System.out.print("Введите 2 любых целых числа: ");
        // «Стандартный» поток ввода.
        Scanner scan = new Scanner(System.in);

        // # 1 Ввод int значений
        int number1 = scan.nextInt();
        int number2 = scan.nextInt();
        System.out.println ("Cумма чисел: " + (number1 + number2));

        // #2 Ввод double значений
        System.out.print("Введите любое дробное число: ");
        double number = scan.nextDouble();
        System.out.println ("Вы ввели дробное число " + number);

        // #3 Ввод String значений
        System.out.println("Введите любые 2 слова или фразу: ");
        String phrase1 = scan.nextLine();
        // String phrase2 = scan.nextLine();
        System.out.println(phrase1);

        // #4 Вывод до первого пробела
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите любое слово или фразу: ");
        String phrase3 = sc.next();
        System.out.println(phrase3);

    }
}

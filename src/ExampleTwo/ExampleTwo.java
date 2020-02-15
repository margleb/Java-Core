package ExampleTwo;
import ExampleOne.ExampleOne;

public class ExampleTwo extends ExampleOne {
    public static void main(String[] args) {
        // Нельзя импортировать классы из пакета по умолчанию
        // Main main = new Main();

        ExampleOne exampleOne = new ExampleOne();
        ExampleTwo exampleTwo = new ExampleTwo();

        /* верхний уровень */
        // Могу получить доступ, так как импортирован и публичный
        System.out.println(exampleOne.one);

        /* нижний уровень (уровень члена) */

        // Защищенное
        // Не могу получить доступ из класса
        // System.out.println(exampleOne.two);

        // Пакетно-приватное
        // Не могу получить доступ из класса
        // System.out.println(exampleOne.three);
        // He Могу получить доступ из собкласса
        // System.out.println(exampleTwo.three);

        // Приватное
        // Не могу получить доступ из класса
        // System.out.println(exampleOne.four);
        // He Могу получить доступ из собкласса
        // System.out.println(exampleTwo.four);

    }
}
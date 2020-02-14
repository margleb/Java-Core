/*
 Существует 3 вида распределения памяти в JAVA
 - Java Heap - используется для выделения памяти обьектам и классам JRE
 - Stack Memory - используется для выполнения потока (thread)
 - PermGen - содержит метаданные классов и объектов
 */

public class Human {
    int age = 20;
    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human.getAge(5, 0.2,true, human));
    }
    // примитивы при передаче в метод хранятся в Stack, а при передачи
    // обьектов - передается ссылка на него, сам обьект храниятся в Heap
    double getAge(int i, double d, boolean bool, Human human) {
        double newAge = i + d;
        return human.age = (int) newAge;
        // цикл забивает память Stack (StackOverflowError)
        // return human.getAge(i, d, bool, human);
    }
}

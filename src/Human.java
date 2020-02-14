public class Human {
    int age;
    double weight;
    public static void main(String[] args)
    {
        Human human = new Human();
        human.buyBread();
        human.buyMilk();
        System.out.println("Hello World!");
    }
    void birthday() {
        age = age + 1;
    }

    void buyBread() {
        System.out.println("buy bread");
    }

    void buyMilk() {
        System.out.println("buy milk");
    }
}

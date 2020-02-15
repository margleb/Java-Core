import java.io.IOException;

public class Overload {
    // ключевые слова, а также кидаение ошибок никак не оказывают влияние на overloading
    public static int addTwoDigits(int a, int b) throws IOException {
        return a + b;
    }
    protected final double addTwoDigits(double a, double b) throws RuntimeException {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        Overload overload = new Overload();
        OverloadChild overloadChild = new OverloadChild();
        System.out.println(overload.addTwoDigits(5, 6));
        System.out.println(overload.addTwoDigits(2.4, 3.5));
        overloadChild.addTwoDigits();

    }
}

class OverloadChild extends Overload {
    void addTwoDigits() {
        System.out.println("Overload Child");
    }
}
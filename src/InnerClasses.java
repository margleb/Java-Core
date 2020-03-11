public class InnerClasses {
    private static int j = 6;
    private int i = 5;
    Inner inner = new Inner();
    void method() {
        Inner inner = new Inner();
    }
    class Inner {
        int q = j;
        int w = i;
        void method() {
            q = j + i;
        }
        // статический класс не допускается
        // static int e = 5;
        // за исключением final
        final static int e = 5;
    }
    public static void main(String[] args) {
        Inner inner = new InnerClasses().new Inner();
    }
}
class OtherClass {
    InnerClasses.Inner inner = new InnerClasses().new Inner();
}
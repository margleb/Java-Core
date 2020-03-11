public class StaticInnerClass {

    private static int i = 1;
    int j = 2;

    static class Inner {
        static int q = i;
        int w = 2;
        enum e {
        }
        void method() {
            System.out.println("method");
        }
        static void staticMethod() {
        }
        Inner() {
            System.out.println("constructor");
        }
        int getI() {
            return i;
        }
    }

    static class Inner2 extends Inner {

    }
    class Inner3 extends Inner {
        void method() {
            System.out.println("inner3");
        }
    }

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        Inner inner = staticInnerClass.new Inner3();
        inner.method();
    }
}

class OtherClass extends StaticInnerClass.Inner {
    public static void main(String[] args) {
        StaticInnerClass.Inner inner = new StaticInnerClass.Inner();
        System.out.println(inner.getI());
    }
}

package reflection;

public class MyClass {
    private transient int i;
    // String s;
    public MyClass() {
    }
    // public MyClass(String s) {
        //this.s = s;
    // }
    public synchronized String someMethod(String s) {
        System.out.println("this is " + s);
        return s;
    }
}
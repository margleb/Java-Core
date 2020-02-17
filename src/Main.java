public class Main extends Object {
    public static void main(String[] args) {
        int a = 6;
        int b = 8;
        int c = 6;
        int d = 3;

        if(a > b) {
            System.out.println("a > b");
        } else if(a == b) {
            System.out.println("a == b");
        } else  {
            System.out.println("a < b");
        }

        if(a > b)
            if(c < d)
            System.out.println("a > b");
    }
}

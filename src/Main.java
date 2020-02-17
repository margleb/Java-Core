public class Main extends Object {

    enum Days { MONDAY, THUSDAY, WENSDAY }

    public static void main(String[] args) {
       int [] arr = {1,2,3};
       int i = 0;
       while(i == 5) {
           System.out.println(i);
           i++;
       }

       System.out.println();

       i = 0;
       // do выполнится как минимум один раз
       do {
           System.out.println(arr[i]);
           i++;
       } while(false);

    }
}

public class Main extends Object {

    enum Days { MONDAY, THUSDAY, WENSDAY }

    public static void main(String[] args) {
        // можно передать примитивы, строки или enum
        // без оператора break выведутся другие кейсы после условия
        // дефолт не обязательно должен быть последним
        int a = 1;
        String str = "string";
        Days thusday = Days.THUSDAY;
        switch(thusday) {
            case MONDAY:
                System.out.println(Days.MONDAY);
                // break;
            case THUSDAY:
                System.out.println(Days.THUSDAY);
                // break;
            case WENSDAY:
                System.out.println(Days.WENSDAY);
                // break;
            default:
                System.out.println("No idea!");
                // break;
        }
    }
}

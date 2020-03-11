public class LocalClasses {
    static int i = 5;
    int j = 6;
    void does(int e) {
        int r = 5;
        // до определения класса недопускается его использование
        // Local local;
        // класс работающий только на уровне метода
        // не может быть public private protected
        class Local {
            // финальная статическая переменная
            final static int q = 4;
            int w = j;
            public int t = e;
            int y = r;
        }
    }
    void does2() {
    }
}

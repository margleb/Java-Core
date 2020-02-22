public class Main {
    public static void main(String[] args) {
        //  0 0 0 0 1 1 0 1
        int a = 13; // 1101

        /** Позиция при сдвиге влево **/
        // при сдвиге, последние биты заполняем нулями
        // 13 * 2
        // 0 0 0 1 1 0 1 0
        int b = a << 1;
        // System.out.println(b); // 11010 (26)

        // 0 0 1 1 0 1 0 0
        // 13 * 2²
        int с = a << 2;
        // System.out.println(с); // 110100 (52)

        //  0 1 1 0 1 0 0 0
        // 13 * 2³
        int d = a << 3;
        // System.out.println(d); // 1101000 (78)

        /** Позиция при сдвиге вправо **/
        //  0 0 0 0 0 1 1 0
        // 13 / 2
        int e = a >> 1;
        System.out.println(e); // 110 (6)

        //  0 0 0 0 0 0 1 1
        // 13 / 2²
        int r = a >> 2;
        System.out.println(r); // 011 (3)
    }
}
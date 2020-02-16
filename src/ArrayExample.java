public class ArrayExample {

    public static void main(String[] args) {
        // инициалзиация массива
        Object[] i = new Object[5];
        // |null|null|null|null|null
        int[] j = new int[3];
        // |0|0|0|
        j[0] = 2;
        j[1] = 1;
        j[2] = 3;
        for(int k = 0; k < j.length; k++) {
            // System.out.println(j[k]);
        }

        // двухмерный массива
        int[][] b = new int[3][];
        int[] k = new int[5];
        b[0] = k;
        for(int f = 0; f < b[0].length; f++) {
            //System.out.println(b[0][f]);
        }

        // Анонимное создание массивов
        int[] h = {5, 6, 7};
        // methodArray(new int[][]{{1,2}, {3,4}, {4,6}});
        methodArray(h);
    }

    static void methodArray(int[] t) {
        for(int y = 0; y < t.length; y++) {
            System.out.println(t[y]);
        }
    }

}

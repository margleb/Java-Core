/*
1. В первую очередь преобразование идет к примитивам
2. Далее автобоксинг (но преобразование только к самому себе, то есть из short Integer не получится!)
3. В случае, если альтернативы не найдено, то запускается массивы с примитивным типом

 */

public class OverloadingExample {
    public static void main(String[] args) {
     OverloadingExample overloadingExample = new OverloadingExample();
     short b = 5;
     // кастим (обрезаем до byte)
     overloadingExample.OverloadMethod(b);
     // overloadingExample.OverloadMethod((byte) b);
    }

    /** Ecли short значение, то отправится к ближайму самому большому целочисленному значению **/
    // void OverloadMethod(int i) {
        // System.out.println("int");
    // }

    // void OverloadMethod(long i) {
        // System.out.println("long");
    // }

    /** автобоксинга из short приметива в Обьект Integer не будет!! **/
    /** чтобы заработало кастинг до int **/
    void OverloadMethod(Integer i) {
        System.out.println("Integer");
    }

    // void OverloadMethod(double i) {
        // System.out.println("double");
    // }

    // void OverloadMethod(short... i) {
        // System.out.println("short...");
    // }

    /** Если не находит примитивные типы, то тогда пытаемся сделать автобоксинг **/
    // void OverloadMethod(Short i) {
        // System.out.println("Short");
    // }

    /** После удаления методоа с аргументом Short, оverloading пойдет к Object **/
    // void OverloadMethod(Object i) {
        // System.out.println("Object");
    // }

    // void OverloadMethod(Object... i) {
        // System.out.println("Object...");
    // }

    // void OverloadMethod(byte i) {
        // System.out.println("byte");
    // }

    /********************************/
    // В итоге, допускается три варианта

    // расширение 1
    void OverloadMethod(int i) {
        System.out.println("int");
    }

    // автобоксинг 2
    // Либо к Object суперклассу
    void OverloadMethod(Short i) {
        System.out.println("Short");
    }

    // массивные типы 3
    void OverloadMethod(short... i) {
        System.out.println("Short");
    }
}

/*
num(перечисление) - это список именованных констант

// примерно то, что формируется в Enum
class CoffeSize2 {
    public static final CoffeSize2 SMALL = new CoffeSize2();
    public static final CoffeSize2 MEDIUM = new CoffeSize2();
    public static final CoffeSize2 BIG = new CoffeSize2();
}
*/

// Могут распологаться как в методе, так и за его пределами
// enum CoffeSize { SMALL, MEDIUM, BIG };

public class EnumExample {
    enum CoffeSize {
        SMALL(100),
        MEDIUM(200),
        // Константно-специфическое классовое тело
        // Constant-specific class bodies
        BIG(300) {
            // переопределение метода getCoffeeClass()
            String getCoffeClass() {
                return "B";
            }
        };

        // в enum допускаются поля
        String coffeClass = "A";
        int milliliters;
        // в enum можно создавать конструкторы
        CoffeSize(int milliliters) {
           this.milliliters = milliliters;
        }
        // можно создавать методы
        int getMilliliters() {
            return milliliters;
        }
        String getCoffeClass() {
            return coffeClass;
        }
    };
    public static void main(String[] args) {

        CoffeSize coffeSizeSmall = CoffeSize.SMALL;
        System.out.println(coffeSizeSmall);
        System.out.println(coffeSizeSmall.getMilliliters());
        // возращает A
        System.out.println(coffeSizeSmall.getCoffeClass());
        System.out.println();

        CoffeSize coffeSizeMedium = CoffeSize.MEDIUM;
        System.out.println(coffeSizeMedium);
        System.out.println(coffeSizeMedium.getMilliliters());
        // возращает A
        System.out.println(coffeSizeMedium.getCoffeClass());
        System.out.println();

        CoffeSize coffeSizeBig = CoffeSize.BIG;
        System.out.println(coffeSizeBig);
        System.out.println(coffeSizeBig.getMilliliters());
        // возращает B
        System.out.println(coffeSizeBig.getCoffeClass());
        System.out.println();

    }
}
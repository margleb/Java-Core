// 1. Мы не можем расширять класс enum, так как он уже расширяется
// 2. Можно импламентироваться интерфейсы
// 3. В остальном, это такой же класс
// 4. Enum не могут быть public либо protected
// 5. Enum не могут быть локальными, т.е. их нельзя определять внутри методов
// 6. Допускается переопределение в интерфейсе

enum Level {
    BEGGINER("green") {
        // здесь переопределяется метод
        public String getColor() {
            return "color is " + color;
        }
    }, INTERMEDIATE("blue"), EXPERT("red");
    Level(String color) {
        this.setColor(color);
    }
    String color;
    void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

public class EnumExample {
    public static void main(String[] args) {
        Level.BEGGINER.setColor("blue");
        System.out.println(Level.BEGGINER.getColor());
        // System.out.println(Level.BEGGINER.toString());
    }
}

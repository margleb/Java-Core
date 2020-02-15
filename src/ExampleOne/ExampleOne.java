/*
Класс может быть объявлен с модификатором public, и в этом случае этот класс виден всем классам везде.
Если класс не имеет модификатора (по умолчанию, также известного как package-private), он виден только в своем собственном пакете
*/

package ExampleOne;

// верхний уровень доступа (только public или пакетно приватный)
public class ExampleOne {
    // доступен в классе, пакете, сабклассе, а также из внешних пакетах
    public int one = 10;
    // доступен в классе, пакете, сабклассе
    protected int two = 3;
    // доступен в классе, пакете
    int three = 7;
    // доступен в классе
    private int four = 15;
    public static void main(String[] args) {

    }
}

class PrivateExample {
    public static void main(String[] args) {
        ExampleOne exampleOne = new ExampleOne();
        // Не могу полчить доступ, так как приватное
        // System.out.println(exampleOne.four);
    }
}


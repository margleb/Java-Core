/*
* Интерфейс - 100% абстрактный класс
* Интерфейс используется для описания какого-либо поведения
* Интерфейс может быть расширяем сразу несколькими интерфейсами
*
* Все абстрактные, стандартные и статические методы в интерфейсе неявно общедоступны, поэтому вы можете опустить публичный модификатор.
* Однако, хотя класс может расширять только один другой класс, интерфейс может расширять любое количество интерфейсов.
*
 */

// interface не может быть final
// может быть расширен любым количеством интерфейсов
public interface IShowInterface extends IOtherInterface, Bancable {
    // public static final
    // все переменные в интерфейсах финализированные
    int SOME_VARIABLE = 5;
    // методы интерфейса автоматически публичные и асбтрактные
    void addTwoDigits(int one, int two);
    // в интерфейсах не может быть методов с телом
    // void method() { }
}

interface IOtherInterface {
    void someMethod();
}

interface Bancable {
    void bounce();
}

class Example implements IShowInterface, Bancable {

    @Override
    // по умолчанию всегда public
    public void addTwoDigits(int one, int two) {

    }

    @Override
    public void someMethod() {
        // нельзя переопределять поле интерфейса
        // SOME_VARIABLE = 5;
    }

    @Override
    public void bounce() {

    }

}

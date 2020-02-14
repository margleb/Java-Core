/* Cуществует еще такое понятие как JavaBean conventions */

public class Person {
    private String name;
    private boolean blond;

    // Ecли значение boolean, то используется is
    public boolean isBlond() {
        return blond;
    }

    // В остальных случаей get/set
    public String getName() {
        return name;
    }

    public void setName(String name) {
       this.name = name;
    }
    
}

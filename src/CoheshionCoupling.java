public class CoheshionCoupling {
    public static void main(String[] args) {

    }
}

// Плохая инкапсуляция
class A {
    int i;
    public int getI() {
        return i;
    }
}
class B {
    void printI() {
        // Классы должны знать о друг друге как можно меньше и только из публичных методов
        System.out.println(new A().i);
    }
}

class Restarant {
    Employee employee;
}

// один класс не может выболнять несколько методов
 class Employee {
     // void Cook() {
     // }
     // void deliverFood() {
     // }
     // void cleanFloor() {
     // }

     // hight coheshion
     Cook cook;
     Waiter weiter;
     Janitor janitor;
 }


class Cook {
    void cook() {
    }
}
class Waiter {
    void deliverFood() {
    }
}
class Janitor {
    void cleanFloor() {
    }
}
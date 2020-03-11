public class IsAHasLesson {
    public static void main(String[] args) {

    }
}

class Telega {
    int weels = 4;
}
// is a (является ли)
// class MyCar extends Telega {
    // void drive() {
    // }
// }


class MyCar {
     // has a (имеет ли обьект)
     Radio radio = new Radio();
     void listen() {
         radio.listen();
     }
     void drive() {
     }
}
class Radio {
    void listen() {
        System.out.println("listen radio");
    }
}
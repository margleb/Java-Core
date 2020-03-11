public class FinalLesson {
    // мы можем записать значение тольк оодин раз
    final int i;
    // {
    // i  = 5;
    // }
    FinalLesson() {
        i = 6;
    }
    public static void main(String[] args) {
        One one = new Two();
    }
}

class One {
    final void method() {
        System.out.println("one");
    }
}

class Two extends One {
    // final метод нельзя переписывать
    // void method() {
    // System.out.println("two");
    // }
}

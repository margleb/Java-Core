/*
 stringBuilder - если требуется постоянное изменение строк, то лучше использовать StringBuilder
 stringBuffer -  Потокобезопасная, изменяемая последовательность символов
 */

public class Main {
    public static void main(String[] args) {
         String s1 = new String("abc");
         String s2 = s1.concat("def");
         // строка s не изменяемая
         // System.out.println(s1);
         // System.out.println(s2);

         // StringBuilder
        StringBuilder stringBuilder = new StringBuilder("abc");
        // Добавляет указанный строку к этой последовательности
        stringBuilder.append("def");
        // Вставляет строку в эту последовательность символов.
        stringBuilder.insert(3, "-");


        // все методы синхронизированы, используется для многопоточных приложений
        // StringBuffer stringBuffer;

    }
}

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        // инициализирует объект с текущей датой и временем.
        Date date = new Date();
        System.out.println("Текущая дата: \n" + date + "\n");
        // 1мин - 60000 мил.секунд
        Date dateSec = new Date(60000);
        System.out.println("Число миллисекунд, истекших с полуночи 1 января 1970 г: \n" + dateSec + "\n");
        // класс Calendar позволяет работать более удобно с датами, чем класс Date
        Calendar calendar = Calendar.getInstance();
        // устанавливаем дату
        calendar.setTime(date);
        System.out.println("Текущая дата в календаре: \n" + calendar.getTime() + "\n");
        // добавляем одну неделю
        calendar.add(Calendar.WEEK_OF_MONTH, 1);
        System.out.println("Текущая дата в календаре + 1 неделя: \n" + calendar.getTime() + "\n");
        // Форматирование даты
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Форматированная дата №1: \n" + dateFormat.format(calendar.getTime())  + "\n");
        // Устанавливаем свой форамат
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("Форматированная дата №2: \n" +simpleDateFormat.format(calendar.getTime())  + "\n");
        // Распарсим дату
        Date newDate = simpleDateFormat.parse("05/12/1985 05:22");
        System.out.println("Распарсенная дата: \n" + newDate);

    }
}

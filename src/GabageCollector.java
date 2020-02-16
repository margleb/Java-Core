// Как только на обьект нет ссылок, garbage collector удаляет его из памяти
// System.gc() - предлагает запустить garbage collector

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GabageCollector {
    public static void main(String[] args) {
        // Date dt = method1();
        // удаляем ссылку на обьект, чтобы garbage collector его удалил из памяти
        // dt = null;
        // createObjects();
        method2();
    }
    private static Date method1() {
        Date date = new Date();
        Date date2 = date;
        System.out.println(date);
        return date;
    }

    private static void method2() {
       GabageCollector GabageCollector1 = new GabageCollector();
       GabageCollector GabageCollector2 = new GabageCollector();
       GabageCollector1 = null;
       GabageCollector2 = null;
       System.gc();
    };

    public static void createObjects() {
        Runtime runtime = Runtime.getRuntime();
        // общее и свободное кол-во памяти до cоздания обьектов
        System.out.println("Total memory berfore: " + runtime.totalMemory());
        System.out.println("Total free memory berfore: " + runtime.freeMemory());
        List<Date> dateList = new ArrayList<>();
        System.out.println();
        for(long i=0; i < 1_000_000_00; i++) {
            Date date = new Date();
            dateList.add(date);
            // date = null;
        }
        // dateList = null;
        // общее и свободное кол-во памяти после создания обьектов
        System.out.println("Total memory after: " + runtime.totalMemory());
        System.out.println("Total free memory after: " + runtime.freeMemory());
        System.out.println();
        // предлагает очистить память (не гарантировано)
        System.gc();
        // общее и свободное кол-во памяти после запуска метода gc
        System.out.println("Total memory after gc: " + runtime.totalMemory());
        System.out.println("Total free memory after gc: " + runtime.freeMemory());
    }

    @Override
    // метод запускается при срабатывании Garbage Collector (но не всегда!)
    public void finalize() {
        System.out.println("Garbage Collector сработал!");
    }
}

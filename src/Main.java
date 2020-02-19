/*
Java Collection Framework — иерархия интерфейсов и их реализаций, которая является частью JDK и позволяет разработчику пользоваться большим количесвом структур данных из «коробки».

На вершине иерархии в Java Collection Framework располагаются 2 интерфейса:
- Collection -  простые последовательные наборы элементов.
  - List -  Реализации этого интерфейса представляют собой упорядоченные коллекции. Кроме того, разработчику предоставляется возможность доступа к элементам коллекции по индексу и по значению (так как реализации позволяют хранить дубликаты, результатом поиска по значению будет первое найденное вхождение).
  - Queue - Этот интерфейс описывает коллекции с предопределённым способом вставки и извлечения элементов, а именно — очереди FIFO (first-in-first-out).
  - Set - Коллекция, не содержащая дублированные элементы
- Map. - наборы пар «ключ — значение» (словари).

Чем коллекции лучше массивов?
В них больше функционала, делать это над массивами зачастую нецелесообразно (или плохое качество кода или долго реализовывать или требуют хорошего понимания алгоритмов).

Когда лучше использовать массивы, чем коллекции?
Когда нужно хранить набор данных фиксированного размера

Коллекции бывают трех типов
1. Упорядоченые (Ordered), например LinkedHasSet()
2. Неупорядоченные, например HashSet()
3. Отсортированные, например TreeSet()
 */

import java.util.*;

public class Main {
    public static void ExampleCollection() {
        // массивы всегда определенного размера, в отличии от коллекций
        int[] array = new int[15];
        Collection collection = new ArrayList();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        collection.remove("2");
        // цикл
        Iterator iterator = collection.iterator();
        // есть ли следюущий эл. в колекции
        while(iterator.hasNext()) {
            // выводит следующий элемент
            System.out.println(iterator.next());
        }
        // с помочью цикла for
        for (Object obj: collection) {
            System.out.println(obj);
        }
        // Collections collections;
        // Arrays arrays;
    }

    public static void MajorCollections() {
        /* наследуются от Collection */

        // cтандартный массив индекс - значение
        List listCollection = new ArrayList();
        listCollection.add("1");
        listCollection.add("2");
        listCollection.add("3");
        // переписываем 2ой элемент на значение 5
        listCollection.set(2, "5");
        // вставляем в качестве 2ого элемента 6
        listCollection.add(1, 6);
        System.out.println("Cписок:");
        // System.out.println(listCollection.get(1));
        for(int i = 0; i < listCollection.size(); i++) {
            // возращает элемент в определенной позиции в массиве
            System.out.println(listCollection.get(i));
        }

        // очередь
        Queue queueCollection = new PriorityQueue();
        //  добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
        queueCollection.offer("1");
        queueCollection.offer("2");
        queueCollection.offer("3");

        // Получает, но не удаляет первый элемент очереди. Возращает null, если элемента не существует
        System.out.println("Первый элемент в очереди \n"  + queueCollection.peek());

        System.out.println("Очередь с удалением:");
        Iterator iterator = queueCollection.iterator();
        while(iterator.hasNext()) {
            // Получает и удаляет последний элемент в очереди
            // или возращает null, если очередь пуста
            System.out.println(queueCollection.poll());
            // System.out.println(iterator.next());
        }

        // кол-во элементов в очереди
        System.out.println("Количество элементов в очереди \n" + queueCollection.size());


        Set setCollection = new HashSet();
        setCollection.add("1");
        // каждый элемент в cете добавляется один раз!
        setCollection.add("2");
        setCollection.add("2");
        setCollection.add("2");
        // каждый элемент в cете добавляется один раз!
        setCollection.add("3");
        setCollection.add("3");
        System.out.println("Cеты:");
        for(Object obj: setCollection) {
            System.out.println(obj);
        }

        // ассоциативный массив
        Map<Integer, String> passports = new HashMap();
        passports.put(212133, "Лидия Аркадьевна Бубликова");
        passports.put(162348, "Иван Михайлович Серебряков");
        passports.put(8082771, "Дональд Джон Трамп");
        passports.put(917352, "Алексей Андреевич Ермаков");
        passports.put(925648, "Максим Олегович Архаров");

        // Возвращает представление отображений, содержащихся в этой карте
        System.out.println("Accоциативный массив: ");
        // Set set = passports.entrySet();
        // Пробигаемся по ключами
        Set set = passports.keySet();
        for(Object obj: set) {
            System.out.println(obj);
        }

        System.out.println("ФИО читателя по нормеру паспорта 8082771:");
        System.out.println(passports.get(8082771));

    }

    public static void TypeCollections() {

        // Неупорядочная коллекция HashSet
        System.out.println("Неупорядочная коллекция HashSet:");
        Collection HashSetCollection = new HashSet();
        HashSetCollection.add("4");
        HashSetCollection.add("3");
        HashSetCollection.add("2");
        HashSetCollection.add("1");
        // У HashSet нет гарантии, что элементы выведутся в упорядочной последовтельности
        for(Object obj: HashSetCollection) {
            System.out.println(obj);
        }

        // Упорядочная коллекция LinkedHashSet
        System.out.println("Упорядочная коллекция LinkedHashSet:");
        Collection linkedHashSetCollection = new LinkedHashSet();
        linkedHashSetCollection.add("4");
        linkedHashSetCollection.add("3");
        linkedHashSetCollection.add("2");
        linkedHashSetCollection.add("1");
        // Отсортирована по принципу добаления
        for(Object obj: linkedHashSetCollection) {
            System.out.println(obj);
        }

        // Отсортированая коллекция  TreeSet
        System.out.println("Упорядочная коллекция TreeSet:");
        Collection TreeSetCollection = new TreeSet();
        TreeSetCollection.add("2");
        TreeSetCollection.add("3");
        TreeSetCollection.add("1");
        for(Object obj: TreeSetCollection) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        // ExampleCollection();
        // MajorCollections();
        TypeCollections();
    }


}

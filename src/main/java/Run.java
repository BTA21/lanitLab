/**
 * Класс для работы.
 * @author Набиев Азамат Ильдусович
 * @version 1.1
 */
public class Run {
    /**
     * Процедура являющаяся точкой входа для выполняемой программы
     * @param args аргументы командной строки
     * @throws InsideStateException исключение срабатывающее, если вложенный объект пытаются поместить куда-то ещё
     * @throws ItemStoreExeption исключение срабатывающее, если пытаются поместить оюъект, который превышает лимиты вложенности
     */
    public static void main(String[] args) throws ItemStoreExeption, InsideStateException{

//        Предметы
        Item item1 = new Item("Мяч1", 0.5d, 4,false);
        Item item2 = new Item("Игрушка1", 0.2d, 2,false);
        Item item3 = new Item("Мяч2", 0.5d, 4,false);
        Item item4 = new Item("Игрушка2", 0.2d, 2,false);
        Item item5 = new Item("Книга1", 0.5d, 4,true);//  Плоский предмет
        Item item6 = new Item("Книга2", 0.2d, 2,true);//  Плоский предмет
        Item item7 = new Item("Мяч3", 0.5d, 4,false);
        Item item8 = new Item("Книга3", 0.5d, 4,true);//  Плоский предмет
        Item item9 = new Item("Книга4", 0.5d, 4,true);//  Плоский предмет

//        Сумки
        Bag bag1 = new Bag("Мешок", 0.1d, 10, false, 5.0d);

//        Стопки
        Stack stack1 = new Stack("Стопка", 0.1d, 10, true, 3);

//        Коробки
        Box box1 = new Box("Коробка", 0.5d, 4,true, 20.0d, false);

//        item1.getInfo(item1);
//        Работа с мешками
        bag1.getInfo(bag1);

            bag1.putIn(item1);
            bag1.putIn(item2);
            bag1.putIn(item3);
            bag1.putIn(item4);

        bag1.getInfoInside();

        bag1.getInfo(bag1);


        bag1.pullOut("Игрушка1");
        bag1.getInfoInside();

        bag1.getInfo(bag1);



//        Работа со стопкой
//    try {
//        stack1.putIn(item1);
//        stack1.putIn(item5);
//        stack1.putIn(item6);
//        stack1.putIn(item7);
//        stack1.putIn(item8);
//        stack1.putIn(item9);
//    } catch (ItemStoreExeption e){
//        e.printStackTrace();
//    }
//        stack1.getInfoInside();
//
        stack1.getInfo(stack1);
//
//        stack1.putInQuestion();
//
//
//        stack1.pullOut();
//        stack1.getInfoInside();

//        bag1.getInfo(bag1);
        //        System.out.println("============");

//
//        bag1.pullOut("Игрушка1");
//        bag1.getInfoInside();


//        Box box = new Box("Коробка", 3, "Красный");
//        Box box1 = new Box("Коробка", 2.0, 5, "Желтый", 10);
//        box.setName("Коробка");


    }
}

public class Run {

    public static void main(String[] args) {
        Item item1 = new Item("Мяч1", 0.5d, 4,false);
        Item item2 = new Item("Игрушка1", 0.2d, 2,false);
        Item item3 = new Item("Мяч2", 0.5d, 4,false);
        Item item4 = new Item("Игрушка2", 0.2d, 2,false);
        Bag bag1 = new Bag("Мешок", 0.1d, 10, false, 5.0d);
        Stack stack1 = new Stack("Стопка", 0.1d, 10, true, 3);
        Box box1 = new Box("Коробка", 0.5d, 4,true, 20.0d);
        Item item5 = new Item("Книга1", 0.5d, 4,true);
        Item item6 = new Item("Книга2", 0.2d, 2,true);
        Item item7 = new Item("Мяч3", 0.5d, 4,false);
        Item item8 = new Item("Книга3", 0.5d, 4,true);
        Item item9 = new Item("Книга4", 0.5d, 4,true);

//        item1.getInfo(item1);
//        bag1.getInfo(bag1);

//        bag1.putIn(item1);
//        bag1.putIn(item2);
//        bag1.putIn(item3);
//        bag1.putIn(item4);
//        bag1.getInfoInside();
//
//        bag1.getInfo(bag1);
//
//
//        bag1.pullOut(true, item1);
//        bag1.getInfoInside();
//
//        bag1.getInfo(bag1);

//        System.out.println("============");
//
        stack1.putIn(item1);
        stack1.putIn(item5);
        stack1.putIn(item6);
        stack1.putIn(item7);
        stack1.putIn(item8);
        stack1.putIn(item9);

        stack1.getInfoInside();

        stack1.getInfo(stack1);


        stack1.pullOut(true, item1);
        stack1.getInfoInside();

//        bag1.getInfo(bag1);
        //        System.out.println("============");

//
//        bag1.pullOut("Игрушка1");
//        bag1.getInfoInside();


//        Box box = new Box("Коробка", 3, "Красный");
//        Box box1 = new Box("Коробка", 2.0, 5, "Желтый", 10);
//        box.setName("Коробка");






//        System.out.println("bigFlag " + item.getVolume());
//        System.out.println("name " + item.getName());
//        System.out.println("flat " + item.getFlat());
//        System.out.println("weight " + item.getWeight());

//        System.out.println("============");
//
//        System.out.println(box.getName());
//        System.out.println(box.getFlat());
//        System.out.println(box.getVolume());
//        System.out.println(box.getWeight());
//        System.out.println(box.color);
//
//        System.out.println("============");
//
//        System.out.println(box1.getName());
//        System.out.println(box1.getFlat());
//        System.out.println(box1.getVolume());
//        System.out.println(box1.getWeight());
//        System.out.println(box1.color);
    }
}

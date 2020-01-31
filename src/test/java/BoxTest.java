//import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    Box box = new Box("Коробка", 2.0d, 4,true, 20.0d, false);

    Item item1 = new Item("Мяч1", 0.5d, 4,false);
    Item item2 = new Item("Игрушка1", 0.3d, 2,false);
    Item item3 = new Item("Мяч2", 0.5d, 4,false);
    Item item4 = new Item("Игрушка2", 0.2d, 2,false);
    Item item5 = new Item("Книга1", 50d, 4,true);//  Плоский предмет


    @Test
    void putIn() {
        box.openBox();
        try {
            box.putIn(item1);
            box.putIn(item2);
            box.putIn(item3);
            box.putIn(item4);
        } catch (ItemStoreExeption e) {
        e.printStackTrace();
    }
        Double expected = 3.5d;
        Double actual = box.weight;
        assertEquals(expected, actual);
    }

//    @Test(expected=ItemStoreExeption.class)
//    void putInException() {
//        try{
//            box.putIn(item5);
//        } catch (ItemStoreExeption e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    void pullOut() {
        box.openBox();
        try {
            box.putIn(item1);
            box.putIn(item2);
            box.putIn(item3);
        } catch (ItemStoreExeption e) {
        e.printStackTrace();
    }
        box.pullOut("Игрушка1");
        Double expected = 3.0d;
        Double actual = box.weight;
        assertEquals(expected, actual);
    }

    @Test
    void testPullOut() {
        box.openBox();
        try {
            box.putIn(item1);
            box.putIn(item2);
            box.putIn(item3);
        } catch (ItemStoreExeption e) {
        e.printStackTrace();
    }
        box.pullOut();
        Double expected = 3.0d;
        Double actual = box.weight;
        assertEquals(expected, actual);
    }

    @Test
    void openBox() {
        box.openBox();
        Boolean expected = true;
        Boolean actual = box.getOpenState();
    }

    @Test
    void closeBox() {
        box.closeBox();
        Boolean expected = false;
        Boolean actual = box.getOpenState();
    }

    @Test
    void testToString() {
        String isFlat = box.getFlat()? "является плоским.":"не является плоским.";
        String expected =  "\n============================================================================================================== \n" +
                "Описание объекта: \n" +box.getName() + " с весом " + box.getWeight() +
                ", имеющим объем " +box.getVolume() + ", который " + isFlat;
        String actual =box.toString();
        assertEquals(expected, actual);
    }
}
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    Bag bag = new Bag("Мешок", 0.1d, 10, false, 5.0d);

    Item item1 = new Item("Мяч1", 0.5d, 4,false);
    Item item2 = new Item("Игрушка1", 0.2d, 2,false);
    Item item3 = new Item("Мяч2", 0.5d, 4,false);
    Item item4 = new Item("Игрушка2", 0.2d, 2,false);
    Item item5 = new Item("Книга1", 0.5d, 4,true);//  Плоский предмет

    @Test
    void putIn() {
        bag.putIn(item1);
        bag.putIn(item2);
        bag.putIn(item3);
        bag.putIn(item4);
        bag.putIn(item5);
        Double expected = 2d;
        Double actual = bag.weight;
        assertEquals(expected, actual);
    }

    @Test
    void pullOut() {
        bag.putIn(item1);
        bag.putIn(item2);
        bag.putIn(item3);
        bag.putIn(item4);
        bag.putIn(item5);
        bag.pullOut("Игрушка1");
        Double expected = 1.8d;
        Double actual = bag.weight;
        assertEquals(expected, actual);
    }

    @Test
    void testPullOut() {
        bag.putIn(item1);
        bag.putIn(item2);
        bag.putIn(item3);
        bag.putIn(item4);
        bag.putIn(item5);
        bag.pullOut();
        Double expected = 1.5;
        Double expected1 = 1.8;
        Double actual = bag.weight;
        assertEquals(expected, expected1, actual);
    }

    @Test
    void testToString() {
        String isFlat = bag.getFlat()? "является плоским.":"не является плоским.";
        String expected =  "\n============================================================================================================== \n" +
                "Описание объекта: \n" +bag.getName() + " с весом " + bag.getWeight() +
                ", имеющим объем " +bag.getVolume() + ", который " + isFlat;
        String actual =bag.toString();
        assertEquals(expected, actual);
    }
}
import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {

    Bag bag = new Bag("Мешок", 0.1d, 10, false, 5.0d);

    Item item1 = new Item("Мяч1", 0.5d, 4,false);
    Item item2 = new Item("Игрушка1", 0.2d, 2,false);
    Item item3 = new Item("Мяч2", 0.5d, 4,false);
    Item item4 = new Item("Игрушка2", 0.2d, 2,false);
    Item item5 = new Item("Книга1", 5d, 4,true);//  Плоский предмет

    @Test
    public void putIn() throws ItemStoreExeption, InsideStateException{
        bag.putIn(item1);
        bag.putIn(item2);
        bag.putIn(item3);
        bag.putIn(item4);
        Double expected = 1.5d;
        Double actual = bag.weight;
        assertEquals(expected, actual);
    }

    @Test(expected = ItemStoreExeption.class)
    public void putInException() throws ItemStoreExeption, InsideStateException {
        bag.putIn(item1);
        bag.putIn(item5);
    }

    @Test
    public void pullOut() throws ItemStoreExeption, InsideStateException {

            bag.putIn(item1);
            bag.putIn(item2);
            bag.putIn(item3);
            bag.putIn(item4);

        bag.pullOut("Игрушка1");
        Double expected = 1.3d;
        Double actual = bag.weight;
        assertEquals(expected, actual);
    }

    @Test
    public void testPullOut() throws ItemStoreExeption, InsideStateException {
        bag.putIn(item1);
        bag.putIn(item2);
        bag.putIn(item3);
        bag.putIn(item4);
        bag.pullOut();
        Double expected = 1.5;
        Double expected1 = 1.8;
        Double actual = bag.weight;
        assertEquals(expected, expected1, actual);
    }

    @Test
    public void testToString() {
        String isFlat = bag.getFlat()? "является плоским.":"не является плоским.";
        String expected =  "\n============================================================================================================== \n" +
                "Описание объекта: \n" +bag.getName() + " с весом " + bag.getWeight() +
                ", имеющим объем " +bag.getVolume() + ", который " + isFlat;
        String actual =bag.toString();
        assertEquals(expected, actual);
    }
}
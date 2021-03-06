import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {
    Box box = new Box("Коробка", 2.0d, 4,true, 20.0d, false);

    Item item1 = new Item("Мяч1", 0.5d, 4,false);
    Item item2 = new Item("Игрушка1", 0.3d, 2,false);
    Item item3 = new Item("Мяч2", 0.5d, 4,false);
    Item item4 = new Item("Игрушка2", 0.2d, 2,false);
    Item item5 = new Item("Книга1", 50d, 4,true);//  Плоский предмет


    @Test
    public void putIn() throws ItemStoreExeption, InsideStateException{
        box.openBox();
        box.putIn(item1);
        box.putIn(item2);
        box.putIn(item3);
        box.putIn(item4);

        Double expected = 3.5d;
        Double actual = box.weight;
        assertEquals(expected, actual);
    }

    @Test(expected = ItemStoreExeption.class)
    public void putInException() throws ItemStoreExeption, InsideStateException {
            box.putIn(item5);
    }

    @Test
    public void pullOut() throws ItemStoreExeption, InsideStateException{
        box.openBox();
        box.putIn(item1);
        box.putIn(item2);
        box.putIn(item3);
        box.pullOut("Игрушка1");
        Double expected = 3.0d;
        Double actual = box.weight;
        assertEquals(expected, actual);
    }

    @Test
    public void testPullOut() throws ItemStoreExeption, InsideStateException{
        box.openBox();
        box.putIn(item1);
        box.putIn(item2);
        box.putIn(item3);
        box.pullOut();
        Double expected = 2.8d;
        Double actual = box.weight;
        assertEquals(expected, actual);
    }

    @Test
    public void openBox() {
        box.openBox();
        Boolean expected = true;
        Boolean actual = box.getOpenState();
    }

    @Test
    public void closeBox() {
        box.closeBox();
        Boolean expected = false;
        Boolean actual = box.getOpenState();
    }

    @Test
    public void testToString() {
        String isFlat = box.getFlat()? "является плоским.":"не является плоским.";
        String expected =  "\n============================================================================================================== \n" +
                "Описание объекта: \n" +box.getName() + " с весом " + box.getWeight() +
                ", имеющим объем " +box.getVolume() + ", который " + isFlat;
        String actual =box.toString();
        assertEquals(expected, actual);
    }
}
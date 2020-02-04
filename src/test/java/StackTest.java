import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    Stack stack = new Stack("Стопка", 1d, 10, true, 3);
    Item item1 = new Item("Мяч1", 0.2d, 4,false);
    Item item2 = new Item("Книга1", 0.5d, 4,true);//  Плоский предмет
    Item item3 = new Item("Книга2", 0.5d, 4,true);//  Плоский предмет
    Item item4 = new Item("Доска", 1d, 4,true);//  Плоский предмет
    Item item5 = new Item("Капитал", 5d, 2,true);//  Плоский предмет
    Item item6 = new Item("Книга3", 0.5d, 4,true);//  Плоский предмет

    @Test
    public void putIn() throws ItemStoreExeption, InsideStateException {
        stack.putIn(item1);
        stack.putIn(item2);
        stack.putIn(item3);
        stack.putIn(item4);
        Double expected = 2d;
        Double actual = stack.weight;
        assertEquals(expected, actual);
    }

    @Test(expected = ItemStoreExeption.class)
    public void putInException() throws ItemStoreExeption, InsideStateException {
        stack.putIn(item2);
        stack.putIn(item3);
        stack.putIn(item4);
        stack.putIn(item5);
    }

    @Test
    public void putInQuestion1() {
        String actual = stack.putInQuestion();
        String expected = " Компьютер: Да!";
        assertEquals(expected, actual);
    }

    @Test
    public void putInQuestion2() throws ItemStoreExeption, InsideStateException{
        stack.putIn(item1);
        stack.putIn(item2);
        stack.putIn(item3);
        stack.putIn(item4);
        String actual = stack.putInQuestion();
        String expected = " Компьютер: Нет!";
        assertEquals(expected, actual);
    }

    @Test
    public void pullOut() throws ItemStoreExeption, InsideStateException{
        stack.putIn(item1);
        stack.putIn(item2);
        stack.putIn(item3);
        stack.putIn(item4);
        stack.pullOut();
        Double expected = 1d;
        Double actual = stack.weight;
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        String isFlat = stack.getFlat()? "является плоским.":"не является плоским.";
        String expected =  "\n============================================================================================================== \n" +
                "Описание объекта: \n" +stack.getName() + " с весом " + stack.getWeight() +
                ", имеющим объем " +stack.getVolume() + ", который " + isFlat;
        String actual =stack.toString();
        assertEquals(expected, actual);
    }
}
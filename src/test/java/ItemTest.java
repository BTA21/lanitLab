import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    Item item = new Item("Мяч", 0.5d, 4,false);
    @Test
    void getWeight() {
        Double expected =0.5d;
        Double actual =item.getWeight();
        assertEquals(expected, actual);
    }
    @Test
    void getName() {
        String expected ="Мяч";
        String actual =item.getName();
        assertEquals(expected, actual);
    }
    @Test
    void getVolume() {
        Integer expected =4;
        Integer actual =item.getVolume();
        assertEquals(expected, actual);
    }
    @Test
    void getFlat() {
        Boolean expected =false;
        Boolean actual =item.getFlat();
        assertEquals(expected, actual);
    }
    @Test
    void testToString() {
        String isFlat = item.getFlat()? "является плоским.":"не является плоским.";
        String expected =  "\n============================================================================================================== \n" +
                "Описание объекта: \n" +item.getName() + " с весом " + item.getWeight() +
                ", имеющим объем " +item.getVolume() + ", который " + isFlat;
        String actual =item.toString();
        assertEquals(expected, actual);
    }
}
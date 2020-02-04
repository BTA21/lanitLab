import org.junit.Test;

import static org.junit.Assert.*;

public class ItemsCompareTest {

    Item item1 = new Item("Мяч", 0.5d, 4,false);
    Item item2 = new Item("Мяч", 0.5d, 4,false);

    @Test
    public void testToString() {
        String isFlat1 = item1.getFlat()? "является плоским.":"не является плоским.";
        String isFlat2 = item2.getFlat()? "является плоским.":"не является плоским.";
        String expected =  "\n============================================================================================================== \n" +
                "Описание объекта: \n" +item1.getName() + " с весом " + item1.getWeight() +
                ", имеющим объем " +item1.getVolume() + ", который " + isFlat1;
        String actual =  "\n============================================================================================================== \n" +
                "Описание объекта: \n" +item2.getName() + " с весом " + item2.getWeight() +
                ", имеющим объем " +item2.getVolume() + ", который " + isFlat2;
        assertEquals(expected, actual);
    }
}

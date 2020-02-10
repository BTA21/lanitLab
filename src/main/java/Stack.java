import java.util.ArrayList;
import java.util.stream.Stream;
/**
 * Класс объекта-стопки со свойствами <b>name</b>, <b>weight</b>, <b>volume</b>, <b>flat</b>, <b>qt</b>, <b>stackArr</b>, <b>openState</b> и <b>amIinsideYet</b>.
 * @autor Набиев Азамат Ильдусович
 * @version 1.1
 */
public class Stack extends Item {
    /** Поле определяющее максимальное количество предметов, которое вмещает стопка */
    private Integer qt;
    /** Массив, в котором перечислены все объекты, вмещаемые коробкой */
    private ArrayList<Item> stackArr;
    /**
     * Конструктор - создание нового объекта-коробки с определенными значениями
     * @param name  наименование объекта
     * @param weight  вес (стопка сама по себе ничего не весит)
     * @param volume  объем
     * @param flat  плоскость
     * @param qt  лимит веса
     * @see Stack#Stack(String, Double, Integer, Boolean, Integer)
     */
    Stack(String name, Double weight, Integer volume, Boolean flat, Integer qt) {
        super(name, weight = 0d, volume, flat);
        /**
         * {@value} limit максимальное количество предметов, которое может вмещать стопка
         */
        this.qt = qt;
        /**
         * {@value} bagArr массив перечисляющий сожержимое стопки
         */
        this.stackArr = new ArrayList<Item>(qt);
    }
    /**
     * Процедура помещения объекта в стопку
     * @param item объект
     * @throws InsideStateException исключение срабатывающее, если вложенный объект пытаются поместить куда-то ещё
     * @throws ItemStoreExeption исключение срабатывающее, если пытаются поместить оюъект, который превышает лимиты вложенности
     */
    public void putIn(Item item) throws ItemStoreExeption, InsideStateException {
        if(this.stackArr.size() >= this.qt) {
            throw new ItemStoreExeption("You exceed stack limits!");
        }
        if(item.getAmIinsideYet() == true) {
            throw new InsideStateException("You can not put the item which is contained somewhere yet!");
        }
            if(item.getFlat() == true) {
                item.setAmIinsideYet(true);
                this.stackArr.add(0, item);
                this.weight += item.getWeight();
            } else
                System.out.println("\n Стопки можно складывать только из плоских предметов!");
    }
    /**
     * Функция отвечающая на вопрос:"Можно ли дополнить стопку?"
     */
    public String putInQuestion() {
        System.out.println("\n Пользователь: Можно ли дополнить стопку?");
        String answer = (this.stackArr.size() < this.qt)?" Компьютер: Да!":" Компьютер: Нет!";
        System.out.println(answer);
        return answer;
    }
    /**
     * Процедура удаления верхнего объекта из стопки
     */
    public void pullOut() {
        int index = this.stackArr.size();
        Item item = this.stackArr.get(0);
        item.setAmIinsideYet(false);
        this.weight -= item.getWeight();
        this.stackArr.remove(0);
    }
    /**
     * Функция вывода значениий объекта-стопки {@link Stack}
     */
    void getInfo(Item stack) {
        super.getInfo(stack);
        System.out.println(" Лимит предметов, которые можно поместить: " + this.qt + ".\n" +
                "============================================================================================================== \n");
    }
    /**
     * Функция вывода содержимого объекта-стопки {@link Stack}
     */
    void getInfoInside() {
        System.out.println("\n Содержимое стопки:");
        for (Item anArray:stackArr) {
            System.out.println(anArray);
        }
    }
}

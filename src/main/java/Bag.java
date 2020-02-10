import java.util.ArrayList;
import java.util.Random;
/**
 * Класс объекта-сумка со свойствами <b>name</b>, <b>weight</b>, <b>volume</b>, <b>flat</b>, <b>limit</b>, <b>bagArr</b> и <b>amIinsideYet</b>.
 * @autor Набиев Азамат Ильдусович
 * @version 1.1
 */
public class Bag extends Item {
    /** Поле определяющее максимальный вес, который вмещает сумка */
    private Double limit;
    /** Массив, в котором перечислены все объекты, вмещаемые сумкой */
    private ArrayList<Item> bagArr;
    /**
     * Конструктор - создание нового объекта-сумки с определенными значениями
     * @param name  наименование объекта
     * @param weight  вес
     * @param volume  объем
     * @param flat  плоскость
     * @param limit  лимит веса
     * @see Bag#Bag(String, Double, Integer, Boolean, Double)
     */
    Bag(String name, Double weight, Integer volume, Boolean flat, Double limit) {
        super(name, weight, volume, flat);
        /**
         * {@value} bagArr массив перечисляющий сожержимое сумки
         */
        this.bagArr = new ArrayList<Item>(0);
        /**
         * {@value} limit максимальный вес предметов, который может выдержать сумка
         */
        this.limit = limit;
    }
    /**
     * Процедура помещения объекта в сумку
     * @param item объект
     * @throws InsideStateException исключение срабатывающее, если вложенный объект пытаются поместить куда-то ещё
     * @throws ItemStoreExeption исключение срабатывающее, если пытаются поместить оюъект, который превышает лимиты вложенности
     */
    public void putIn(Item item) throws ItemStoreExeption, InsideStateException {
        if (this.limit < item.getWeight()) {
            throw new ItemStoreExeption("You exceed bag limits!");
        }
        if (item.getAmIinsideYet() == true) {
            throw new InsideStateException("You can not put the item which is contained somewhere yet!");
        }
            this.bagArr.add(item);
            item.setAmIinsideYet(true);
            this.limit -= item.getWeight();
            this.weight += item.getWeight();
    }
    /**
     * Процедура удаления случайного объекта из сумки
     */
    public void pullOut() {
        int max = this.bagArr.size();
        Random random = new Random();
        int index = random.nextInt(max);
        Item item = this.bagArr.get(index);
        item.setAmIinsideYet(false);
        this.bagArr.remove(index);
        this.limit += item.getWeight();
        this.weight -= item.getWeight();
    }
    /**
     * Процедура удаления объекта с указанным именем из сумки
     * @param name наименование удаляемого объекта
     */
    public void pullOut(String name) {
        for (int index = 0; index<this.bagArr.size(); index++){
            Item item = this.bagArr.get(index);
            if (item.getName()==name){
                item.setAmIinsideYet(false);
                this.bagArr.remove(index);
                this.limit += item.getWeight();
                this.weight -= item.getWeight();
                break;
            }
        }
    }
    /**
     * Функция вывода значениий объекта-сумки {@link Bag}
     */
    void getInfo(Item bag) {
        super.getInfo(bag);
        System.out.print(" Лимит веса:" + this.limit + ".\n" +
                "============================================================================================================== \n");
    }
    /**
     * Функция вывода содержимого объекта-сумки {@link Bag}
     */
    void getInfoInside() {
        System.out.println("\n Содержимое мешка:");
        for (Item anArray:bagArr) {
            System.out.println(anArray);
        }
    }
}

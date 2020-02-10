import java.util.ArrayList;
import java.util.Random;
/**
 * Класс объекта-коробки со свойствами <b>name</b>, <b>weight</b>, <b>volume</b>, <b>flat</b>, <b>limit</b>, <b>boxArr</b>, <b>openState</b> и <b>amIinsideYet</b>.
 * @author Набиев Азамат Ильдусович
 * @version 1.1
 */
public class Box extends Item implements BoxI {
    /** Поле определяющее максимальный вес, который вмещает коробка */
    private Double limit;
    /** Поле определяющее является ли коробка открытой */
    private Boolean openState;
    /** Массив, в котором перечислены все объекты, вмещаемые коробкой */
    private ArrayList<Item> boxArr;
    /**
     * Конструктор - создание нового объекта-коробки с определенными значениями
     * @param name  наименование объекта
     * @param weight  вес
     * @param volume  объем
     * @param flat  плоскость
     * @param limit  лимит веса
     * @param openState свойство определяющее открыта коробка или нет
     * @see Box#Box(String, Double, Integer, Boolean, Double, Boolean)
     */
    Box(String name, Double weight, Integer volume, Boolean flat, Double limit, Boolean openState) {
        super(name, weight, volume, flat = true);
        /**
         * {@value} bagArr массив перечисляющий сожержимое коробки
         */
        this.boxArr = new ArrayList<Item>(0);
        /**
         * {@value} limit максимальный вес предметов, который может выдержать сумка
         */
        this.limit = limit;
        /**
         * {@value} openState состояние, определяющее открыта ли коробка или нет
         */
        this.openState = openState;
    }
    /**
     * Процедура помещения объекта в коробку
     * @param item объект
     * @throws InsideStateException исключение срабатывающее, если вложенный объект пытаются поместить куда-то ещё
     * @throws ItemStoreExeption исключение срабатывающее, если пытаются поместить оюъект, который превышает лимиты вложенности
     */
    public void putIn(Item item) throws ItemStoreExeption, InsideStateException {
        if(this.limit < item.getWeight()) {
            throw new ItemStoreExeption("You exceed box limits!");
        }
        if(item.getAmIinsideYet() == true) {
            throw new InsideStateException("You can not put the item which is contained somewhere yet!");
        }
            if(this.openState != false) {
                item.setAmIinsideYet(true);
                this.boxArr.add(item);
            this.limit -= item.getWeight();
            this.weight += item.getWeight();
            } else
                System.out.println("\n Чтобы положить что-нибудь в коробку, её сначала нужно открыть!");
    }
    /**
     * Процедура удаления случайного объекта из коробки
     */
    public void pullOut() {
        if(this.openState != false) {
            int max = this.boxArr.size();
            Random random = new Random();
            int index = random.nextInt(max);
            Item item = this.boxArr.get(index);
            item.setAmIinsideYet(false);
            this.boxArr.remove(index);
            this.limit += item.getWeight();
            this.weight -= item.getWeight();
        } else
            System.out.println("\n Чтобы что-нибудь вытащить из коробки, её сначала нужно открыть!");
    }
    /**
     * Функция получения значения поля {@link Box#openState}
     * @return возвращает значение определяющее открыта коробка или нет
     */
    public Boolean getOpenState() {
        return openState;
    }
    /**
     * Процедура удаления объекта с указанным именем из сумки
     * @param name наименование удаляемого объекта
     */
    public void pullOut(String name) {
        if(this.openState != false) {
            for (int index = 0; index < this.boxArr.size(); index++) {
                Item item = this.boxArr.get(index);
                if (item.getName() == name) {
                    item.setAmIinsideYet(false);
                    this.boxArr.remove(index);
                    this.limit += item.getWeight();
                    this.weight -= item.getWeight();
                    break;
                }
            }
        } else
            System.out.println("\n Чтобы что-нибудь вытащить из коробки, её сначала нужно открыть!");
    }
    /**
     * Процедура открытия коробки
     */
    @Override
    public void openBox() {
        if(this.openState != true) {
            this.openState = true;
        } else
        System.out.println("\n Коробка уже открыта!");
    }
    /**
     * Процедура закрытия коробки
     */
    @Override
    public void closeBox() {
        if(this.openState != false) {
            this.openState = false;
        } else
            System.out.println("\n Коробка уже закрыта!");
    }
    /**
     * Функция вывода значениий объекта-коробки {@link Box}
     * @param box коробка
     */
    void getInfo(Item box) {
        super.getInfo(box);
        System.out.print(" Лимит веса:" + this.limit + ".\n" +
                "============================================================================================================== \n");
    }
    /**
     * Функция вывода содержимого объекта-коробки {@link Box}
     */
    void getInfoInside() {
        System.out.println("\n Содержимое коробки:");
        for (Item anArray:boxArr) {
            System.out.println(anArray);
        }
    }
}

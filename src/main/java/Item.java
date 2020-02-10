/**
 * Класс объекта со свойствами <b>name</b>, <b>weight</b>, <b>volume</b>, <b>flat</b> и <b>amIinsideYet</b>.
 * @author Набиев Азамат Ильдусович
 * @version 1.1
 */
public class Item {
    /** Поле наименование объекта */
    private String name;
    /** Поле вес */
    protected Double weight;
    /** Поле объем */
    private Integer volume;
    /** Поле определяющее является объект плоским или нет */
    private Boolean flat;
    /** Поле определяющее является объект вложенным или нет (по умолчанию не вложен при создании) */
    private Boolean amIinsideYet;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param name  наименование объекта
     * @param weight  вес
     * @param volume  объем
     * @param flat  плоскость
     * @see Item#Item(String, Double, Integer, Boolean)
     */
    Item(String name, Double weight, Integer volume, Boolean flat) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.flat = flat;
        /**
         * {@value} amIinsideYet объект при создании никуда не помещён!
         */
        this.amIinsideYet = false;
    }
    /**
     * Процедура определения является ли объект вложенным или нет {@link Item#amIinsideYet}
     * @param amIinsideYet вложенность
     */
    public void setAmIinsideYet(Boolean amIinsideYet) {
        this.amIinsideYet = amIinsideYet;
    }
    /**
     * Функция получения значения поля {@link Item#amIinsideYet}
     * @return возвращает значение определяющее вложенность объекта
     */
    public Boolean getAmIinsideYet() {
        return amIinsideYet;
    }
    /**
     * Процедура определения является ли объект плоским или нет {@link Item#flat}
     * @param flat плоскость
     */
    public void setFlat(Boolean flat) {
        this.flat = flat;
    }
    /**
     * Процедура определения объема {@link Item#volume}
     * @param volume объём
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }
    /**
     * Функция получения значения поля {@link Item#weight}
     * @return возвращает значение веса объекта
     */
    public Double getWeight() {
        return weight;
    }
    /**
     * Процедура определения веса {@link Item#weight}
     * @param weight вес
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    /**
     * Процедура определения наименования объекта {@link Item#name}
     * @param name наименование
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Функция получения значения поля {@link Item#name}
     * @return возвращает значение наименования объекта
     */
    public String getName() {
        return name;
    }
    /**
     * Функция получения значения поля {@link Item#volume}
     * @return возвращает значение объёма объекта
     */
    public Integer getVolume() {
        return volume;
    }
    /**
     * Функция получения значения поля {@link Item#flat}
     * @return возвращает значение определяющее является ли объект плоским
     */
    public Boolean getFlat() {
        return flat;
    }
    /**
     * Функция вывода значениий объекта {@link Item}
     * @param item объект
     */
    void getInfo(Item item){
        System.out.print(item);
    }
    /**
     * Функция переопределения toString для всех классов {@link Item}
     * @return возвращает значение веса объекта
     */
    public String toString() {
        String isFlat = this.flat? "является плоским.":"не является плоским.";
        return "\n============================================================================================================== \n" +
        "Описание объекта: \n" +this.name + " с весом " + this.weight +
                ", имеющим объем " +this.volume + ", который " + isFlat;
    }
}

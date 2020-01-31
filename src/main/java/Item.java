public class Item {
    private String name;
    protected Double weight;
    private Integer volume;//объем
    private Boolean flat;//плоский или нет
    private Boolean amIinsideYet;//вложен ли куда-нибудь объект

    Item(String name, Double weight, Integer volume, Boolean flat){
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.flat = flat;
        this.amIinsideYet = false;//объект при создании никуда не помещён
    }


    public void setFlat(Boolean flat) {
        this.flat = flat;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public Integer getVolume() {
        return volume;
    }

    public Boolean getFlat() {
        return flat;
    }

    void getInfo(Item item){
        System.out.print(item);
    }

    public String toString() {
        String isFlat = this.flat? "является плоским.":"не является плоским.";
        return "\n============================================================================================================== \n" +
        "Описание объекта: \n" +this.name + " с весом " + this.weight +
                ", имеющим объем " +this.volume + ", который " + isFlat;
    }

}

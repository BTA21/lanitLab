public class Item {
    private String name;
    private Double weight;
    private Integer volume;//объем
    private Boolean flat;//плоский или нет

    Item(String name, Double weight, Integer volume, Boolean flat){
        this.name = name;
        this.weight = weight;
        this.volume = volume;
        this.flat = flat;
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
        System.out.println(item);
    }

    public String toString() {
        String isFlat = this.flat? "являющимся плоским.":"не являющимся плоским.";
        return "===================================================================================== \n" +
        "Описание объекта: \n" +this.name + " с весом " + this.weight + ", имеющим объем " +this.volume + " и " + isFlat;
    }

}

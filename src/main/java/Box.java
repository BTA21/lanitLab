import java.util.ArrayList;

public class Box extends Item{
    private Double limit;
    private ArrayList<Item> boxArr;
    Box(String name, Double weight, Integer volume, Boolean flat, Double limit) {
        super(name, weight, volume, flat);
        this.boxArr = new ArrayList<Item>(0);
        this.limit = limit;
    }
    public void putIn(Item item){
        if(this.limit>=item.getWeight()) {
            this.boxArr.add(item);
            this.limit -= item.getWeight();
        } else {
            System.out.println("\n Коробка не выдержит!");
        }


//        super.getInfo(item);
    }
    public void pullOut(Boolean rand, Item item){
        if (rand == true) {
            int max = this.boxArr.size();
            int index = (int) Math.random() * max;
            this.boxArr.remove(index);
            this.limit += item.getWeight();
        }
    }

    public void pullOut(String name){
        for (Item anArray: boxArr){
            if(anArray.getName() == name){
                this.boxArr.remove(anArray);
            }
        }
    }

    void getInfo(Item box) {
        super.getInfo(box);
        System.out.println("\n Лимит веса:" + this.limit);

    }

    void getInfoInside() {
        System.out.println("\n Содержимое коробки:");
        for (Item anArray:boxArr) {
            System.out.println(anArray);
        }
    }

}

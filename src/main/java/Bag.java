import java.util.ArrayList;

public class Bag extends Item{
    private Double limit;
    private ArrayList<Item> bagArr;
    Bag(String name, Double weight, Integer volume, Boolean flat, Double limit) {
        super(name, weight, volume, flat);
        this.bagArr = new ArrayList<Item>(0);
        this.limit = limit;
    }
    public void putIn(Item item){
        if(this.limit>=item.getWeight()) {
            this.bagArr.add(item);
            this.limit -= item.getWeight();
        } else {
            System.out.println("\n Мешок не выдержит!");
        }


//        super.getInfo(item);
    }
    public void pullOut(Boolean rand, Item item){
        if (rand == true) {
            int max = this.bagArr.size();
            int index = (int) Math.random() * max;
            this.bagArr.remove(index);
            this.limit += item.getWeight();
        }
    }

    public void pullOut(String name){
        for (Item anArray: bagArr){
            if(anArray.getName() == name){
                this.bagArr.remove(anArray);
            }
        }
    }

    void getInfo(Item bag) {
        super.getInfo(bag);
        System.out.println("\n Лимит веса:" + this.limit);

    }

    void getInfoInside() {
        System.out.println("\n Содержимое мешка:");
        for (Item anArray:bagArr) {
            System.out.println(anArray);
        }
    }

}

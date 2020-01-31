import java.util.ArrayList;
import java.util.Random;

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
            this.weight += item.getWeight();
        } else {
            System.out.println("\n Мешок не выдержит!");
        }

    }
    public void pullOut(){
        int max = this.bagArr.size();
        Random random = new Random();
        int index = random.nextInt(max);
        Item item = this.bagArr.get(index);
        this.bagArr.remove(index);
        this.limit += item.getWeight();
        this.weight -= item.getWeight();
    }

    public void pullOut(String name){
        for (int index = 0; index<this.bagArr.size(); index++){
            Item item = this.bagArr.get(index);
            if (item.getName()==name){
                this.bagArr.remove(index);
                this.limit += item.getWeight();
                this.weight -= item.getWeight();
                break;
            }
        }
    }

    void getInfo(Item bag) {
        super.getInfo(bag);
        System.out.print(" Лимит веса:" + this.limit + ".\n" +
                "============================================================================================================== \n");
    }

    void getInfoInside() {
        System.out.println("\n Содержимое мешка:");
        for (Item anArray:bagArr) {
            System.out.println(anArray);
        }
    }

}

import java.util.ArrayList;
import java.util.Random;

public class Box extends Item implements BoxI {
    private Double limit;
    private Boolean openState;
    private ArrayList<Item> boxArr;
    Box(String name, Double weight, Integer volume, Boolean flat, Double limit, Boolean openState) {
        super(name, weight, volume, flat=true);
        this.boxArr = new ArrayList<Item>(0);
        this.limit = limit;
        this.openState = openState;
    }
    public void putIn(Item item) throws ItemStoreExeption {
        if(this.limit<item.getWeight()  || getAmIinsideYet()==true) {
            throw new ItemStoreExeption("You exceed bag limits or try to put in an item which is contained yet!");
        }
            if(this.openState!=false){
                item.setAmIinsideYet(true);
                this.boxArr.add(item);
            this.limit -= item.getWeight();
            this.weight += item.getWeight();
            } else
                System.out.println("\n Чтобы положить что-нибудь в коробку, её сначала нужно открыть!");
    }


    public void pullOut(){
        if(this.openState!=false) {
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

    public Boolean getOpenState() {
        return openState;
    }

    public void pullOut(String name){
        if(this.openState!=false) {
            for (int index = 0; index<this.boxArr.size(); index++){
                Item item = this.boxArr.get(index);
                if (item.getName()==name){
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

    @Override
    public void openBox(){
        if(this.openState != true){
            this.openState = true;
        } else
        System.out.println("\n Коробка уже открыта!");
    }

    public void closeBox(){
        if(this.openState != false){
            this.openState = false;
        } else
            System.out.println("\n Коробка уже закрыта!");
    }

    void getInfo(Item box) {
        super.getInfo(box);
        System.out.print(" Лимит веса:" + this.limit + ".\n" +
                "============================================================================================================== \n");
    }

    void getInfoInside() {
        System.out.println("\n Содержимое коробки:");
        for (Item anArray:boxArr) {
            System.out.println(anArray);
        }
    }

}

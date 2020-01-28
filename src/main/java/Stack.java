import java.util.ArrayList;

public class Stack extends Item{
    private Integer qt;
    private ArrayList<Item> stackArr;
    private Integer counter;
    Stack(String name, Double weight, Integer volume, Boolean flat, Integer qt) {
        super(name, weight, volume, flat);
        this.qt = qt;
        this.stackArr = new ArrayList<Item>(qt);;
    }
    public void putIn(Item item){
        if(this.stackArr.size()<this.qt) {
            if(item.getFlat()==true) {
                this.stackArr.add(0, item);
            } else
                System.out.println("\n В стопки можно класть только плоские предметы!");
        } else {
            System.out.println("\n Стопка не выдержит!");
        }


//        super.getInfo(item);
    }
    public void pullOut(Boolean rand, Item item){
        if (rand == true) {
            int max = this.stackArr.size();
            int index = (int) Math.random() * max;
            this.stackArr.remove(index);
        }
    }

    public void pullOut(String name){
        for (Item anArray: stackArr){
            if(anArray.getName() == name){
                this.stackArr.remove(anArray);
            }
        }
    }

    void getInfo(Item stack) {
        super.getInfo(stack);
        System.out.println("\n Лимит предметов, которые можно поместить:" + this.qt);

    }

    void getInfoInside() {
        System.out.println("\n Содержимое стопки:");
        for (Item anArray:stackArr) {
            System.out.println(anArray);
        }
    }

}

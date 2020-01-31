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
                this.weight += item.getWeight();
            } else
                System.out.println("\n Стопки можно складывать только из плоских предметов!");
        } else {
            System.out.println("\n Стопка не выдержит!");
        }
    }

    public void putInQuestion(){
        System.out.println("\n Пользователь: Можно ли дополнить стопку?");
        String answer = (this.stackArr.size()<this.qt)?" Компьютер: Да!":" Компьютер: Нет!";
        System.out.println(answer);
    }

    public void pullOut(){
            int index = this.stackArr.size();
            this.stackArr.remove(0);
            Item item = this.stackArr.get(index);
            this.weight -= item.getWeight();
    }

    void getInfo(Item stack) {
        super.getInfo(stack);
        System.out.println(" Лимит предметов, которые можно поместить: " + this.qt + ".\n" +
                "============================================================================================================== \n");
    }

    void getInfoInside() {
        System.out.println("\n Содержимое стопки:");
        for (Item anArray:stackArr) {
            System.out.println(anArray);
        }
    }

}

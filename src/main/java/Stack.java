import java.util.ArrayList;
import java.util.stream.Stream;

public class Stack extends Item{
    private Integer qt;
    private ArrayList<Item> stackArr;
    private Integer counter;
    Stack(String name, Double weight, Integer volume, Boolean flat, Integer qt) {
        super(name, weight = 0d, volume, flat);
        this.qt = qt;
        this.stackArr = new ArrayList<Item>(qt);
    }

    public void putIn(Item item) throws ItemStoreExeption {
        if(this.stackArr.size()>=this.qt) {
            throw new ItemStoreExeption("You exceed stack limits!");
        }
            if(item.getFlat()==true) {
                this.stackArr.add(0, item);
                this.weight += item.getWeight();
            } else
                System.out.println("\n Стопки можно складывать только из плоских предметов!");
    }

    public String putInQuestion(){
        System.out.println("\n Пользователь: Можно ли дополнить стопку?");
        String answer = (this.stackArr.size()<this.qt)?" Компьютер: Да!":" Компьютер: Нет!";
        System.out.println(answer);
        return answer;
    }

    public void pullOut(){
        int index = this.stackArr.size();
        Item item = this.stackArr.get(0);
        this.weight -= item.getWeight();
        this.stackArr.remove(0);

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

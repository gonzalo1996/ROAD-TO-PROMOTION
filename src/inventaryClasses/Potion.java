package inventaryClasses;


import enumerations.EHierarchy;
import enumerations.EPotionSize;

public class Potion extends Element{
    private int hp_recovery;
    private double stock;
    private EPotionSize potion_size;//HIGH MEDIUM SMALL


    public Potion(String nameE, EHierarchy grade,int hp_recovery, int stock, EPotionSize potion_size) {
        super(nameE,grade);
        this.hp_recovery = hp_recovery;
        this.stock = stock;
        this.potion_size = potion_size;
    }

    public int getHp_recovery() {
        return hp_recovery;
    }

    public double getStock() {
        return stock;
    }

    public void addPotion() {
        stock++;
    }

    @Override
    public double use() {
        stock--;
        return hp_recovery;
    }

    @Override
    public String toString() {
        return super.toString()+"\nHP able to increase: "+ this.hp_recovery + "\nType of potion: "+this.potion_size + "\nStock: " + this.stock + "\n";
    }
}

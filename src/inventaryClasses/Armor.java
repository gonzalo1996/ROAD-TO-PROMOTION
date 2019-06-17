package inventaryClasses;


import enumerations.EHierarchy;

/**
 * Clase armadura que tiene como objetivo funcionar cÃ³mo una segunda barra de vida para PLAYER.
 */
public class Armor extends Element{

    private double hp_armor;

    public Armor() {
        super();
        hp_armor = 0;
    }

    public Armor(String nameE, EHierarchy grade, double hp_armor) {
        super(nameE,grade);
        this.hp_armor = hp_armor;
    }

    public void setHp_armor(double hp_armor) {
        this.hp_armor = hp_armor;
    }

    public double getHp_armor(){
        return hp_armor;
    }
    @Override
    public double use() {
        return hp_armor;
    }

    @Override
    public String toString() {

        String rta = super.toString()+" Valor: "+ this.hp_armor + "\n";
        return rta;
    }

}

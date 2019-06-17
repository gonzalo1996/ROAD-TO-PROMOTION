package inventaryClasses;


import enumerations.EHierarchy;

/**
 * Clase dirigida para la defensa de PLAYER, esta se encarga de reducir el daÃ±o de WEAPON
 */
public class Shield extends Element{

    private double hp_shield;

    public Shield(/*String shield, EHierarchy legendary, int i, int i1*/) {
        super();
        hp_shield =0;
    }

    public Shield(String nameE, EHierarchy grade, double defense2) {
        super(nameE,grade);
        hp_shield = defense2;
    }

    public void setHp_shield(double hp_shield) {
        this.hp_shield = hp_shield;
    }

    public double getHp_shield() {
        return hp_shield;
    }

    @Override
    public double use() {
        return hp_shield;
    }

    @Override
    public String toString() {
        return super.toString()+"\nDefensa: " + this.hp_shield;
    }

}

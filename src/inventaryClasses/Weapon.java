package inventaryClasses;


import enumerations.EHierarchy;

public class Weapon extends Element{

    private double atk_value;

    public Weapon() {
        super();
        atk_value = 0;
    }

    public Weapon(String nameE,  EHierarchy grade, double atk_value) {
        super(nameE,grade);
        this.atk_value = atk_value;
    }


    public double getAtk_value() {
        return atk_value;
    }

    public void setAtk_value(double atk_value) {
        this.atk_value = atk_value;
    }

    @Override
    public String toString() {
        String rta = super.toString()+"Ataque: "+ this.atk_value +"\n";
        return rta;
    }

}

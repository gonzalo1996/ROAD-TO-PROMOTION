package classes;


import enumerations.EBattlePosition;
import inventaryClasses.*;

public class Hero extends Player{

    private double especial_atack;

    public Hero(int i, String akkarin, int hp, int base_damage, int defense, int speed_reaction, double v, int exp, int level, Equipment equipHero, Inventory<Element> inventoryHero, int especial_atack) {
        super();
        this.especial_atack =0;
    }

    public Hero(Hero h){
        super(h);
        setEspecial_atack( h.getEspecial_atack() );
    }

    public Hero(EBattlePosition battlePosition, String name, double hp, double base_damage, double defense, double speed_reaction, float crit_rate, double exp, int level, Equipment equipment, Inventory<Element> inventory_elements, double especial_atack) {
        super(battlePosition, name, hp, base_damage, defense, speed_reaction, crit_rate, exp, level, equipment, inventory_elements);
        this.especial_atack = especial_atack;
    }

    public double getEspecial_atack() {
        return especial_atack;
    }
    public void setEspecial_atack(double especial_atack) {
        this.especial_atack = especial_atack;
    }

    //NEW METHODS
    @Override
    public double calculate_damage_without_weapon(){
        double total_damage=super.calculate_damage_without_weapon();
        if(Random()){
            total_damage += getEspecial_atack();
        }
        return total_damage;
    }

    @Override
    public void attack(Player player_attacked){
        double total_damage=0;

        if( hasWeapon() ){
            total_damage = calculate_damage_with_weapon();
        }else{
            total_damage = calculate_damage_without_weapon();
        }
        player_attacked.receive_damage( total_damage );
    }

    //OLD METHODS
    public void LevelUP() {
        setLevel(getLevel()+1);
        setBase_damage(getBase_damage()+1);
        setCrit_rate(getCrit_rate()+1);
        setDefense(getDefense()+1);
        setHp(getHp()+1);
        setSpeed_reaction(getSpeed_reaction()+1);
    }

    //Metodo para que si supera el tope para subir el nivel, si es mayor el personaje sube de nivel, sino
    //se le agrega la experiencia recibida
    public void AddExp(double exp_recive) {
        double exptotal=0,aux=0;
        exptotal=getExp();
        aux=exptotal -exp_recive;
        if(aux != 0) {
            setExp(aux);
            LevelUP();
        }else {
            setExp(exp_recive);
        }
    }

    public boolean useAtackEspecial() {
        boolean flag=false;
        int damage=0,random=0;

        random=(int) ((Math.random() *9)+1);
        if(random<7) {
            flag=false;
        }else {
            flag=true;
        }
        return flag;
    }
}
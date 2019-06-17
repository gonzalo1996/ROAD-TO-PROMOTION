package classes;

import java.util.concurrent.ThreadLocalRandom;

import battleClasses.BattleStats;
import enumerations.EBattlePosition;
import inventaryClasses.*;

/**
 * Clase dedicada para la creaciÃ³n de multiples NPC's(Non-Player Computer)
 */
public class Enemy extends Player{



    //define si ataca o no al hÃ©roe cuando este entra en su rango de Ã¡rea
    private boolean hostile;
    //define si es un enemigo raro,comÃºn,muy frecuente.
    private String race;
    //habilidad del pj.
    private String ability;

    public Enemy() {
        super();
        this.hostile = true;
        this.race = "";
        this.ability = "";
    }

    public Enemy(EBattlePosition battlePosition, String name, double hp, double base_damage, double defense, double speed_reaction, float crit_rate, double exp, int level, Equipment equipment,
                 Inventory<Element> inventory_elements, String race, String ability) {
        super(battlePosition,name,hp,base_damage,defense,speed_reaction,crit_rate,exp,level,equipment,inventory_elements);
        this.hostile = true;
        this.race = race;
        this.ability = ability;

    }

    public Enemy(Enemy toCopy){
        super(toCopy);
            this.hostile = toCopy.isHostile();
            this.getRace();
            this.getAbility();
    }

    @Override
    public void attack(Player player_attacked) {
       
    }

    //TODO: se puede hacer que la clase sea estatica y asi no tiene que recibirla por parametro ?
    public void generateAction(BattleStats bs){
        int rta = 0;
        rta = action(bs);
        // 1 = curar , 2 = defender , 3 = equipar escudo , 4 = atacar , 5 = moverse
        switch (rta){

            case 1:
                setHp( getHp() + getAPotionFromInventory());
                break;
            case 2:
                /*setDefense(getDefense() + getEquipment().getShieldInUse().use());*/
                break;
            case 3:
               /* getEquipment().getShieldInUse().use();*/
                break;
            case 4:
                /*attack(Hero );*/
                break;
            case 5:
                //Se mueve de forma aleatoria de las 3 posibilades 
                break;
        }
    }

    //TODO: se puede hacer que la clase sea estatica y asi no tiene que recibirla por parametro ?
    public int action(BattleStats bs){
        // 1 = curar , 2 = defender , 3 = equipar escudo , 4 = atacar , 5 = moverse

        int rta = 0;

        //si ya perdio la mitad de la vida, intentara curarse de inmediato
        if (getHp() < (bs.getOriginalEnemy().getHp())/2){
            if(getInventory_elements().containsPotions()){
                rta = 1;
            }else{
                if(equipment.getShieldInUse().getHp_shield()>0){
                    rta = 2;
                }else {
                    if(getInventory_elements().containsShields()){
                        rta = 3;
                    }
                }
            }
        }else {
            rta = ThreadLocalRandom.current().nextInt(4, 6);
        }

        return rta;
    }

    public boolean isHostile() {
        return hostile;
    }

    public String getRace() {
        return race;
    }

    public String getAbility() {
        return ability;
    }
}

package classes;

import java.util.concurrent.ThreadLocalRandom;

import enumerations.EBattleOptionChoosed;
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
    public EBattleOptionChoosed generateBattleOptionChoose(){
        EBattleOptionChoosed npc_election=null;

        if(1 == 1){
            npc_election = EBattleOptionChoosed.ATTACK;
        }else if(){
            npc_election = EBattleOptionChoosed.HEAL;
        }else if(){
            npc_election = EBattleOptionChoosed.MOVE_TO_ANOTHER_POSITION;
        }
        return npc_election;
    }

    //TODO: mejorar este método para que cuando esté en la posicion 2, ó 3, pueda cambiar a la 1.
    public EBattlePosition generateNewBattlePosition(){
        EBattlePosition newBattlePosition=null;

        if(Random() && getBattlePosition() == EBattlePosition.FIRST_POSITION ){
            newBattlePosition = EBattlePosition.SECOND_POSITION;
        }else{
            newBattlePosition = EBattlePosition.THIRD_POSITION;
        }
        return newBattlePosition;
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

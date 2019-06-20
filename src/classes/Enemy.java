package classes;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import enumerations.EBattleOptionChoosed;
import enumerations.EBattlePosition;
import inventaryClasses.*;

/**
 * Clase dedicada para la creaciÃ³n de multiples NPC's(Non-Player Computer)
 */
public class Enemy extends Player {

    //define si ataca o no al hÃ©roe cuando este entra en su rango de Ãrea
    private boolean hostile;
    //define si es un enemigo raro,comÃºn,muy frecuente.
    private String race;
    //habilidad del pj.
    private String ability;

    public Enemy(int i, String dark_knight, int hp, int base_damage, int defense, int speed_reaction, double v, int exp, int level, Equipment equipEnemy, Inventory<Element> inventoryEnemy, String knight, String super_hp) {
        super();
        this.hostile = true;
        this.race = "";
        this.ability = "";
    }

    public Enemy(EBattlePosition battlePosition, String name, double hp, double base_damage, double defense, double speed_reaction, float crit_rate, double exp, int level, Equipment equipment,
                 Inventory<Element> inventory_elements, String race, String ability) {
        super(battlePosition, name, hp, base_damage, defense, speed_reaction, crit_rate, exp, level, equipment, inventory_elements);
        this.hostile = true;
        this.race = race;
        this.ability = ability;

    }

    public Enemy(Enemy toCopy) {
        super(toCopy);
        this.hostile = toCopy.isHostile();

        this.getAbility();
    }

    @Override
    public void attack(Player player_attacked) {

    }

    public EBattlePosition generateBattlePosition(){
        EBattlePosition newBattlePosition= null;
        boolean generated= false;

        int random_number = (int)(Math.random()*2+1);

        if( getBattlePosition() == EBattlePosition.FIRST_POSITION && !generated ){
            switch (random_number){
                case 1:
                    newBattlePosition = EBattlePosition.SECOND_POSITION;
                    break;
                case 2:
                    newBattlePosition = EBattlePosition.THIRD_POSITION;
                    break;
            }
            generated = true;
        }

        if( getBattlePosition() == EBattlePosition.SECOND_POSITION && !generated ){
            switch (random_number){
                case 1:
                    newBattlePosition = EBattlePosition.FIRST_POSITION;
                    break;
                case 2:
                    newBattlePosition = EBattlePosition.THIRD_POSITION;
                    break;
            }
            generated = true;
        }

        if( getBattlePosition() == EBattlePosition.THIRD_POSITION && !generated ){
            switch (random_number){
                case 1:
                    newBattlePosition = EBattlePosition.FIRST_POSITION;
                    break;
                case 2:
                    newBattlePosition = EBattlePosition.SECOND_POSITION;
                    break;
            }
            generated = true;
        }
        return newBattlePosition;
    }

    //TODO: se puede hacer que la clase sea estatica y asi no tiene que recibirla por parametro ?
    //no recibe nada por parametro. se usa en BATTLE.
    public EBattleOptionChoosed generateBattleOptionChoose() {
        EBattleOptionChoosed npc_election = null;
        int numeroAleatorio = (int) (Math.random()*2+1);
        switch (numeroAleatorio){
            case 0:
            //TODO: para curarse tiene que tener mas de la mitad de la vida
                npc_election = EBattleOptionChoosed.HEAL;
                break;
            case 1:
                //TODO: si tiene más de la mitad de vida que ataque
                npc_election = EBattleOptionChoosed.ATTACK;
                break;
            case 2:
                //TODO: a elección del que programe esto. KKKKKKKKKKKKKKKKKK
                npc_election = EBattleOptionChoosed.MOVE_TO_ANOTHER_POSITION;
                break;
        }
        return npc_election;

    }

    public Element itemDrop(){
        Element herosprize=null;

        int qty_elements = getInventory_elements().getElement_list().size();
        int random_number = (int)(Math.random()*qty_elements+1);

        herosprize = getInventory_elements().getElement_list().get(random_number);

        return herosprize;
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
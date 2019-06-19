package app;

import classes.Enemy;
import classes.Equipment;
import classes.Hero;
import enumerations.EBattlePosition;
import enumerations.EHierarchy;
import enumerations.EPotionSize;
import battleClasses.Battle;
import inventaryClasses.*;

public class Main {


    public static void main(String[] args) {
        //TODO: crear armor, shield, weapon,potion
        Potion potion = new Potion("Heal Potion",EHierarchy.LEGENDARY,150,3, EPotionSize.HIGH);
        Potion potion1 = new Potion("Heal Potion",EHierarchy.EXOTIC,100,3, EPotionSize.MEDIUM);
        Potion potion2 = new Potion("Heal Potion",EHierarchy.PECULIAR,75,3, EPotionSize.MEDIUM);
        Potion potion3 = new Potion("Heal Potion",EHierarchy.SIMPLE,50,3, EPotionSize.SMALL);

        Shield shield = new Shield("Diamond Shield",EHierarchy.LEGENDARY,150);
        Shield shield1 = new Shield("Gold Shield",EHierarchy.EXOTIC,100);
        Shield shield2 = new Shield("Silver Shields",EHierarchy.PECULIAR,75);
        Shield shield3 = new Shield("\n" + "Bronze shield",EHierarchy.SIMPLE,50);

        Weapon weapon = new Weapon("Excalibur",EHierarchy.LEGENDARY,150);
        Weapon weapon1 = new Weapon("Gold Sword",EHierarchy.EXOTIC,100);
        Weapon weapon2 = new Weapon("Silver Sword",EHierarchy.PECULIAR,75);
        Weapon weapon3 = new Weapon("Wood Sword",EHierarchy.SIMPLE,50);

        Armor armor = new Armor("Diamond Armor",EHierarchy.LEGENDARY,40);
        Armor armor1 = new Armor("Gold Armor",EHierarchy.LEGENDARY,40);
        Armor armor2 = new Armor("Silver Armor",EHierarchy.LEGENDARY,40);
        Armor armor3 = new Armor("Bronze Armor",EHierarchy.LEGENDARY,40);

        //TODO: EQUIPAMIENTO Actual
        Equipment equipHero= new Equipment(weapon3,shield3,armor3);
        Equipment equipEnemy= new Equipment(weapon2,shield2,armor2);

        //TODO: INVENTORY de ENEMY Y DE HERO
        Inventory<Element> inventoryEnemy = new Inventory<>();
        Inventory<Element> inventoryHero = new Inventory<>();

        inventoryEnemy.addElement(potion2);
        inventoryEnemy.addElement(potion2);
        inventoryEnemy.addElement(shield2);

        inventoryHero.addElement(potion3);
        inventoryHero.addElement(potion3);
        inventoryHero.addElement(shield3);

        //TODO: ENEMY con su inventario(su inventario va a droppear items)

        Enemy enemy= new Enemy(1,"Dark Knight",500,100,140,50,1.1,110,10,equipEnemy,
                inventoryEnemy,"Knight","Super Hp");

        //TODO: HERO inicia peladisimo páh.
        /*EBattlePosition battlePosition, String name, double hp, double base_damage, double defense,
        double speed_reaction, float crit_rate, double exp, int level, Equipment equipment,
         Inventory<Element> inventory_elements, double especial_atack*/
        Hero hero= new Hero(1,"Akkarin",300,150,70,80,3.0,50,5,equipHero,inventoryHero,50);


        //TODO: guardar el progreso del HERO.(posición en el mapa, inventario, estadisticas).

        //TODO: HERO colisiona con ENEMY y deben pelear(sí es que ENEMY hostil=true).
        //TODO: CUANDO HERO MATE AL ENEMY, ENEMY hostil=false.

        //TODO: CUANDO SE DERROTE AL FINAL BOSS HACER UN JPANEL QUE SE SUPERPONGA AL JUEGO Y TIRE UN "CONGRATULATION".
        //estos 4 elementos reciben los atributos de su super clase

        //nombre del elemento
        //grado o jerarquia del elemento
        //HERO INVENTORY
        /*Armor armor = new Armor("armor",EHierarchy.LEGENDARY,40);
        Potion potion = new Potion("potion",EHierarchy.LEGENDARY,100,3, EPotionSize.HIGH);
        Shield shield = new Shield("shield",EHierarchy.LEGENDARY,100);
        Weapon weapon = new Weapon("sword",EHierarchy.LEGENDARY,50);

        //ENEMY INVENTORY
        Armor armor2 = new Armor("armor",EHierarchy.LEGENDARY,40);
        Potion potion2 = new Potion("potion",EHierarchy.LEGENDARY,100,3, EPotionSize.HIGH);
        Shield shield2 = new Shield("shield",EHierarchy.LEGENDARY,100);
        Weapon weapon2 = new Weapon("sword",EHierarchy.LEGENDARY,50);*/


//		int battlePosition; // 1 2 3
//		boolean state;//vivo o muerto
//		String name;
//		double hp;
//		double attack;
//		double defense;//se incrementa solo con los escudos
//		double speed;//define quiÃ©n empieza una batalla.
//		float crit_rate;
//		double exp;
//		int level;
//		Inventory<Potion> potions;//curaciÃ³n(3 tipos: chica,mediana,grande)
//		Inventory<Weapon> weapons;//sword,spear,bow
//		Inventory<Shield> shields;//3 (chico,mediano,grande), es la defensa
//		Inventory<Armor> armors;//3 (rareza: bronce,plata,diamant)

        //creación de hero&enemy
        /*Hero intellij = new Hero( );
        Enemy eclipse = new Enemy();

        //batalla , SÍ el enemigo es hostile(aunq la mayoria son hostiles por no decir el 100%)
        Battle start_battle = new Battle(intellij,eclipse);*/




    }

}

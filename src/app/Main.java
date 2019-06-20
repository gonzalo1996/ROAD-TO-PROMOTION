package app;

import Exceptions.FullInventoryException;
import classes.Enemy;
import classes.Equipment;
import classes.Hero;
import enumerations.EHierarchy;
import enumerations.EPotionSize;
import inventaryClasses.*;

public class Main {


    public static void main(String[] args) throws FullInventoryException {
        //TODO: crear armor, shield, weapon,potion
        Potion potion = new Potion("Heal Potion",EHierarchy.LEGENDARY,150,3, EPotionSize.HIGH);
        Potion potion1 = new Potion("Heal Potion",EHierarchy.EXOTIC,100,3, EPotionSize.MEDIUM);
        Potion potion2 = new Potion("Heal Potion",EHierarchy.PECULIAR,75,3, EPotionSize.MEDIUM);
        Potion potion3 = new Potion("Heal Potion",EHierarchy.SIMPLE,50,3, EPotionSize.SMALL);

        Shield shield = new Shield("Diamond Shield",EHierarchy.LEGENDARY,150);
        Shield shield1 = new Shield("Gold Shield",EHierarchy.EXOTIC,100);
        Shield shield2 = new Shield("Silver Shields",EHierarchy.PECULIAR,75);
        Shield shield3 = new Shield("Bronze shield",EHierarchy.SIMPLE,50);

        Weapon weapon = new Weapon("Excalibur",EHierarchy.LEGENDARY,150);
        Weapon weapon1 = new Weapon("Gold Sword",EHierarchy.EXOTIC,100);
        Weapon weapon2 = new Weapon("Silver Sword",EHierarchy.PECULIAR,75);
        Weapon weapon3 = new Weapon("Wood Sword",EHierarchy.SIMPLE,50);

        Armor armor = new Armor("Diamond Armor",EHierarchy.LEGENDARY,40);
        Armor armor1 = new Armor("Gold Armor",EHierarchy.LEGENDARY,40);
        Armor armor2 = new Armor("Silver Armor",EHierarchy.LEGENDARY,40);
        Armor armor3 = new Armor("Bronze Armor",EHierarchy.LEGENDARY,40);

        //TODO: EQUIPAMIENTO Actual
        Equipment equipHero= new Equipment(weapon3,shield3,armor3,potion3);
        Equipment equipEnemy= new Equipment(weapon2,shield2,armor2,potion2);

        //TODO: INVENTORY de ENEMY Y DE HERO
        Inventory<Element> inventoryEnemy = new Inventory<Element>();
        Inventory<Element> inventoryHero = new Inventory<Element>();

        inventoryEnemy.addElement(weapon1);
        inventoryEnemy.addElement(shield1);
        inventoryEnemy.addElement(armor1);
        inventoryEnemy.addElement(potion1);

        inventoryEnemy.addElement(weapon);
        inventoryEnemy.addElement(shield);
        inventoryEnemy.addElement(armor);
        inventoryEnemy.addElement(potion);

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

    }

}

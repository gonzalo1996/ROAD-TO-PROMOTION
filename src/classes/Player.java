package classes;


import enumerations.EBattlePosition;
import inventaryClasses.*;

/**
 *
 */
public abstract class Player {

    private EBattlePosition battlePosition;
    private String name;
    private double hp;
    private double base_damage;
    private double defense;//se incrementa solo con los escudos.
    private double speed_reaction;//define quiÃ©n empieza una batalla.
    private double crit_rate;
    private double exp;
    private int level;
    Equipment equipment; //contiene los elementos en USO.
    private Inventory<Element> inventory_elements;

    //NEW CONSTRUCTORS
    public Player(){
        setBattlePosition( EBattlePosition.FIRST_POSITION );
        setName( "" );
        setHp(100);
        setBase_damage(15);
        setDefense(10);
        setSpeed_reaction(10);
        setCrit_rate(0.5);
        setExp(0);
        setLevel(0);
        setEquipment(null);
        inventory_elements = new Inventory<Element>();
    }

    public Player(EBattlePosition battlePosition, String name, double hp, double base_damage, double defense, double speed_reaction, float crit_rate, double exp, int level, Equipment equipment, Inventory<Element> inventory_elements) {
        setBattlePosition(battlePosition);
        setName(name);
        setHp(hp);
        setBase_damage(base_damage);
        setDefense(defense);
        setSpeed_reaction(speed_reaction);
        setCrit_rate(crit_rate);
        setExp(exp);
        setLevel(level);
        setEquipment(equipment);
        setInventory_elements(inventory_elements);
    }

    //ESTE CONSTRUCTOR SE VA A USAR PARA LAS BATALLAS.
    public Player(Player p) {
        setBattlePosition( p.getBattlePosition() );
        setName( p.getName() );
        setHp( p.getHp() );
        setBase_damage( p.getBase_damage() );
        setDefense( p.getDefense() );
        setSpeed_reaction( p.getSpeed_reaction() );
        setCrit_rate( p.getCrit_rate() );
        setExp( p.getCrit_rate() );
        setLevel( p.getLevel() );
        setEquipment( p.getEquipment() );
        setInventory_elements( p.getInventory_elements() );
    }

    public boolean hasPotion(){
        boolean ans=false;
        if( this.getEquipment().getPotionInUse() != null){
            ans = true;
        }
        return ans;
    }

    public boolean hasWeapon(){
        boolean ans=false;
        if( this.getEquipment().getWeaponInUse() != null){
            ans = true;
        }
        return ans;
    }

    public boolean hasShield(){
        boolean ans=false;
        if( this.getEquipment().getShieldInUse() != null){
            ans = true;
        }
        return ans;
    }

    public boolean hasArmor(){
        boolean ans=false;
        if( this.getEquipment().getArmorInUse() != null){
            ans = true;
        }
        return ans;
    }

    public boolean isDead(){
        boolean ans = false;
        if( getHp() <= 0 ){
            ans = true;
        }
        return ans;
    }

    public boolean heal(){
        boolean healed=false;
        if(hasPotion()){
            Potion p = getEquipment().getPotionInUse();
            p.use();
            if( p.getStock() == 0 ){
                getEquipment().potionOut();
            }
            healed = true;
        }
        return healed;
    }

    public double calculate_damage_without_weapon(){

        double total_damage = 0;

        //la formula del daÃ±o
        total_damage = (getBase_damage() + getSpeed_reaction()) * 0.50 + (getBase_damage()*crit_rate);

        return total_damage;
    }

    //todo: esto podria se un solo metodo, si no tiene arma va a dar +0 en osea q no lo va a afectar
    public double calculate_damage_with_weapon(){
        return calculate_damage_without_weapon() + getEquipment().getWeaponInUse().getAtk_value();
    }



    //TODO: todo que se encarga de actualizar los ATRIBUTOS del PLAYER ATACADO.
    public void receive_damage(double attacker_damage){
        //INICIALIZO VARIABLES DE DEFENSAS
        double damage_leftover=0;
        double shield_defense=0;
        double armor_defense = 0;

        if(getEquipment().getShieldInUse() != null){
            shield_defense = getEquipment().getShieldInUse().getHp_shield();
        }

        if( getEquipment().getArmorInUse() != null ){
            armor_defense = getEquipment().getArmorInUse().getHp_armor();
        }

        //SÃ� TIENE SHIELD, LE HAGO DAÃ‘O A SHIELD
        if( hasShield() ){

            if( shield_defense > attacker_damage ){
                //REDUZCO LA HP_SHIELD
                getEquipment().getShieldInUse().setHp_shield( shield_defense - attacker_damage );

                //SETTEO EL DAÑO ATACANTE A 0 PARA QUE NO ENTRE EN LAS SIGUIENTES CONDICIONES(IF's).
                attacker_damage = 0;
            }else{
                //ACÃ� ROMPO EL SHIELD
                damage_leftover = shield_defense - attacker_damage;
                //SE LO QUITO AL SHIELD
                getEquipment().shieldDestroyed();
            }
        }

        //ÚTILIZO MI DEFENSA PASIVA 7U7 KYAAA
        damage_leftover -= getDefense() - damage_leftover;

        if( damage_leftover > 0 && hasArmor() ){

            if( armor_defense > attacker_damage ){
                getEquipment().getArmorInUse().setHp_armor( armor_defense - attacker_damage );
                attacker_damage = 0;
            }else{
                attacker_damage = armor_defense - attacker_damage;
                getEquipment().armorDestroyed();
            }
        }

        if( damage_leftover > 0 && !isDead() ){
            setHp( getHp()-damage_leftover );
        }
    }

        //Metodo en el cual lo utilizaremos, para varias funciones
    public boolean Random() {
        boolean flag=false;
        int NumerRandom=0;

        NumerRandom=(int) (Math.random() *9)+1;
        if(NumerRandom < 5) {
            flag=false;
        }else {
            flag=true;
        }

        return flag;
    }

    public abstract void attack(Player player_attacked);

    public void equipWeapon(Weapon weaponToEquip) {
        getEquipment().setWeaponInUse( weaponToEquip );
    }

    public void equipShield(Shield shieldToEquip) {
        getEquipment().setShieldInUse(shieldToEquip);
    }

    public void equipArmor(Armor armorToEquip) {
        getEquipment().setArmorInUse(armorToEquip);
    }

    public void equipPotion(Potion potionToEquip) {
        getEquipment().setPotionInUse(potionToEquip);
    }

    ////////////////////////////////////////////////////////////////
    //GETTERS & SETTERS

    public EBattlePosition getBattlePosition() {
        return battlePosition;
    }

    public void setBattlePosition(EBattlePosition battlePosition) {
        this.battlePosition = battlePosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getBase_damage() {
        return base_damage;
    }

    public void setBase_damage(double base_damage) {
        this.base_damage = base_damage;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getSpeed_reaction() {
        return speed_reaction;
    }

    public void setSpeed_reaction(double speed_reaction) {
        this.speed_reaction = speed_reaction;
    }

    public double getCrit_rate() {
        return crit_rate;
    }

    public void setCrit_rate(double crit_rate) {
        this.crit_rate = crit_rate;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Inventory<Element> getInventory_elements() {
        return inventory_elements;
    }

    public void setInventory_elements(Inventory<Element> inventory_elements) {
        this.inventory_elements = inventory_elements;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }


}

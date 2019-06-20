package classes;


import inventaryClasses.Armor;
import inventaryClasses.Potion;
import inventaryClasses.Shield;
import inventaryClasses.Weapon;

/**
 * Clase contenedora de equipamiento en uso
 */
public class Equipment {

    private Weapon weaponInUse;
    private Shield shieldInUse;
    private Armor armorInUse;
    private Potion potionInUse;


    public Equipment(Weapon weaponInUse, Shield shieldInUse, Armor armorInUse, Potion potionInUse) {
        this.weaponInUse = weaponInUse;
        this.shieldInUse = shieldInUse;
        this.armorInUse = armorInUse;
        this.potionInUse = potionInUse;
    }

    public Weapon getWeaponInUse() {
        return weaponInUse;
    }

    public void setWeaponInUse(Weapon weaponInUse) {
        this.weaponInUse = weaponInUse;
    }

    public Shield getShieldInUse() {
        return shieldInUse;
    }

    public void setShieldInUse(Shield shieldInUse) {
        this.shieldInUse = shieldInUse;
    }

    public Armor getArmorInUse() {
        return armorInUse;
    }

    public void setArmorInUse(Armor armorInUse) {
        this.armorInUse = armorInUse;
    }

    public void shieldDestroyed(){
        setShieldInUse(null);
    }

    public void armorDestroyed(){
        setArmorInUse(null);
    }

    public void potionOut(){
        setPotionInUse(null);
    }

    public Potion getPotionInUse() {
        return potionInUse;
    }

    public void setPotionInUse(Potion potionInUse) {
        this.potionInUse = potionInUse;
    }
}

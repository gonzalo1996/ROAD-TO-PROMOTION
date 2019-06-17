package classes;


import inventaryClasses.Armor;
import inventaryClasses.Shield;
import inventaryClasses.Weapon;

/**
 * Clase contenedora de equipamiento en uso
 */
public class Equipment {

    private Weapon weaponInUse;
    private Shield shieldInUse;
    private Armor armorInUse;

    public Equipment(Weapon weaponInUse, Shield shieldInUse, Armor armorInUse) {
        this.weaponInUse = weaponInUse;
        this.shieldInUse = shieldInUse;
        this.armorInUse = armorInUse;
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
}

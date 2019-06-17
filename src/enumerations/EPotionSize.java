package enumerations;

/**
 * Enum que especifica el tamaÃ±o de la pociÃ³n en la clase inventaryClases/Potion.java
 */
public enum EPotionSize {

    HIGH("high"),MEDIUM("medium"),SMALL("small");

    private String potion_size;

    private EPotionSize(final String potionSize){
        potion_size = potionSize;
    }

    public String getPotion_size() {
        return potion_size;
    }
}
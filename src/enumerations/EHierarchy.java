package enumerations;

/**
 * Enum que define la JerarquÃ­a en inventaryClases/Element.java
 */
public enum EHierarchy {

    //1 es legendario, 2 es exotico, 3 peculiar, 4 comun
    LEGENDARY(1),EXOTIC(2),PECULIAR(3),SIMPLE(4);

    private int numero_jerarquia;

    private EHierarchy(final int numero_jerarquia) {
        this.numero_jerarquia = numero_jerarquia;
    }

    public int getNumero_jerarquia(){
        return numero_jerarquia;
    }

}

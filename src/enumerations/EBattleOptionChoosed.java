package enumerations;

public enum EBattleOptionChoosed {

    ATTACK(1),HEAL(2),MOVE_TO_ANOTHER_POSITION(3);

    private int opcion_escogida;

    private EBattleOptionChoosed(final int opcion_escogida){
        this.opcion_escogida = opcion_escogida;
    }

    public int getOpcion_escogida() {
        return opcion_escogida;
    }
}

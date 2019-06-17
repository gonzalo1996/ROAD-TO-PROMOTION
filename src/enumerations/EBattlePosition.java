package enumerations;

public enum EBattlePosition {

    FIRST_POSITION(1),SECOND_POSITION(2),THIRD_POSITION(3);

    private int battle_position;

    private EBattlePosition(final int battlePosition){
        battle_position = battlePosition;
    }

    public int getBattle_position() {
        return battle_position;
    }

}

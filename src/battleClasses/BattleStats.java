package battleClasses;

import classes.Enemy;
import classes.Hero;

public class BattleStats {

    private Hero originalHero;
    private Enemy originalEnemy;

    public BattleStats(Hero h, Enemy e){
        originalEnemy = e;
        originalHero = h;
    }

    public Hero getOriginalHero() {
        return originalHero;
    }

    public Enemy getOriginalEnemy() {
        return originalEnemy;
    }

    public void setOriginalHero(Hero originalHero) {
        this.originalHero = originalHero;
    }

    public void setOriginalEnemy(Enemy originalEnemy) {
        this.originalEnemy = originalEnemy;
    }
}

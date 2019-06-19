package battleClasses;

import classes.Enemy;
import classes.Hero;
import enumerations.EBattleOptionChoosed;
import enumerations.EBattlePosition;

/**
 * @use Cuando el HERO entra en un RANGO determinado de un ENEMY. Instanciamos esta clase para empezar una BATTLE(con el metodo fight)
 */
public class Battle {

    private Hero hero;
    private Enemy enemy;
    private int turns;

    //CONSTRUCTORS
    public Battle(Hero herO, Enemy enemY) {

        //TODO: crear constructor copia para la batalla papurris
        this.hero = new Hero(herO);
        this.enemy = new Enemy(enemY);
        turns = 0;
    }

    //METHODS
    public void fight(){
        boolean my_turn = false;

        if( hero.getSpeed_reaction() >= enemy.getSpeed_reaction()  ){
            my_turn = true;
        }else{
            my_turn = false;
        }

        while(!hero.isDead() && !enemy.isDead()){
            if (my_turn == true) {

                //TODO: seleccionar una accion a realizar con un clic.

                EBattleOptionChoosed player_election=null; // = //TODO: from SWING, a button choosed by an user.
                switch (player_election){
                    case ATTACK:
                        hero.attack(enemy);
                        break;
                    case HEAL:
                        hero.getAPotionFromInventory();
                        break;
                    case MOVE_TO_ANOTHER_POSITION:
                        //TODO: make a display of choose 2 alternative Position
                        EBattlePosition newPosition = null; // = TODO: a method which displays 2 new positions.
                        hero.setBattlePosition( newPosition );
                        break;
                }


                my_turn = !my_turn;

            } else if (my_turn == false) {

                EBattleOptionChoosed npc_election = enemy.generateBattleOptionChoose();

                switch (npc_election){
                    case ATTACK:
                        enemy.attack(hero);
                        break;
                    case HEAL:
                        enemy.getAPotionFromInventory();
                        break;
                    case MOVE_TO_ANOTHER_POSITION:

                        EBattlePosition newPosition = enemy.generateBattlePosition();
                        enemy.setBattlePosition( newPosition );
                        break;
                }
                my_turn = !my_turn;
            }
        }

        if(!hero.isDead()){
            //TODO: JFrame of "enemy has been defeated" + show an item as prize + if HERO want to add it on inventory or not.
            System.out.println("ENEMY HAS BEEN DEFEATED");
        }else{
            //TODO: JFrame of "YOU LOSSE!" and send to HERO to the starting point of the game.
            System.out.println("GAME OVER!");
        }

    }

    //GETTERS AND SETTERS

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}
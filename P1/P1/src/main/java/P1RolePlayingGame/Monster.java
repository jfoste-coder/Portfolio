


public class Monster {

    //Fields
    public String type;
    public int hitPoints; 
    public int attackRating;
    public int xpValue;
    public int goldValue;

    // constructor for Monster
    public Monster(String type, int hp, int attackR, int xp, int gold){

        //sets values for monster object
        this.type = type;
        this.hitPoints = hp;
        this.attackRating = attackR;
        this.xpValue = xp;
        this.goldValue = gold;

    }

    // Constructore overload for goblin
    public Monster(){

        //creates goblin when no argument is passed
        this.type = "Goblin";
        this.hitPoints = 10;
        this.attackRating = 1;
        this.xpValue = 1;
        this.goldValue = 1;

    }


    // method to check to see if the monster is defeated
    public boolean isDefeated(){
        return this.hitPoints < 1;
    }

    // method for taking damage
    public void receiveAttack(int incAttack){
        this.hitPoints -= incAttack;
        System.out.println("Monster receives attack");
        System.out.println("Monster Health " + this.hitPoints);
        System.out.println();
    }

}

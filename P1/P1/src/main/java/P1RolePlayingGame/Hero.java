


public class Hero {

    // Fields
    public String name;
    public int hitPointsRemaining;
    public int hitPointsMax;
    public int attackRating;
    public int defenseRating;
    public int currentXP;
    public int currentLevel;
    public int healingPotions;


    // constructor
    public Hero(String name, int hpMax, int ar, int dr, int potions){
        this.name = name;
        this.hitPointsRemaining = hpMax;
        this.hitPointsMax = hpMax;
        this.attackRating = ar; // attack rating
        this.defenseRating = dr; // defense rating
        this.currentXP = 0;
        this.currentLevel = 0;
        this.healingPotions = potions;
    }


    // checks to see if the Hero has hit points remaining
    public boolean hasHPRemaining(){
        return this.hitPointsRemaining >= 1;
    }

    // calculates damage on received attacks
    public void receiveAttack(int incAttack){

        // calculates only if incAttack is greater than defense rating
        if(incAttack > this.defenseRating){
            this.hitPointsRemaining -= incAttack - this.defenseRating;
            System.out.println("Hero recieves attack");
            System.out.println("Hero Health " + this.hitPointsRemaining);
            System.out.println();
        }
        else{
            System.out.println("hero blocks attack");
            System.out.println(this.hitPointsRemaining);
            System.out.println();
        }
    }

    // calculate level and xp. 10 xp = 1 level
    public void receiveXP(int xpReceived){
        this.currentXP += xpReceived;
        if(this.currentXP >= 10){

            // add levels
            this.currentLevel += this.currentXP / 10;

            // adds health
            this.hitPointsMax += 5 * (this.currentXP / 10);

            // calculates remainder and assigns to current XP
            this.currentXP = this.currentXP % 10;
        }

    }

    // health potions
    public void useHealingPotion(){
        if(this.healingPotions > 0){
            this.hitPointsRemaining = this.hitPointsMax;
            this.healingPotions--;
        }
    }










}

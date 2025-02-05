


public class Battle {


    // https://tenor.com/view/godzilla-let-them-fight-fight-ken-watanabe-watanabe-gif-5687182
    public static String fight(Hero h, Monster m){
        String result = "Battle Start";
        System.out.println();
        System.out.println("start fight between " + h.name + " and " + m.type);
        System.out.println();

        while(!m.isDefeated() && h.hasHPRemaining()){
            

            // hero attacks monster
            m.receiveAttack(h.attackRating);

            // hero wins
            if(m.isDefeated()){
            
                // level up
                h.receiveXP(m.xpValue);

                // add potions to hero inventory by dividing monster gold value by 3
                h.healingPotions =+ m.goldValue / 3;

                // updates string output
                result = h.name + " has defeated the " + m.type + " earning " + m.goldValue + " gold and " + m.xpValue + " XP, leveling up " + (m.xpValue / 10) + " times.";
            }
            
            // monster attacks hero
            h.receiveAttack(m.attackRating);

            // returns true if the hero has hp remaining so we check to see if its false then use a healing potion
            if(!h.hasHPRemaining()){
                h.useHealingPotion();
            }

            // monster wins
            if(!h.hasHPRemaining()){

                // updates string output
                result = "The " + m.type + " has defeated "+ h.name + ". Game Over.";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Monster with attack greater than defense of hero
        Monster mon1 = new Monster("Goblin King", 100 , 11, 12, 8);
        
        // deafault construstor building a goblin
        Monster mon2 = new Monster();

        // monster with high attack
        Monster mon3 = new Monster("Abbadon", 1000, 50, 200, 500);

        // A barbarian with 100 HP, 10 attack rating, 10 defense rating, and 10 potions
        Hero brb = new Hero("Barb the barbarian", 100, 10, 10, 10);

        // fight 1
        String fightResult = Battle.fight(brb, mon1);
        System.out.println(fightResult);

        // fight 2
        String fightResult2 = Battle.fight(brb, mon2);
        System.out.println(fightResult2);

        // fight 3
        String fightResult3 = Battle.fight(brb, mon3);
        System.out.println(fightResult3);

    }

}

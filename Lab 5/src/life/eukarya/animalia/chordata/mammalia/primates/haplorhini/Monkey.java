/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/

package src.life.eukarya.animalia.chordata.mammalia.primates.haplorhini;

import src.life.eukarya.animalia.Animal;

/**
 * start of class Monkey
 * 
 * 
 * 
 */
public class Monkey extends Animal{


    /**
     * constructor for Monkey class
     * 
     * @param name name of animal
     * @param type type of animal
     * @param nocturnal boolean for sleep schedule
     */
    public Monkey(String name, String type, Boolean nocturnal){
        super(name, "Monkey", false);
    }

    /**
     * method to feed Monkey
     * 
     * method overrides base class printFeed method to customize for Monkey
     * 
     * 
     */
    @Override
    public void printFeed(){
        System.out.println("You should give this monkey some bananas.");
    }

    /**
     * method for monkey roaming
     * 
     * method overrides base class printRoam method to customize for monkey
     */
    @Override
    public void printRoam(){
        System.out.println("this monkey climbs a tree!");
    }


}


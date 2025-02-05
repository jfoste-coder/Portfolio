/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/

package src.life.eukarya.animalia.chordata.aves.telluraves.strigiformes;

import src.life.eukarya.animalia.Animal;

/**
 * start of class Owl
 * 
 * 
 * 
 */
public class Owl extends Animal{


    /**
     * constructor for Owl class
     * 
     * @param name name of animal
     * @param type type of animal
     * @param nocturnal boolean for sleep schedule
     */
    public Owl(String name, String type, Boolean nocturnal){
        super(name, "Owl", true);
    }

    /**
     * method to feed Owl
     * 
     * method overrides base class printFeed method to customize for owl
     */
    @Override
    public void printFeed(){
        System.out.println("You should give this owl some mice.");
    }

    /**
     * method for Owl roaming
     * 
     * method overrides base class printRoam method to customize for owl
     */
    @Override
    public void printRoam(){
        System.out.println("this owl flies around.");
    }


}

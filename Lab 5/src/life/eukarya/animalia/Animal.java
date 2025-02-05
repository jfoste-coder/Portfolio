/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/

package src.life.eukarya.animalia;

/**
 * start of class Animal
 * 
 * 
 * 
 */
public class Animal{


    // fields
    private String name;
    private String type;
    private Boolean nocturnal;

    /**
     * constructor for Animal class
     * 
     * @param name name of animal
     * @param type type of animal
     * @param nocturnal boolean for sleep schedule
     */
    public Animal(String name, String type, Boolean nocturnal){
        this.name = name;
        this.type = type;
        this.nocturnal = nocturnal;
    }


    /**
     * method to print info
     * 
     * 
     * prints   this.name is a(n) this.type.
     */
    public void printInfo(){
        System.out.println(this.name + " is a(n) " + this.type +".");
    }

    /**
     * method to print sleep info
     * 
     * 
     * checks nocturnal boolean to output either daytime or nighttime sleep schedule
     */
    public void printSleepInfo(){
        if(this.nocturnal){
            System.out.println(this.type + "s sleep during the day.");
        }
        else{
            System.out.println(this.type + "s sleep during the night.");
        }
    }

    /**
     * method to print roaming
     * 
     * 
     * prints animal walking habits
     */
    public void printRoam(){
        System.out.println(this.name + " walks around.");
    }

    /**
     * method to CHOMP
     * 
     * CHOMP CHOMP CHOMP CHOMP
     * 
     */
    public void printFeed(){
        System.out.println("Chomp chomp");
    }





}

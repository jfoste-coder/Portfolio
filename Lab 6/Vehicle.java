/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * start of Vehicle Class
 * 
 * the vehicle contains the properties of being shareable
 */
public abstract class Vehicle implements Shareable{


    // fields
    protected String model;
    protected int year;
    protected PowerSource primaryPowerSource;

    
    // diferent types of power sources
    public enum PowerSource{
        HYDROGEN,
        ELECTRIC,
        COMBUSTION,
        MANUAL
    }

    /**
     * Constructor for Vehicle class
     * 
     * creates a Vehicle which has different properties
     * 
     * @param model - model of the vehicle
     * @param year - year of the vehicle
     * @param primaryPowerSource - power source of the vehicle
     */
    public Vehicle(String model, int year, PowerSource primaryPowerSource){
        this.model = model;
        this.year = year;
        this.primaryPowerSource = primaryPowerSource;
    }

    // abstract method for starting and stopping the power
    public abstract void startEngine();
    public abstract void stopEngine();

    /**
     * Overrride for Shareable interface
     * 
     * lists how many people were pickup at a location
     * 
     * @param persons - int of people being picked up
     * @param pickUpLocation - String of location being picke up at
     */
    @Override
    public void startShare(int persons, String pickUpLocation){
        System.out.println(persons + " picked up at " + pickUpLocation);
    }

    /**
     * Overrride for Shareable interface
     * 
     * lists how many people were dropped off at a location
     * 
     * @param persons - int of people being dropped off
     * @param dropOffLocation - String of location being dropped off at
     */
    @Override
    public void finishShare(int persons, String dropOffLocation){
        System.out.println(persons + " dropped off at " + dropOffLocation);
    }
}

/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * start of Truck Class
 * 
 * the interface contains the properties of being rentable and extends from the vehicle class
 */
public class Truck extends Vehicle implements Rentable{

    /**
     * Constructor for Truck class
     * 
     * creates a Truck which has different properties
     * 
     * @param model - model of the vehicle
     * @param year - year of the vehicle
     * @param primaryPowerSource - power source of the vehicle
     */
    public Truck(String model, int year, PowerSource primaryPowerSource){

        super(model, year, primaryPowerSource);

    }

    // override method of startEngine from the vehicle super class
    @Override
    public void startEngine(){
        System.out.println("Truck engine started");
    }

    // override method of stopEngine from the vehicle super class
    @Override
    public void stopEngine(){
        System.out.println("Truck engine turned off");
    }

    /**
     * override for the startRental from the Rentable interface
     * 
     * @param days - days the vehicle has been rented
     * @param dailyRate - daily rental rate of the vehicle
     */
    @Override
    public double startRental(int days, float dailyRate){
        return days * dailyRate;
    }

    // override for the finishRental from the Rentable interface
    @Override
    public void finishRental(){
        System.out.println("The Truck has been returned");
    }




    
} 


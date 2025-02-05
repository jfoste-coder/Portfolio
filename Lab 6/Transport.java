/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/

/**
 * start of Transport Class
 * 
 * the transport class contains the main method
 */
public class Transport{


    public static void main(String[] args) {
        
        // field for daily rental rate
        float dailyRate = 14;

        // car object testing
        Car sentra = new Car("Sentra", 2021, Vehicle.PowerSource.COMBUSTION);
        sentra.startEngine();
        sentra.stopEngine();
        System.out.println(sentra.startRental(7, dailyRate));
        sentra.finishRental();
        sentra.startShare(12, "GMU");
        sentra.finishShare(12, "GMU");

        // Truck object testing
        Truck tacoma = new Truck("Tacoma", 2021, Vehicle.PowerSource.COMBUSTION);
        tacoma.startEngine();
        tacoma.stopEngine();
        System.out.println(tacoma.startRental(7, dailyRate));
        tacoma.finishRental();
        tacoma.startShare(12, "GMU");
        tacoma.finishShare(12, "GMU");

        // Motorcycle object testing
        Motorcycle pilot = new Motorcycle("Pilot", 2021, Vehicle.PowerSource.COMBUSTION);
        pilot.startEngine();
        pilot.stopEngine();
        System.out.println(pilot.startRental(7, dailyRate));
        pilot.finishRental();
        pilot.startShare(12, "GMU");
        pilot.finishShare(12, "GMU");

        // Bicycle object testing
        Bicycle chariot = new Bicycle("Chariot", 2021, Vehicle.PowerSource.MANUAL);
        chariot.startEngine();
        chariot.stopEngine();
        System.out.println(chariot.startRental(7, dailyRate));
        chariot.finishRental();
        chariot.startShare(12, "GMU");
        chariot.finishShare(12, "GMU");



    }










}

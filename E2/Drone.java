/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * start of Drone subclass
 * 
 * inherits from Robot class
 */
public class Drone extends Robot{


    /**
     * Constructor for Drone class
     * 
     * creates a Drone which has a serial number and various capabilites
     * 
     * @param serialNumber - serial number for robot
     */
    public Drone(int serialNumber){
        // uses parent constructor from Robot class
        super(serialNumber, true, false, true);
    }

    /**
     * overrides canFly
     * 
     * @return boolean flying
     */
    @Override
    public boolean canFly(){
        return true;
    }

    /**
     * overrides isAutonomous
     * 
     * @return boolean Autonomous
     */
    @Override
    public boolean isAutonomous(){
        return true;
    }

    /**
     * overrides isTeleoperated
     * 
     * @return boolean Teleoperated
     */
    @Override
    public boolean isTeleoperated(){
        return true;
    }
}

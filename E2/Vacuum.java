/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/




/**
 * start of Vacuum subclass
 * 
 * inherits from Robot class
 */
public class Vacuum extends Robot{


    /**
     * Constructor for Drone class
     * 
     * creates a Drone which has a serial number and various capabilites
     * 
     * @param serialNumber - serial number for robot
     */
    public Vacuum(int serialNumber){
        // calls constructor from Robot class
        super(serialNumber, false, false, false);


    }

    /**
     * method to check cleaning capabilities
     * 
     * @return boolean canClean if true
     */
    public boolean canClean(){
        return true;
    }

    /**
     * override method to check capabilites
     * 
     * @return String listing all capabilities of robot and whether the robot can fight
     */
    @Override
    public String getCapabilities(){
        if(this.canClean()){
            return super.getCapabilities() + "canClean ";
        }
        else{
            return super.getCapabilities();
        }
    }

    /**
     * overrides canFly
     * 
     * @return boolean flying
     */
    @Override
    public boolean canFly(){
        return false;
    }

    /**
     * overrides isAutonomous
     * 
     * @return boolean Autonomous
     */
    @Override
    public boolean isAutonomous(){
        return false;
    }

    /**
     * overrides isTeleoperated
     * 
     * @return boolean Teleoperated
     */
    @Override
    public boolean isTeleoperated(){
        return false;
    }
}

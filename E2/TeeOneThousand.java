/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * start of TeeOnThousand subclass
 * 
 * inherits from MovieRobot class
 */
public class TeeOneThousand extends MovieRobot{

    /**
     * Constructor for HAL9000 object
     * 
     * @param serialNumber - serial number for robot
     * @param flies - robot's flying capability
     * @param autonomous - whether the robot can operate on its own
     * @param teleoperated - whether it can be operated remotely
     */
    public TeeOneThousand(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
        // calls constructor from MovieRobot class
        super(serialNumber, flies, autonomous, teleoperated);
    }

    /**
     * override method to check capabilites
     * 
     * @return Boolean cheacks for catchphrase
     */
    @Override
    public boolean canSpeak(){
        return this.catchPhrase != null;
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
     * @return String listing all capabilities of robot and whether the robot can clean
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
}

/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/




/**
 * start of Replicant subclass
 * 
 * inherits from MovieRobot class
 */
public class Replicant extends MovieRobot{

    /**
     * Constructor for Replicant object
     * 
     * @param serialNumber - serial number for robot
     * @param flies - robot's flying capability
     * @param autonomous - whether the robot can operate on its own
     * @param teleoperated - whether it can be operated remotely
     */
    public Replicant(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
        super(serialNumber, flies, autonomous, teleoperated, "like tears in the rain...");
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
     * method to check fighting capabilities
     * 
     * @return boolean canFight if true
     */
    public boolean canFight(){
        return true;
    }

    /**
     * override method to check capabilites
     * 
     * @return String listing all capabilities of robot and whether the robot can fight
     */
    @Override
    public String getCapabilities(){
        if(this.canFight()){
            return super.getCapabilities() + "canFight ";
        }
        else{
            return super.getCapabilities();
        }
    }
}

/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/

/**
 * start of HAL9000 subclass
 * 
 * inherits from MovieRobot class
 */
public class HAL9000 extends MovieRobot{

    /**
     * Constructor for HAL9000 object
     * 
     * @param serialNumber - serial number for robot
     * @param autonomous - whether the robot can operate on its own
     * @param teleoperated - whether it can be operated remotely
     */
    public HAL9000(int serialNumber, boolean autonomous, boolean teleoperated){
        super(serialNumber, true, autonomous, teleoperated, "I can't let you do that Dave.");
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

}

/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/




/**
 * start of MovieRobot subclass
 * 
 * inherits from Robot class
 */
public abstract class MovieRobot extends Robot{



    // field for catchphrase
    protected String catchPhrase;

    /**
     * Constructor for MovieRobot class
     * 
     * creates a movie robot which has a serial number and various capabilites
     * 
     * @param serialNumber - serial number for robot
     * @param flies - robot's flying capability
     * @param autonomous - whether the robot can operate on its own
     * @param teleoperated - whether it can be operated remotely
     * @param catchPhrase - tag line for the robot
     */
    public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated, String catchPhrase){

        super(serialNumber, flies, autonomous, teleoperated);
        this.catchPhrase = catchPhrase;
    }


    /**
     * Constructor overload for MovieRobot class
     * 
     * creates a movie robot which has a serial number and various capabilites but cannot speak or doesnt have a catch phrase
     * 
     * @param serialNumber - serial number for robot
     * @param flies - robot's flying capability
     * @param autonomous - whether the robot can operate on its own
     * @param teleoperated - whether it can be operated remotely
     */
    public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){

        super(serialNumber, flies, autonomous, teleoperated);
    }

    /**
     * method to check if the robot can talk
     * 
     * @return boolean canSpeak
     */
    public abstract boolean canSpeak();

    /**
     * override method to check capabilites
     * 
     * @return String listing all capbilities of robot and whether the robot can speak
     */
    @Override
    public String getCapabilities(){
        if(this.canSpeak()){
            return super.getCapabilities() + "canSpeak ";
        }
        else{
            return super.getCapabilities();
        }
    }

    /**
     * override of toString to print robots
     * 
     * @return String listing all capbilities of robot and its catch phrase
     */
    @Override
    public String toString(){
        if(this.canSpeak()){
            return super.toString() + " \"" + this.catchPhrase + "\"";
        }
        else{
            return super.toString();
        }
    }
}

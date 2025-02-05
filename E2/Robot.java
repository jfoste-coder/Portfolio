/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/




/**
 * 
 * start of robot class
 */
public class Robot{



    // fields
    protected int serialNumber;
    protected boolean flies;
    protected boolean autonomous;
    protected boolean teleoperated;





    /**
     * Constructor for Robot class
     * 
     * creates a robot which has a serial number and various capabilites
     * 
     * @param serialNumber - serial number for robot
     * @param flies - robot's flying capability
     * @param autonomous - whether the robot can operate on its own
     * @param teleoperated - whether it can be operated remotely
     * 
     */
    public Robot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
        this.serialNumber = serialNumber;
        this.flies = flies;
        this.autonomous = autonomous;
        this.teleoperated = teleoperated;
    }

    /**
     * method to set capabilities
     * 
     * @param flies - robot's flying capability
     * @param autonomous - whether the robot can operate on its own
     * @param teleoperated - whether it can be operated remotely
     */
    public void setCapabilities(boolean fly, boolean auto, boolean tele){
        this.flies = fly;
        this.autonomous = auto;
        this.teleoperated = tele;
    }

    /**
     * method to get serial number
     * 
     * @return int serial number
     */
    public int getSerialNumber(){
        return this.serialNumber;
    }

    /**
     * method to check flying capabilities
     * 
     * @return boolean flying
     */
    public boolean canFly(){
        return this.flies;
    }

    /**
     * method to check autonomy
     * 
     * @return boolean atunomous
     */
    public boolean isAutonomous(){
        return this.autonomous;
    }

    /**
     * method to check teleoperablilty
     * 
     * @return boolean teleoperated
     */
    public boolean isTeleoperated(){
        return this.teleoperated;
    }

    /**
     * method to check capabilites
     * 
     * @return String listing all capbilities of robot
     */
    public String getCapabilities(){
        String capabilities = "";
        if(this.canFly()){
            capabilities += "canFly ";
        }
        if(this.isAutonomous()){
            capabilities += "isAutonomous ";
        }
        if(this.isTeleoperated()){
            capabilities += "isTeleoperated ";
        }
        return capabilities;
    }

    /**
     * override of toString to print robots
     * 
     * @return String listing all capbilities of robot
     */
    @Override
    public String toString(){
        return "ID: " + this.serialNumber + ", Capabilities: " + this.getCapabilities();
    }





    public static void main(String[] args) {
        
        /* code for testing

        Robot a = new Robot(1234, true, false, true);
        System.out.println(a);
        a.setCapabilities(false, true, true);
        System.out.println(a);
        System.out.println(a.getSerialNumber());

        Drone b = new Drone(6789);
        System.out.println(b);

        Vacuum h = new Vacuum(4000);
        System.out.println(h);

        // MovieRobot c = new MovieRobot(343, true, true, true, "I am 343 guilty spark.");
        // System.out.println(c);

        // MovieRobot d = new MovieRobot(117, false, true, false);
        // System.out.println(d);

        HAL9000 e = new HAL9000(9000, true, true);
        System.out.println(e);

        Replicant f = new Replicant(666, false, false, false);
        System.out.println(f);

        TeeOneThousand g = new TeeOneThousand(1000, true, true, true);
        System.out.println(g);
        */
    }
}















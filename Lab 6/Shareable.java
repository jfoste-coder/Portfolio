/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


/**
 * start of Shareable Interface
 * 
 * the interface contains the properties of being Shareable
 */
public interface Shareable{

    void startShare(int persons, String pickUpLocation);
    void finishShare(int persons, String dropOffLocation);

}
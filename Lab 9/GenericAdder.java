/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



public class GenericAdder<A extends Number> {

    // fields
    private final A baseNumber;

    //constructor
    public GenericAdder(A baseNumber){
        this.baseNumber = baseNumber;
    }

    //getter
    public A getBaseNumber(){
        return this.baseNumber;
    }

    /**
     * method to add different generic types
     * 
     * @return Integer
     * @param object of type B which extends the number class
     */
    public <B extends Number> Integer intAdd(B otherInt){
        return this.baseNumber.intValue()+otherInt.intValue();
    }




}

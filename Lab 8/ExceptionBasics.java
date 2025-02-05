/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/




public class ExceptionBasics {
    public static void main(String[] args) {
        System.out.println("Hello, Exceptional World!");
        //App app = new App();
        //app.propagationExample(); // requires more propagation: add "throws Throwable" to this method
        //app.catchingExample();

        
        // iGotcha(2,0);


    }
    /**
     * The syntax "throws ThrowableType" after the parameter list indicates
     * that the method is not handling the situation, the caller of the method is.
     * @throws Throwable an example creating a new Throwable instance with message "Catch me if you can!"
     */
    public void propagationExample() throws Throwable{
        // This is an example, there are conditions you want check before throwing an exception 
        throw new Throwable("Catch me if you can!");
    }

    /**
     * Notice how catching exceptions stops propagation
     */
    public void catchingExample(){
        try{
            // all lines before the line below will execute normally
            propagationExample(); // The method result is now corrupted due to the exception
            // the result of the method, if any, and until the end of this try's block will not execute. 
        }catch(Throwable t){ // "Throwable t" is the type we are aiming to catch
            System.out.println("Catch you I did!"); // and caught it is
        }

        try{
            // the Throwable may be thrown and propagated from a line within this block    
        }catch(Throwable t){
            // and this block executes if the Throwable was in fact thrown.
        }

    }

    /**
     * method that takes two values and throws exception if dividing by zero
     */
    public static void iGotcha(int a, int b){

        
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("Dividing "+ a +" by " + b + " is not possible");
        }
    }
}

/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileVader {
    public static void main(String[] args) {
        String fileName = "example.txt"; // 1. make sure you created this file and it is at the same location as this code 
        FileReader fr = null;
        BufferedReader br = null;
        //2. exception type FileNotFoundException: 
        //put the line below within a try-catch statement with the respective type (FileNotFoundException)
        try{
            fr = new FileReader(fileName);
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        //3. exception type IOException, exception type IOException:
        // Now wrap the remaining statements within a try-catch statement
        // Make sure you are not missing a NullPointerException from the variable fr
        try{ 
            br = new BufferedReader(fr);
            String line;
            br.close();// intentionally cause an IOException
            while ((line = br.readLine()) != null) {
                // Process the line
                System.out.println(line);
            }
            // br.close();
        }catch(IOException e){
            AnakinException a = new AnakinException();
            System.out.println(a.getMessage());
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

        // 4. You are all set
    }
}


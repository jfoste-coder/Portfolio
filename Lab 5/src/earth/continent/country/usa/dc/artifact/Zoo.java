/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/

package src.earth.continent.country.usa.dc.artifact;

import src.life.eukarya.animalia.Animal;
import src.life.eukarya.animalia.chordata.aves.telluraves.strigiformes.Owl;
import src.life.eukarya.animalia.chordata.mammalia.primates.haplorhini.Monkey;

/**
 * start of class Zoo
 * 
 * the Zoo class contains the main method
 * 
 */
public class Zoo{


    public static void main(String[] args) {

        // new animal
        Animal mooDeng = new Animal("Moo Deng", "Hippo", false);
        mooDeng.printInfo();
        mooDeng.printSleepInfo();
        mooDeng.printRoam();
        mooDeng.printFeed();

        // new owl
        Owl pesto = new Owl("Pesto", "", true);
        pesto.printInfo();
        pesto.printSleepInfo();
        pesto.printRoam();
        pesto.printFeed();

        // new monkey
        Monkey harambe = new Monkey("Harambe", "", true);
        harambe.printInfo();
        harambe.printSleepInfo();
        harambe.printRoam();
        harambe.printFeed();
    }



}

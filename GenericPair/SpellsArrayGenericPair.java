/**
 * Example SpellsArrayGenericPair: a version of the Spells program that
 * uses an array of GenericPair objects
 *
 * @author Jim Teresco, Siena College, CSIS 210, Fall 2017
 * @version Fall 2019
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpellsArrayGenericPair {

    public static void main(String args[]) throws IOException {

	final int NUM_SPELLS = 10;
        // create an array of the magic spells we know.
        // Note: due to the way Java handles arrays and generic types,
        // we have to leave off the <String,String> in the construction..
        GenericPair<String,String> spells[] = new GenericPair[NUM_SPELLS];

	Scanner inFile = new Scanner(new File("spells.txt"));
	for (int i = 0; i < NUM_SPELLS; i++) {
	    String spell = inFile.nextLine().trim();
	    String action = inFile.nextLine().trim();
       
	    spells[i] = new GenericPair<String,String>(spell, action);
	}
	inFile.close();
	
        // we play a little game matching spells to descriptions
        // until an invalid spell is specified
        Scanner keyboard = new Scanner(System.in);
        int spellnum = 0;
        while (spellnum >= 0) {
            System.out.print("Which spell will you use? ");
            String spellName = keyboard.next();
            spellnum = -1;
            for (int spellIndex = 0; spellIndex < spells.length; spellIndex++) {
                if (spellName.equals(spells[spellIndex].getFirst())) {
                    spellnum = spellIndex;
                    break;
                }
            }
            if (spellnum >= 0) {
                System.out.println(spells[spellnum].getSecond());
            }
            else {
                System.out.println("Your wand doesn't know that one.  It explodes.  Bye!");
            }
        }
    }
}

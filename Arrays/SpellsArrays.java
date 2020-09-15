/**
 * Example SpellsArrays: a version of the Spells program that
 * uses parallel arrays to match up spells with their actions
 *
 * @author Jim Teresco, Siena College, CSIS 210, Fall 2017
 * @version Fall 2019
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SpellsArrays {

    /**
       Create arrays representing Harry Potter spells, and look
       up spell actions by name.

       @param args not used
       @throws IOException
    */
    public static void main(String args[]) throws IOException {

	final int NUM_SPELLS = 10;
        // create arrays of the magic spells we know.
	// one array has the spell incantations and the other
	// described their effects

        String spells[] = new String[NUM_SPELLS];
        String actions[] = new String[NUM_SPELLS];

	Scanner inFile = new Scanner(new File("spells.txt"));
	for (int i = 0; i < NUM_SPELLS; i++) {
	    String spell = inFile.nextLine().trim();
	    String action = inFile.nextLine().trim();
       
	    spells[i] = spell;
	    actions[i] = action;
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
                if (spellName.equals(spells[spellIndex])) {
                    spellnum = spellIndex;
                    break;
                }
            }
            if (spellnum >= 0) {
                System.out.println(actions[spellnum]);
            }
            else {
                System.out.println("Your wand doesn't know that one.  It explodes.  Bye!");
            }
        }
    }
}

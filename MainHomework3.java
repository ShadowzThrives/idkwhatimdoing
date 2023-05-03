// CS 110 Homework #3: Grammy Awards Problem
// Place this file in the same directory as your own source code and add it to your project.
// DO NOT MODIFY THE CONTENTS OF THIS FILE OTHER THAN AS INDICATED BELOW.

import java.util.HashMap;
import java.util.List;

/**
 * Class to drive Homework #3 code
 * 
 * @author Brian Powell
 *
 */
public class MainHomework3 {
	/**
	 * Program entry point
	 * 
	 * @param args Command line arguments - not used
	 */
	public static void main(String[] args) {
		// Define filename to read Grammy awards from
		// You may change the contents of the storeFile variable if convenient while
		// writing your program
		final String awardsFile = "awards2.csv";

		// Load awards
		List<Grammy> awards = Grammy.loadAwards(awardsFile, true);

		// Filter to just Song of the Year Awards
		List<Grammy> songAwards = SongOfTheYearGrammy.filterAwardsOfType(awards);

		// Calculate number of Song of the Year awards per artist
		HashMap<String, Integer> artistAwards = Grammy.countAwardsForArtists(songAwards);

		// Print artists with most awards
		Grammy.printMostAwardedArtists(artistAwards);
		
		// Print name of programmer
		System.out.printf("\nCode was written by %s.\n", Grammy.getProgrammerName());
	}
}

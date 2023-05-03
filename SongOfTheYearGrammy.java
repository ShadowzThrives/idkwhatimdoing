/*
 * Programmer
 * 5/2/2023
 * Computer Science 110 Section 1
 * Homework #3: Grammy Awards Problem
 */
import java.util.List;
public class SongOfTheYearGrammy extends Grammy{

	public SongOfTheYearGrammy(Integer year, String work, List<String> artists) {

		super(year, work, artists);

	}

	public String getAwardName() {

		return "Song of the Year";

	}

	public static List<Grammy> filterAwardsOfType(List<Grammy> awards) {

			return Grammy.filterAwardsOfType(awards, "Song of the Year");

	}

}
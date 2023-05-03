/*
 * Programmer
 * 5/2/2023
 * Computer Science 110 Section 1
 * Homework #3: Grammy Awards Problem
 */
import java.util.List;

public class RecordOfTheYearGrammy extends Grammy{

	public RecordOfTheYearGrammy(Integer year, String work, List<String> artists) {

		super(year, work, artists);

	}

	public String getAwardName() {

			return "Record of the Year";

	}	

	public static List<Grammy> filterAwardsOfType(List<Grammy> awards) {
	
		return Grammy.filterAwardsOfType(awards, "Record of the Year");

	}

}
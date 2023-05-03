// CS 110 Homework #3: Grammy Awards Problem
// Place this file in the same directory as your own source code and add it to your project.
// DO NOT MODIFY THE CONTENTS OF THIS FILE.

import java.util.List;

public interface Award {

	/**
	 * Get the name of the award
	 * 
	 * @return Name of the award
	 */
	String getAwardName();

	/**
	 * Get year of award
	 * 
	 * @return Year of award
	 */
	int getYear();

	/**
	 * Set year of the award
	 * 
	 * @param value Year of the award
	 */
	void setYear(int value);

	/**
	 * Get artists associated with an award
	 * 
	 * @return List of artists associated with award
	 */
	List<String> getArtists();
	
	/**
	 * Add artists to an award
	 * 
	 * @param newArtists List of new awards
	 */
	void addArtists(List<String> newArtists);

	/**
	 * Get name of the work
	 * 
	 * @return Name of work
	 */
	String getWork();

	/**
	 * Set the name of the work
	 * 
	 * @param value Name of work
	 */
	void setWork(String value);
	

}
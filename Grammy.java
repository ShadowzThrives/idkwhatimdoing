/*
 * Programmer
 * 5/2/2023
 * Computer Science 110 Section 1
 * Homework #3: Grammy Awards Problem
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grammy implements Award{

    public int year;
    public String work;
    public List<String> artists = new ArrayList<String>();

    public Grammy(Integer year, String work, List<String> artists) {
        this.year = year;
        this.work = work;
        this.artists.addAll(artists);
    }
    
    public String toString() {
        String artistList = String.join("; ", artists);
        return year + " award: " + artistList + " - " + work;
    }

    public String getAwardName() {
        return "Grammy";
    }

    public int getYear() {
        return year;
    }
    
    public String getWork() {
        return work;
    }

    public List<String> getArtists() {
        return artists;
    }
    
    public void setYear(int value) {
        this.year = value; // stores the specified value for the year in the object
    }

    public void setWork(String value) {
        this.work = value; // stores specified value for the name of the awarded work in the object
    }
    
    public void addArtists(List<String> newArtists) {
        this.artists.addAll(newArtists);
    }
    
    public static HashMap<String,Integer> countAwardsForArtists(List<Grammy> awards){
        HashMap<String,Integer> artistAwards = new HashMap<>();
        for(Grammy award: awards){
            List<String> artists = award.getArtists();
            for(String artist: artists){
                String[] artistNames = artist.split("; ");
                for(String artistname: artistNames){
                    if(artistAwards.containsKey(artistname)){
                        artistAwards.put(artistname,artistAwards.get(artistname)+1);
                    }else{
                        artistAwards.put(artistname,1);

                    }

                }
                
            }
        }
        return artistAwards;
    }
    
    public static List<Grammy> filterAwardsOfType(List<Grammy> awards, String awardType) {
        List<Grammy> filteredAwards = new ArrayList<>();
        for (Grammy award : awards) {
            if (award.getAwardName().equals(awardType)) {
                filteredAwards.add(award);
            }
        }
        return filteredAwards;
    }

    public static Grammy parseLine(String line) {
        // Splitting the string "line" with a comma
        String[] parts = line.split(",");

        // Parsing the year of the award to an integer
        int year;
        try {
            year = Integer.parseInt(parts[0].trim());
        } catch (NumberFormatException e) {
            // Return null if year cannot be parsed
            return null;
        }

        // Splitting the artists column using a semicolon as a/the delimiter into individual artist names
        List<String> artists = Arrays.asList(parts[1].trim().split(";"));

        // Depending on the value in the award column, create a SongOfTheYearGrammy or RecordOfTheYearGrammy object
        String awardType = parts[2].trim();
        if (awardType.equals("Song of the Year")) {
            return new SongOfTheYearGrammy(year, parts[3].trim(), artists);
        } else if (awardType.equals("Record of the Year")) {
            return new RecordOfTheYearGrammy(year, parts[3].trim(), artists);
        } else {
            // Return null if the award type is not recognized
            return null;
        }
    }
    
    public static List<Grammy> loadAwards(String filename, boolean skipHeader) {
        List<Grammy> awards = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            if (skipHeader) {
                reader.readLine(); // skip the header line
            }

            String line;
            while ((line = reader.readLine()) != null) {
                Grammy award = parseLine(line);
                if (award != null) {
                    awards.add(award);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing file: " + filename);
                    e.printStackTrace();
                }
            }
        }

        return awards;
    }

    public static void printMostAwardedArtists(HashMap<String, Integer> artistAwards) {
        int maxAwards = 0;
        ArrayList<String> mostAwardedArtists = new ArrayList<>();

        // Finding the greatest number of awards received by any artist
        for (Map.Entry<String, Integer> entry : artistAwards.entrySet()) {
            int numAwards = entry.getValue();
            if (numAwards > maxAwards) {
                maxAwards = numAwards;
                mostAwardedArtists.clear();
                mostAwardedArtists.add(entry.getKey());
            } else if (numAwards == maxAwards) {
                mostAwardedArtists.add(entry.getKey());
            }
        }

        // Printing the results
        System.out.print("The most-awarded artist(s) have received " + maxAwards + " Grammy awards: ");
        for (String artist : mostAwardedArtists) {
            System.out.print(artist + ", ");
        }
        System.out.println();
    }

    // print out programmer/my name
    public static String getProgrammerName() {
    	String myName = "programmer";
        return myName;
    }
}

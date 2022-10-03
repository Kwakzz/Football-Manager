import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Player implements Serializable {


    public Player (String playerName, Club playerCurrentClub, int playerAge, Nationality nationality,
                   playerPosition position,
                   int playerMarketValue, int weeklyWage) {
       this.playerName = playerName;
       this.playerCurrentClub = playerCurrentClub;
       this.playerAge = playerAge;
       this.position = position;
       this.nationality = nationality;
       this.playerMarketValue = playerMarketValue;
       this.weeklyWage = weeklyWage;
   }

   // Player's Name
   private String playerName;

    /**
     * @return player's name
     */
    public String getPlayerName () {
        return playerName;
    }


   // Player's Age
   private int playerAge;

    /**
     * @return player's age
     */
    public int getPlayerAge () {
        return playerAge;
    }
    public void addToPlayerAge () {
        playerAge += 1;
    }

   // Player's Nationality
    public enum Nationality {
        ALGERIA, AMERICA, ARGENTINA, AUSTRIA, BELGIUM, BRAZIL, CAMEROON, CANADA, COLOMBIA, CROATIA,
       ENGLAND, FRANCE, GERMANY, GHANA,
       ITALY, NETHERLANDS, NIGERIA, POLAND, PORTUGAL, SENEGAL, SERBIA, SOUTH_KOREA, SPAIN, URUGUAY, ZAMBIA
   }
   Nationality nationality;

    /**
     * @return player's nationality
     */
    public Nationality getNationality () {
        return nationality;
    }


   // Player's Position
   public enum playerPosition {
        GOALKEEPER, DEFENDER, MIDFIELDER, STRIKER
   }
   playerPosition position;

    /**
     * @return position of player
     */
   public playerPosition getPosition () {
       return position;
   }

    /**
     * @param newPosition player's new position
     * @return player's new position
     */
   public String changePosition (playerPosition newPosition) {
       this.position = newPosition;
       return getPlayerName() +  " is now a " + position;
   }


   // Player's Team
   Club playerCurrentClub;

    /**
     * @return the name of the player's current club
     */
    public String getCurrentClub () {
        return playerCurrentClub.getClubName();
    }

    public void changeClub (Club newClub) {
        this.playerCurrentClub = newClub;
    }


    // Player's Weekly Wages
    private int weeklyWage;

    /**
     * @return player's weekly wage
     */
    public int getWage () {
        return weeklyWage;
    }

    /**
     * @param value increment in player's weekly wage
     */
    public void wageMutator (int value) {
        weeklyWage += value;
    }


    // Player's Market Value
    private int playerMarketValue;

    /**
     * @return player's market value
     */
    public int getPlayerMarketValue () {
        return playerMarketValue;
    }


    // Player's Goal Tally
    private int playerTotalGoals = 0;
    private int playerSeasonGoals = 0;

    /**
     * adds one to the player's total number of goals
     */
    public void addToPlayerTotalGoals () {
        playerTotalGoals+=1;
    }

    /**
     * adds one to the player's number of goals for current season
     */
    public void addToPlayerSeasonGoals () {
        playerSeasonGoals+=1;
    }
    public void resetPlayerSeasonGoals () {
        this.playerSeasonGoals = 0;
    }

    /**
     * @return total number of goals scored by the player
     */
    public int getPlayerTotalGoals () {
        return playerTotalGoals;
    }

    /**
     * @return goals scored by player in current season. Resets to 0 when season begins.
     */
    public int getPlayerSeasonGoals () {
        return playerSeasonGoals;
    }


    // Player's List of Clubs
    ArrayList <Club> listOfClubsPlayedFor = new ArrayList<>();

    /**
     * @param listOfClubsPlayedFor
     */
    public void setListOfClubsPlayedFor(ArrayList<Club> listOfClubsPlayedFor) {
        this.listOfClubsPlayedFor.add(this.playerCurrentClub);
    }

    /**
     * @return the list of clubs the player has played for.
     */
    public String getListOfClubsPlayedFor() {
        String [] listOfClubsPlayedForArray = new String[listOfClubsPlayedFor.size()];
        for (int i = 0; i < listOfClubsPlayedFor.size(); i++) {
            listOfClubsPlayedForArray [i] = listOfClubsPlayedFor.get(i).getClubName();
        }
        return Arrays.toString(listOfClubsPlayedForArray);
    }

    /**
     * @return player's name, age, current team and position as a string
     */
    public String getPlayerDetails () {
        return getPlayerName() + ", " + getPlayerAge() + ", " + getNationality() +
                ", " + getCurrentClub() + ", " + getPosition() + ", " + getPlayerTotalGoals() +
                " goals scored" + ", €" + getPlayerMarketValue();
    }

    static File file = new File("players.sav");
    public static void savePlayer(Player obj, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            oos.flush();
        }
    }

    public static Player loadPlayer (File file) throws IOException, ClassNotFoundException {
        Player result;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Player) ois.readObject();
        }
        return result;
    }

}


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Club implements Serializable {

    public Club (String clubName, Manager manager, int clubBudget, int clubStadiumCapacity, String clubStadiumName,
                 int attack, int defence) {
        this.clubName = clubName;
        this.manager = manager;
        this.clubBudget = clubBudget;
        this.clubStadiumCapacity = clubStadiumCapacity;
        this.clubStadiumName = clubStadiumName;
        this.attack = attack;
        this.defence = defence;
    }

    // Team Name
    private final String clubName;

    /**
     * @return club name as string.
     */
    public String getClubName () {
        return clubName;
    }

    // Team Players
    ArrayList <Player> players = new ArrayList<>();

    // Add players

    /**
     * @param player1 first player added to the club's array list of players.
     * @param player2 second player added to the club's array list of players.
     * @param player3 third player added to the club's array list of players.
     * @param player4 fourth player added to the club's array list of players.
     * @param player5 fifth player added to the club's array list of players.
     */
    public void addDefaultPlayers (Player player1, Player player2, Player player3,
                                   Player player4, Player player5) {
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
    }

    /**
     * @return names of players in team
     */
    public String getPlayers () {
        String [] playersArray = new String[5];
        int i = 0;
        while (i < 5) {
            playersArray [i] = players.get(i).getPlayerName();
            i++;
        }
        return Arrays.toString(playersArray);
    }

    /**
     * @return array list of player objects.
     */
    public ArrayList <Player> getPlayersAsObjects () {
        return players;
    }

    // Club Manager
    private Manager manager;

    public void setManager (Manager manager) {
        this.manager = manager;
    }
    public Manager getManager() {
        return manager;
    }

    // Sum of goals scored by each player in the club
    private int clubSeasonGoals = 0;
    private int clubTotalGoals = 0;


    public void addToClubSeasonGoals (int score) {
        clubSeasonGoals += score;
    }
    public void addToClubTotalGoals (int score) {
        clubTotalGoals += score;
    }
    public void resetClubSeasonGoals () {
        this.clubSeasonGoals = 0;
    }

    /**
     * @return sum of goals scored by each player in the club during current season. Resets to 0 when new season begins
     */
    public int getClubSeasonGoals () {
        return clubSeasonGoals;
    }

    /**
     * @return sum of goals scored by each player in the club till current time
     */
    public int getClubTotalGoals () {
        return clubTotalGoals;
    }

    // Goals Conceded

    private int noOfGoalsConcededThisSeason = 0;
    private int totalNoOfGoalsConceded = 0;

    /**
     * @param goalsConceded goals conceded in a game. Added to the variable "noOfGoalsConcededThisSeason" after every game.
     */
    public void addToNoOfGoalsConcededThisSeason(int goalsConceded) {
        this.noOfGoalsConcededThisSeason += goalsConceded;
    }

    public void resetNoOfGoalsConcededThisSeason () {
        this.noOfGoalsConcededThisSeason = 0;
    }

    /**
     * @param goalsConceded goals conceded in a game. Added to the variable "totalNooOfGoalsConceded" after every game.
     */
    public void addToTotalNoOfGoalsConceded(int goalsConceded) {
        this.totalNoOfGoalsConceded += goalsConceded;
    }

    /**
     * @return number of goals club has conceded during current season. Resets to 0 when new season begins
     */
    public int getNoOfGoalsConcededThisSeason() {
        return noOfGoalsConcededThisSeason;
    }

    /**
     * @return total number of goals conceded since the user began playing.
     */
    public int getTotalNoOfGoalsConceded() {
        return totalNoOfGoalsConceded;
    }


    /**
     * @return club's goal difference for season. Resets to 0 when new
     * season begins.
     */
    public int getGoalDifferenceForSeason() {
        return clubSeasonGoals - noOfGoalsConcededThisSeason;
    }

    private int cleanSheets;

    /**
     * increases the club's number of clean sheets by 1.
     */
    public void addToNoOfCleanSheets () {
        cleanSheets+=1;
    }

    /**
     * @return the number of clean sheets the club has had.
     */
    public int getCleanSheets() {
        return cleanSheets;
    }
    public void resetNoOfCleanSheets () {
        cleanSheets = 0;
    }

    // Points for the season
    private int points = 0;

    /**
     * @param points added to club's point tally after match
     */
    public void addPoints (int points) {
        this.points += points;
    }

    /**
     * @return number of points team currently has. Resets to 0 when new season begins.
     */
    public int getPoints() {
        return points;
    }

    public void resetPoints () {
        this.points = 0;
    }

    // CLub Budget
    private int clubBudget;
    /**
     * @return club's current budget
     */
    public double getClubBudget() {
        return clubBudget;
    }
    public void clubBudgetMutator (int value) {
        clubBudget += value;
    }


    //Stadium
    private final String clubStadiumName;
    /**
     * @return the name of the club's stadium
     */
    public String getClubStadiumName() {
        return clubStadiumName;
    }
    private final int clubStadiumCapacity;

    /**
     * @return club's stadium capacity
     */
    public int getClubStadiumCapacity() {
        return clubStadiumCapacity;
    }


    // No of Spectators for game
    /**
     * @return number of spectators for current game
     */
    public int getNoOfSpectatorsForGame() {
        Random random = new Random();
        return random.nextInt(clubStadiumCapacity/2, clubStadiumCapacity);

    }

    // ticket price
    private double ticketPrice = 10;
    public void changeTicketPrice () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New Ticket Price: ");
        ticketPrice = scanner.nextInt();
        System.out.printf("\nNew Ticket Price is %02f\n", ticketPrice);
    }


    // Match revenue
    /**
     */
    public void getMatchRevenue () {
        double matchRevenue = getNoOfSpectatorsForGame() * ticketPrice;
        clubBudget+=matchRevenue;
    }

    // Pay Wages
    /**
     * subtract all player's wages from club budget
     */
    public void payWage () {
        for (Player player: players)
            clubBudgetMutator(-player.getWage());
    }

    /**
     * @return club's name, players, total number of goals scored, total number of goals conceded, stadium name and capacity.
     */
    public String getClubDetails () {
        return getClubName().toUpperCase() + "\n" + getPlayers() + "\nGoals Scored: " +
                getClubTotalGoals() + "\nGoals Conceded: " + getTotalNoOfGoalsConceded() + "\nManager:" + getManager().getManagerName() +
                "\nNumber of League Trophies Won: " + getNoOfLeagueTrophiesWon() +
                "\nStadium: "
                + getClubStadiumName() +
                "\nStadium Capacity: " + getClubStadiumCapacity();
    }

    // Attacking and Defensive Stats
    private int attack;
    private int defence;

    /**
     * @return attack stat
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return defence stat
     */
    public int getDefence() {
        return defence;
    }

    // Probability For No of Goals
    private int p0Goals;
    private int p1Goal;
    private int p2Goals;
    private int p3Goals;
    private int p4Goals;
    private int p5Goals;

    public void setP0Goals(int p0Goals) {
        this.p0Goals = p0Goals;
    }
    public int getP0Goals() {
        return p0Goals;
    }

    public void setP1Goal(int p1Goal) {
        this.p1Goal = p1Goal;
    }
    public int getP1Goal() {
        return p1Goal;
    }

    public void setP2Goals(int p2Goals) {
        this.p2Goals = p2Goals;
    }
    public int getP2Goals() {
        return p2Goals;
    }

    public void setP3Goals(int p3Goals) {
        this.p3Goals = p3Goals;
    }
    public int getP3Goals() {
        return p3Goals;
    }

    public void setP4Goals(int p4Goals) {
        this.p4Goals = p4Goals;
    }
    public int getP4Goals() {
        return p4Goals;
    }

    public void setP5Goals(int p5Goals) {
        this.p5Goals = p5Goals;
    }
    public int getP5Goals() {
        return p5Goals;
    }

    // match score
    int score;

    private int noOfMatchesPlayed;

    /**
     * increases the variable "noOfMatchesPlayed" by 1 after each game.
     */
    public void addToNoOfMatchesPlayed ( ){
        noOfMatchesPlayed += 1;
    }
    public void resetNoOfMatchesPlayed () {
        noOfMatchesPlayed = 0;
    }

    /**
     * @return the number of matches the club has played for the season. Resets to 0 when a new season begins.
     */
    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    private int noOfLeagueTrophiesWon = 0;
    public int getNoOfLeagueTrophiesWon () {
        return noOfLeagueTrophiesWon;
    }
    public void addToNoOfLeagueTrophiesWon () {
        noOfLeagueTrophiesWon += 1;
    }

    static File file = new File("club.sav");
    public static void saveClub(Club obj, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            oos.flush();
        }
    }

    public static Club loadClub (File file) throws IOException, ClassNotFoundException {
        Club result;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Club) ois.readObject();
        }
        return result;
    }
}

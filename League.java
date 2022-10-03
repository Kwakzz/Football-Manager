import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class League implements Serializable {

    private int noOfSeasonsPlayed = 0;

    public void addToNoOfSeasonsPlayed () {
        this.noOfSeasonsPlayed += 1;
    }
    public int getNoOfSeasonsPlayed() {
        return noOfSeasonsPlayed;
    }

    HashMap <String, Integer> leagueScorers = new HashMap<>();

    HashMap <Club, Integer> clubsAndPoints = new HashMap<>();

    HashMap <String, Integer> cleanSheets = new HashMap<>();

    /**
     * puts player names as the key and the number of goals they've scored as the value into the hashmap "leagueScorers."
     */
    public void leagueTopScorersHm () {
        for (Player player: leagueOutfieldPlayers) {
            leagueScorers.put(player.getPlayerName(), player.getPlayerSeasonGoals());
        }
    }


    public void leagueTableHm () {
        for (Club club: leagueClubs) {
            clubsAndPoints.put(club, club.getPoints());
        }
    }

    /**
     * puts club goalkeepers as the key and the number of clean sheets they've obtained as the value into the hashmap "cleanSheets."
     */
    public void mostCleanSheetsHm () {
        for (Club club: leagueClubs) {
            cleanSheets.put(club.players.get(4).getPlayerName(), club.getCleanSheets());
        }
    }


    // League Clubs
    public static ArrayList <Club> leagueClubs = new ArrayList<>();

    /**
     * adds clubs to an array list called leagueClubs.
     */
    public void addClubsToLeague () {
        leagueClubs.add(Play.Barca);
        leagueClubs.add(Play.Bayern);
        leagueClubs.add(Play.Chelsea);
        leagueClubs.add(Play.ManCity);
        leagueClubs.add(Play.PSG);
        leagueClubs.add(Play.RealMadrid);
    }

    /**
     * @return a string array of the clubs in the league
     */
    public String getLeagueClubs () {
        String [] leagueClubsArray = new String [leagueClubs.size()];
        for (int i = 0; i < leagueClubs.size(); i++) {
            leagueClubsArray [i] = leagueClubs.get(i).getClubName();
        }
        return Arrays.toString(leagueClubsArray);
    }

    /**
     * @return array list of league clubs as objects
     */
    public ArrayList <Club> getLeagueClubsAsObjects () {
        return leagueClubs;
    }


    // League Players
    public static ArrayList <Player> leaguePlayers = new ArrayList<>();

    // Outfield Players
    public ArrayList <Player> leagueOutfieldPlayers = new ArrayList<>();

    /**
     * adds players in the clubs to an array list called leaguePlayers
     */
    public void addPlayersToLeague () {
        for (Club club: leagueClubs) {
            leaguePlayers.addAll(club.players);
        }
    }

    /**
     * adds outfield players in the clubs to an array list called leagueOutfieldPlayers
     */
    public void outfieldPlayersArrayList () {
        for (Club club: leagueClubs) {
            leagueOutfieldPlayers.add(club.players.get(0));
            leagueOutfieldPlayers.add(club.players.get(1));
            leagueOutfieldPlayers.add(club.players.get(2));
            leagueOutfieldPlayers.add(club.players.get(3));
        }
    }

    /**
     * @return a string array of the players in the league
     */
    public String getLeaguePlayers () {
        String [] leaguePlayersArray = new String [leaguePlayers.size()];
        for (int i = 0; i < leaguePlayers.size(); i++) {
            leaguePlayersArray [i] = leaguePlayers.get(i).getPlayerName();
        }
        return Arrays.toString(leaguePlayersArray);
    }

    /**
     * @return array list of league players as objects.
     */
    public ArrayList <Player> getLeaguePlayersAsObjects () {
        return leaguePlayers;
    }


    public void getLeagueTable () {

        leagueTableHm();

        Map<Club, Integer> leagueTable = clubsAndPoints.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (entry1, entry2) -> entry2, LinkedHashMap::new));

        // printing
        for (Map.Entry<Club, Integer> en : leagueTable.entrySet()) {
            System.out.printf("%s %d pts %d GD\n", en.getKey().getClubName(),en.getValue(), en.getKey().getGoalDifferenceForSeason());
        }

        System.out.print("\n");
     }

     public void getLeagueWinner () {
         leagueTableHm();

         Map<Club, Integer> finalLeagueTable = clubsAndPoints.entrySet()
                 .stream()
                 .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                         (entry1, entry2) -> entry2, LinkedHashMap::new));

         // printing
         for (Map.Entry<Club, Integer> en : finalLeagueTable.entrySet()) {
             System.out.printf("%s are champions!\n", en.getKey().getClubName());
             en.getKey().addToNoOfLeagueTrophiesWon();
             en.getKey().getManager().addToNoOfLeagueTrophiesWon();
             break;
         }

         System.out.print("\n");
     }


    public void getLeagueTopScorers() {

        leagueTopScorersHm();

        Map<String, Integer> topScorers = leagueScorers.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (entry1, entry2) -> entry2, LinkedHashMap::new));

        // printing
        for (Map.Entry<String, Integer> en : topScorers.entrySet()) {
            System.out.printf("%s %d goals\n", en.getKey(),en.getValue());
        }

        System.out.print("\n");
    }

    public void getMostCleanSheets() {

        mostCleanSheetsHm();

        Map<String, Integer> mostCleanSheets = cleanSheets.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (entry1, entry2) -> entry2, LinkedHashMap::new));

        // printing
        for (Map.Entry<String, Integer> en : mostCleanSheets.entrySet()) {
            System.out.printf("%s %d clean sheets\n", en.getKey(),en.getValue());
        }

        System.out.print("\n");
    }

    public static Player searchPlayer() {
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.next();
        for (Player player: leaguePlayers) {
            if (playerName.equals(player.getPlayerName()))
                return player;
        }
        return null;
    }

    public Club searchClub() {
        Scanner scanner = new Scanner(System.in);
        String clubName = scanner.next();
        for (Club club: leagueClubs) {
            if (clubName.equals(club.getClubName()))
                return club;
        }
        return null;
    }

    public void reset () {
        for (Club club : leagueClubs) {
            club.resetPoints();
            club.resetClubSeasonGoals();
            club.resetNoOfGoalsConcededThisSeason();
            club.resetNoOfCleanSheets();
            club.resetNoOfMatchesPlayed();
            club.getManager().addToManagerAge();
        }

        for (Player player: leaguePlayers) {
            player.resetPlayerSeasonGoals();
            player.addToPlayerAge();
        }

        addToNoOfSeasonsPlayed();
    }

    static File file = new File("league.sav");
    public static void saveLeague(League obj, File file) throws IOException {
             FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(obj);
             oos.flush();
        }


    public static League loadLeague (File file) throws IOException, ClassNotFoundException {
        League result;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (League) ois.readObject();
        }
        return result;
    }
    }


import java.io.*;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class Play implements Serializable {

    // ------- COACHES --------
    static Manager thomasTuchel = new Manager("Thomas Tuchel", 50, Manager.Nationality.GERMANY);
    static Manager xavi = new Manager("Xavi Hernandez", 50, Manager.Nationality.SPAIN);
    static Manager josepGuardiola = new Manager("Josep Guardiola", 51, Manager.Nationality.SPAIN);
    static Manager mauricioPochettino = new Manager("Mauricio Pochettino", 53, Manager.Nationality.ARGENTINA);
    static Manager julianNagelsmann = new Manager("Julian Nagelsmann", 50, Manager.Nationality.GERMANY);
    static Manager carloAncelotti = new Manager("Carlo Ancelotti", 63, Manager.Nationality.ITALY);


    // -------- CLUBS ---------

    public static void initializeBarca() {
        Barca.addDefaultPlayers(pedri, deJong, depay, pique, terStegen);
    }

    public static void initializeBayern() {
        Bayern.addDefaultPlayers(lewandowski, muller, kimmich, alphonsoDavies, neuer);
    }

    public static void initializeChelsea() {
        Chelsea.addDefaultPlayers(havertz, mount, kante, rudiger, mendy);
    }

    public static void initializeManUtd() {
        ManCity.addDefaultPlayers(deBruyne, mahrez, rodri, rubenDias, ederson);
    }

    public static void initializePSG() {
        PSG.addDefaultPlayers(messi, mbappe, verratti, marquinhos, donnarumma);
    }

    public static void initializeRMadrid() {
        RealMadrid.addDefaultPlayers(benzema, vinicius, modric, alaba, courtois);
    }

    // BARCELONA MUNICH
    static Club Barca = new Club("Barcelona", xavi, 100000000,
            50000, "Camp Nou", 84, 83);


    // BAYERN MUNICH
    static Club Bayern = new Club("Bayern Munich", julianNagelsmann, 40000000,
            78000, "Allianz Arena", 92, 88);

    // CHELSEA
    static Club Chelsea = new Club("Chelsea FC", thomasTuchel, 100000000,
            46000, "Stamford Bridge", 84, 85);


    // Manchester City
    static Club ManCity = new Club("Manchester City", josepGuardiola, 700000000,
            55000, "Etihad Stadium", 90, 90);


    // PSG
    static Club PSG = new Club("Paris Saint Germain", mauricioPochettino, 800000000,
            53000, "Parc Des Princess", 92, 88);


    // Real Madrid
    static Club RealMadrid = new Club("Real Madrid", carloAncelotti, 500000000,
            70000, "Santiago Bernabeu", 89, 89);


    static Play play = new Play();

    static League league = new League();

     static Fixtures fixtures = new Fixtures();


    // ------ PLAYERS -------

    // BARCELONA
    static Player pedri = new Player("Pedri", Barca, 20,
            Player.Nationality.SPAIN, Player.playerPosition.MIDFIELDER, 23000000, 38000);

    static Player deJong = new Player("Frenkie De Jong", Barca, 23,
            Player.Nationality.NETHERLANDS, Player.playerPosition.MIDFIELDER, 23000000, 45000);

    static Player depay = new Player("Memphis Depay", Barca, 28,
            Player.Nationality.NETHERLANDS, Player.playerPosition.STRIKER, 23000000, 48000);

    static Player pique = new Player("Gerard Pique", Barca, 34,
            Player.Nationality.SPAIN, Player.playerPosition.DEFENDER, 23000000, 30000);

    static Player terStegen = new Player("Marc Andre Ter Stegen", Barca, 30,
            Player.Nationality.GERMANY, Player.playerPosition.GOALKEEPER, 23000000, 30000);


    // BAYERN MUNICH
    static Player lewandowski = new Player("Robert Lewandowski", Bayern, 34,
            Player.Nationality.POLAND, Player.playerPosition.STRIKER, 60000000, 90000);

    static Player muller = new Player("Thomas Muller", Bayern, 33,
            Player.Nationality.GERMANY, Player.playerPosition.MIDFIELDER, 35000000, 50000);

    static Player kimmich = new Player("Joshua Kimmich", Bayern, 25,
            Player.Nationality.GERMANY, Player.playerPosition.MIDFIELDER, 50000000, 48000);

    static Player alphonsoDavies = new Player("Alphonso Davies", Bayern, 22,
            Player.Nationality.CANADA, Player.playerPosition.DEFENDER, 55000000, 30000);

    static Player neuer = new Player("Manuel Neuer", Bayern, 34,
            Player.Nationality.GERMANY, Player.playerPosition.GOALKEEPER, 23000000, 85000);


    // CHELSEA
    static Player havertz = new Player("Kai Havertz", Chelsea, 22,
            Player.Nationality.GERMANY, Player.playerPosition.STRIKER, 55000000, 110000);

    static Player mount = new Player("Mason Mount", Chelsea, 22,
            Player.Nationality.ENGLAND, Player.playerPosition.MIDFIELDER, 55000000, 70000);

    static Player kante = new Player("N'Golo Kante", Chelsea, 30,
            Player.Nationality.GERMANY, Player.playerPosition.STRIKER, 55000000, 120000);

    static Player rudiger = new Player("Antonio Rudiger", Chelsea, 33,
            Player.Nationality.GERMANY, Player.playerPosition.DEFENDER, 33000000, 60000);

    static Player mendy = new Player("Edouard Mendy", Chelsea, 30,
            Player.Nationality.SENEGAL, Player.playerPosition.GOALKEEPER, 27000000, 60000);


    // MANCHESTER CITY
    static Player deBruyne = new Player("Kevin De Bruyne", ManCity, 30,
            Player.Nationality.BELGIUM, Player.playerPosition.MIDFIELDER, 52000000, 220000);

    static Player mahrez = new Player("Riyad Mahrez", ManCity, 31,
            Player.Nationality.ALGERIA, Player.playerPosition.MIDFIELDER, 48000000, 90000);

    static Player rodri = new Player("Rodri", ManCity, 25,
            Player.Nationality.SPAIN, Player.playerPosition.MIDFIELDER, 49000000, 85000);

    static Player rubenDias = new Player("Ruben Dias", ManCity, 24,
            Player.Nationality.PORTUGAL, Player.playerPosition.DEFENDER, 60000000, 160000);

    static Player ederson = new Player("Ederson Moraes", ManCity, 28,
            Player.Nationality.BRAZIL, Player.playerPosition.GOALKEEPER, 35000000, 150000);


    // PSG
    static Player messi = new Player("Lionel Messi", PSG, 34,
            Player.Nationality.ARGENTINA, Player.playerPosition.STRIKER, 49000000, 260000);

    static Player mbappe = new Player("Kylian Mbappe", PSG, 23,
            Player.Nationality.FRANCE, Player.playerPosition.STRIKER, 80000000, 240000);

    static Player verratti = new Player("Marco Verratti", PSG, 27,
            Player.Nationality.FRANCE, Player.playerPosition.MIDFIELDER, 57000000, 170000);

    static Player marquinhos = new Player("Marquinhos", PSG, 29,
            Player.Nationality.BRAZIL, Player.playerPosition.DEFENDER, 50000000, 100000);

    static Player donnarumma = new Player("Gianluigi Donnarumma", PSG, 23,
            Player.Nationality.ITALY, Player.playerPosition.GOALKEEPER, 40000000, 120000);


    // REAL MADRID
    static Player benzema = new Player("Karim Benzema", RealMadrid, 34,
            Player.Nationality.FRANCE, Player.playerPosition.STRIKER, 50000000, 200000);

    static Player vinicius = new Player("Vinicius Junior", RealMadrid, 23,
            Player.Nationality.BRAZIL, Player.playerPosition.MIDFIELDER, 60000000, 90000);

    static Player modric = new Player("Luka Modric", RealMadrid, 37,
            Player.Nationality.CROATIA, Player.playerPosition.MIDFIELDER, 28000000, 150000);

    static Player alaba = new Player("David Alaba", RealMadrid, 32,
            Player.Nationality.AUSTRIA, Player.playerPosition.DEFENDER, 35000000, 140000);

    static Player courtois = new Player("Thibaut Courtois", RealMadrid, 32,
            Player.Nationality.BELGIUM, Player.playerPosition.GOALKEEPER, 30000000, 130000);




    static Manager myManager;

    // CREATE MANAGER
    public static void createNewManager() throws IllegalStateException {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);

        System.out.println("Name:");
        String managerName = scanner1.next();

        System.out.println("Age:");
        int managerAge = scanner2.nextInt();

        System.out.println("Pick a Nationality:");
        for (Manager.Nationality nationality : Manager.Nationality.values())
            System.out.println(nationality);

        String managerNationality = scanner3.next();

        myManager = new Manager(managerName, managerAge,
                Manager.Nationality.valueOf(managerNationality.toUpperCase()));

    }


    // PICK CLUB
    public static void pickAClub() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick a club:");

        System.out.println("""
                1. Barcelona
                2. Bayern Munich
                3. Chelsea
                4. Manchester City
                5. PSG
                6. Real Madrid
                """);

        String club = scanner.next();

        switch (club) {
            case "Barcelona", "BARCELONA", "1", "Barca", "BARCA" -> {
                myManager.setCurrentClub(Barca);
                Play.Barca.setManager(myManager);
            }
            case "Bayern Munich", "BAYERN MUNICH", "Bayern", "BAYERN", "MUNICH", "2" -> {
                myManager.setCurrentClub(Bayern);
                Play.Bayern.setManager(myManager);
            }
            case "Chelsea", "CHELSEA", "3" -> {
                myManager.setCurrentClub(Chelsea);
                Play.Chelsea.setManager(myManager);
            }
            case "Manchester City", "City", "Man City", "Man C",
                    "MANCHESTER", "CITY", "4" -> {
                myManager.setCurrentClub(ManCity);
                Play.ManCity.setManager(myManager);
            }
            case "PSG", "Paris Saint Germain", "PARIS SAINT GERMAIN", "PARIS" -> {
                myManager.setCurrentClub(PSG);
                Play.PSG.setManager(myManager);
            }
            case "Real Madrid", "Real", "Madrid", "REAL MADRID", "REAL",
                    "MADRID", "6" -> {
                myManager.setCurrentClub(RealMadrid);
                Play.RealMadrid.setManager(myManager);
            }
        }

        System.out.printf("Welcome to %s!\n\n", myManager.getCurrentClubName());
        myManager.setListOfTeamsManaged(myManager.currentClub);
    }

    public static int scoreGenerator(int score0, int score1, int score2, int score3, int score4, int score5,
                                     int pScore0, int pScore1, int pScore2, int pScore3, int pScore4, int pScore5) {

        Random random = new Random();

        // Generate a number from 1 to 10
        int r = random.nextInt(1, 100);

        if (r <= pScore0)
            return score0;

        if (r <= (pScore0 + pScore1))
            return score1;

        if (r <= (pScore0 + pScore1 + pScore2))
            return score2;

        if (r <= (pScore0 + pScore1 + pScore2 + pScore3))
            return score3;

        if (r <= (pScore0 + pScore1 + pScore2 + pScore3 + pScore4))
            return score4;

        else
            return score5;
    }


    public static void quickSim(Club club1, Club club2) {

        Random random = new Random();

        if (club1.getAttack() > club2.getDefence() && club1.getAttack() > club2.getAttack()) {
            club1.setP0Goals(15);
            club2.setP0Goals(25);

            club1.setP1Goal(15);
            club2.setP1Goal(30);

            club1.setP2Goals(30);
            club2.setP2Goals(25);

            club1.setP3Goals(20);
            club2.setP3Goals(15);

            club1.setP4Goals(15);
            club2.setP4Goals(3);

            club1.setP5Goals(5);
            club2.setP5Goals(2);
        }

        if (club2.getAttack() > club1.getDefence() && club2.getAttack() > club1.getAttack()) {
            club2.setP0Goals(15);
            club1.setP0Goals(25);

            club2.setP1Goal(15);
            club1.setP1Goal(30);

            club2.setP2Goals(30);
            club1.setP2Goals(25);

            club2.setP3Goals(20);
            club1.setP3Goals(15);

            club2.setP4Goals(15);
            club1.setP4Goals(3);

            club2.setP5Goals(5);
            club1.setP5Goals(2);
        }


        if (club1.getAttack() == club2.getDefence()) {
            club1.setP0Goals(40);
            club2.setP0Goals(40);

            club1.setP1Goal(20);
            club2.setP1Goal(20);

            club1.setP2Goals(20);
            club2.setP2Goals(20);

            club1.setP3Goals(10);
            club2.setP3Goals(10);

            club1.setP4Goals(6);
            club2.setP4Goals(6);

            club1.setP5Goals(4);
            club2.setP5Goals(4);
        }

        if (club1.getAttack() == club1.getAttack() && club1.getDefence() == club2.getDefence()) {
            club1.setP0Goals(30);
            club2.setP0Goals(30);

            club1.setP1Goal(30);
            club2.setP1Goal(30);

            club1.setP2Goals(20);
            club2.setP2Goals(20);

            club1.setP3Goals(10);
            club2.setP3Goals(10);

            club1.setP4Goals(6);
            club2.setP4Goals(6);

            club1.setP5Goals(4);
            club2.setP5Goals(4);
        }

        if (club1.getAttack() == club1.getAttack()) {
            club1.setP0Goals(20);
            club2.setP0Goals(20);

            club1.setP1Goal(30);
            club2.setP1Goal(30);

            club1.setP2Goals(15);
            club2.setP2Goals(10);

            club1.setP3Goals(20);
            club2.setP3Goals(20);

            club1.setP4Goals(9);
            club2.setP4Goals(9);

            club1.setP5Goals(6);
            club2.setP5Goals(6);
        }

        club1.score = Play.scoreGenerator(0, 1, 2, 3, 4, 5, club1.getP0Goals(), club1.getP1Goal(),
                club1.getP2Goals(), club1.getP3Goals(), club1.getP4Goals(), club1.getP5Goals());
        club2.score = Play.scoreGenerator(0, 1, 2, 3, 4, 5, club2.getP0Goals(), club2.getP1Goal(),
                club2.getP2Goals(), club2.getP3Goals(), club2.getP4Goals(), club2.getP5Goals());


        System.out.printf("%S %d %d %S\n", club1.getClubName(), club1.score, club2.score, club2.getClubName());

        for (int i = 0; i < club1.score; i++) {
            int goalScorerIndex = random.nextInt(0, 4);
            Player goalScorer = club1.players.get(goalScorerIndex);
            goalScorer.addToPlayerSeasonGoals();
            goalScorer.addToPlayerTotalGoals();
            System.out.println(goalScorer.getPlayerName());
        }

        System.out.print("\n");

        for (int i = 0; i < club2.score; i++) {
            int goalScorerIndex = random.nextInt(0, 4);
            Player goalScorer = club2.players.get(goalScorerIndex);
            goalScorer.addToPlayerSeasonGoals();
            goalScorer.addToPlayerTotalGoals();
            System.out.println(goalScorer.getPlayerName());
        }

        System.out.print("\n");

        club1.addToClubSeasonGoals(club1.score);
        club1.addToClubTotalGoals(club1.score);
        club1.addToNoOfGoalsConcededThisSeason(club2.score);
        club1.addToTotalNoOfGoalsConceded(club2.score);

        club2.addToClubSeasonGoals(club2.score);
        club2.addToClubTotalGoals(club2.score);
        club2.addToNoOfGoalsConcededThisSeason(club1.score);
        club2.addToTotalNoOfGoalsConceded(club1.score);

        if (club1.score > club2.score)
            club1.addPoints(3);

        if (club2.score > club1.score)
            club2.addPoints(3);

        if (club1.score == club2.score) {
            club1.addPoints(1);
            club2.addPoints(1);
        }

        if (club1.score == 0)
            club2.addToNoOfCleanSheets();

        if (club2.score == 0)
            club1.addToNoOfCleanSheets();

        System.out.printf("Match Attendance: %d\n\n", club1.getNoOfSpectatorsForGame());
        club1.getMatchRevenue();

        club1.addToNoOfMatchesPlayed();
        club2.addToNoOfMatchesPlayed();

        club1.payWage();
        club2.payWage();
    }

    public static void matchDay() {
        quickSim(Fixtures.matchDays.get(fixtures.matchDay).get(0), Fixtures.matchDays.get(fixtures.matchDay).get(1));
        quickSim(Fixtures.matchDays.get(fixtures.matchDay).get(2), Fixtures.matchDays.get(fixtures.matchDay).get(3));
        quickSim(Fixtures.matchDays.get(fixtures.matchDay).get(4), Fixtures.matchDays.get(fixtures.matchDay).get(5));

        fixtures.matchDay += 1;

        if (fixtures.matchDay == 10) {
            league.getLeagueWinner();
            System.out.println("Season is over.");
            league.reset();
            fixtures.resetMatchDay();
        }
    }


    public static void introMenu() {
        System.out.print("""
                Enter a number
                1. Play
                2. Quit
                """);

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();


        switch (choice) {
            case "1" -> playMenu();
            case "2" -> System.exit(0);
        }
    }

    public static void playMenu() {
        System.out.print("""
                Enter a number
                1. Create New Manager
                2. Load Game
                3. Back
                """);

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();


        switch (choice) {
            case "1" -> {
                createNewManager();
                pickAClub();
                mainMenu();
            }
            case "2" -> Settings.loadGame();
            case "3" -> introMenu();
        }

    }

    public static void mainMenu() {
        System.out.print("""
                Enter a number
                1. Next Match
                2. League
                3. Manager Actions
                4. Save Game
                5. Back
                """);

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        switch (choice) {
            case "1" -> {
                Play.matchDay();
                mainMenu();
            }
            case "2" -> leagueMenu();
            case "3" -> managerActionsMenu();
            case "4" -> {
                Settings.saveGame();
                mainMenu();
            }
            case "5" -> playMenu();
        }
    }

    public static void leagueMenu() {
        System.out.print("""
                Enter a number
                1. Display Upcoming Fixtures
                2. Display League Table
                3. Display Top Scorers
                4. Display Clean Sheets Chart
                5. Search Player
                6. Search Club
                7. View Players
                8. Number of Matches Played
                9. Number of Seasons Played
                10. Back
                """);

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        switch (choice) {
            case "1" -> {
                fixtures.displayUpcomingFixtures();
                leagueMenu();
            }
            case "2" -> {
                league.getLeagueTable();
                leagueMenu();
            }
            case "3" -> {
                league.getLeagueTopScorers();
                leagueMenu();
            }
            case "4" -> {
                league.getMostCleanSheets();
                leagueMenu();
            }
            case "5" -> {
                if (League.searchPlayer() != null) System.out.println(Objects.requireNonNull(League.searchPlayer()).getPlayerName());
                leagueMenu();
            }
            case "6" -> {
                System.out.println(league.searchClub().getClubDetails());
                leagueMenu();
            }
            case "7" -> {
                System.out.println(league.getLeaguePlayers());
                leagueMenu();
            }
            case "8" -> {
                System.out.println(fixtures.getMatchDay());
                leagueMenu();
            }
            case "9" -> {
                System.out.println(league.getNoOfSeasonsPlayed());
                leagueMenu();
            }
            case "10" -> mainMenu();

        }
    }

    public static void managerActionsMenu() {
        System.out.print("""
                Enter a number
                1. Player Exchange
                2. View My Club Details
                3. My Club Budget
                4. Change Player Wage
                5. Change Match Ticket Price
                6. Change Clubs
                7. View Clubs Managed
                8. View My Accomplishments
                9. View My Details
                10. Back
                """);

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        switch (choice) {
            case "1" -> {
                myManager.offerBid();
                managerActionsMenu();
            }
            case "2" -> {
                System.out.println(myManager.currentClub.getClubDetails());
                managerActionsMenu();
            }
            case "3" -> {
                System.out.println(myManager.currentClub.getClubBudget());
                managerActionsMenu();
            }
            case "4" -> {
                myManager.changeWage();
                managerActionsMenu();
            }
            case "5" -> {
                myManager.currentClub.changeTicketPrice();
                managerActionsMenu();
            }
            case "6" -> {
                myManager.changeClub();
                managerActionsMenu();
            }
            case "7" -> {
                System.out.println(myManager.getListOfTeamsManaged());
                managerActionsMenu();
            }
            case "8" -> {
                System.out.println(myManager.viewAccomplishments());
                managerActionsMenu();
            }
            case "9" -> {
                System.out.println(myManager.viewMyDetails());
                managerActionsMenu();
            }
            case "10" -> mainMenu();
        }
    }

    static File file = new File("play.sav");
    public static void savePlay(Play obj, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            oos.flush();
        }
    }

    public static Play loadPlay (File file) throws IOException, ClassNotFoundException {
        Play result;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Play) ois.readObject();
        }
        return result;
    }

    public static void main(String[] args) {

        initializeBarca();
        initializeBayern();
        initializeChelsea();
        initializeManUtd();
        initializePSG();
        initializeRMadrid();

        league.addClubsToLeague();
        league.addPlayersToLeague();
        league.outfieldPlayersArrayList();

        Fixtures.setMatchDay1();
        Fixtures.setMatchDay2();
        Fixtures.setMatchDay3();
        Fixtures.setMatchDay4();
        Fixtures.setMatchDay5();
        Fixtures.setMatchDay6();
        Fixtures.setMatchDay7();
        Fixtures.setMatchDay8();
        Fixtures.setMatchDay9();
        Fixtures.setMatchDay10();
        Fixtures.setMatchDays();


        System.out.println("Welcome to Football Manager.");

            introMenu();

    }
}
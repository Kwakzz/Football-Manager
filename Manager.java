import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Manager implements Serializable {

    public Manager (String managerName, int managerAge, Nationality managerNationality) {
        this.managerName = managerName;
        this.managerAge = managerAge;
        this.managerNationality = managerNationality;
    }

    // Manager's Name
    private final String managerName;

    /**
     * @return manager's name
     */
    public String getManagerName () {
        return managerName;
    }


    // Manager's Age
    private int managerAge;
    /**
     * @return manager's age
     */
    public int getManagerAge () {
        return managerAge;
    }
    public void addToManagerAge () {
        managerAge += 1;
    }

    // Manager's Nationality
    public enum Nationality {
        AMERICA, ARGENTINA, BELGIUM, BRAZIL, CAMEROON, CANADA, COLOMBIA, CROATIA, ENGLAND, FRANCE, GERMANY, GHANA,
        ITALY, NETHERLANDS, NIGERIA, PORTUGAL, SENEGAL, SERBIA, SOUTH_KOREA, SPAIN, URUGUAY, ZAMBIA
    }

    Nationality managerNationality;


    // Manager's Team
    Club currentClub;

    public void setCurrentClub(Club currentClub) {
        this.currentClub = currentClub;
    }

    /**
     * @return manager's current club
     */
    public String getCurrentClubName () {
        return currentClub.getClubName();
    }


    // List of teams managed
    private ArrayList <Club> listOfTeamsManaged = new ArrayList<>();

    public void setListOfTeamsManaged(Club club) {
        this.listOfTeamsManaged.add(club);
    }

    public String getListOfTeamsManaged() {
        String [] listOfTeamsManagedArray = new String[listOfTeamsManaged.size()];
        for (int i = 0; i < listOfTeamsManaged.size(); i++) {
            listOfTeamsManagedArray [i] = listOfTeamsManaged.get(i).getClubName();
        }
        return Arrays.toString(listOfTeamsManagedArray);
    }


    /**
     *
     */
    public void changeWage () {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1;
        int wageChange;
        System.out.printf("Pick player by entering player's name.\n%s\n", currentClub.getPlayers());
        String playerName = scanner.nextLine();
        for (Player player: currentClub.players) {
            if (playerName.equals(player.getPlayerName())) {
                scanner1 = new Scanner(System.in);
                System.out.println("Wage Change: ");
                wageChange = scanner1.nextInt();
                player.wageMutator(wageChange);
            }
        }
    }

    // Change Club
    /**
     * This method is used when the manager decides to switch clubs
     */
    public void changeClub () {
        Scanner scanner = new Scanner(System.in);
        for (Club club: League.leagueClubs)
            System.out.println(club.getClubName());
        System.out.println("Pick a new club");
        String newClub = scanner.nextLine();
        for (Club club: League.leagueClubs) {
            if (newClub.equals(club.getClubName())) {
                this.currentClub = club;
                listOfTeamsManaged.add(club);
                System.out.printf("\nYou're the new manager of %s\n", club.getClubName());
            }
        }
    }


    // Transfers
    public void offerBid () {

        for (Club club: League.leagueClubs)
            System.out.printf("\n%s: %s",club.getClubName(), club.getPlayers());

        Player transferTarget = null;
        Player exchangePlayer = null;
        int transferFee;

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3= new Scanner(System.in);

        System.out.println("\n\nTransfer Target (Enter Player's Full Name): ");
        String input1 = scanner1.nextLine();

        for (Player player: League.leaguePlayers) {
            if (input1.equals(player.getPlayerName())) {
                transferTarget = player;
            }
        }

        System.out.println("Exchange Player (Enter Player's Full Name): ");
        String input2 = scanner2.nextLine();

        for (Player player: League.leaguePlayers) {
            if (input2.equals(player.getPlayerName())) {
                exchangePlayer = player;
            }
        }

        System.out.println("Transfer Fee: ");
        transferFee = scanner3.nextInt();


        if (transferTarget != null && exchangePlayer != null &&
                exchangePlayer.getPlayerMarketValue() + transferFee >= transferTarget.getPlayerMarketValue()) {
            Random random = new Random();
            int acceptOrNot = random.nextInt(2);
            if (acceptOrNot == 1) {
                transferTarget.playerCurrentClub.players.set(transferTarget.playerCurrentClub.players.indexOf(transferTarget), exchangePlayer);
                currentClub.players.set(currentClub.players.indexOf(exchangePlayer), transferTarget);
                transferTarget.playerCurrentClub.clubBudgetMutator(transferFee); // add transfer fee to other club's budget.
                currentClub.clubBudgetMutator(-transferFee); // subtract transfer fee from manager's club's budget
                exchangePlayer.changeClub(transferTarget.playerCurrentClub); // change exchange player's current club to transfer target's former club
                transferTarget.changeClub(currentClub); // change transfer target's club to manager's club
                System.out.printf("%s has been transferred to your club.\n%s has left the club to %s.\n"
                        , transferTarget.getPlayerName(), exchangePlayer.getPlayerName(), exchangePlayer.getCurrentClub());
            } else {
                System.out.println("Your transfer offer has been rejected.");
            }
        }


    }
    private int noOfLeagueTrophiesWon;
    public void addToNoOfLeagueTrophiesWon() {
        this.noOfLeagueTrophiesWon += 1;
    }
    public int getNoOfLeagueTrophiesWon () {
        return noOfLeagueTrophiesWon;
    }

    public String viewAccomplishments () {
        return "Teams Managed: " + getListOfTeamsManaged() +"\nNumber Of League Trophies Won: " + getNoOfLeagueTrophiesWon();
    }

    public String viewMyDetails () {
        return managerName + ", " + getManagerAge() + " years, " + managerNationality;
    }

    static File file = new File("manager.sav");
    public static void saveManager(Manager obj, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            oos.flush();
        }
    }

    public static Manager loadManager (File file) throws IOException, ClassNotFoundException {
        Manager result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Manager) ois.readObject();
        }
        return result;
    }

}

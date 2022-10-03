import java.io.*;

public class Settings implements java.io.Serializable {

    public static void saveGame () {
        try{
            League.saveLeague(Play.league, League.file);

            Manager.saveManager(Play.myManager, Manager.file);
            Manager.saveManager(Play.josepGuardiola, Manager.file);
            Manager.saveManager(Play.julianNagelsmann, Manager.file);
            Manager.saveManager(Play.carloAncelotti, Manager.file);
            Manager.saveManager(Play.mauricioPochettino, Manager.file);
            Manager.saveManager(Play.thomasTuchel, Manager.file);

            Club.saveClub(Play.Barca, Club.file);
            Club.saveClub(Play.Bayern, Club.file);
            Club.saveClub(Play.Chelsea, Club.file);
            Club.saveClub(Play.ManCity, Club.file);
            Club.saveClub(Play.RealMadrid, Club.file);
            Club.saveClub(Play.PSG, Club.file);

            Fixtures.saveFixtures(Play.fixtures, Fixtures.file );

            Play.savePlay(Play.play, Play.file);

            for (Player player: League.leaguePlayers)
                Player.savePlayer(player, Player.file);

            System.out.print("Game Saved\n");
        }
        catch (Exception e) {
            System.out.print("Can't save\n");
        }
    }

    public static void loadGame () {
        try{
            League.loadLeague(League.file);
            Manager.loadManager(Manager.file);
            Club.loadClub(Club.file);
            Fixtures.loadFixtures(Fixtures.file);
            Player.loadPlayer(Player.file);
            Play.loadPlay(Play.file);
            System.out.print("Game Loaded\n");
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.out.print("File not Found\n");
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        catch (IOException ioException) {
            System.out.print("Error serializing\n");
        }
    }
}

import java.io.*;
import java.util.ArrayList;


public class Fixtures implements Serializable {

    int matchDay = 0;

    public int getMatchDay () {
        return matchDay;
    }

    public void resetMatchDay () {
        matchDay = 0;
    }

    static ArrayList <Club> matchDay1 = new ArrayList<>();
    static ArrayList <Club> matchDay2 = new ArrayList<>();
    static ArrayList <Club> matchDay3 = new ArrayList<>();
    static ArrayList <Club> matchDay4 = new ArrayList<>();
    static ArrayList <Club> matchDay5 = new ArrayList<>();
    static ArrayList <Club> matchDay6 = new ArrayList<>();
    static ArrayList <Club> matchDay7 = new ArrayList<>();
    static ArrayList <Club> matchDay8 = new ArrayList<>();
    static ArrayList <Club> matchDay9 = new ArrayList<>();
    static ArrayList <Club> matchDay10 = new ArrayList<>();


    public static void setMatchDay1 () {
        matchDay1.add(Play.Barca);
        matchDay1.add(Play.Bayern);
        matchDay1.add(Play.Chelsea);
        matchDay1.add(Play.ManCity);
        matchDay1.add(Play.PSG);
        matchDay1.add(Play.RealMadrid);
    }

    public static void setMatchDay2 () {
        matchDay2.add(Play.Bayern);
        matchDay2.add(Play.ManCity);
        matchDay2.add(Play.Barca);
        matchDay2.add(Play.PSG);
        matchDay2.add(Play.Chelsea);
        matchDay2.add(Play.RealMadrid);
    }

    public static void setMatchDay3 () {
        matchDay3.add(Play.Bayern);
        matchDay3.add(Play.PSG);
        matchDay3.add(Play.ManCity);
        matchDay3.add(Play.RealMadrid);
        matchDay3.add(Play.Barca);
        matchDay3.add(Play.Chelsea);
    }

    public static void setMatchDay4 () {
        matchDay4.add(Play.Barca);
        matchDay4.add(Play.RealMadrid);
        matchDay4.add(Play.Bayern);
        matchDay4.add(Play.Chelsea);
        matchDay4.add(Play.ManCity);
        matchDay4.add(Play.PSG);
    }

    public static void setMatchDay5 () {
        matchDay5.add(Play.Barca);
        matchDay5.add(Play.ManCity);
        matchDay5.add(Play.Bayern);
        matchDay5.add(Play.RealMadrid);
        matchDay5.add(Play.PSG);
        matchDay5.add(Play.Chelsea);
    }

    public static void setMatchDay6 () {
        matchDay6.add(Play.Bayern);
        matchDay6.add(Play.Barca);
        matchDay6.add(Play.ManCity);
        matchDay6.add(Play.Chelsea);
        matchDay6.add(Play.RealMadrid);
        matchDay6.add(Play.PSG);
    }

    public static void setMatchDay7 () {
        matchDay7.add(Play.ManCity);
        matchDay7.add(Play.Bayern);
        matchDay7.add(Play.PSG);
        matchDay7.add(Play.Barca);
        matchDay7.add(Play.RealMadrid);
        matchDay7.add(Play.Chelsea);
    }

    public static void setMatchDay8 () {
        matchDay8.add(Play.PSG);
        matchDay8.add(Play.Bayern);
        matchDay8.add(Play.RealMadrid);
        matchDay8.add(Play.ManCity);
        matchDay8.add(Play.Chelsea);
        matchDay8.add(Play.Barca);
    }

    public static void setMatchDay9 () {
        matchDay9.add(Play.RealMadrid);
        matchDay9.add(Play.Barca);
        matchDay9.add(Play.Chelsea);
        matchDay9.add(Play.Bayern);
        matchDay9.add(Play.PSG);
        matchDay9.add(Play.ManCity);
    }

    public static void setMatchDay10 () {
        matchDay10.add(Play.ManCity);
        matchDay10.add(Play.Barca);
        matchDay10.add(Play.RealMadrid);
        matchDay10.add(Play.Bayern);
        matchDay10.add(Play.Chelsea);
        matchDay10.add(Play.PSG);
    }


    static ArrayList <ArrayList<Club>> matchDays = new ArrayList<>();

    public static void setMatchDays() {

        matchDays.add(matchDay1);
        matchDays.add(matchDay2);
        matchDays.add(matchDay3);
        matchDays.add(matchDay4);
        matchDays.add(matchDay5);
        matchDays.add(matchDay6);
        matchDays.add(matchDay7);
        matchDays.add(matchDay8);
        matchDays.add(matchDay9);
        matchDays.add(matchDay10);
    }

    public void displayUpcomingFixtures() {
        System.out.printf("\n%s vs %s\n", matchDays.get(matchDay).get(0).getClubName(), matchDays.get(matchDay).get(1).getClubName());
        System.out.printf("%s vs %s\n", matchDays.get(matchDay).get(2).getClubName(), matchDays.get(matchDay).get(3).getClubName());
        System.out.printf("%s vs %s\n", matchDays.get(matchDay).get(4).getClubName(), matchDays.get(matchDay).get(5).getClubName());
    }

    static File file = new File("fixtures.sav");
    public static void saveFixtures(Fixtures obj, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            oos.flush();
        }
    }

    public static Fixtures loadFixtures (File file) throws IOException, ClassNotFoundException {
        Fixtures result;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Fixtures) ois.readObject();
        }
        return result;
    }
     /*
        Barca v Bayern, Chelsea v Man City, PSG, v Madrid

        Bayern v Man City, Barca v PSG, Chelsea v Madrid

        Bayern v PSG, Man City v Madrid, Barca v Chelsea,

        Barca v Real Madrid, Bayern v Chelsea, Man City v PSG

        Barca v Man City, Bayern v Real Madrid, PSG v Chelsea

        barcaFixtures {Bayern, PSG, Chelsea, RealMadrid, ManCity};
        bayernFixtures {Barca, ManCity, PSG, Chelsea, RealMadrid};
        chelseaFixtures {ManCity, RealMadrid, Barca, Bayern, PSG};
        manCityFixtures {Chelsea, Bayern, RealMadrid, PSG, Barca};
        psgFixtures {RealMadrid, Barca, Bayern, ManCity, Chelsea};
        rMadridFixtures {PSG, Chelsea, ManCity, Barca, Bayern};
         */


}

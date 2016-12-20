import java.io.*;
import java.nio.file.Paths;

/**
 * Created by wdwoo on 12/19/2016.
 */
public class ForFiles {
    private BufferedWriter x = null;
    private String[] favoriteStations;

    public void addURI(String URI) {
        try {
            x = new BufferedWriter(new FileWriter("favorites.txt", true));
            x.write(URI);
            x.newLine();
            x.close();
        }
        catch (Exception e) {
            System.out.println("I couldn't add your favorite station. Better luck next time");
        }

    }

    public void initializeFavorites() {

        int numberOfLines=0;
        BufferedReader textReader = null;

        //gets the number of lines in the file, so that an array can be set up and populated
        //also creates other objects which will need the favorites.txt
        try {
            FileReader reader = new FileReader("favorites.txt");
            textReader = new BufferedReader(reader);

            LineNumberReader lines = new LineNumberReader(new FileReader("favorites.txt"));
            lines.skip(Long.MAX_VALUE);
            numberOfLines = lines.getLineNumber()+1;
        }
        catch (Exception e) {
            System.out.println("Oh she broke");
        }

        favoriteStations = new String[numberOfLines];

        for (int i=0; i<numberOfLines; i++) {
            try {
                favoriteStations[i] = textReader.readLine();
            }
            catch(Exception e) {
                System.out.println("Something went wrong. Sorry. Life is unfair.");
            }
        }

        try {
            textReader.close();
        }
        catch (Exception e){
            System.out.println("Couldn't close. Now Christmas is ruined.");
        }

    }

    public int stationsContained() {
        return favoriteStations.length;
    }

    public String[] stationArray() {
        return favoriteStations;
    }
}

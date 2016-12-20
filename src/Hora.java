import com.pumaj.*;
import com.sun.jna.NativeLibrary;
import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;
import java.awt.*;
import java.util.Random;

/**
 * Created by wdwoo on 12/1/2016.
 */
//NEEDED CHANGES/LIST OF PLACEHOLDERS
//need to change text heights so they will change with the window size
//
//need to adjust app window so it fits regardless of what side the taskbar is on (series of if statements, seeing if
//windowSize-taskbarSize==windowSize
//
//get images to put on buttons
//
//replace square buttons with something more visually appealing


public class Hora {

    //sets up app to be used for all of Hora
    protected static PjApplication myApp = new PjApplication();
    protected static int buttonPressed;
    protected static RectButton back = new RectButton();
    public static int stateTracker = 0;
    protected static final int logoWidth = 588, logoHeight = 238;
    protected static final int miniLogoWidth = 70, miniLogoHeight = 100;

    //creates media player
    protected static PjInternetRadio myRadio;
    protected static GvIMediaPlayer hora;

    //booleans for checking which sections button is pressed
    protected static boolean genre, emotion, situation;
    protected static boolean backHit;

    //emotion station lists
    protected static String[] happyStations = {"http://airspectrum.cdnstream1.com:8008/1604_128", "http://uk1.internet-radio.com:8129/live", "http://airspectrum.cdnstream1.com:8018/1606_192", "http://uk3.internet-radio.com/proxy/soulpower?mp=/;", "http://us1.internet-radio.com/proxy/dougwsjfplus?mp=/;"};
    protected static String[] relaxedStations = {"http://www.partyviberadio.com:8000/;stream/1", "http://us2.internet-radio.com:8181/;stream", "http://airspectrum.cdnstream1.com:8116/1649_192", "http://uk4.internet-radio.com:8097/;stream", "http://uk3.internet-radio.com/proxy/siixteen?mp=/;"};
    protected static String[] angryStations = {"http://uk1.internet-radio.com:8294/live", "http://uk5.internet-radio.com:8189/;stream", "http://us1.internet-radio.com:8533/;stream", "http://us1.internet-radio.com:8224/;"};
    protected static String[] tiredStations = {"http://uk1.internet-radio.com:8274/;stream", "http://uk3.internet-radio.com:11168/live", "http://us3.internet-radio.com:8007/;stream", "http://us1.internet-radio.com:8224/;", "http://uk3.internet-radio.com/proxy/radioteamoromance?mp=/;"};
    protected static String[] excitedStations = {"http://uk5.internet-radio.com:8049/live", "http://us3.internet-radio.com:8087/;stream", "http://us2.internet-radio.com:8217/live", "http://uk2.internet-radio.com:8145/;stream", "http://uk2.internet-radio.com:8218/live"};
    protected static String[] sadStations = {"http://us2.internet-radio.com:8443/;stream", "http://us1.internet-radio.com:8599/live"};

    //array of all emotion station arrays (this may not end up being needed)
    protected static String[][] emotionStations = {happyStations, sadStations, angryStations, relaxedStations, excitedStations, tiredStations};

    //genre station lists
    protected static String[] latinStations = {"http://philae.shoutca.st:8180/;stream/1","http://uk3.internet-radio.com/proxy/radioteamoromance?mp=/;"};
    protected static String[] countryStations = {"http://us2.internet-radio.com:8071/;","http://us2.internet-radio.com/proxy/jbrashier?mp=/;","http://us2.internet-radio.com/proxy/1stargold?mp=/;","http://us1.internet-radio.com/proxy/bmcnmusic?mp=/;"};
    protected static String[] popStations = {"http://us3.internet-radio.com:8019/live","http://us1.internet-radio.com:8419/;","http://us3.internet-radio.com:8087/;stream","http://uk2.internet-radio.com:8145/;stream"};
    protected static String[] rockStations = {"http://us2.internet-radio.com:8191/;stream","http://uk1.internet-radio.com:8294/live","http://us2.internet-radio.com:8347/;stream","http://us2.internet-radio.com/proxy/classicrock160?mp=/;","http://us2.internet-radio.com:8351/;stream"};
    protected static String[] holidayStations = {"http://uk5.internet-radio.com:8278/live","http://77.75.16.229:443/;stream/1"};
    protected static String[] hipHopStations = {"http://us2.internet-radio.com:8217/live","http://www.partyviberadio.com:8016/;stream/1","http://us1.internet-radio.com:8336/","http://us3.internet-radio.com:8133/","http://us3.internet-radio.com:8133/;stream"};
    protected static String[] classicalStations = {"http://stream.weta.org:8000","http://uk1.internet-radio.com:8084/;","http://us3.internet-radio.com:8078/;stream","http://uk1.internet-radio.com/proxy/introducingclassics?mp=/"};
    protected static String[] electronicStations = {"http://us3.internet-radio.com:8087/;stream","http://us3.internet-radio.com:8087/;stream", "http://us3.internet-radio.com:8087/;stream","http://uk2.internet-radio.com:30075/live","http://uk3.internet-radio.com:11168/live"};
    protected static String[] folkStations = {"http://us1.internet-radio.com/proxy/bmcnmusic?mp=/ "};
    protected static String[] reggaeStations = {"http://www.partyviberadio.com:8000/;stream/1","http://andromeda.shoutca.st:8149/;stream/1", "http://us2.internet-radio.com:8281/live", "http://uk4.internet-radio.com/proxy/pigpenradio?mp=/", "http://uk2.internet-radio.com/proxy/ukvibes?mp=/ "};
    protected static String[] jazzStations = {"http://uk3.internet-radio.com:11168/live","http://us1.internet-radio.com:8406/","http://us2.internet-radio.com:8443/;stream","http://us1.internet-radio.com/proxy/dougwsjfplus?mp=/;","http://us1.internet-radio.com/proxy/dougwsjfplus?mp=/"};
    protected static String[] metalStations = {"http://uk1.internet-radio.com:8294/live", "http://uk5.internet-radio.com:8189/;stream","http://us1.internet-radio.com:8533/;stream","http://us1.internet-radio.com/proxy/adammorez?mp=/","http://uk2.internet-radio.com/proxy/gutiskaradio?mp=/"};
    protected static String[] oldiesStations = {"http://airspectrum.cdnstream1.com:8018/1606_192","http://airspectrum.cdnstream1.com:8012/1605_192","http://airspectrum.cdnstream1.com:8024/1302_19","http://us2.internet-radio.com:8160/;stream","http://uk2.internet-radio.com/proxy/1fmuk?mp=/"};
    protected static String[] discoStations = {"http://uk5.internet-radio.com:8174/;stream", "http://stream.generationdiscofunk.com:8000/;stream/1", "http://listento.thefunkstation.com:8000/;stream/1"};
    protected static String[] hindiStations = {"http://uk2.internet-radio.com:8043/live", "http://us2.internet-radio.com:8281/live"};

    //array of all genre station arrays (may not be needed)
    protected static String[][] genreStations = {latinStations, countryStations, popStations, rockStations, holidayStations, hipHopStations, classicalStations, electronicStations, folkStations, reggaeStations, jazzStations, metalStations, oldiesStations, discoStations, hindiStations};

    //situation station list
    protected static String[] partyStations = {"http://www.partyviberadio.com:8016/;stream/1","http://us2.internet-radio.com:8217/live","http://us3.internet-radio.com:8087/;stream","http://uk4.internet-radio.com:10104/;","http://uk1.internet-radio.com:15614/;","http://uk2.internet-radio.com:8145/;stream","http://uk2.internet-radio.com:8218/live"};
    protected static String[] gymStations = {"http://www.partyviberadio.com:8016/;stream/1","http://uk5.internet-radio.com:8174/","http://us3.internet-radio.com:8019/live","http://uk1.internet-radio.com:15614/;","http://us3.internet-radio.com:8087/;stream"};
    protected static String[] roadtripStations = {"http://airspectrum.cdnstream1.com:8024/1302_192","http://us2.internet-radio.com:8443/;stream","http://uk5.internet-radio.com:8049/live","http://uk2.internet-radio.com:30163/live","http://airspectrum.cdnstream1.com:8116/1649_192"};
    protected static String[] dateStations = {"http://airspectrum.cdnstream1.com:8024/1302_192","http://airspectrum-ir.cdnstream.com:8000/1258_192","http://uk5.internet-radio.com:8049/live","http://uk1.internet-radio.com:8269/;","http://us2.internet-radio.com:8071/;"};
    protected static String[] stargazingStations = {"http://airspectrum.cdnstream1.com:8024/1302_192","http://us3.internet-radio.com:8091/;stream","http://us1.internet-radio.com:8406/index.html?sid=1","http://airspectrum-ir.cdnstream.com:8000/1258_192","http://stream.soundstorm-radio.com:8000/;stream/1"};
    protected static String[] beachStations = {"http://airspectrum.cdnstream1.com:8018/1606_192","http://us3.internet-radio.com:8019/live","http://uk1.internet-radio.com:15614/;","http://uk5.internet-radio.com:8174/index.html?sid=1"};

    //array of all situation station arrays (may not be needed)
    protected static String[][] situationStations = {partyStations, gymStations, roadtripStations, dateStations, stargazingStations, beachStations};

    public static void main(String[] args) {
        NativeLibrary.addSearchPath("libvlc", System.getProperty("user.dir") + "/lib/win/");
        myRadio = new PjInternetRadio();
        hora = myRadio.getMediaPlayer();
        //object which will allow you to get the screensize of whatever device program is running in
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int taskbarHeight = screenSize.height - GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        int carryOver = 10;

        boolean running = true;

        //sets up app
        myApp.setBackground(RGBtoHSB(1, 1, 20));
        myApp.setVisible(true);
        myApp.setLayout(null);
        myApp.setWidth(screenSize.width);
        myApp.setHeight(screenSize.height - taskbarHeight);
        myApp.setLocation(0, 0);


        //adds back button
        backButton();

        //adds quit button
        quitButton();

        favoriteList();

        //plays intro sound file
        PjUtils.playSoundFile("Assets/Sounds/Intro_Sound.wav");

        while (running) {
            if (stateTracker == 0) {
                //generates opening screen
                openingScreen();
                stateTracker = 1;
            }

            if (stateTracker == 1) {
                //generates category selection screen
                buildCategory();
            }
            if (stateTracker == 2) {
                switch (buttonPressed) {
                    case 0:
                        buildEmotion();
                        carryOver = 0;
                        break;
                    case 1:
                        buildSituation();
                        carryOver = 1;
                        break;
                    case 2:
                        buildGenre();
                        carryOver = 2;
                        break;
                    case 3:

                        buildFavorite();
                        carryOver = 3;
                        break;

                }
            }

            if (stateTracker == 3) {
                switch (carryOver) {
                    case 0:
                        buildEmotionStations();
                        break;
                    case 1:
                        buildSituationStations();
                        break;
                    case 2:
                        buildGenreStations();
                        break;
                    case 3:
                        System.out.println("placeholder for buildFavoriteStations");
                        break;
                }
            }
        }
    }

    public static void openingScreen() {

        //shape creation
        PjRectangle logo = new PjRectangle();
        RectButton enter = new RectButton();

        //variables
        boolean listening = true;
        String logoPath = "Assets/Images/Hora.png";

        //sets up logo with image, size, and location
        logo.setSize(logoWidth, logoHeight);
        logo.setLocation(myApp.getWidth() / 2 - logo.getWidth() / 2, myApp.getHeight() / 5);
        logo.setImage(logoPath);
        logo.setBackground(Color.yellow);
        myApp.add(logo);

            //creates font
            Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/45);

            //sets up enter button with text, size, and location
            enter.setSize(myApp.getWidth()/2 - myApp.getWidth() / 9, myApp.getHeight() / 12);
            enter.setText("Listening Has Never Been Easier");
            enter.setFont(c);
            enter.setFontColor(Color.black);
            myApp.add(enter).setLocation((myApp.getWidth()/2)-enter.getWidth()/2, (myApp.getHeight()/3)+enter.getHeight()*3);

        //waits to execute when shape clicked
        while (listening) {
            if (enter.clickTracker == 1) {
                enter.clickTracker = 0;
                listening = false;
                myApp.remove(enter);
                myApp.remove(logo);
            }
            PjUtils.sleep(500);
        }
    }

    public static void buildCategory() {

        //variable creation
        String logoPath = "Assets/Images/Hora.png";
        PjRectangle logo = new PjRectangle();
        RectButton[] buttons = new RectButton[4];
        boolean listening = true;

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/50);

        //places logo
        logo.setSize(logoWidth, logoHeight);
        logo.setLocation(myApp.getWidth()/2-logo.getWidth()/2, myApp.getHeight()/20);
        logo.setBackground(Color.yellow);
        logo.setImage(logoPath);
        myApp.add(logo);

        //fills array of buttons
        for (int i=0; i<4; i++) {
            buttons[i] = new RectButton();
            buttons[i].setSize(myApp.getWidth()/2 - myApp.getWidth() / 9, myApp.getHeight() / 12);
            buttons[i].setFont(c);
            buttons[i].setFontColor(Color.black);
            myApp.add(buttons[i]);
            if (i==0) {
                buttons[i].setLocation(myApp.getWidth()/2-buttons[i].getWidth()/2, myApp.getHeight()/4+buttons[i].getHeight()*2);
                buttons[i].setText("Emotion");
            }
            else if (i==1) {
                buttons[i].setLocation(myApp.getWidth()/2-buttons[i].getWidth()/2, buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/2);
                buttons[i].setText("Situation");
            }
            else if (i==2) {
                buttons[i].setLocation(myApp.getWidth()/2-buttons[i].getWidth()/2, buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/2);
                buttons[i].setText("Genre");
            }
            else {
                buttons[i].setLocation(myApp.getWidth()/2-buttons[i].getWidth()/2, buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/2);
                buttons[i].setText("Favorites");
            }
        }

        //doesn't work yet, can also be made more efficient
        while (listening) {
            for (int i=0; i<4; i++) {
                if (buttons[i].clickTracker==1 || back.clickTracker==1) {
                    buttonPressed=i;
                    //clears app
                    for (int j=0; j<4; j++) {
                        myApp.remove(buttons[j]);
                    }
                    myApp.remove(logo);
                    stateTracker=2;

                    //looks if app was cleared because of back button, if true executes back functionality
                    if (back.clickTracker==1) {
                        stateTracker=0;
                        back.clickTracker=0;
                    }
                    listening=false;
                }
            }
            PjUtils.sleep(500);
        }
    }

    public static void buildEmotion() {
        //variable creation
        PjRectangle miniLogo = new PjRectangle();
        String miniLogoPath = "Assets/Images/horalogo.png";
        PjRectangle emotionText = new PjRectangle();
        RectButton[] buttons = new RectButton[6];
        String[] emotions = {"Happy", "Sad", "Angry", "Relaxed", "Excited", "Tired"};
        boolean listening = true;

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/15);
        Font d = new Font("Orkney", Font.PLAIN, myApp.getWidth()/50);

        //places text
        emotionText.setText("Emotions:");
        emotionText.setFontColor(Color.white);
        emotionText.setFont(c);
        emotionText.setSize(myApp.getWidth()/2,myApp.getHeight()/5);
        emotionText.setLocation(myApp.getWidth()/2-emotionText.getWidth()/2, myApp.getHeight()/20);
        emotionText.setBackground(myApp.getBackground());
        myApp.add(emotionText);


        //adds minilogo to upper left
        miniLogo.setSize(miniLogoWidth, miniLogoHeight);
        miniLogo.setLocation(0,0);
        miniLogo.setBackground(Color.yellow);
        miniLogo.setImage(miniLogoPath);
        myApp.add(miniLogo);


        //adds buttons
        for (int i=0; i<6; i++) {
            //creates generic button and sets text
            buttons[i] = new RectButton();
            buttons[i].setSize(myApp.getWidth()/2 - myApp.getWidth() / 9, myApp.getHeight() / 6);
            buttons[i].setText(emotions[i]);
            buttons[i].setFont(d);
            buttons[i].setFontColor(Color.black);


            //sets button location based upon i value
            if (i<=2) {
                if (i==0) {
                    buttons[i].setLocation(myApp.getWidth()/2-buttons[i].getWidth()-buttons[i].getWidth()/8, myApp.getHeight()/4);
                }
                else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/4);
                }
            }
            else {
                if (i==3) {
                    buttons[i].setLocation(myApp.getWidth()/2+buttons[i].getWidth()/8, myApp.getHeight()/4);
                }
                else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/4);
                }
            }
            myApp.add(buttons[i]);
        }

        //listens to see which button has been pressed
        while (listening) {
            for (int i=0; i<6; i++) {
                if (buttons[i].clickTracker==1 || back.clickTracker==1) {
                    buttonPressed=i;
                    //clears app
                    for (int j=0; j<6; j++) {
                        myApp.remove(buttons[j]);
                    }
                    myApp.remove(emotionText);
                    emotion = true;
                    stateTracker=3;

                    //looks if app was cleared because of back button, if true executes back functionality
                    if (back.clickTracker==1) {
                        back.clickTracker=0;
                        stateTracker=1;
                    }
                    listening=false;
                }
            }
        }
    }

    public static void buildEmotionStations() {

        //creates variables
        boolean listening = true;
        PlayButton play = new PlayButton();
        PauseButton pause = new PauseButton();
        PjRectangle type = new PjRectangle();
        RectButton next = new RectButton();
        RectButton previous = new RectButton();
        RectButton addFavorites = new RectButton();
        Font d = new Font("Orkney", Font.PLAIN, myApp.getWidth()/50);
        Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/20);
        Random rand = new Random();
        int station = 0;
        String[] emotions = {"Happy", "Sad", "Angry", "Relaxed", "Excited", "Tired"};

        //places play button
        play.setSize(myApp.getWidth()/16, myApp.getHeight()/8);
        play.setText("Play");
        play.setFont(d);
        play.setLocation(myApp.getWidth()/2+(play.getWidth()/2), myApp.getHeight()/2+play.getHeight()*2);
        myApp.add(play);

        //places pause button
        pause.setSize(myApp.getWidth()/16, myApp.getHeight()/8);
        pause.setText("Pause");
        pause.setFont(d);
        pause.setLocation((myApp.getWidth()/2)-(play.getWidth())-play.getWidth()/2, myApp.getHeight()/2+play.getHeight()*2);
        myApp.add(pause);

        //places next button
        next.setSize(myApp.getWidth()/6, myApp.getHeight()/16);
        next.setText("Next Station");
        next.setFont(d);
        next.setLocation(myApp.getWidth()/2+(play.getWidth()/2), (myApp.getHeight()/2)+next.getHeight());
        myApp.add(next);

        //places previous button
        previous.setSize(myApp.getWidth()/6, myApp.getHeight()/16);
        previous.setText("Previous Station");
        previous.setFont(d);
        previous.setLocation((myApp.getWidth()/2)-previous.getWidth()-previous.getWidth()/5, (myApp.getHeight()/2)+previous.getHeight());
        myApp.add(previous);

        //places addFavorites button
        addFavorites.setSize(myApp.getWidth() / 6, myApp.getHeight() / 16);
        addFavorites.setText("Add to Favorites");
        addFavorites.setFont(d);
        addFavorites.setLocation(myApp.getWidth()-addFavorites.getWidth()-addFavorites.getHeight()/2, addFavorites.getHeight()/2);
        myApp.add(addFavorites);

        //selects which radio array to play based off of button pressed and starts media player
        for (int m=0; m<emotionStations.length; m++) {
            if (buttonPressed==m) {
                station=m;
            }
        }

        //creates randStation
        int randStation=rand.nextInt(emotionStations[station].length);

        //gets radio playing random station
        try {
            hora.setURI(emotionStations[station][randStation]);
            hora.setMute(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //adds type of station
        type.setText(emotions[station]);
        type.setFontColor(Color.white);
        type.setFont(c);
        type.setSize(myApp.getWidth()/2,myApp.getHeight()/5);
        type.setLocation(myApp.getWidth()/2-type.getWidth()/2, myApp.getHeight()/10);
        type.setBackground(myApp.getBackground());
        myApp.add(type);


        //starts media player and sets pause, play, previous and next buttons
        while (listening) {
            PjUtils.sleep(100);

            //play/pause button listeners
            if (pause.clickTracker==1){
                hora.setMute(true);
                pause.clickTracker=0;
            }
            if (play.clickTracker==1){
                hora.setMute(false);
                play.clickTracker=0;
            }
            if (next.clickTracker==1){
                randStation += 1;
                if (randStation>emotionStations[station].length-1){
                    randStation = 0;
                }
                try {
                    hora.setURI(emotionStations[station][randStation]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                next.clickTracker=0;
            }
            if (previous.clickTracker==1){
                randStation -= 1;
                if (randStation<0){
                    randStation = emotionStations[station].length-1;
                }
                try {
                    hora.setURI(emotionStations[station][randStation]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                previous.clickTracker=0;
            }

            //looks to see if the add to favorites button has been clicked
            if (addFavorites.clickTracker==1) {
                ForFiles favoriteDoc = new ForFiles();
                favoriteDoc.addURI(hora.getURI());
                addFavorites.clickTracker=0;
            }

            //looks if app was cleared because of back button, if true executes back functionality
            if (back.clickTracker==1) {
                back.clickTracker=0;
                myApp.remove(pause);
                myApp.remove(play);
                myApp.remove(previous);
                myApp.remove(next);
                myApp.remove(type);
                myApp.remove(addFavorites);
                hora.setMute(true);
                stateTracker=2;
                buttonPressed=0;
                listening=false;
            }
        }
    }



    public static void buildSituation() {
        //variable creation
        PjRectangle miniLogo = new PjRectangle();
        String miniLogoPath = "Assets/Images/horalogo.png";
        PjRectangle situationText = new PjRectangle();
        RectButton[] buttons = new RectButton[6];
        String[] situations = {"Party", "Gym", "Roadtrip", "Date", "Stargazing", "Beach"};
        boolean listening = true;

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/15);
        Font d = new Font("Orkney", Font.PLAIN, myApp.getWidth()/50);

        //places text
        situationText.setText("Situations:");
        situationText.setFontColor(Color.white);
        situationText.setFont(c);
        situationText.setSize(logoWidth, logoHeight/2);
        situationText.setLocation(myApp.getWidth()/2-situationText.getWidth()/2, myApp.getHeight()/20);
        situationText.setBackground(myApp.getBackground());
        myApp.add(situationText);

        //adds minilogo to upper left
        miniLogo.setSize(miniLogoWidth, miniLogoHeight);
        miniLogo.setLocation(0,0);
        miniLogo.setBackground(Color.yellow);
        miniLogo.setImage(miniLogoPath);
        myApp.add(miniLogo);

        //adds buttons
        for (int i=0; i<6; i++) {
            //creates generic button and sets text
            buttons[i] = new RectButton();
            buttons[i].setSize(myApp.getWidth()/6, myApp.getHeight()/6);
            buttons[i].setText(situations[i]);
            buttons[i].setFont(d);
            buttons[i].setFontColor(Color.black);
            myApp.add(buttons[i]);

            //sets button location based upon i value
            if (i<=2) {
                if (i==0) {
                    buttons[i].setLocation(myApp.getWidth()/2-buttons[i].getWidth()-buttons[i].getWidth()/8, myApp.getHeight()/4);
                }
                else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/4);
                }
            }
            else {
                if (i==3) {
                    buttons[i].setLocation(myApp.getWidth()/2+buttons[i].getWidth()/8, myApp.getHeight()/4);
                }
                else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/4);
                }
            }
        }

        //listens to see which button has been pressed
        while (listening) {
            for (int i=0; i<6; i++) {
                if (buttons[i].clickTracker==1 || back.clickTracker==1) {
                    //doesn't do anything yet
                    buttonPressed=i;
                    situation = true;
                    //clears app
                    for (int j=0; j<6; j++) {
                        myApp.remove(buttons[j]);
                    }
                    myApp.remove(situationText);
                    stateTracker=3;

                    //looks if app was cleared because of back button, if true executes back functionality
                    if (back.clickTracker==1) {
                        back.clickTracker=0;
                        stateTracker=1;
                    }
                    listening=false;
                }
            }
        }
    }

    public static void buildSituationStations() {

        //creates variables
        boolean listening = true;
        PlayButton play = new PlayButton();
        PauseButton pause = new PauseButton();
        PjRectangle type = new PjRectangle();
        RectButton next = new RectButton();
        RectButton previous = new RectButton();
        RectButton addFavorites = new RectButton();
        Font d = new Font("Orkney", Font.PLAIN, myApp.getWidth()/50);
        Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/20);
        Random rand = new Random();
        int station = 0;
        String[] situations = {"Party", "Gym", "Roadtrip", "Date", "Stargazing", "Beach"};

        //places play button
        play.setSize(myApp.getWidth()/16, myApp.getHeight()/8);
        play.setText("Play");
        play.setFont(d);
        play.setLocation(myApp.getWidth()/2+(play.getWidth()/2), myApp.getHeight()/2+play.getHeight()*2);
        myApp.add(play);

        //places pause button
        pause.setSize(myApp.getWidth()/16, myApp.getHeight()/8);
        pause.setText("Pause");
        pause.setFont(d);
        pause.setLocation((myApp.getWidth()/2)-(play.getWidth())-play.getWidth()/2, myApp.getHeight()/2+play.getHeight()*2);
        myApp.add(pause);

        //places next button
        next.setSize(myApp.getWidth()/6, myApp.getHeight()/16);
        next.setText("Next Station");
        next.setFont(d);
        next.setLocation(myApp.getWidth()/2+(play.getWidth()/2), (myApp.getHeight()/2)+next.getHeight());
        myApp.add(next);

        //places previous button
        previous.setSize(myApp.getWidth()/6, myApp.getHeight()/16);
        previous.setText("Previous Station");
        previous.setFont(d);
        previous.setLocation((myApp.getWidth()/2)-previous.getWidth()-previous.getWidth()/5, (myApp.getHeight()/2)+previous.getHeight());
        myApp.add(previous);

        //places addFavorites button
        addFavorites.setSize(myApp.getWidth() / 6, myApp.getHeight() / 16);
        addFavorites.setText("Add to Favorites");
        addFavorites.setFont(d);
        addFavorites.setLocation(myApp.getWidth()-addFavorites.getWidth()-addFavorites.getHeight()/2, addFavorites.getHeight()/2);
        myApp.add(addFavorites);

        //selects which radio array to play based off of button pressed and starts media player
        for (int m=0; m<situationStations.length; m++) {
            if (buttonPressed==m) {
                station=m;
            }
        }

        //creates randStation
        int randStation=rand.nextInt(situationStations[station].length);

        //gets radio playing random station
        try {
            hora.setURI(situationStations[station][randStation]);
            hora.setMute(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //adds type of station
        type.setText(situations[station]);
        type.setFontColor(Color.white);
        type.setFont(c);
        type.setSize(myApp.getWidth()/2,myApp.getHeight()/5);
        type.setLocation(myApp.getWidth()/2-type.getWidth()/2, myApp.getHeight()/10);
        type.setBackground(myApp.getBackground());
        myApp.add(type);

        //starts media player and sets pause, play, previous and next buttons
        while (listening){
            PjUtils.sleep(100);

            //play/pause button listeners
            if (pause.clickTracker==1){
                hora.setMute(true);
                pause.clickTracker=0;
            }
            if (play.clickTracker==1){
                hora.setMute(false);
                play.clickTracker=0;
            }
            if (next.clickTracker==1){
                randStation += 1;
                if (randStation>situationStations[station].length-1){
                    randStation = 0;
                }
                try {
                    hora.setURI(situationStations[station][randStation]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                next.clickTracker=0;
            }
            if (previous.clickTracker==1){
                randStation -= 1;
                if (randStation<0){
                    randStation = situationStations[station].length-1;
                }
                try {
                    hora.setURI(situationStations[station][randStation]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                previous.clickTracker=0;
            }

            //looks to see if the add to favorites button has been clicked
            if (addFavorites.clickTracker==1) {
                ForFiles favoriteDoc = new ForFiles();
                favoriteDoc.addURI(hora.getURI());
                addFavorites.clickTracker=0;
            }

            //looks if app was cleared because of back button, if true executes back functionality
            if (back.clickTracker==1) {
                back.clickTracker=0;
                myApp.remove(pause);
                myApp.remove(play);
                myApp.remove(previous);
                myApp.remove(next);
                myApp.remove(type);
                myApp.remove(addFavorites);
                hora.setMute(true);
                stateTracker=2;
                buttonPressed=1;
                listening=false;
            }
        }
    }


    public static void buildGenre() {
        //variable creation
        PjRectangle miniLogo = new PjRectangle();
        String miniLogoPath = "Assets/Images/horalogo.png";
        PjRectangle genreText = new PjRectangle();
        RectButton[] buttons = new RectButton[15];
        boolean listening = true;
        String[] genres = {"Latin", "Country", "Pop", "Rock", "Holiday", "Hip Hop", "Classical", "Electronic", "Folk", "Reggae", "Jazz", "Metal", "Oldies", "Disco", "Hindi"};

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/15);
        Font d = new Font("Orkney", Font.PLAIN, myApp.getWidth()/50);

        //places text
        genreText.setText("Genres:");
        genreText.setFontColor(Color.white);
        genreText.setFont(c);
        genreText.setSize(myApp.getWidth()/3, myApp.getHeight()/5);
        genreText.setLocation(myApp.getWidth()/2-genreText.getWidth()/2, myApp.getHeight()/20);
        genreText.setBackground(myApp.getBackground());
        myApp.add(genreText);

        //adds minilogo to upper left
        miniLogo.setSize(miniLogoWidth, miniLogoHeight);
        miniLogo.setLocation(0,0);
        miniLogo.setBackground(Color.yellow);
        miniLogo.setImage(miniLogoPath);
        myApp.add(miniLogo);

        //adds genre buttons
        for (int i=0; i<15; i++) {


            //adds on generic button and adds text
            buttons[i] = new RectButton();
            buttons[i].setSize(myApp.getWidth() / 6, myApp.getHeight() / 10);
            buttons[i].setText(genres[i]);
            buttons[i].setFont(d);
            buttons[i].setFontColor(Color.black);
            myApp.add(buttons[i]);

            //sets button location based upon i value
            if (i<=4) {
                if (i==0) {
                    buttons[i].setLocation(myApp.getWidth()/3-buttons[i].getWidth()/2-buttons[i].getWidth()/4, myApp.getHeight()/4);
                }
                else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i].getHeight()+buttons[i].getHeight()/2);
                }
            }
            else if (i>4 && i<=9) {
                if (i==5) {
                    buttons[i].setLocation(buttons[1].getX()+buttons[i].getWidth()+buttons[i].getWidth()/4, buttons[0].getY());
                }
                else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i].getHeight()+buttons[i].getHeight()/2);
                }
            }
            else {
                if (i==10) {
                    buttons[i].setLocation(buttons[5].getX()+buttons[i].getWidth()+buttons[i].getWidth()/4, buttons[5].getY());
                }
                else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i].getHeight()+buttons[i].getHeight()/2);
                }
            }
        }

        //listens to see which button has been pressed
        while (listening) {
            for (int i=0; i<15; i++) {
                if (buttons[i].clickTracker==1 || back.clickTracker==1) {
                    //doesn't do anything yet
                    buttonPressed=i;
                    genre = true;
                    //clears app
                    for (int j=0; j<15; j++) {
                        myApp.remove(buttons[j]);
                    }
                    myApp.remove(genreText);
                    stateTracker=3;

                    //looks if app was cleared because of back button, if true executes back functionality
                    if (back.clickTracker==1) {
                        back.clickTracker=0;
                        stateTracker=1;
                    }
                    listening=false;
                }
            }
        }
    }

    public static void buildGenreStations() {
        //creates variables
        boolean listening = true;
        PlayButton play = new PlayButton();
        PauseButton pause = new PauseButton();
        PjRectangle type = new PjRectangle();
        RectButton next = new RectButton();
        RectButton previous = new RectButton();
        RectButton addFavorites = new RectButton();
        Font d = new Font("Orkney", Font.PLAIN, myApp.getWidth()/50);
        Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/20);
        Random rand = new Random();
        int station = 0;
        String[] genres = {"Latin", "Country", "Pop", "Rock", "Holiday", "Hip Hop", "Classical", "Electronic", "Folk", "Reggae", "Jazz", "Metal", "Oldies", "Disco", "Hindi"};

        //places play button
        play.setSize(myApp.getWidth()/16, myApp.getHeight()/8);
        play.setText("Play");
        play.setFont(d);
        play.setLocation(myApp.getWidth()/2+(play.getWidth()/2), myApp.getHeight()/2+play.getHeight()*2);
        myApp.add(play);

        //places pause button
        pause.setSize(myApp.getWidth()/16, myApp.getHeight()/8);
        pause.setText("Pause");
        pause.setFont(d);
        pause.setLocation((myApp.getWidth()/2)-(play.getWidth())-play.getWidth()/2, myApp.getHeight()/2+play.getHeight()*2);
        myApp.add(pause);

        //places next button
        next.setSize(myApp.getWidth()/6, myApp.getHeight()/16);
        next.setText("Next Station");
        next.setFont(d);
        next.setLocation(myApp.getWidth()/2+(play.getWidth()/2), (myApp.getHeight()/2)+next.getHeight());
        myApp.add(next);

        //places previous button
        previous.setSize(myApp.getWidth()/6, myApp.getHeight()/16);
        previous.setText("Previous Station");
        previous.setFont(d);
        previous.setLocation((myApp.getWidth()/2)-previous.getWidth()-previous.getWidth()/5, (myApp.getHeight()/2)+previous.getHeight());
        myApp.add(previous);

        //places addFavorites button
        addFavorites.setSize(myApp.getWidth() / 6, myApp.getHeight() / 16);
        addFavorites.setText("Add to Favorites");
        addFavorites.setFont(d);
        addFavorites.setLocation(myApp.getWidth()-addFavorites.getWidth()-addFavorites.getHeight()/2, addFavorites.getHeight()/2);
        myApp.add(addFavorites);

        //selects which radio array to play based off of button pressed and starts media player
        for (int m=0; m<genreStations.length; m++) {
            if (buttonPressed==m) {
                station=m;
            }
        }

        //creates randStation
        int randStation=rand.nextInt(genreStations[station].length);

        //gets radio playing random station
        try {
            hora.setURI(genreStations[station][randStation]);
            hora.setMute(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //adds type of station
        type.setText(genres[station]);
        type.setFontColor(Color.white);
        type.setFont(c);
        type.setSize(myApp.getWidth()/2,myApp.getHeight()/5);
        type.setLocation(myApp.getWidth()/2-type.getWidth()/2, myApp.getHeight()/10);
        type.setBackground(myApp.getBackground());
        myApp.add(type);

        //starts media player and sets pause, play, previous and next buttons
        while (listening){
            PjUtils.sleep(100);

            //play/pause button listeners
            if (pause.clickTracker==1){
                hora.setMute(true);
                pause.clickTracker=0;
            }
            if (play.clickTracker==1){
                hora.setMute(false);
                play.clickTracker=0;
            }
            if (next.clickTracker==1){
                randStation += 1;
                if (randStation>genreStations[station].length-1){
                    randStation = 0;
                }
                try {
                    hora.setURI(genreStations[station][randStation]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                next.clickTracker=0;
            }
            if (previous.clickTracker==1){
                randStation -= 1;
                if (randStation<0){
                    randStation = genreStations[station].length-1;
                }
                try {
                    hora.setURI(genreStations[station][randStation]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                previous.clickTracker=0;
            }

            //looks to see if the add to favorites button has been clicked
            if (addFavorites.clickTracker==1) {
                ForFiles favoriteDoc = new ForFiles();
                favoriteDoc.addURI(hora.getURI());
                addFavorites.clickTracker=0;
            }

            //looks if app was cleared because of back button, if true executes back functionality
            if (back.clickTracker==1) {
                back.clickTracker=0;
                myApp.remove(pause);
                myApp.remove(play);
                myApp.remove(previous);
                myApp.remove(next);
                myApp.remove(type);
                myApp.remove(addFavorites);
                hora.setMute(true);
                stateTracker=2;
                buttonPressed=2;
                listening=false;
            }
        }
    }

    public static void buildFavorite() {

        ForFiles favoriteGeneration = new ForFiles();
        favoriteGeneration.initializeFavorites();

        //creates variables
        boolean listening = true;
        PlayButton play = new PlayButton();
        PauseButton pause = new PauseButton();
        PjRectangle type = new PjRectangle();
        RectButton next = new RectButton();
        RectButton previous = new RectButton();
        Font d = new Font("Orkney", Font.PLAIN, 25);
        Font c = new Font("Orkney", Font.PLAIN, 95);
        Random rand = new Random();
        int station = 0;
        int randStation = rand.nextInt(favoriteGeneration.stationArray().length);

        //places play button
        play.setSize(myApp.getWidth() / 16, myApp.getHeight() / 8);
        play.setText("Play");
        play.setFont(d);
        play.setLocation(myApp.getWidth() / 2 + (play.getWidth() / 2), myApp.getHeight() / 2 + play.getHeight() * 2);
        myApp.add(play);

        //places pause button
        pause.setSize(myApp.getWidth() / 16, myApp.getHeight() / 8);
        pause.setText("Pause");
        pause.setFont(d);
        pause.setLocation((myApp.getWidth() / 2) - (play.getWidth()) - play.getWidth() / 2, myApp.getHeight() / 2 + play.getHeight() * 2);
        myApp.add(pause);

        //places next button
        next.setSize(myApp.getWidth() / 6, myApp.getHeight() / 16);
        next.setText("Next Station");
        next.setFont(d);
        next.setLocation(myApp.getWidth() / 2 + (play.getWidth() / 2), (myApp.getHeight() / 2) + next.getHeight());
        myApp.add(next);

        //places previous button
        previous.setSize(myApp.getWidth() / 6, myApp.getHeight() / 16);
        previous.setText("Previous Station");
        previous.setFont(d);
        previous.setLocation((myApp.getWidth() / 2) - previous.getWidth() - previous.getWidth() / 5, (myApp.getHeight() / 2) + previous.getHeight());
        myApp.add(previous);

        if (favoriteGeneration.stationsContained()==0) {
            //placeholder for empty array conditions
        }
        else {
            try {
                int a = rand.nextInt(favoriteGeneration.stationArray().length);
                hora.setURI(favoriteGeneration.stationArray()[a]);
                hora.setMute(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while (listening) {
            PjUtils.sleep(100);

            //play/pause button listeners
            if (pause.clickTracker == 1) {
                hora.setMute(true);
                pause.clickTracker = 0;
            }
            if (play.clickTracker == 1) {
                hora.setMute(false);
                play.clickTracker = 0;
            }
            if (next.clickTracker == 1) {
                randStation += 1;
                if (randStation > emotionStations[station].length - 1) {
                    randStation = 0;
                }
                try {
                    hora.setURI(emotionStations[station][randStation]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                next.clickTracker = 0;
            }
            if (previous.clickTracker == 1) {
                randStation -= 1;
                if (randStation < 0) {
                    randStation = emotionStations[station].length - 1;
                }
                try {
                    hora.setURI(emotionStations[station][randStation]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                previous.clickTracker = 0;
            }

            //looks if app was cleared because of back button, if true executes back functionality
            if (back.clickTracker == 1) {
                back.clickTracker = 0;
                myApp.remove(pause);
                myApp.remove(play);
                myApp.remove(previous);
                myApp.remove(next);
                myApp.remove(type);
                hora.setMute(true);
                stateTracker = 1;
                buttonPressed = 0;
                listening = false;
            }
        }

    }

    public static void favoriteList() {
        //reads the existing favorties list from .txt file and adds them to a String[] to be read by builder
        String[] favoritesStations = new String[10];
        ForFiles favoritesText = new ForFiles();

        favoritesText.initializeFavorites();
    }

    //streamlined way to take RGB colors and make them HSB
    public static Color RGBtoHSB(int r, int g, int b) {
        float[] HSB = new float[3];
        Color.RGBtoHSB(r, g, b, HSB);
        Color returned = Color.getHSBColor(HSB[0], HSB[1], HSB[2]);
        return returned;
    }

    //creates back button
    public static void backButton() {

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/55);

        //sets up and places back button
        back.setText("Back");
        back.setFont(c);
        back.setFontColor(Color.black);
        back.setSize(myApp.getWidth()/20, myApp.getHeight()/25);
        myApp.add(back).setLocation(12, myApp.getHeight()-back.getHeight()-back.getHeight()/4);
    }

    //creates quit button
    public static void quitButton() {

        //object creation
        QuitButton quit = new QuitButton();

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, myApp.getWidth()/55);

        //sets up and places quit button
        quit.setText("Quit");
        quit.setFont(c);
        quit.setFontColor(Color.black);
        quit.setSize(myApp.getWidth()/20, myApp.getHeight()/25);
        myApp.add(quit).setLocation(myApp.getWidth()-quit.getWidth()-quit.getWidth()/4, myApp.getHeight()-quit.getHeight()-quit.getHeight()/4);

    }

}
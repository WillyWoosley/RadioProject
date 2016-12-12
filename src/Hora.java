import com.pumaj.*;
import org.w3c.dom.css.Rect;
import org.w3c.dom.events.MouseEvent;
import com.giavaneers.gui.elements.embedded.GvIMediaPlayer;
import com.giavaneers.gui.elements.embedded.GvVLCMediaPlayer;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;

/**
 * Created by wdwoo on 12/1/2016.
 */
//NEEDED CHANGES/LIST OF PLACEHOLDERS
//need to change text heights so they will change with the window size
//
//need to insert real logo, see how that works in regards to variable dependencies
//
//need to adjust app window so it fits regardless of what side the taskbar is on (series of if statements, seeing if
//windowSize-taskbarSize==windowSize
//
//get images to put on buttons
//
//better colors for everything
//
//replace square buttons with something more visually appealing


public class Hora {

    //sets up app to be used for all of Hora
    protected static PjApplication myApp = new PjApplication();
    protected static int buttonPressed;
    protected static final int logoWidth = 588, logoHeight = 238;
    protected static final int miniLogoWidth = 70, miniLogoHeight = 100;


    public static void main(String[] args) {

        //object which will allow you to get the screensize of whatever device program is running in
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int taskbarHeight = screenSize.height-GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;

        //sets up app
        myApp.setBackground(RGBtoHSB(1,1,20));
        myApp.setVisible(true);
        myApp.setLayout(null);
        myApp.setWidth(screenSize.width);
        myApp.setHeight(screenSize.height-taskbarHeight);
        myApp.setLocation(0, 0);

        //adds back button
        backButton();

        //adds quit button
        quitButton();

        //generates opening screen
        openingScreen();

        //generates category selection screen
        buildCategory();


        if (buttonPressed==0) {
            buildEmotion();
        }

        else if (buttonPressed==1) {
            buildSituation();
        }

        else if (buttonPressed==2) {
            buildGenre();
        }

        else {
            //insert favorites
            //
            //placeholder to confirm button is working
            System.out.println("3");
        }
    }

    public static void openingScreen() {

        //shape creation
        PjRectangle logo = new PjRectangle();
        RectButton enter = new RectButton();

        //variables
        boolean listening = true;
        String logoPath = "/Users/Christoph/Desktop/RadioProjec/Assets/Images/Hora.png";

        //sets up logo with image, size, and location
        logo.setSize(logoWidth, logoHeight);
        logo.setLocation(myApp.getWidth()/2-logo.getWidth()/2, myApp.getHeight()/2-logo.getHeight());
        logo.setImage(logoPath);
        logo.setBackground(Color.yellow);
        myApp.add(logo);

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, 18);

        //sets up enter button with text, size, and location
        enter.setSize(logoWidth-logoWidth/10, logoHeight/5);
        enter.setText("Listening Has Never Been Easier");
        enter.setFont(c);
        enter.setFontSize(28);
        enter.setFontColor(Color.black);
        myApp.add(enter).setLocation(logo.getX()+logoWidth/20, logo.getY()+logoHeight+logoHeight/6);

        //plays intro sound file
        PjUtils.playSoundFile("/Users/Christoph/Desktop/RadioProjec/Assets/Sounds/Intro_Sound.wav");

        //waits to execute when shape clicked; really hogs CPU for what it does, needs optimization
        while(listening) {
            if (enter.clickTracker==1) {
                enter.clickTracker=0;
                listening = false;
                myApp.remove(enter);
                myApp.remove(logo);
            }
            PjUtils.sleep(500);
        }

    }

    public static void buildCategory() {

        //variable creation
        String logoPath = "/Users/Christoph/Desktop/RadioProjec/Assets/Images/Hora.png";
        PjRectangle logo = new PjRectangle();
        RectButton[] buttons = new RectButton[4];
        boolean listening = true;

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, 18);

        //places logo
        logo.setSize(logoWidth, logoHeight);
        logo.setLocation(myApp.getWidth()/2-logo.getWidth()/2, myApp.getHeight()/20);
        logo.setBackground(Color.yellow);
        logo.setImage(logoPath);
        myApp.add(logo);

        //fills array of buttons
        for (int i=0; i<4; i++) {
            buttons[i] = new RectButton();
            buttons[i].setSize(logoWidth-logoWidth/8, logoHeight/4);
            buttons[i].setFont(c);
            buttons[i].setFontColor(Color.black);
            myApp.add(buttons[i]);
            if (i==0) {
                buttons[i].setLocation(logo.getX()+logo.getWidth()/16, logo.getY()+logo.getHeight()+buttons[i].getHeight()/2);
                buttons[i].setText("Emotion");
            }
            else if (i==1) {
                buttons[i].setLocation(logo.getX()+logo.getWidth()/16, buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/2);
                buttons[i].setText("Situation");
            }
            else if (i==2) {
                buttons[i].setLocation(logo.getX()+logo.getWidth()/16, buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/2);
                buttons[i].setText("Genre");
            }
            else {
                buttons[i].setLocation(logo.getX()+logo.getWidth()/16, buttons[i-1].getY()+buttons[i-1].getHeight()+buttons[i].getHeight()/2);
                buttons[i].setText("Favorites");
            }
        }

        //doesn't work yet, can also be made more efficient
        while (listening) {
            for (int i=0; i<4; i++) {
                if (buttons[i].clickTracker==1) {
                    buttonPressed=i;
                    //clears app
                    for (int j=0; j<4; j++) {
                        myApp.remove(buttons[j]);
                    }
                    myApp.remove(logo);
                    listening=false;
                }
            }
            PjUtils.sleep(500);
        }
    }

    public static void buildEmotion() {
        //variable creation
        PjRectangle miniLogo = new PjRectangle();
        String miniLogoPath = "/Users/Christoph/Desktop/RadioProjec/Assets/Images/horalogo.png";
        PjRectangle emotionText = new PjRectangle();
        RectButton[] buttons = new RectButton[6];
        String[] emotions = {"Happy", "Sad", "Angry", "Relaxed", "Excited", "Tired"};
        boolean listening = true;

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, 100);
        Font d = new Font("Orkney", Font.PLAIN, 25);

        //places text
        emotionText.setText("Emotions:");
        emotionText.setFontColor(Color.white);
        emotionText.setFont(c);
        emotionText.setSize(logoWidth, logoHeight/2);
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
            buttons[i].setSize(logoWidth-logoWidth/8, logoHeight/2);
            buttons[i].setText(emotions[i]);
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
                if (buttons[i].clickTracker==1) {
                    //doesn't do anything yet
                    buttonPressed=i;
                    //clears app
                    for (int j=0; j<6; j++) {
                        myApp.remove(buttons[j]);
                    }
                    myApp.remove(emotionText);
                    listening=false;
                }
            }
        }
    }

    public static void buildSituation() {
        //variable creation
        PjRectangle miniLogo = new PjRectangle();
        String miniLogoPath = "/Users/Christoph/Desktop/RadioProjec/Assets/Images/horalogo.png";
        PjRectangle situationText = new PjRectangle();
        RectButton[] buttons = new RectButton[6];
        String[] situations = {"Party", "Roadtrip", "Gym", "Date", "Stargazing", "Beach"};
        boolean listening = true;

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, 100);
        Font d = new Font("Orkney", Font.PLAIN, 25);

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
            buttons[i].setSize(logoWidth-logoWidth/8, logoHeight/2);
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
                if (buttons[i].clickTracker==1) {
                    //doesn't do anything yet
                    buttonPressed=i;
                    //clears app
                    for (int j=0; j<6; j++) {
                        myApp.remove(buttons[j]);
                    }
                    myApp.remove(situationText);
                    listening=false;
                }
            }
        }
    }

    //still needs editing so it works for genre
    public static void buildGenre() {
        //variable creation
        PjRectangle miniLogo = new PjRectangle();
        String miniLogoPath = "/Users/Christoph/Desktop/RadioProjec/Assets/Images/horalogo.png";
        PjRectangle genreText = new PjRectangle();
        RectButton[] buttons = new RectButton[12];
        boolean listening = true;
        String[] genres = {"Latin", "Rock", "Classical", "Reggae", "Holiday", "Electronic", "Jazz", "Country", "Pop", "Hip Hop", "Folk", "Metal"};

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, 100);
        Font d = new Font("Orkney", Font.PLAIN, 25);

        //places text
        genreText.setText("Genres:");
        genreText.setFontColor(Color.white);
        genreText.setFont(c);
        genreText.setSize(logoWidth, logoHeight/2);
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
        for (int i=0; i<12; i++) {


            //adds on generic button and adds text
            buttons[i] = new RectButton();
            buttons[i].setSize(logoWidth-logoWidth/8, logoHeight/2);
            buttons[i].setText(genres[i]);
            buttons[i].setFont(d);
            buttons[i].setFontColor(Color.black);
            myApp.add(buttons[i]);

            //sets button location based upon i value
            if (i<=3) {
                if (i==0) {
                    buttons[i].setLocation(myApp.getWidth()/3-buttons[i].getWidth(), myApp.getHeight()/4);
                }
                else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i].getHeight()+buttons[i].getHeight()/8);
                }
            }
            else if (i>3 && i<=7) {
               if (i==4) {
                    buttons[i].setLocation(buttons[0].getX()+buttons[i].getWidth()+buttons[i].getWidth()/8, buttons[0].getY());
               }
               else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i].getHeight()+buttons[i].getHeight()/8);
               }
            }
            else {
                if (i==8) {
                    buttons[i].setLocation(buttons[4].getX()+buttons[i].getWidth()+buttons[i].getWidth()/8, buttons[4].getY());
                }
                else {
                    buttons[i].setLocation(buttons[i-1].getX(), buttons[i-1].getY()+buttons[i].getHeight()+buttons[i].getHeight()/8);
                }
            }
        }

        //listens to see which button has been pressed
        while (listening) {
            for (int i=0; i<12; i++) {
                if (buttons[i].clickTracker==1) {
                    //doesn't do anything yet
                    buttonPressed=i;
                    //clears app
                    for (int j=0; j<12; j++) {
                        myApp.remove(buttons[j]);
                    }
                    myApp.remove(genreText);
                    listening=false;
                }
            }
        }
    }

    //streamlined way to take RGB colors and make them HSB
    public static Color RGBtoHSB(int r, int g, int b) {
        float[] HSB = new float[3];
        Color.RGBtoHSB(r, g, b, HSB);
        Color returned = Color.getHSBColor(HSB[0], HSB[1], HSB[2]);
        return returned;
    }

    //placeholder for way to clear function, doesn't work
    public static void clearGUI(PjApplication myApp) {

        myApp.removeAll();

    }

    public static void button(PjApplication myApp, int x, int y, int width, int height, String setText) {
        //need something that will adjust oval size as center varies
        //need it to actually have a border
        //need real colors rather than placeholders
        RectButton center = new RectButton();
        RectButton centerBorder = new RectButton();
        PjOval right = new PjOval();
        PjOval rightBorder = new PjOval();
        PjOval left = new PjOval();
        PjOval leftBorder = new PjOval();

        center.setLocation(x, y);
        center.setText(setText);
        center.setFontSize(center.getWidth()/4);
        center.setSize(width, height);

        centerBorder.setSize(width+width/20, height+height/20);
        centerBorder.setLocation(x-width/40, y-height/40);
        centerBorder.setBackground(Color.cyan);

        left.setLocation(center.getX()-left.getWidth()/2, center.getY());
        right.setLocation(center.getX()+center.getWidth()-right.getWidth()/2, center.getY());

        myApp.add(center);
        myApp.add(left);
        myApp.add(right);
        myApp.add(centerBorder);

    }

    //creates back button
    public static void backButton() {
        BackButton back = new BackButton();

        //creates font
        Font c = new Font("Orkney", Font.PLAIN, 20);

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
        Font c = new Font("Orkney", Font.PLAIN, 20);

        //sets up and places quit button
        quit.setText("Quit");
        quit.setFont(c);
        quit.setFontColor(Color.black);
        quit.setSize(myApp.getWidth()/20, myApp.getHeight()/25);
        myApp.add(quit).setLocation(myApp.getWidth()-quit.getWidth()-quit.getWidth()/4, myApp.getHeight()-quit.getHeight()-quit.getHeight()/4);

    }

}
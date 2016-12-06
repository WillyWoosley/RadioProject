import com.pumaj.*;
import org.w3c.dom.css.Rect;

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


public class Hora {

    //sets up app to be used for all of Hora
    protected static PjApplication myApp = new PjApplication();

    public static void main(String[] args) {

        //object which will allow you to get the screensize of whatever device program is running in
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int taskbarHeight = screenSize.height-GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;

        //sets up app
        myApp.setBackground(RGBtoHSB(240, 248, 255));
        myApp.setVisible(true);
        myApp.setLayout(null);
        myApp.setWidth(screenSize.width);
        myApp.setHeight(screenSize.height-taskbarHeight);
        myApp.setLocation(0, 0);

        //adds quit button
        quitButton();

        //runs openingScreen
        openingScreen();

        //runs buildInterface(doesn't work yet)
        buildInterface();

    }

    public static void openingScreen() {

        //shape creation
        PjRectangle logo = new PjRectangle();
        RectButton enter = new RectButton();

        //variables
        int logoWidth = myApp.getWidth()/4, logoHeight = logoWidth * 2/3; //placeholder sizes until we get ratio fo actual logo to work with IMPORTANT TO CHANGE
        boolean listening = true;
        String logoPath = "/assets/images/placeholder.png";

        //sets up logo with image, size, and location
        logo.setSize(logoWidth, logoHeight);
        logo.setLocation(myApp.getWidth()/2-logo.getWidth()/2, myApp.getHeight()/2-logo.getHeight());
        logo.setImage(logoPath);
        logo.setBackground(RGBtoHSB(240, 248, 255));
        myApp.add(logo);

        //sets up enter button with text, size, and location
        enter.setSize(logoWidth-logoWidth/10, logoHeight/5);
        enter.setText("Click here to begin...");
        enter.setFontSize(32);
        enter.setFontColor(Color.white);
        myApp.add(enter).setLocation(logo.getX()+logoWidth/20, logo.getY()+logoHeight+logoHeight/6);

        //waits to execute when shape clicked; really hogs CPU for what it does, needs optimization
        while(listening) {
            if (enter.clickTracker==1) {
                enter.clickTracker=0;
                listening = false;
                myApp.remove(enter);
                myApp.remove(logo);
            }
            PjUtils.sleep(1000);
        }

    }

    public static void buildInterface() {

        //places logo
        String logoPath = "/assets/images/placeholder.png";
        RectButton logo = new RectButton();
        logo.setSize(600, 400);
        logo.setLocation(myApp.getWidth()/2-logo.getWidth()/2, 25);
        logo.setImage(logoPath);
        myApp.add(logo);

        //creates array of buttons
        RectButton[] buttons = new RectButton[4];
        for (int i=0; i<4; i++) {
            buttons[i] = new RectButton();
            myApp.add(buttons[i]);
            if (i==0) {
                buttons[i].setLocation(20, 20);
                buttons[i].setText("Emotion");
            }
            if (i==1) {
                buttons[i].setLocation(200, 213);
            }
            if (i==2) {
                buttons[i].setLocation(900, 900);
            }
            if (i==3) {
                buttons[i].setLocation(324, 213);
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

    //creates quit button
    public static void quitButton() {
        RectButton quit = new RectButton();
        quit.setText("Quit");
        quit.setFontSize(30);
        quit.setFontColor(Color.white);
        quit.setSize(myApp.getWidth()/20, myApp.getHeight()/25);
        myApp.add(quit).setLocation(myApp.getWidth()-quit.getWidth()-quit.getWidth()/4, myApp.getHeight()-quit.getHeight()-quit.getHeight()/4);
    }

}
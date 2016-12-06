import com.pumaj.*;
import org.w3c.dom.css.Rect;

import java.awt.*;

/**
 * Created by wdwoo on 12/1/2016.
 */
public class Hora {

    //sets up app to be used for all of Hora
    protected static PjApplication myApp = new PjApplication();

    public static void main(String[] args) {

        //object which will allow you to get the screensize of whatever device program is running in
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //sets up app
        myApp.setBackground(RGBtoHSB(240, 248, 255));
        myApp.setVisible(true);
        myApp.setLayout(null);
        myApp.setWidth((int) screenSize.getWidth());
        myApp.setHeight((int) screenSize.getHeight());
        myApp.setLocation(0, 0);

        //runs openingScreen
        openingScreen();

    }

    public static void openingScreen() {

        //shape creation
        PjRectangle logo = new PjRectangle();
        RectButton enter = new RectButton();

        //variables
        int logoWidth = 600, logoHeight = 400; //placeholder sizes until we get ratio fo actual logo to work with IMPORTANT TO CHANGE
        boolean listening = true;
        String logoPath = "/assets/images/placeholder.png";

        //sets up logo with image, size, and location
        logo.setSize(logoWidth, logoHeight);
        logo.setLocation(myApp.getWidth()/2-logo.getWidth()/2, myApp.getHeight()/2-logo.getHeight());
        logo.setImage(logoPath);
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
                System.out.println("it worked");
                enter.clickTracker=0;
                listening = false;
            }
            PjUtils.sleep(1000);
        }

    }

    public static void buildInterface() {

        //sets colors
        float[] backgroundRGB = new float[3];
        Color.RGBtoHSB(240, 248, 255, backgroundRGB);
        //myApp.setBackground(Color.getHSBColor(backgroundRGB[0], backgroundRGB[1], backgroundRGB[2]));
        myApp.setBackground(RGBtoHSB(240, 248, 255));

        //places logo
        String logoPath = "/assets/images/placeholder.png";
        RectButton logo = new RectButton();
        logo.setSize(600, 400);
        logo.setLocation(myApp.getWidth()/2-logo.getWidth()/2, 25);
        logo.setImage(logoPath);
        myApp.add(logo);

        //adds buttons
        RectButton emotion = new RectButton();
        emotion.setText("emotion");
        emotion.setFontSize(40);
        emotion.setSize(500, 200);
        myApp.add(emotion).setLocation(500, 500);


    }

    public static void test() {

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

}
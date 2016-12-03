import com.pumaj.PjApplication;

import java.awt.*;

/**
 * Created by wdwoo on 12/1/2016.
 */
public class Hora {
    public static void main(String[] args) {
        buildInterface();
    }

    public static void buildInterface() {

        //object which will allow you to get the screensize of whatever device program is running in
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //sets up app
        PjApplication myApp = new PjApplication();
        myApp.setVisible(true);
        myApp.setLayout(null);
        myApp.setWidth((int) screenSize.getWidth());
        myApp.setHeight((int) screenSize.getHeight());
        myApp.setLocation(0, 0);

        //sets colors
        float[] backgroundRGB = new float[3];
        Color.RGBtoHSB(240, 248, 255, backgroundRGB);
        Color background = Color.getHSBColor(backgroundRGB[0], backgroundRGB[1], backgroundRGB[2]);
        myApp.setBackground(background);

        //places logo
        String logoPath = "/assets/images/placeholder.png";
        RectButton logo = new RectButton();
        logo.setSize(600, 400);
        logo.setLocation(myApp.getWidth()/2-logo.getWidth()/2, 25);
        logo.setImage(logoPath);
        myApp.add(logo);

        //adds buttons
        SmoothButton emotion = new SmoothButton();
        emotion.setText("emotion");
        emotion.setFontSize(40);
        emotion.setSize(500, 200);
        myApp.add(emotion).setLocation(500, 500);



    }

}
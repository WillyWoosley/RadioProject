import com.pumaj.PjIRectangle;
import com.pumaj.PjRectangle;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by wdwoo on 12/1/2016.
 */
public class RectButton extends PjRectangle implements PjIRectangle {
    public int clickTracker;
    public RectButton() {
        super();
    }

    public void initialize() {
        super.initialize();
        setOpaque(true);
        setBackground(RGBtoHSB(255,0,128));
    }

    public void mouseClicked(MouseEvent e) {
        clickTracker=1;

    }

    public void mouseEntered(MouseEvent e) {
        setBackground(RGBtoHSB(179,0,90));
    }

    public void mouseExited(MouseEvent e) {
        setBackground(RGBtoHSB(255,0,128));
    }

    public static Color RGBtoHSB(int r, int g, int b) {
        float[] HSB = new float[3];
        Color.RGBtoHSB(r, g, b, HSB);
        Color returned = Color.getHSBColor(HSB[0], HSB[1], HSB[2]);
        return returned;
    }

}

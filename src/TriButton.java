import com.pumaj.PjITriangle;
import com.pumaj.PjTriangle;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Christoph on 12/12/16.
 */
public class TriButton extends PjTriangle implements PjITriangle {
    public int clickTracker;
    public TriButton() {
        super();
    }

    public void initialize() {
        super.initialize();
        setOpaque(true);
        setBackground(RGBtoHSB(0,255,0));
    }

    public void mouseClicked(MouseEvent e) {
        clickTracker=1;
    }

    public void mouseEntered(MouseEvent e) {
        setBackground(RGBtoHSB(0,179,0));
    }

    public void mouseExited(MouseEvent e) {
        setBackground(RGBtoHSB(0,255,0));
    }

    public static Color RGBtoHSB(int r, int g, int b) {
        float[] HSB = new float[3];
        Color.RGBtoHSB(r, g, b, HSB);
        Color returned = Color.getHSBColor(HSB[0], HSB[1], HSB[2]);
        return returned;
    }

}


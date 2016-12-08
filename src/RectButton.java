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
        setBackground(RGBtoHSB(135,206,235));
    }

    public void mouseClicked(MouseEvent e) {
        clickTracker=1;

    }

    public void mouseEntered(MouseEvent e) {
        setBackground(RGBtoHSB(0,191,255));
    }

    public void mouseExited(MouseEvent e) {
        setBackground(RGBtoHSB(135,206,235));
    }

    public static Color RGBtoHSB(int r, int g, int b) {
        float[] HSB = new float[3];
        Color.RGBtoHSB(r, g, b, HSB);
        Color returned = Color.getHSBColor(HSB[0], HSB[1], HSB[2]);
        return returned;
    }

}

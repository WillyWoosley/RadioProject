import java.awt.event.MouseEvent;

/**
 * Created by Christoph on 12/14/16.
 */
public class PlayButton extends RectButton {
    public PlayButton() {
        super();
    }

    public void initialize() {
        super.initialize();
        setOpaque(true);
        setBackground(RGBtoHSB(0, 255, 0));
    }

    public void mouseClicked(MouseEvent e) {
        clickTracker=1;
    }

    public void mouseEntered(MouseEvent e) {
        setBackground(RGBtoHSB(0, 190, 0));
    }

    public void mouseExited(MouseEvent e) {
        setBackground(RGBtoHSB(0, 255, 0));
    }

}

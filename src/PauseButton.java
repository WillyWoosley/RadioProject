import java.awt.event.MouseEvent;
import javax.sound.sampled.*;

/**
 * Created by Christoph on 12/12/16.
 */
public class PauseButton extends RectButton {
    public PauseButton() {
    super();
    }

    public void initialize() {
        super.initialize();
        setOpaque(true);
        setBackground(RGBtoHSB(255, 0, 0));
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        setBackground(RGBtoHSB(210, 0, 0));
    }

    public void mouseExited(MouseEvent e) {
        setBackground(RGBtoHSB(255, 0, 0));
    }

}


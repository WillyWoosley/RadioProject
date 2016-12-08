import java.awt.event.MouseEvent;

/**
 * Created by wdwoo on 12/8/2016.
 */
public class QuitButton extends RectButton {
    public QuitButton() {
        super();
    }

    public void initialize() {
        super.initialize();
        setOpaque(true);
        setBackground(RGBtoHSB(220, 0, 0));
    }

    public void mouseClicked(MouseEvent e) {
        System.exit(1);
    }

    public void mouseEntered(MouseEvent e) {
        setBackground(RGBtoHSB(255, 0, 0));
    }

    public void mouseExited(MouseEvent e) {
        setBackground(RGBtoHSB(220, 0, 0));
    }

}

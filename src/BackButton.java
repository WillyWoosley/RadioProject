import java.awt.event.MouseEvent;

/**
 * Created by Christoph on 12/11/16.
 */
public class BackButton extends RectButton {
    public BackButton() {
        super();
    }

    public void initialize() {
        super.initialize();
        setOpaque(true);
        setBackground(RGBtoHSB(230, 0, 230));
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("back");
        //we need to add what it does here
    }

    public void mouseEntered(MouseEvent e) {
        setBackground(RGBtoHSB(150, 0, 150));
    }

    public void mouseExited(MouseEvent e) {
        setBackground(RGBtoHSB(230, 0, 230));
    }
}





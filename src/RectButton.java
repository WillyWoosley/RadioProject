import com.pumaj.PjIRectangle;
import com.pumaj.PjRectangle;
import com.pumaj.PjUtils;

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
        setBackground(Color.red);
    }

    public void mouseClicked(MouseEvent e) {
        clickTracker=1;

    }

    public void mouseEntered(MouseEvent e) {
        setBackground(Color.green);
    }

    public void mouseExited(MouseEvent e) {
        setBackground(Color.red);
    }

}

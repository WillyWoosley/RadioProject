import com.pumaj.PjIRectangle;
import com.pumaj.PjRectangle;
import com.pumaj.PjUtils;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by wdwoo on 12/2/2016.
 */
public class SmoothButton extends PjRectangle {
    public SmoothButton() {
        super();
    }

    public void initialize() {
        super.initialize();
        setOpaque(true);
        setBackground(Color.red);
    }

    public void mouseEntered(MouseEvent e) {
        setBackground(Color.green);
    }

    public void mouseExited(MouseEvent e) {
        setBackground(Color.red);
    }

    public static PjIRectangle newComponentInstance()
    {
        return(newComponentInstance(null, null));
    }

    public static PjIRectangle newComponentInstance(
            String alias) {
        return (newComponentInstance(alias, null));
    }

    public static PjIRectangle newComponentInstance(
            String componentName,
            String hostname) {
        PjIRectangle remoteApp =
                (PjIRectangle) PjUtils.newComponentInstance(
                        PjRectangle.class.getName(), componentName, hostname);

        return (remoteApp);
    }
}

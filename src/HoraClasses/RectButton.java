import com.pumaj.PjIRectangle;
import com.pumaj.PjRectangle;
import com.pumaj.PjUtils;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by wdwoo on 12/1/2016.
 */
public class RectButton extends ClickableShape implements PjIRectangle {
    public RectButton() {
        super();
    }

    public void initialize() {
        super.initialize();
        setOpaque(true);
        setBackground(Color.red);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("clicked me");
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

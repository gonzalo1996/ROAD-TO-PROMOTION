package events;

import java.awt.*;
import java.awt.event.KeyEvent;

public class EventMovement extends KeyEvent {

    public EventMovement(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
        super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
    }

    public EventMovement(Component source, int id, long when, int modifiers, int keyCode, char keyChar) {
        super(source, id, when, modifiers, keyCode, keyChar);
    }


}

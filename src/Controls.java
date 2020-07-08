import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Controls implements KeyboardHandler {

    private Keyboard keyboard;
    private Player player;

    public void init() {

        keyboard = new Keyboard(this);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressedRight);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressedDown);

        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressedSpace);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                player.moveControllerLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.moveControllerRight();
                break;
            case KeyboardEvent.KEY_SPACE:
                player.playThisLine();
                break;
            case KeyboardEvent.KEY_DOWN:
                player.playThisLine();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setPlayer(Player player){
        this.player = player;
    }


}

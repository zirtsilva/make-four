import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Controller {

    int playerNumber;
    int currentPosition;
    Picture controllerPicture;
    boolean canMove = false;


    Controller(int playerNumber) {

        this.playerNumber = playerNumber;
        currentPosition = 4;
        if (playerNumber == 1) {
            Picture controller1 = new Picture(Constants.PADDING + 380, Constants.PADDING, Constants.YELLOW_PIECE_SOURCE);
            controllerPicture = controller1;
        }

        if (playerNumber == 2) {
            Picture controller2 = new Picture(Constants.PADDING + 380, Constants.PADDING, Constants.RED_PIECE_SOURCE);
            controllerPicture = controller2;
        }
    }


    public void moveLeft() {
        if (currentPosition > 1 && canMove) {
            controllerPicture.translate(-120, 0);
            currentPosition--;
        }
    }

    public void moveRight() {
        if (currentPosition < 7 && canMove) {
            controllerPicture.translate(120, 0);
            currentPosition++;
        }
    }

    public void startRound() {
        controllerPicture.draw();
        canMove = true;
    }

    public void hide() {
        controllerPicture.delete();
        canMove = false;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }



}

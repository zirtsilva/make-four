import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DrawPlay implements Runnable{

    private int playedPosition;
    private int playerNumber;
    private int toMove;
    Picture picture;
    Background background;


    public DrawPlay (int playedPosition, int playerNumber, int toMove, Picture picture, Background background){

        this.playedPosition = playedPosition;
        this.playerNumber = playerNumber;
        this.toMove = toMove;
        this.picture = picture;
        this.background = background;

    }


    @Override
    public synchronized void run() {

        Piece piece = new Piece(((playedPosition - 1) * 120) + 20 + Constants.PADDING, 20, playerNumber);
        picture = piece.getPicture();
        picture.draw();
        background.getBackground().delete();
        background.getBackground().draw();

        for (int i = 0; i < 110 + toMove * 110; i++) {

            try {
                Thread.sleep(1);
                picture.translate(0, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < (toMove*10); i++){
            try {
                Thread.sleep(1);
                picture.translate(0, -1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < (toMove*10); i++){
            try {
                Thread.sleep(1);
                picture.translate(0, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

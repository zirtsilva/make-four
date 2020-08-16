import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DrawPlay implements Runnable{


    private int playedPosition;
    private int playerNumber;
    private int toMove;
    Picture picture;

    public DrawPlay (int playedPosition, int playerNumber, int toMove, Picture picture){

        this.playedPosition = playedPosition;
        this.playerNumber = playerNumber;
        this.toMove = toMove;
        this.picture = picture;

    }

    @Override
    public synchronized void run() {

        Piece piece = new Piece(((playedPosition - 1) * 120) + 20 + Constants.PADDING, 20, playerNumber);
        picture = piece.getPicture();
        picture.draw();

        for (int i = 0; i < 110 + toMove * 110; i++) {

            try {
                Thread.sleep(1);
                picture.translate(0, 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

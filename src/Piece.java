import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Piece {

    private String player;
    private String color1Path = "resources/yellowPiece.png";
    private String color2Path = "resources/redPiece.png";
    Picture picture;

    Piece(double posX, double posY, int player){
        if (player == 1){
            this.player = color1Path;
        }
        if (player == 2){
            this.player = color2Path;
        }

        Picture picture = new Picture(posX, posY, this.player);
        picture.draw();
        this.picture = picture;

    }

    public Picture getPicture(){
        return picture;
    }

}

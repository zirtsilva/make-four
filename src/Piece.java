import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Piece {

    private String player;

    private String color1Path = "resources/redPiece.png";
    private String color2Path = "resources/yellowPiece.png";

    Piece(int player){
        if (player == 1){
            this.player = color1Path;
        }
        if (player == 2){
            this.player = color2Path;
        }

        Picture piece = new Picture(10, 10, this.player);

    }

}

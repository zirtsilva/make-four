import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    public Background(){

        Picture top = new Picture(Constants.PADDING, Constants.PADDING, "resources/top.png");
        top.draw();

        Picture background = new Picture(Constants.PADDING, Constants.PADDING + Constants.TOP_SIZE, "resources/background.png");
        background.draw();

    }

}

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    Picture back;
    Picture top;
    Picture background;

    public Background(){

        back = new Picture(Constants.PADDING, Constants.PADDING + Constants.TOP_SIZE, "resources/back.png");
        back.draw();

        top = new Picture(Constants.PADDING, Constants.PADDING, "resources/top.png");
        top.draw();

        background = new Picture(Constants.PADDING, Constants.PADDING + Constants.TOP_SIZE, "resources/background.png");
        background.draw();

    }

    public Picture getBackground() {
        return background;
    }
}

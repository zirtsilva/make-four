import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DrawRestartScreen implements Runnable {



    @Override
    public void run() {

        Picture picture = new Picture(100, 100 , "resources/restartScreen.png");

        try {
            Thread.sleep(2500);
            picture.draw();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}

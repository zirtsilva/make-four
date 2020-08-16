import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DrawVerticalLine implements Runnable {

    int x;
    int y;

    DrawVerticalLine(int i, int j){

        x = 10 + 70 - 5 + j * 120;
        y = 10 + 170 + i * 110;

    }

    @Override
    public void run() {

        Picture line = new Picture(x, y, "resources/verticalLine.png");
        Picture restart = new Picture(200, 350, "resources/restartScreen.png");

        try {

            Thread.sleep(500);
            line.draw();
            Thread.sleep(250);
            line.delete();
            Thread.sleep(250);
            line.draw();
            Thread.sleep(250);
            line.delete();
            Thread.sleep(250);
            line.draw();
            Thread.sleep(250);
            line.delete();
            Thread.sleep(250);
            line.draw();
            Thread.sleep(250);
            line.delete();
            Thread.sleep(250);
            line.draw();
            restart.draw();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameEngine {

    Player player1;
    Player player2;
    Player currentPlayer;
    Controls controls;
    Grid grid;
    int[][] positions;
    int winner;
    Background background;
    Controller controller1;
    Controller controller2;
    ExecutorService cachedPool;


    public void init() {

        background = new Background();

        grid = new Grid(background);

        controller1 = new Controller(1);
        Player player1 = new Player(controller1, 1);
        player1.setGameEngine(this);

        controller2 = new Controller(2);
        Player player2 = new Player(controller2, 2);
        player2.setGameEngine(this);

        player1.setOtherPlayer(player2);
        player2.setOtherPlayer(player1);

        controls = new Controls();
        controls.init();
        controls.setGameEngine(this);

        this.player1 = player1;
        this.player2 = player2;

        cachedPool = Executors.newCachedThreadPool();

    }

    public void startGame(){
        playRound(player1);
    }

    public void playRound(Player player) {

        currentPlayer = player;
        controls.setPlayer(player);
        if (checkIfThereIsAWinner()) {
            endGame();
        } else if (checkIfThereIsADraw()){
            Picture draw = new Picture(10, 10, "resources/draw.png");
            Picture restart = new Picture(200, 350, "resources/restartScreen.png");
            draw.draw();
            restart.draw();
        } else {
            player.startRound();
        }
    }

    public void setPlay(int playerNumber, int playedPosition) {
        grid.setPlay(playerNumber, playedPosition);
    }

    public boolean playedPositionIsFree(int currentPosition){

        return grid.playedPositionIsFree(currentPosition);

    }

    public boolean  checkIfThereIsAWinner() {

        positions = grid.getPositions();

        //check horizontally
        for (int i = 0; i <= 5; i++){
            for (int j = 0; j <= 3; j++){
                if ((positions[i][j] != 0) && (positions[i][j] == positions[i][j+1]) && (positions[i][j] == positions[i][j+2]) && (positions[i][j] == positions[i][j+3])){
                    System.out.println("Winner: Player " + positions[i][j]);
                    winner = positions[i][j];
                    cachedPool.submit(new DrawHorizontalLine(i, j));
                    return true;
                }
            }
        }

        //check vertically
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j <= 6; j++){
                if ((positions[i][j] != 0) && (positions[i][j] == positions[i+1][j]) && (positions[i][j] == positions[i+2][j]) && (positions[i][j] == positions[i+3][j])){
                    System.out.println("Winner: Player " + positions[i][j]);
                    winner = positions[i][j];
                    cachedPool.submit(new DrawVerticalLine(i, j));
                    return true;
                }
            }
        }

        //check diagonally right to left
        for (int i = 0; i <= 2; i++){
            for (int j = 0; j <= 3; j++){
                if ((positions[i][j] != 0) && (positions[i][j] == positions[i+1][j+1]) && (positions[i][j] == positions[i+2][j+2]) && (positions[i][j] == positions[i+3][j+3])){
                    System.out.println("Winner: Player " + positions[i][j]);
                    winner = positions[i][j];
                    return true;
                }
            }
        }

        //check diagonally left to right
        for (int i = 5; i >=3; i--){
            for (int j = 0; j <= 3; j++){
                if ((positions[i][j] != 0) && (positions[i][j] == positions[i-1][j+1]) && (positions[i][j] == positions[i-2][j+2]) && (positions[i][j] == positions[i-3][j+3])){
                    System.out.println("Winner: Player " + positions[i][j]);
                    winner = positions[i][j];
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfThereIsADraw(){

        for (int i = 0; i <= 5; i++){
            for (int j = 0; j <= 6; j++){
                if (positions[i][j] == 0){
                    return false;
                }
            }
        }

        return true;

    }


    public void endGame(){

        currentPlayer = null;

        if (winner == 1){
            Picture picture = new Picture(10, 10, "resources/player1Wins.png");
            picture.draw();

        }

        if (winner == 2){
            Picture picture = new Picture(10, 10, "resources/player2Wins.png");
            picture.draw();
        }

    }

    public void restartGame(){

        grid.getCachedPool().shutdownNow();
        cachedPool.shutdownNow();

        player1 = null;
        player2 = null;
        currentPlayer = null;
        controls = null;
        //grid = null;
        positions = null;
        winner = 0;
        background = null;
        controller1 = null;
        controller2 = null;

        Thread.currentThread().interrupt();

        GameEngine g = new GameEngine();
        g.init();
        g.startGame();

    }

}




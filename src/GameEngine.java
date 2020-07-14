public class GameEngine {

    Player player1;
    Player player2;
    Player currentPlayer;
    Controls controls;
    Grid grid;
    int[][] positions;


    public void init() {

        Background background = new Background();

        Grid grid = new Grid();

        Controller controller1 = new Controller(1);
        Player player1 = new Player(controller1, 1);
        player1.setGameEngine(this);

        Controller controller2 = new Controller(2);
        Player player2 = new Player(controller2, 2);
        player2.setGameEngine(this);

        player1.setOtherPlayer(player2);
        player2.setOtherPlayer(player1);

        Controls controls = new Controls();
        controls.init();
        this.controls = controls;

        this.grid = grid;
        this.player1 = player1;
        this.player2 = player2;

    }

    public void startGame(){
        playRound(player1);
    }

    public void playRound(Player player) {

        currentPlayer = player;
        controls.setPlayer(player);
        player.startRound();
        System.out.println(checkIfThereIsAWinner());

    }

    public void setPlay(int playerNumber, int playedPosition) {
        grid.setPlay(playerNumber, playedPosition);
    }

    public boolean playedPositionIsFree(int currentPosition){

        return grid.playedPositionIsFree(currentPosition);

    }

    public boolean checkIfThereIsAWinner() {

        positions = grid.getPositions();

        //check horizontally
        for (int j = 0; j <=5; j++) {

            int currentNum = positions[j][0];
            int currentConsecutive = 1;
            int maxConsecutive = 1;
            for (int i = 1; i < positions[j].length; i++) {
                if ((positions[j][i] == currentNum) && (currentNum != 0)) {
                    currentConsecutive++;
                    maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
                    if (maxConsecutive >= 4){
                        return true;
                    }
                } else {
                    currentNum = positions[j][i];
                    currentConsecutive = 1;
                }
            }
        }
        return false;
    }

}




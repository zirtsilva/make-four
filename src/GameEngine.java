public class GameEngine {

    Player player1;
    Player player2;
    Player currentPlayer;
    Controls controls;
    Grid grid;


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

    }

    public void setPlay(int playerNumber, int playedPosition){
        grid.setPlay(playerNumber, playedPosition);
        System.out.println(playerNumber);
        System.out.println(playedPosition);
    }



}




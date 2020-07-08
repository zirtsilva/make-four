public class GameEngine {

    Player player1;
    Player player2;



    public void init() {

        Background background = new Background();

        Controller controller1 = new Controller(1);
        Player player1 = new Player(controller1);

        Controls controls1 = new Controls();
        controls1.setPlayer(player1);
        controls1.init();



        this.player1 = player1;

    }

    public void startGame(){
        player1.startRound();
    }


}

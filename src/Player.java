public class Player {

    int playerNumber;
    private Controller controller;
    private boolean itsHisTurn = false;
    GameEngine gameEngine;
    Player otherPlayer;


    Player (Controller controller, int playerNumber){
        this.controller = controller;
        this.playerNumber = playerNumber;
    }

    public void moveControllerLeft(){
        controller.moveLeft();
    }
    public void moveControllerRight(){
        controller.moveRight();
    }

    public void playThisLine() {
        if (itsHisTurn) {
            controller.hide();
            if (gameEngine.playedPositionIsFree(controller.getCurrentPosition())) {
                gameEngine.setPlay(playerNumber, controller.getCurrentPosition());
                endRound();
            } else {
                startRound();
            }
        }
    }

    public void startRound(){
        itsHisTurn = true;
        controller.startRound();
    }
    public void endRound(){
        itsHisTurn = false;
        gameEngine.playRound(otherPlayer);
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void setOtherPlayer(Player otherPlayer){
        this.otherPlayer = otherPlayer;
    }
}

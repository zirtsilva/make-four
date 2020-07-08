public class Player {

    private String name;
    private String playerNumber;
    private Controller controller;
    private boolean itsHisTurn = false;


    Player (Controller controller){
        this.controller = controller;
    }

    public Controller getController(){
        return controller;
    }

    public void moveControllerLeft(){
        controller.moveLeft();
    }
    public void moveControllerRight(){
        controller.moveRight();
    }
    public void playThisLine(){
        if (itsHisTurn) {
            controller.hide();
            System.out.println(controller.getCurrentPosition());
        }
    }
    public void startRound(){
        itsHisTurn = true;
        controller.startRound();
    }
    public void endRound(){
        itsHisTurn = false;
    }


}

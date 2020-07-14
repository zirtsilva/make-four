import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    boolean[][] occupiedPositions;
    int[][] positions;
    Picture picture;
    int toMove = 0;


    Grid() {
        occupiedPositions = new boolean[6][7];
        positions = new int[6][7];
    }

    public void setPlay(int playerNumber, int playedPosition) {

        if (playedPositionIsFree(playedPosition)) {

            if (!(occupiedPositions[5][playedPosition - 1])) {
                occupiedPositions[5][playedPosition - 1] = true;
                positions[5][playedPosition - 1] = playerNumber;
                toMove = 5;
            } else if (!(occupiedPositions[4][playedPosition - 1])) {
                occupiedPositions[4][playedPosition - 1] = true;
                positions[4][playedPosition - 1] = playerNumber;
                toMove = 4;
            } else if (!(occupiedPositions[3][playedPosition - 1])) {
                occupiedPositions[3][playedPosition - 1] = true;
                positions[3][playedPosition - 1] = playerNumber;
                toMove = 3;
            } else if (!(occupiedPositions[2][playedPosition - 1])) {
                occupiedPositions[2][playedPosition - 1] = true;
                positions[2][playedPosition - 1] = playerNumber;
                toMove = 2;
            } else if (!(occupiedPositions[1][playedPosition - 1])) {
                occupiedPositions[1][playedPosition - 1] = true;
                positions[1][playedPosition - 1] = playerNumber;
                toMove = 1;
            } else if (!(occupiedPositions[0][playedPosition - 1])) {
                occupiedPositions[0][playedPosition - 1] = true;
                positions[0][playedPosition - 1] = playerNumber;
                toMove = 0;
            }


            Thread thread = new Thread(new DrawPlay(playedPosition, playerNumber, toMove, picture));
            thread.start();



            System.out.println("" + positions[0][0] + positions[0][1] + positions[0][2] + positions[0][3] + positions[0][4] + positions[0][5] + positions[0][6]);
            System.out.println("" + positions[1][0] + positions[1][1] + positions[1][2] + positions[1][3] + positions[1][4] + positions[1][5] + positions[1][6]);
            System.out.println("" + positions[2][0] + positions[2][1] + positions[2][2] + positions[2][3] + positions[2][4] + positions[2][5] + positions[2][6]);
            System.out.println("" + positions[3][0] + positions[3][1] + positions[3][2] + positions[3][3] + positions[3][4] + positions[3][5] + positions[3][6]);
            System.out.println("" + positions[4][0] + positions[4][1] + positions[4][2] + positions[4][3] + positions[4][4] + positions[4][5] + positions[4][6]);
            System.out.println("" + positions[5][0] + positions[5][1] + positions[5][2] + positions[5][3] + positions[5][4] + positions[5][5] + positions[5][6]);
            System.out.println("-------------");


        }
    }

    public boolean playedPositionIsFree(int playedPosition) {
        if (!(occupiedPositions[0][playedPosition - 1])) {
            return true;
        }
        return false;
    }

    public int[][] getPositions(){
        return positions;
    }

}

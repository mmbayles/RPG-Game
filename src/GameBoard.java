public class GameBoard {
    int width;
    int height;
    int numEnemies;
    String[][] gameBoard;
    int[][] playerLocation = new int[1 + numEnemies][2];
    Player[] arrayPlayers = new Player[1 + numEnemies];

    public GameBoard(int x, int y) {
        width = x;
        height = y;
        gameBoard = new String[height][width];
    }

    public void displayGame() {
        int i1 = gameBoard.length - 1;
        for (int i = i1; i > -1; i--) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                if (gameBoard[i][j] == null) {
                    System.out.print("O" + " ");
                } else {
                    System.out.print(gameBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void placePlayer() {

    }
}

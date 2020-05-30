import java.util.Scanner;

public class Main {
    private static void displayGame(int gameBoard[][]) {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int menuChoice() {
        Scanner myObj = new Scanner(System.in);
        boolean quit = false;
        int choice = 1;
        while (!quit) {
            System.out.println("1) Play Game");
            System.out.println("2) Quit");
            choice = myObj.nextInt();
            if (choice < 3 || choice > 0) quit = true;
        }
        return choice;
    }

    private static void gameLoop() {
        System.out.println("Welcome to my game!");
        int choice = menuChoice();
        if (choice != 1) System.exit(0);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Please choose a name for your character");
        String name = myObj.nextLine();
        System.out.println("Please choose board height");
        int height = myObj.nextInt();
        System.out.println("Please choose board width");
        int width = myObj.nextInt();

        Player me = new Player(name);
        System.out.println(me.playerName);


        boolean gameOver = false;
        int[][] gameBoard = new int[height][width];
        while (!gameOver) {
            displayGame(gameBoard);
            gameOver = true;
        }
    }

    public static void main(String[] args) {
        gameLoop();
    }
}

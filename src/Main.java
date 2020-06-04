import java.util.Scanner;

public class Main {

    private static int menuChoice(String[] menuChoices) {
        Scanner myObj = new Scanner(System.in);
        boolean quit = false;
        int choice = -1;
        while (!quit) {
            for (int i = 0; i < menuChoices.length; i++) {
                System.out.println(i + 1 + ") " + menuChoices[i]);
            }
            choice = myObj.nextInt() - 1;
            if (choice > -1 && choice < menuChoices.length) {
                quit = true;
            }
        }
        return choice;
    }

    private static void gameLoop() {
        GameBoard board = new GameBoard(10, 10);
        System.out.println("Welcome to my game!");
        String[] mainMenu = new String[]{"Start Game", "Quit"};
        int choice = menuChoice(mainMenu);
        if (choice == 1) System.exit(0);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Please choose a name for your character");
        String name = myObj.nextLine();

        System.out.println("Please choose a class for your character");
        Player player = new Player(name);
        String[] classMenu = new String[]{"Warrior", "Archer", "Mage"};
        int playerClass = menuChoice(classMenu);
        if (playerClass == 0) {
            player = new Warrior(name);
        } else if (playerClass == 1) {
            player = new Archer(name);
        } else if (playerClass == 2) {
            player = new Mage(name);
        }

        System.out.println("Please enter the number of enemies");
        int numEnemies = myObj.nextInt();
//        int[][] playerLocation = new int[1 + numEnemies][2];
//        Player[] arrayPlayers = new Player[1 + numEnemies];
        board.arrayPlayers[0] = player;
        board.playerLocation[0][0] = player.x;
        board.playerLocation[0][1] = player.y;
        for (int i = 0; i < numEnemies; i++) {
            Goblin monster = new Goblin("Goblin");
            monster.x = i;
            monster.y = board.height;
            board.arrayPlayers[i + 1] = monster;
            board.playerLocation[i + 1][0] = player.x;
            board.playerLocation[i + 1][1] = player.y;
        }

        System.out.println(player.playerName);
        System.out.println(player.type);

        boolean gameOver = false;
//        String[][] gameBoard = new String[gameBoardY][gameBoardY];
        board.gameBoard[0][0] = player.icon;
//        Arrays.setAll(gameBoard, i -> "O");
        while (!gameOver) {
            board.displayGame();
            player.move(board.gameBoard);
//            System.out.println("game over?");
//            gameOver = myObj.nextBoolean();
        }
    }

    public static void main(String[] args) {
        gameLoop();
    }
}

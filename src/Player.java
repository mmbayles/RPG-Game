import java.util.Scanner;

public class Player {

    String playerName;
    int x = 0;
    int y = 0;
    int hp;
    int attack;
    int defense;
    int speed;
    int range;
    String icon;
    String type;

    public Player(String name) {
        playerName = name;
    }

    public static void attack() {

    }

    public void move(String gameBoard[][]) {
        // current position
        Scanner myObj = new Scanner(System.in);
        System.out.println("Would you like to move your character? (wasd)");
        String direction = myObj.nextLine();

        gameBoard[y][x] = null;
        if (direction.toLowerCase().equals("a")) {
            x = -1 + x;
        } else if (direction.toLowerCase().equals("d")) {
            x = 1 + x;
        } else if (direction.toLowerCase().equals("w")) {
            y = 1 + y;
        } else if (direction.toLowerCase().equals("s")) {
            y = -1 + y;
        }
        if (x > -1 && y > -1 && y < gameBoard.length && x < gameBoard[0].length) {
            gameBoard[y][x] = icon;
        }
    }

    public static void main(String[] args) {

    }
}

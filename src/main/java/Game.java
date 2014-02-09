import java.util.Map;
import java.util.Scanner;

/**
 * @author alex.collins
 */
public class Game {
    private String name;
    private Map<String,Integer> points;
    private String[][] grid;
    private int score = 0;

    public Game(String name, Map<String, Integer> points, String[][] grid) {
        this.name = name;
        this.points = points;
        this.grid = grid;
    }

    public void play() {
        Scanner in = new Scanner(System.in);

        System.out.println("You're playing " + name + ".") ;

        while (true) {
            System.out.println("Where do you want to dig (enter x then y)?");

            int x = in.nextInt();
            int y = in.nextInt();

            if (grid[x][y] != null) {
                String treasure = grid[x][y];
                score += points.get(treasure);
                grid[x][y] = null;
                System.out.println("You found " + treasure + "! Your score is " + score + ".");
            } else {
                System.out.println("Sorry, nothing there!");
            }
        }
    }
}

package Maze_Game;


/**
 * Created by Salta on 2018.
 */
public class Map {
    public static int AISLE = 0;
    public static int WALL = 1;
    public static int GOAL = 2;

    public static void create(int[][] area) {
        // All around the perimeter wall
        for(int x = 0; x < area.length; ++x) {
            area[x][0] = WALL;
            area[x][area[0].length - 1] = WALL;
        }
        for(int y = 0; y < area[0].length; ++y) {
            area[0][y] = WALL;
            area[area.length - 1][y] = WALL;
        }
        // Initialize all passages except the outer circumference
        for(int x = 1; x < area.length - 1; ++x) {
            for (int y = 1; y < area[0].length - 1; ++y) {
                area[x][y] = AISLE;
            }
        }
        // We will set up pillars every other
        for (int x = 2; x < area.length - 2; x += 2) {
            for (int y = 2; y < area[0].length - 2; y += 2) {
                area[x][y] = WALL;
            }
        }
        // 1 Create a "new" wall from the top pillar in either up, down, left, or right direction
        final int[] dx = { 0, -1, 1, 0 };
        final int[] dy = { 1, 0, 0, -1 };
        for (int x = 2; x < area.length - 2; x += 2) {
            int r = (int)(Math.random() * 4);
            while (area[x + dx[r]][2 + dy[r]] == WALL) {
                r = (int)(Math.random() * 4);
            }
            area[x + dx[r]][2 + dy[r]] = WALL;
        }
        // 2 Create a "new" wall in either direction from the post pillars or downwards to the left or right
        for (int y = 4; y < area[0].length - 2; y += 2) {
            for (int x = 2; x < area.length - 2; x += 2) {
                int r = (int)(Math.random() * 3);
                while (area[x + dx[r]][y + dy[r]] == WALL) {
                    r = (int)(Math.random() * 4);
                }
                area[x + dx[r]][y + dy[r]] = WALL;
            }
        }
        // I will set a goal
        area[area.length - 2][area[0].length -2] = GOAL;

        // Print map information on standard output
        for (int x = 0; x < area.length; ++x) {
            for (int y = 0; y < area[0].length; ++y) {
                System.out.print( area[x][y] );
            }
            System.out.println();
        }
    }
}

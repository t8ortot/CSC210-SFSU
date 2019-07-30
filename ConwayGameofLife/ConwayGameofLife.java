import java.util.Scanner;

/**
 * A Java implementation of Conway's Game of Life cellular automation.
 *
 * Conway's Rules to Game of Life:
 * - If a cell that is “populated” has <= 1 neighbor, or >= 4 neighbors, it dies. Otherwise, it survives. 
 * - If an "unpopulated" cell has exactly 3 neighbors, it becomes populated.
 * - Cells on the edge always remain unpopulated (0).
 *
 * @author James Clark
 */
public class ConwayGameofLife {

    /**
     * @param x An x-coordinate specified by the user
     * @param y An y-coordinate specified by the user
     * @param n number of timesteps to run the game for.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //game area
        int grid[][] = new int[10][10];
        System.out.println("Please enter list of (x,y) pairs (both 0 < value < 9)");
        System.out.print("for populated cells (enter a negative x or y to quit): ");
        //xy-coordinate pair
        int x = input.nextInt();
        int y = input.nextInt();

        //validity check and store.
        while (x >= 0 && y >= 0) {
            while (x >= 9 || x == 0) {
                System.out.println("Sorry, your x-value must be between 0 and 9.");
                System.out.print("Please re-enter x-value: ");
                x = input.nextInt();
            }
            while (y >= 9 || y == 0) {
                System.out.println("Sorry, your y-value must be between 0 and 9.");
                System.out.print("Please re-enter y-value: ");
                y = input.nextInt();
            }

            //stores a 1 at the coordniate.
            grid[x][y] = 1;

            x = input.nextInt();
            y = input.nextInt();
        }

        System.out.print("Please enter the number of timesteps (0 < steps <= 20): ");
        int n = input.nextInt();
        //validity check
        while (n <= 0 || n > 20) {
            System.out.println("Sorry, the number of time steps you selected is invalid.");
            System.out.print("Please enter a different number of time steps (0 < steps <= 20): ");
            n = input.nextInt();
        }

        //prints output
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.println("Initial Grid");
            } else {
                System.out.println("Time Step " + i);
            }
            displayGrid(grid);
            updateGrid(grid);
            System.out.println();
        }
    }

    /**
    * @param grid the game grid array to be printed
    */
    public static void displayGrid(int[][] grid) {
        for (int l = 0; l <= 9; l++) {
            System.out.print(l);
        }
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(i);
        }
    }

    /**
    * @param grid the game grid to be updated
    */
    public static void updateGrid(int[][] grid) {
        int neighbors;
        int temp[][] = new int[10][10];
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                neighbors = 0;
                if (grid[i - 1][j - 1] == 1) {
                    neighbors += 1;
                }
                if (grid[i - 1][j] == 1) {
                    neighbors += 1;
                }
                if (grid[i - 1][j + 1] == 1) {
                    neighbors += 1;
                }
                if (grid[i][j - 1] == 1) {
                    neighbors += 1;
                }
                if (grid[i][j + 1] == 1) {
                    neighbors += 1;
                }
                if (grid[i + 1][j - 1] == 1) {
                    neighbors += 1;
                }
                if (grid[i + 1][j] == 1) {
                    neighbors += 1;
                }
                if (grid[i + 1][j + 1] == 1) {
                    neighbors += 1;
                }

                if (neighbors >= 4 || neighbors <= 1) {
                    temp[i][j] = 0;
                } else if (neighbors == 3) {
                    temp[i][j] = 1;
                }else {
                    temp[i][j] = grid[i][j];
                }
                

                }
            }
         for (int g = 0; g < grid.length; g++){
            System.arraycopy(temp[g], 0, grid[g], 0, grid[g].length);
        }
    }
}

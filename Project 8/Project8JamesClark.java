/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project8jamesclark;

import java.util.Scanner;

/**
 *
 * @author Jimmy
 */
public class Project8JamesClark {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int grid[][] = new int[10][10];
        System.out.println("Please enter list of (x,y) pairs (both 0 < value < 9)");
        System.out.print("for populated cells (enter a negative x or y to quit): ");
        int x = input.nextInt();
        int y = input.nextInt();

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
            grid[x][y] = 1;

            x = input.nextInt();
            y = input.nextInt();
        }

        System.out.print("Please enter the number of timesteps (0 < steps ≤ 20): ");
        int n = input.nextInt();
        while (n <= 0 || n > 20) {
            System.out.println("Sorry, the number of time steps you selected is invalid.");
            System.out.print("Please enter a different number of time steps (0 < steps ≤ 20): ");
            n = input.nextInt();
        }

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

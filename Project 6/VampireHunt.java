package VampireHunt;

import java.util.Scanner;

/**
 * Hunt your victim by guessing their coordinates on a 10 by 10 grid.
 *
 * @author James Clark
 * @version 11/6/16
 */
public class VampireHunt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //random x-coordinate for victim
        int targetX = myRand(0, 9);
        //random y-coordinate for victim
        int targetY = myRand(0, 9);
        //random number between 5 and 10 for blood points
        int health = myRand(5, 10);
        //distance from victim (intialized at 1 to start loop)
        double distance = 1;

        //Header
        System.out.println("Welcome to the Vampire Hunt game!");

        //Option to cheat
        System.out.print("Would you like to cheat? (1 for yes, 0 for no): ");
        //User input (1 for yes, 0 for no)
        int cheat = input.nextInt();

        //Counter-measure if user enters a number that isn't 1 or 0
        while (cheat != 0 && cheat != 1) {
            System.out.print("Please enter 1 for yes, or 0 for no: ");
            cheat = input.nextInt();
        }

        //If user decides to cheat, print location of victim
        if (cheat == 1) {
            System.out.println("Your victim is located at " + targetX + " " + targetY);
        }

        //prints the amount of blood points you start with
        System.out.println("You start with " + health + " blood points.");
        System.out.println();

        //loop continues until the user finds victim or blood points reaches 0.
        while (distance != 0 && health > 0) {
            System.out.print("Please enter your target x and y-coordinates (both between 0 and 9): ");
            //User guess for victims x-coordinate
            int playerX = input.nextInt();
            //User guess for victims y-coordinate
            int playerY = input.nextInt();

            //counter-measure if user inputs number for x that isn't between 0 and 9.
            while (playerX < 0 || playerX > 9) {
                System.out.println("Please re-enter your x-coordinate with a number between 0 and 9: ");
                playerX = input.nextInt();
            }

            //counter-measure if user inputs number for y that isn't between 0 and 9.
            while (playerY < 0 || playerY > 9) {
                System.out.println("Please re-enter your y-coordinate with a number between 0 and 9: ");
                playerY = input.nextInt();
            }

            //calculates distance from user's guess position to victim's position
            distance = findDistance(playerX, playerY, targetX, targetY);

            //if the player has not found the Victim
            if (distance != 0) {

                //Extra Credit
                System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~");
                //Prints legend for map
                System.out.println("You are located at x");
                if (cheat == 1) {
                    System.out.println("The Victim is located at o");
                }

                //Prints out map with coordinates and location of player (and victim if cheating)
                System.out.println("  0 1 2 3 4 5 6 7 8 9  ");
                for (int i = 0; i <= 9; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j <= 9; j++) {
                        if (playerY == i && playerX == j) {
                            System.out.print("x ");
                        } else if (targetY == i && targetX == j && cheat == 1) {
                            System.out.print("o ");
                        } else {
                            System.out.print("  ");
                        }

                    }
                    System.out.print(i);
                    System.out.println();
                }
                System.out.println("  0 1 2 3 4 5 6 7 8 9  ");
                System.out.println("~^~^~^~^~^~^~^~^~^~^~^~^~^~");

                //prints distance accurate to 2 decimals
                System.out.print("You are ");
                System.out.printf("%.2f", distance);
                System.out.println(" units away from your victim.");

                //Random damage between 0 and 2
                int damage = myRand(2, 0);
                //Subtracts the damage from current blood points
                health -= damage;
                //If blood points becomes negative, change to 0.
                if (health < 0) {
                    health = 0;
                }

                //print statements for each damage outcome
                switch (damage) {
                    case 2:
                        System.out.println("You are hit by an arrow! You lose 2 blood points!");
                        break;
                    case 1:
                        System.out.println("You were grazed by an arrow! You lose 1 blood point!");
                        break;
                    case 0:
                        System.out.println("An arrow flies past you. You don't take any damage.");
                        break;
                }

                //Grammar check
                if (health != 1) {
                    System.out.println("Your now have " + health + " blood points.");
                } else {
                    System.out.println("Your now have " + health + " blood point.");
                }
                
            //Game ends if distance is 0
            } else if (distance == 0) {
                System.out.println("You bit your victim! They are now a vampire!");
            }

            //Game ends if blood points reach 0
            if (health == 0) {
                System.out.println("The vampire hunters killed you!");
            }
            System.out.println();
        }
    }
    
    /**
     * Generates a random number between the given low and high values.
     * @param low The lower bound
     * @param high The upper bound
     * @return The random number
     */
    public static int myRand(int low, int high) {
        //Calculates the range from high to low
        int range = high - low;

        //Calculates a value within the range
        int value = (int) (Math.random() * range);

        //Returns the relevant value
        return high - value;
    }
    /**
     * Computes the distance between two points on an x&y plane
     * @param x1 The x-coordinate for point 1
     * @param y1 The y-coordinate for point 1
     * @param x2 The x-coordinate for point 2
     * @param y2 The y-coordinate for point 2
     * @return The distance between the two points
     */
    public static double findDistance(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(
                Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        return distance;
    }

}

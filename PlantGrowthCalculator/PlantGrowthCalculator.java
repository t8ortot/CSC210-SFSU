package PlantGrowthCalculator;

import java.util.Scanner;

/**
 *Takes a user input for the highest and lowest temperatures for their plant and
 * the minimal amount of rainfall for the plant, then predicts the height and
 * new growth for each month based on average temperatures and rainfall for the
 * corresponding months.
 * 
 * @author James Clark
 * @version 10/10/16
 */
public class PlantGrowthCalculator {

    /**
     *
     */
    public static void main(String[] args) {

        // Requirements
        final int NUMMONTHS = 12;
        int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
        int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};

        // Initialize Scanner
        Scanner input = new Scanner(System.in);

        // Welcome meesage to match formatting of example.
        System.out.println("Welcome to the 210 gardening planner!");

        //User input for the minTemp
        System.out.print("Please enter minimum temperature for plant: ");
        int minTemp = input.nextInt();

        //User input for maxTemp
        System.out.print("Please enter maximum temperature for plant: ");
        int maxTemp = input.nextInt();

        //User input for minRain
        System.out.print("Please enter the minimal rainfall for the plant: ");
        int minRain = input.nextInt();

        //Formatting
        System.out.println("Month\tTemp\tRain\tGrowth\tPlant Height");

        //Initializing height with 13 values so the current height can be calculated
        //with 0 as the original value. With 12 values, height[i-1] will not work when i=0.
        int[] height = new int[13];

        //for-loop to print each row
        for (int i = 0; i < NUMMONTHS; i++) {

            //print month
            System.out.print(i + "\t");

            //print avgTemp and avgRain values correspnding to the month
            System.out.print(avgTemp[i] + "\t" + avgRain[i] + "\t");

            //initialize newGrowth variable
            int newGrowth;

            //If the avgTemp for the corresponding month is outside the range 
            //of temperatures for the plant, set newGrowth to -1. If the avgTemp is
            //within the range of temperatures, newGrowth is set to the avgRain 
            //for the corresponding month minus the minimal amount of rain needed
            //for the plant.
            if (minTemp > avgTemp[i] || maxTemp < avgTemp[i]) {
                newGrowth = -1;
            } else {
                newGrowth = avgRain[i] - minRain;
            }

            //current height is the previous height plus new growth
            height[i + 1] = height[i] + newGrowth;

            //If height becomes less than 0, reset it to 0.
            if (height[i + 1] < 0) {
                height[i + 1] = 0;
            }

            //Print newGrowth and height
            System.out.print(newGrowth + "\t" + height[i + 1]);
            System.out.println();
        }

        //Extra Credit
        //Initialize maxMonth and maxHeight
        int maxMonth = 0;
        int maxHeight = 0;

        //Finding the max height by scanning the height array. If a value in the array
        //is larger than the value saved in maxHeight, replace maxHeight with the greater
        //value. Then save the month it correspnds with in maxMonth. If multiple months have
        //the same value, it only records the first month it occurs.
        for (int i = 0; i < 13; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxMonth = i - 1;
            }
        }
        
        //prints extra credit
        System.out.println("Extra Credit follows:");
        System.out.println("Max height = " + maxHeight + " in month " + maxMonth + ".");
    }
}

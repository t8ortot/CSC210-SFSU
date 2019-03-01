package HeartRateCalculator;

import java.util.Scanner;

/**
 * Program that checks if user is above, below, or at their maximum
 * heart rate.
 *
 * @author James Clark
 * @version 9/15/16
 */
public class HeartRateCalculator {

    /**
     * Compute the user's maximum heart rate
     * @param age User's age
     * @param heartRate User's Heart Rate
     * @param max Formula for maximum heart rate
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your age: ");
        int age = input.nextInt(); //User's input for age.

        System.out.print("Please enter your current heart rate: ");
        int heartRate = input.nextInt(); //User's input for heart rate.

        int max = 220 - age; //Calculating the user's maximum heart rate.
        System.out.println("Your maximum heart rate is: " + max);

        if (heartRate == max) { //Check if heart rate is equal to the maximum.
            System.out.println("Your heart rate is at the maximum!");
        
        } else if (heartRate > max) { //Check if heart rate is above the maximum.
            System.out.println("Your heart rate is above the maximum!");
        
        } else if (heartRate < max) { //Check if heart rate is below the maximum.
            System.out.println("Your heart rate is below the maximum.");

        }

    }

}

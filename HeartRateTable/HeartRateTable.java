import java.util.Scanner;

/**
 * Calculates the beats per minute (BPM) between an upper and lower bound for a list
 * ages.
 *
 * @author James Clark
 * @version 9/26/2016
 */
public class HeartRateTable {

    /**
     * @param lower The lower percentage of the target range.
     * @param upper The upper percentage of the target range.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your lower bound: ");

        float lower = input.nextInt(); //User input for lower bound
        lower /= 100; //Divides the lower bound by 100.

        System.out.print("Please enter your upper bound: ");

        float upper = input.nextInt(); //User input for upper bound
        upper /= 100; //Divides the upper bound by 100

        System.out.println("Age\tTarget\tMaximum"); //generating columns

        int age = 20; //Setting list of ages at 20
        int max; //Maximum Heart rate displayed for each age
        float targetUp; //Value for Target Upper bound
        float targetLow; //Value for Target Lower bound

        while (age <= 70) { //While the age is below 70, repeat.
            System.out.print(age + "\t"); //Prints age
            max = 220 - age; //Calculates maximum HR
            targetUp = max * upper; //Calculates Upper bound BPM
            targetLow = max * lower; //Calculates Lower bound BPM
            System.out.printf("%.0f", targetLow); //Prints lower bound with no decimals
            System.out.print("-");
            System.out.printf("%.0f", targetUp); //Prints upper bound with no decimals
            System.out.println("\t" + max);  //Prints Maximum BPM
            age += 5; //Adds 5 to age
        }

    }

}

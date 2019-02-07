package jamesclarkproject3;

/**
 * Creates a chart that marks all age and heart rate combinations that are in
 * the target zone (*) and beyond the maximum heart rate (+).
 *
 * @author James Clark
 * @version 10/3/16
 */
public class HeartRateChart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int MIN_AGE = 15, MAX_AGE = 90;
        //setting minimum and maximum ages for x-scale
        final int MIN_HEARTRATE = 60, MAX_HEARTRATE = 175;
        //setting minimum and maximum heart rates for y-scale

        System.out.println("HR Age");
        //printing x-axis and y-axis labels
        System.out.print("   ");

        for (int age = MIN_AGE; age <= MAX_AGE; age += 5) {
            //loop continues from ages 15 to 90 in intervals of 5

            System.out.print(" " + age);
            //prints x-axis
        }

        for (int heartRate = MIN_HEARTRATE; heartRate <= MAX_HEARTRATE; heartRate += 5) {
            //loop continues from 60 BPM to 175 BPM in intervals of 5
            System.out.println(" ");  
            System.out.printf("%3d", heartRate);
            //prints y-axis
            System.out.print("  ");

            for (int starAge = 15; starAge <= 90; starAge += 5) {
                //loop continues from 15 to 90 in intervals of 5

                int star = 220 - starAge;
                //calculating age-specific maximum heart rate
                float minStar = (float) (star * 0.5);
                //calculating minimum target
                float maxStar = (float) (star * 0.85);
                //calculating maximum target

                if (heartRate >= minStar && heartRate <= maxStar) {
                    //if the heart rate is in the target zone
                    System.out.print("*  ");
                    //print a star

                } else if (heartRate > star) {
                    //if the heart rate is above the maximum
                    System.out.print("+  ");
                    //print a plus

                } else {
                    //if it doesn't satify both
                    System.out.print("   ");
                    //leave blank
                }

            }

        }

    }

}

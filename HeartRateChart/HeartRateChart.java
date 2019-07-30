/**
 * Creates a chart that marks all age and heart rate combinations that are in
 * the target zone (*) and beyond the maximum heart rate (+).
 *
 * @author James Clark
 * @version 10/3/16
 */
public class HeartRateChart {

    public static void main(String[] args) {

        //minimum and maximum ages for x-axis
        final int MIN_AGE = 15, MAX_AGE = 90;

        //setting minimum and maximum heart rates for y-axis
        final int MIN_HEARTRATE = 60, MAX_HEARTRATE = 175;
        
        //printing x-axis and y-axis labels
        System.out.println("HR Age");
        System.out.print("   ");

        //loop continues from ages 15 to 90 in intervals of 5
        for (int age = MIN_AGE; age <= MAX_AGE; age += 5) {
            
            //prints x-axis
            System.out.print(" " + age);
        }

        //loop continues from 60 BPM to 175 BPM in intervals of 5
        for (int heartRate = MIN_HEARTRATE; heartRate <= MAX_HEARTRATE; heartRate += 5) {
            //prints y-axis
            System.out.println(" ");
            System.out.printf("%3d", heartRate);
            System.out.print("  ");

            //loop continues from 15 to 90 in intervals of 5
            for (int starAge = 15; starAge <= 90; starAge += 5) {
                //calculating age-specific maximum heart rate
                int star = 220 - starAge;
                //calculating minimum target
                float minStar = (float) (star * 0.5);
                //calculating maximum target
                float maxStar = (float) (star * 0.85);
                
                //if the heart rate is in the target zone
                if (heartRate >= minStar && heartRate <= maxStar) {
                    //print a star
                    System.out.print("*  ");
                //if the heart rate is above the maximum
                } else if (heartRate > star) {
                    //print a plus
                    System.out.print("+  ");
                //if it doesn't satify both
                } else {
                    //leave blank
                    System.out.print("   ");
                    
                }

            }

        }

        System.out.println();

    }

}

package project5.pkg5jamesclark;

/**
 * Calculates an approximate value of pi.
 *
 * @author James Clark
 * @version 10/30/16
 */
public class Project55JamesClark {

    public static void main(String[] args) {
        final int N = 5000;
        int numInside = 0;
        double currX, currY, radius, mypi;

        for (int i = 0; i < N; i++) {
            /* make a throw: get new x and new y */
            currX = newRand(-1., 1.);
            currY = newRand(-1., 1.);

            /* check if throw inside circle */
            radius = findRadius(currX, currY);
            if (radius < 1.0) {
                /* increment counter if inside circle */
                numInside++;
            }
        }
        /* find ratio */
        /* calculate pi */
        mypi = 4 * numInside / (float) N;
        System.out.println("Pi = " + mypi);
    }
    
    /**
     * Compute a random double between values given for low and high.
     * @param low Lower bound
     * @param high Upper bound
     * @return Randomly generated number within the bounds
     */
    public static double newRand(double low, double high) {
        //Calculates the range from high to low
        double range = high - low;

        //Calculates a value within the range
        double value = range * Math.random();

        //Returns the relevant value
        return high - value;
    }
    
    /**
     * Calculates the radius using the Pythagorean theorem.
     * @param x x-coordinate
     * @param y y-coordinate
     * @return radius
     */
    public static double findRadius(double x, double y) {
        //Returns the Pythagorean theorem to find the radius
        return Math.sqrt((x * x) + (y * y));
    }
}

package LocatePeaks;

/**
 * Finds the peaks (above average values) from a list of values and then
 * rearranges them into increasing order.
 *
 * @author James Clark
 * @version 10/23/2016
 */
public class LocatePeaks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //initialize the given values
        float[] x = {0.2f, 0.5f, 0.1f, 0.15f, 0.2f, 0.13f, 0.3f, 0.25f, 0.3f, 0.3f,
            0.7f, 0.2f, 0.45f, 0.15f, 0.2f, 0.85f, 0.3f, 0.65f, 0.2f, 0.1f};

        //initialized for calculating average of data set
        float avg = 0;

        //inititialized to count amount of peaks
        int peaks = 0;

        //initialized as place holder.
        int p = 0;

        //initialized as value holder
        float hold;

        //Header
        System.out.println("Data array: ");

        //Prints data set with accuracy to two decimals, starting the next line after
        //ten values.
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%.2f", x[i]);
            System.out.print(" ");
            if (i == 9) {
                System.out.println();
            }
        }

        //Style
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }

        //Calulates the average of the data set.
        for (int i = 0; i < x.length; i++) {
            avg += x[i];
            if (i == (x.length-1)) {
                avg = avg / x.length;
            }
        }

        //Calculates the amount of peaks
        for (int i = 0; i < x.length; i++) {
            if (x[i] >= avg) {
                peaks++;
            }
        }

        //Creates an array with enough elements to hold all the index values
        int[] peakIndex = new int[peaks];

        //Creates an array with enough elements to hold all the peak values
        float[] peakValue = new float[peaks];

        //Header
        System.out.println("Peaks found: ");

        //Prints indexes and peak values, then adds the index and value into another array
        for (int i = 0; i < x.length; i++) {
            if (x[i] >= avg) {
                System.out.print(i + "\t");
                System.out.println(x[i]);
            }
            if (x[i] >= avg) {
                peakIndex[p] = i;
                peakValue[p] = x[i];
                p++;
            }
        }

        //Style
        System.out.println();

        //Sorts values
        for (int b = 0; b < peaks; b++) {
            for (int m = 0; m < peaks; m++) {
                if (peakValue[m] > peakValue[b]) {
                    hold = peakValue[b];
                    peakValue[b] = peakValue[m];
                    peakValue[m] = hold;
                    hold = peakIndex[b];
                    peakIndex[b] = peakIndex[m];
                    peakIndex[m] = (int) hold;
                }
            }
        }
        //Header
        System.out.println("Sorted peaks: ");

        //Prints sorted values
        for (int i = 0; i < peaks; i++) {
            System.out.println(peakIndex[i] + "\t" + peakValue[i]);
        }
    }
}

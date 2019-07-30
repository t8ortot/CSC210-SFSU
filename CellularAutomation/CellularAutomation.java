import java.util.Scanner;

/**
 *Program that generates a cellular automaton based on the user's inputs.
 *
 * @author James Clark
 * @version 11/14/16
 */
public class CellularAutomation {

    /**
     * 
     * @param C number of cells on the y-axis
     * @param N number of time steps on the x-axis
     * @param index user specified index to start pattern
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Header
        System.out.println("Welcome to the cellular automaton simulation!");

        //User input for amount of cells on the y-axis (80 maximum).
        System.out.print("Please enter the number of cells (0 < Cells <= 80): ");
        int C = input.nextInt(); //Number of cells on y-axis.
        //Bound check
        while (C > 80 || C <= 0) {
            System.out.print("Please re-enter the number of cells (0 < Cells <= 80): ");
            C = input.nextInt();
        }

        //User input for number of time steps.
        System.out.print("Please enter number of time steps (Steps > 0) : ");
        int N = input.nextInt(); //Number of time steps on the x-axis
        //Bound check
        while (N <= 0) {
            System.out.print("Number of steps must be greater than 0, please re-enter: ");
        }

        //Creates an array with C+1 amount of cells so if user inputs index of C 
        //it will have a right side value
        int[] cell = new int[C + 1];

        //User input for selected indices to start the program with. Ended with any negative number.
        System.out.print("Please enter the indices of occupied cells (0 < Index < " + C + ")(Use negative number to end): ");
        int index = input.nextInt(); //Selected indices

        //Takes list of cells selected and assigns them to be 1, until a negative number is entered.
        do {
            //Bound check
            if (index >= cell.length - 1 || index <= 0) {
                System.out.print(index + " exceeds the maximum specified bound! Please re-enter: ");
                index = input.nextInt();
            }
            cell[index] = 1;
            index = input.nextInt();
        } while (index >= 0);

        int ruler = 0; //Ruler for amount of cells
        //prints ruler across y-axis
        for (int i = 0; i < C; i++) {
            System.out.print(ruler);
            ruler++;
            if (ruler == 10) {
                ruler = 0;
            }
        }
        System.out.println();

        //Prints and updates the array N amount of times
        for (int i = 0; i <= N; i++) {
            displayCells(cell);
            updateCells(cell);
        }
    }
    
    /**
     * Prints out all elements in given array, interpreted as either " " or "#".
     * @param data The array that needs to be printed
     */
    public static void displayCells(int data[]) {
        //Scans all elements in array. If 1, print a #. If 0, leave blank.
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                System.out.print("#");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    /**
     * Updates the array elements for the next time step based on the guidelines given.
     * @param data The array that needs to be updated for the next time step.
     */
    public static void updateCells(int data[]) {
        //Temporary array to hold new values
        int[] temp = new int[data.length];
        //Predetermined Rules. Set value indicated to temporary array if the elements match the case.
        for (int i = 1; i < data.length - 1; i++) {
            if (data[i - 1] == 1 && data[i] == 1 && data[i + 1] == 1) {
                temp[i] = 0;

            } else if (data[i - 1] == 1 && data[i] == 1 && data[i + 1] == 0) {
                temp[i] = 1;

            } else if (data[i - 1] == 1 && data[i] == 0 && data[i + 1] == 1) {
                temp[i] = 1;

            } else if (data[i - 1] == 1 && data[i] == 0 && data[i + 1] == 0) {
                temp[i] = 0;

            } else if (data[i - 1] == 0 && data[i] == 1 && data[i + 1] == 1) {
                temp[i] = 1;

            } else if (data[i - 1] == 0 && data[i] == 1 && data[i + 1] == 0) {
                temp[i] = 1;

            } else if (data[i - 1] == 0 && data[i] == 0 && data[i + 1] == 1) {
                temp[i] = 1;

            } else if (data[i - 1] == 0 && data[i] == 0 && data[i + 1] == 0) {
                temp[i] = 0;
            }

        }
        //Replace old values with new values (NetBeans gave me the option to
        //replace my for-loop with this method.)
        System.arraycopy(temp, 0, data, 0, data.length);
    }

}

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculates the positioning of N Queens on a NxN board without them attacking each other.
 *
 * @author Oreste Luci
 */
public class EightQueens {

    public static void main(String[] args) {

        System.out.println("Enter the size (same as number of Queens) of the board:");

        Console console = System.console();
        int size = Integer.parseInt(console.readLine());

        EightQueens eight = new EightQueens();

        int[] array = new int[size];
        List<int[]> results = new ArrayList<>();

        eight.eightQueens(array, 0, results);

        System.out.println(results.size() + " solutions found:\n");

        for (int[] result : results) {
            eight.printSolution(result);
            System.out.println(" ");
        }

        System.out.println(results.size() + " solutions found.\n");
    }

    /**
     * Recursive function that calculates the placement of the Queens.
     * Puts the valid results in the results arrays.
     * Each item in the Array indicates the row in which is placed for the given column.
     */
    public void eightQueens(int[] positions, int position, List<int[]> results) {

        if (position >= positions.length) {
            results.add(positions);
            return;
        }

        for (int value=0; value<positions.length; value++) {

            if (isValidPosition(positions,position,value)) {

                positions[position] = value;

                int[] newResult = new int[positions.length];

                System.arraycopy(positions,0,newResult,0,positions.length);

                eightQueens(newResult, position+1, results);
            }
        }
    }

    /**
     * A Queen not placeable on the board if compared with another queen:
     *
     * 1. x1 = x2
     * 2. y1 = y2
     * 3. |x1 - x2| = |y1 -y2|
     */
    private boolean isValidPosition(int[] positions, int position, int value) {

        if (position == 0) {
            return true;
        }

        // Determine if it can be placed in the given position
        for (int i=0; i<position; i++) {

            int x1 = i;
            int y1 = positions[i];
            int x2 = position;
            int y2 = value;

            if (x1 == x2) {
                return false;
            }

            if (y1 == y2) {
                return false;
            }

            if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Pretty prints the solution array.
     */
    private void printSolution(int[] positions) {

        for (int i=0; i<positions.length; i++) {
            for (int j=0; j<positions.length; j++) {
                if (positions[i]==j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println(" ");
        }
    }
}

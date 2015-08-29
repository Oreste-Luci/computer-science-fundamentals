/**
 * @author Oreste Luci
 */
public class Spiral2DArray {

    public static void main(String[] args) {

        Spiral2DArray sa = new Spiral2DArray();

        int[][] matrix = sa.createMatrix(1,1);
        sa.printMatrix(matrix);
        sa.printSpiral(matrix);

        matrix = sa.createMatrix(4,4);
        sa.printMatrix(matrix);
        sa.printSpiral(matrix);

        matrix = sa.createMatrix(4,6);
        sa.printMatrix(matrix);
        sa.printSpiral(matrix);
    }

    public void printSpiral(int[][] array) {

        System.out.println("Spiral:");

        int rows = array.length;
        int cols = array[0].length;

        // Initial values
        int top = -1;
        int right = cols;
        int bottom = rows;
        int left = -1;

        int t_start = -1;
        int t_stop = cols + 1;
        int r_start = 0;
        int r_stop = rows + 1;
        int b_start = cols - 1;
        int b_stop = -1;
        int l_start = rows - 1;
        int l_stop = 0;

        double minValue = Math.min(array.length, array[0].length);
        long maxLoops = Math.round(minValue/2.0);

        for (long loop=0; loop<maxLoops; loop++) {

            // Top
            top++;
            t_start++;
            t_stop--;
            for(int j=t_start; j<t_stop; j++) {
                print(array[top][j]);
            }

            // Right
            right--;
            r_start++;
            r_stop--;
            for (int i=r_start; i<r_stop; i++) {
                print(array[i][right]);
            }

            // Bottom
            bottom--;
            b_start--;
            b_stop++;
            for (int j=b_start; j>=b_stop; j--) {
                print(array[bottom][j]);
            }

            // Left
            left++;
            l_start--;
            l_stop++;
            for (int i=l_start; i>=l_stop; i--) {
                print(array[i][left]);
            }
        }

        System.out.println(" ");
    }

    private void print(int value) {
        System.out.print(value + " ");
    }

    private int[][] createMatrix(int size_x, int size_y) {

        int[][] matrix = new int[size_x][size_y];

        int value=1;
        for (int i=0;i<size_x;i++) {
            for (int j=0; j<size_y; j++) {
                matrix[i][j] = value++;
            }
        }

        return matrix;
    }

    public void printMatrix(int[][] matrix) {

        System.out.println("\nMatrix:");

        int size_x = matrix.length;
        int size_y = matrix[0].length;

        for (int i=0;i<size_x;i++) {
            for (int j=0; j<size_y; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println(" ");
        }

        System.out.println(" ");
    }
}

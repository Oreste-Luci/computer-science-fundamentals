import java.util.*;

/*

    Problem Statement

    You are given a 2D matrix, a, of dimension MxN and a positive integer R. You have to rotate the matrix R times and print the resultant matrix. Rotation should be in anti-clockwise direction.

    Rotation of a 4x5 matrix is represented by the following figure. Note that in one rotation, you have to shift elements by one step only (refer sample tests for more clarity).

    matrix-rotation

    It is guaranteed that the minimum of M and N will be even.

    Input
    First line contains three space separated integers, M, N and R, where M is the number of rows, N is number of columns in matrix, and R is the number of times the matrix has to be rotated.
    Then M lines follow, where each line contains N space separated positive integers. These M lines represent the matrix.

    Output
    Print the rotated matrix.

    Constraints
    2 <= M, N <= 300
    1 <= R <= 109
    min(M, N) % 2 == 0
    1 <= aij <= 108, where i ∈ [1..M] & j ∈ [1..N]

    Sample Input #00

    4 4 1
    1 2 3 4
    5 6 7 8
    9 10 11 12
    13 14 15 16
    Sample Output #00

    2 3 4 8
    1 7 11 12
    5 6 10 16
    9 13 14 15
    Sample Input #01

    4 4 2
    1 2 3 4
    5 6 7 8
    9 10 11 12
    13 14 15 16
    Sample Output #01

    3 4 8 12
    2 11 10 16
    1 7 6 15
    5 9 13 14
    Sample Input #02

    5 4 7
    1 2 3 4
    7 8 9 10
    13 14 15 16
    19 20 21 22
    25 26 27 28
    Sample Output #02

    28 27 26 25
    22 9 15 19
    16 8 21 13
    10 14 20 7
    4 3 2 1
    Sample Input #03

    2 2 3
    1 1
    1 1
    Sample Output #03

    1 1
    1 1

*/
public class MatrixRotation {

    int rotation;

    public static void main(String[] args) {

        MatrixRotation mr = new MatrixRotation();

        String[][] matrix = mr.readMatrix();

        matrix = mr.rotateMatrix(matrix);

        mr.printMatrix(matrix);
    }

    public String[][] rotateMatrix(String[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        String[][] rotatedMatrix = new String[rows][cols];

        // Reading layers
        List<String> layer;
        List<List<String>> layers = new ArrayList<>((Math.max(rows,cols) / 2) + 1);

        int startRow = 0;
        int startCol = 0;

        boolean finished = false;
        while (!finished) {

            int maxRows = rows - startRow;
            int maxCols = cols - startCol;

            layer = new ArrayList<String>(maxRows*2 + maxCols*2);

            // Top layer
            for (int j=startCol; j<maxCols; j++) {
                layer.add(matrix[startRow][j]);
            }

            // Right layer
            for (int i=startRow+1; i<maxRows-1; i++) {
                layer.add(matrix[i][maxCols-1]);
            }

            // Bottom layer
            for (int j=maxCols-1; j>=startCol; j--) {
                layer.add(matrix[maxRows-1][j]);
            }

            // Left layer
            for (int i=maxRows-2; i>=startRow+1; i--) {
                layer.add(matrix[i][startCol]);
            }

            layers.add(layer);

            startRow++;
            startCol++;

            if (startCol > (cols/2) || startRow > (rows/2)) {
                finished = true;
            }
        }

        // Rotating layers
        for (List<String> l : layers) {
            rotateList(l);
        }

        // Filling new matrix
        startRow = 0;
        startCol = 0;
        int layerCount = 0;
        finished = false;
        while (!finished) {

            int maxRows = rows - startRow;
            int maxCols = cols - startCol;

            layer = layers.get(layerCount++);

            // Top layer
            for (int j=startCol; j<maxCols; j++) {
                rotatedMatrix[startRow][j] = layer.remove(0);
            }

            // Right layer
            for (int i=startRow+1; i<maxRows-1; i++) {
                rotatedMatrix[i][maxCols-1] = layer.remove(0);
            }

            // Bottom layer
            for (int j=maxCols-1; j>=startCol; j--) {
                rotatedMatrix[maxRows-1][j] = layer.remove(0);
            }

            // Left layer
            for (int i=maxRows-2; i>=startRow+1; i--) {
                rotatedMatrix[i][startCol] = layer.remove(0);
            }

            layers.add(layer);

            startRow++;
            startCol++;

            if (startCol > (cols/2) || startRow > (rows/2)) {
                finished = true;
            }

        }

        return rotatedMatrix;
    }

    private void rotateList(List<String> list) {

        if (list.size() == 0) {
            return;
        }

        int length = list.size();
        int rotate = this.rotation;

        // Calculating minimum number of rotations
        if (rotate > length) {
            rotate = rotate - (rotate / length) * length ;
        }

        for (int i=0; i<rotate; i++) {
            String v = list.remove(0);
            list.add(v);
        }
    }

    public String[][] readMatrix() {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        this.rotation = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                matrix[i][j] = scanner.next();
            }
        }

        return matrix;
    }

    public void printMatrix(String[][] matrix) {

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

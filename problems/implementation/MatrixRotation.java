import java.util.*;

public class MatrixRotation {

    int rotation;

    public static void main(String[] args) {

        MatrixRotation mr = new MatrixRotation();

        int[][] matrix = mr.readMatrix();

        matrix = mr.rotateMatrix(matrix);

        mr.printMatrix(matrix);
    }

    public int[][] rotateMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] rotatedMatrix = new int[rows][cols];

        // Reading layers
        List<Integer> layer;
        List<List<Integer>> layers = new ArrayList<>();

        int startRow = 0;
        int startCol = 0;

        boolean finished = false;
        while (!finished) {

            layer = new ArrayList<Integer>();
            int maxRows = rows - startRow;
            int maxCols = cols - startCol;

            // Top layer
            for (int j=startCol; j<maxCols; j++) {
                layer.add(new Integer(matrix[startRow][j]));
            }

            // Right layer
            for (int i=startRow+1; i<maxRows-1; i++) {
                layer.add(new Integer(matrix[i][maxCols-1]));
            }

            // Bottom layer
            for (int j=maxCols-1; j>=startCol; j--) {
                layer.add(new Integer(matrix[maxRows-1][j]));
            }

            // Left layer
            for (int i=maxRows-2; i>=startRow+1; i--) {
                layer.add(new Integer(matrix[i][startCol]));
            }

            layers.add(layer);

            startRow++;
            startCol++;

            if (startCol > (cols/2) || startRow > (rows/2)) {
                finished = true;
            }
        }

        // Rotating layers
        for (List<Integer> l : layers) {
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
                rotatedMatrix[startRow][j] = layer.remove(0).intValue();
            }

            // Right layer
            for (int i=startRow+1; i<maxRows-1; i++) {
                rotatedMatrix[i][maxCols-1] = layer.remove(0).intValue();
            }

            // Bottom layer
            for (int j=maxCols-1; j>=startCol; j--) {
                rotatedMatrix[maxRows-1][j] = layer.remove(0).intValue();
            }

            // Left layer
            for (int i=maxRows-2; i>=startRow+1; i--) {
                rotatedMatrix[i][startCol] = layer.remove(0).intValue();
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

    private void rotateList(List<Integer> list) {

        if (list.size() == 0) {
            return;
        }

        for (int i=0; i<this.rotation; i++) {
            Integer v = list.remove(0);
            list.add(v);
        }
    }

    public int[][] readMatrix() {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

         this.rotation = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public void printMatrix(int[][] matrix) {

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

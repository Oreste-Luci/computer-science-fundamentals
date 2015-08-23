import java.util.Scanner;

public class LevelsFromOneNodeToOther {

    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter graph number (1 or 2):");
        int graphNumber = scanner.nextInt();

        System.out.println("Enter node 1:");
        int node1 = scanner.nextInt();

        System.out.println("Enter node 2:");
        int node2 = scanner.nextInt();

        int[][] graph = LevelsFromOneNodeToOther.createGraph(graphNumber);

        System.out.println("The minimum path is: " + LevelsFromOneNodeToOther.distance(node1,node2,graph));
    }

    /**
     * This implements Dijkstra's Algorithm
     */
    public static int distance(int node1, int node2, int[][] graph) {

        --node1;
        --node2;

        int size = graph.length;

        // Array where result will be kept
        // First row keeps distance
        // Second row keeps where from
        int[][] distances = new int[3][size];

        // Initializing array
        for (int i=0; i<size; i++) {
            distances[0][i] = INF; // Contains distance
            distances[1][i] = -1; // Contains from where
            distances[2][i] = 0; // 0 -> Not visited, 1 -> Visited
        }

        int previousDistance = 0;
        int node = node1;

        boolean finished = false;
        while (!finished) {

            for (int i=0; i<size; i++) {

                int currentDistance = graph[node][i];

                if (node1 == i) {

                    distances[0][i] = 0;
                    distances[1][i] = 0;
                    distances[2][i] = 1;

                } else if ( (currentDistance + previousDistance) > 0 && (currentDistance + previousDistance) < distances[0][i]) {

                    distances[0][i] = previousDistance + currentDistance;
                    distances[1][i] = node;
                }
            }

            // Findind the next node to examine
            int smallest = INF;
            int smallestNode = INF;

            for (int i=0; i<size; i++) {
                if (i != node1  &&  distances[2][i] != 1  &&  distances[0][i] < smallest) {
                    smallest = distances[0][i];
                    smallestNode = i;
                }
            }

            if (smallest == INF) {
                finished = true;
            } else {
                node = smallestNode;
                distances[2][smallestNode] = 1;
                previousDistance = distances[0][smallestNode];
            }
        }

        System.out.print("Shortest Path: ");
        printPath(distances, node2);
        System.out.println(" ");

        return distances[0][node2];
    }

    /**
     * Prints the resulting shortest path from the end to the begining
     */
    public static void printPath(int[][] solution, int node) {

        if (node == -1) {
            System.out.println("No Path to Node!");
        } else if (node == 0) {
            return;
        } else {
            System.out.print( (node + 1) + " ");
            printPath(solution, solution[1][node]);
        }
    }

    public static int[][] createGraph(int v) {

        int[][] graph1 = {
            //    1   2   3   4   5   6   7   8   9  10  11  12  13  14  15
                {INF,  1,INF,  1,  1,  1,INF,INF,INF,INF,INF,INF,INF,INF,INF},
                {  1,INF,INF,INF,INF,INF,  1,INF,INF,INF,INF,INF,INF,INF,INF},
                {INF,INF,INF,  1,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
                {  1,INF,  1,INF,INF,INF,INF,  1,INF,INF,INF,INF,INF,INF,INF},
                {  1,INF,INF,INF,INF,INF,INF,INF,  1,  1,INF,INF,INF,INF,INF},
                {  1,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
                {INF,  1,INF,INF,INF,INF,INF,  1,INF,INF,INF,  1,INF,INF,INF},
                {INF,INF,INF,  1,INF,INF,  1,INF,INF,INF,INF,INF,  1,INF,INF},
                {INF,INF,INF,INF,  1,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
                {INF,INF,INF,INF,  1,INF,INF,INF,INF,INF,INF,INF,INF,  1,INF},
                {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,  1,INF,INF,INF},
                {INF,INF,INF,INF,INF,INF,  1,INF,INF,INF,  1,INF,INF,INF,INF},
                {INF,INF,INF,INF,INF,INF,INF,  1,INF,INF,INF,INF,INF,  1,  1},
                {INF,INF,INF,INF,INF,INF,INF,INF,INF,  1,INF,INF,  1,INF,INF},
                {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,  1,INF,INF}
        };

        int[][] graph2 = {
                //  A    B    C    D    E    F    G    H
                {  0,  20, INF,  80, INF, INF,  90, INF},
                {INF,   0, INF, INF, INF,  10, INF, INF},
                {INF, INF,   0,  10, INF,  50, INF,  20},
                {INF, INF,  10,   0, INF, INF,  20, INF},
                {INF,  50, INF, INF,   0, INF,  30, INF},
                {INF, INF,  10,  40, INF,   0, INF, INF},
                { 20, INF, INF, INF, INF, INF,   0, INF},
                {INF, INF, INF, INF, INF, INF, INF,   0}
        };

        if (v == 1)
            return graph1;
        else
            return graph2;
    }
}

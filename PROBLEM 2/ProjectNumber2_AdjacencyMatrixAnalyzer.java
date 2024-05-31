package renewedpackage;

import java.util.HashMap; 
import java.util.Map;
import java.util.Scanner;

public class ProjectNumber2_AdjacencyMatrixAnalyzer {

    public static void main(String[] args) {
        Scanner alovera_scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int alovera_numVertices = alovera_scanner.nextInt();

        // Initialize adjacency matrix with zeros
        int[][] alovera_adjMatrix = new int[alovera_numVertices][alovera_numVertices];

        System.out.println("Enter the adjacency matrix (space-separated values per row): ");
        for (int alovera_i = 0; alovera_i < alovera_numVertices; alovera_i++) {
            for (int alovera_j = 0; alovera_j < alovera_numVertices; alovera_j++) {
                alovera_adjMatrix[alovera_i][alovera_j] = alovera_scanner.nextInt();
            }
        }

        // Analyze and print edge occurrences
        alovera_analyzeAdjacencyMatrix(alovera_adjMatrix);

        alovera_scanner.close();
    }

    public static void alovera_analyzeAdjacencyMatrix(int[][] alovera_adjMatrix) {
        int alovera_numVertices = alovera_adjMatrix.length;

        // Create a dictionary to store edge occurrences (vertex pair as key and count as value)
        HashMap<String, Integer> alovera_edgeCounts = new HashMap<>();
        for (int alovera_i = 0; alovera_i < alovera_numVertices; alovera_i++) {
            for (int alovera_j = alovera_i; alovera_j < alovera_numVertices; alovera_j++) {  // Consider upper triangular matrix for undirected graphs
                if (alovera_adjMatrix[alovera_i][alovera_j] > 0) {
                    String alovera_edgeKey = alovera_i + "-" + alovera_j;  // Create key string (consider order for undirected graph)
                    alovera_edgeCounts.put(alovera_edgeKey, alovera_edgeCounts.getOrDefault(alovera_edgeKey, 0) + alovera_adjMatrix[alovera_i][alovera_j]);
                }
            }
        }

        // Print the edges and their occurrence counts
        for (Map.Entry<String, Integer> alovera_entry : alovera_edgeCounts.entrySet()) {
            String[] alovera_vertices = alovera_entry.getKey().split("-");
            int alovera_source = Integer.parseInt(alovera_vertices[0]);
            int alovera_destination = Integer.parseInt(alovera_vertices[1]);
            System.out.println("Edge (" + alovera_source + ", " + alovera_destination + ") appears " + alovera_entry.getValue() + " times.");
        }
    }
}
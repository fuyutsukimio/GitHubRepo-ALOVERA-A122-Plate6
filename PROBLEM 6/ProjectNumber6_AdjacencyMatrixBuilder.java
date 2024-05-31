package renewedpackage;

import java.util.Scanner;

public class ProjectNumber6_AdjacencyMatrixBuilder {

  public static void main(String[] args) {
    Scanner alovera_scanner = new Scanner(System.in);
    System.out.print("Is the graph directed? (true/false) ");
    boolean alovera_isDirected = alovera_scanner.nextBoolean();

    System.out.print("Enter the number of vertices: ");
    int alovera_numVertices = alovera_scanner.nextInt();

    // Initialize adjacency matrix with zeros
    int[][] alovera_adjMatrix = new int[alovera_numVertices][alovera_numVertices];

    System.out.print("Enter the number of edges: ");
    int alovera_numEdges = alovera_scanner.nextInt();

    System.out.println("Enter the edges (source vertex, destination vertex): ");
    for (int alovera_i = 0; alovera_i < alovera_numEdges; alovera_i++) {
      int alovera_source = alovera_scanner.nextInt();
      int alovera_destination = alovera_scanner.nextInt();

      // Handle loops and multiple edges
      alovera_adjMatrix[alovera_source][alovera_destination]++;

      // Handle directed edges (one-way connection)
      // If undirected graph is desired, uncomment the following line:
      if (!alovera_isDirected) {
      alovera_adjMatrix[alovera_destination][alovera_source]++;
      }
    }

    System.out.println("Adjacency Matrix:");
    for (int alovera_i = 0; alovera_i < alovera_numVertices; alovera_i++) {
      for (int alovera_j = 0; alovera_j < alovera_numVertices; alovera_j++) {
        System.out.print(alovera_adjMatrix[alovera_i][alovera_j] + " ");
      }
      System.out.println();
    }
    alovera_scanner.close();
  }
}
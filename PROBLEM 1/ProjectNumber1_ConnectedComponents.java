package renewedpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectNumber1_ConnectedComponents {

  static class UnionFind {
    private int[] alovera_parent; //Stores the parent element for each vertex. Initially, each vertex is its own parent (representing a single-element set).
    private int[] alovera_rank; //Used for path compression optimization. It keeps track of the "height" of a tree in the forest (number of ancestors).

    public UnionFind(int alovera_n) {
      alovera_parent = new int[alovera_n];
      alovera_rank = new int[alovera_n];
      for (int alovera_i = 0; alovera_i < alovera_n; alovera_i++) {
        alovera_parent[alovera_i] = alovera_i;
      }
    }

    public int alovera_find(int alovera_x) {
      if (alovera_parent[alovera_x] != alovera_x) {
        alovera_parent[alovera_x] = alovera_find(alovera_parent[alovera_x]);  // Path compression for efficiency
      }
      return alovera_parent[alovera_x];
    }
    
    public void alovera_union(int alovera_x, int alovera_y) {
      int alovera_rootX = alovera_find(alovera_x);
      int alovera_rootY = alovera_find(alovera_y);

      if (alovera_rootX == alovera_rootY) {
        return;  // Already in the same set
      }

      if (alovera_rank[alovera_rootX] > alovera_rank[alovera_rootY]) {
        alovera_parent[alovera_rootY] = alovera_rootX;
      } else if (alovera_rank[alovera_rootX] < alovera_rank[alovera_rootY]) {
        alovera_parent[alovera_rootX] = alovera_rootY;
      } else {
        alovera_parent[alovera_rootY] = alovera_rootX;
        alovera_rank[alovera_rootX]++;
      }
    }
  }
  
  public static int alovera_countConnectedComponents(List<List<Integer>> alovera_edges, int alovera_numVertices) {
    UnionFind alovera_uf = new UnionFind(alovera_numVertices);

    // Iterate through edges and perform union on connected vertices
    for (List<Integer> alovera_edge : alovera_edges) {
      int alovera_src = alovera_edge.get(0);
      int alovera_dest = alovera_edge.get(1);
      alovera_uf.alovera_union(alovera_src, alovera_dest);
    }

    // Count the number of distinct parent elements (representatives of sets)
   int alovera_count = 0;
    for (int alovera_i = 0; alovera_i < alovera_numVertices; alovera_i++) {
      if (alovera_uf.alovera_find(alovera_i) == alovera_i) {
        alovera_count++;
      }
    }
    return alovera_count;
  }

  public static void main(String[] args) {
    Scanner alovera_scanner = new Scanner(System.in);

    System.out.print("Enter the number of vertices: ");
    int alovera_numVertices = alovera_scanner.nextInt();

    System.out.print("Enter the number of edges: ");
    int alovera_numEdges = alovera_scanner.nextInt();

    List<List<Integer>> alovera_edges = new ArrayList<>();

    System.out.println("Enter the edges (source vertex, destination vertex): ");
    for (int alovera_i = 0; alovera_i < alovera_numEdges; alovera_i++) {
      int alovera_source = alovera_scanner.nextInt();
      int alovera_destination = alovera_scanner.nextInt();
      alovera_edges.add(List.of(alovera_source, alovera_destination));
    }

    int alovera_connectedComponents = alovera_countConnectedComponents(alovera_edges, alovera_numVertices);

    if (alovera_connectedComponents == 1) {
      System.out.println("Graph is connected");
    } else {
      System.out.println("Graph is not connected. Number of connected components: " + alovera_connectedComponents);
    }

    alovera_scanner.close();
  }
}
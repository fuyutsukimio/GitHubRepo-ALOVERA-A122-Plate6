package renewedpackage;
import java.util.*;

public class VertexDegree {
    private static Map<Integer, List<Integer>> alovera_adjList;

    public static void main(String[] args) {
        Scanner alovera_scanner = new Scanner(System.in);

        for (int alovera_t = 1; alovera_t <= 5; alovera_t++) {
            alovera_adjList = new HashMap<>();
            System.out.println("Test case " + alovera_t + ":");
            System.out.println("Enter the number of edges:");
            int alovera_numEdges = alovera_scanner.nextInt();
            System.out.println("Enter the edges (format: node1 node2):");
            for (int alovera_i = 0; alovera_i < alovera_numEdges; alovera_i++) {
                int alovera_u = alovera_scanner.nextInt();
                int alovera_v = alovera_scanner.nextInt();
                alovera_adjList.computeIfAbsent(alovera_u, k -> new ArrayList<>()).add(alovera_v);
                alovera_adjList.computeIfAbsent(alovera_v, k -> new ArrayList<>()).add(alovera_u);
            }
            System.out.println("Degrees of vertices:");
            for (int alovera_node : alovera_adjList.keySet()) {
                System.out.println("Degree of vertex " + alovera_node + ": " + alovera_adjList.get(alovera_node).size());
            }
            System.out.println();
        }
        alovera_scanner.close();
    }
}

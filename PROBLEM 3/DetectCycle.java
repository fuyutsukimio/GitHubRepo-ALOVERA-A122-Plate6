package renewedpackage;

import java.util.*;

public class DetectCycle {
    private static Map<Integer, List<Integer>> alovera_adjList;
    private static Set<Integer> alovera_visited;

    public static void main(String[] args) {
        Scanner alovera_scanner = new Scanner(System.in);

        for (int alovera_t = 1; alovera_t <= 5; alovera_t++) {
            alovera_adjList = new HashMap<>();
            alovera_visited = new HashSet<>();
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
            System.out.println("Has Cycle: " + hasCycle());
            System.out.println();
        }
        alovera_scanner.close();
    }

    private static boolean hasCycle() {
        for (int alovera_node : alovera_adjList.keySet()) {
            if (!alovera_visited.contains(alovera_node) && dfs(alovera_node, -1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(int alovera_node, int alovera_parent) {
        alovera_visited.add(alovera_node);
        for (int alovera_neighbor : alovera_adjList.get(alovera_node)) {
            if (!alovera_visited.contains(alovera_neighbor)) {
                if (dfs(alovera_neighbor, alovera_node)) return true;
            } else if (alovera_neighbor!= alovera_parent) {
                return true;
            }
        }
        return false;
    }
}

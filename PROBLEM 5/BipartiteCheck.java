package renewedpackage;
import java.util.*;

public class BipartiteCheck {
    private static Map<Integer, List<Integer>> alovera_adjList;
    private static Map<Integer, Integer> alovera_colors;

    public static void main(String[] args) {
        Scanner alovera_scanner = new Scanner(System.in);

        for (int alovera_t = 1; alovera_t <= 5; alovera_t++) {
            alovera_adjList = new HashMap<>();
            alovera_colors = new HashMap<>();
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
            System.out.println("Is Bipartite: " + isBipartite());
            System.out.println();
        }
        alovera_scanner.close();
    }

    private static boolean isBipartite() {
        for (int alovera_node : alovera_adjList.keySet()) {
            if (!alovera_colors.containsKey(alovera_node)) {
                if (!bfs(alovera_node)) return false;
            }
        }
        return true;
    }

    private static boolean bfs(int alovera_start) {
        Queue<Integer> alovera_queue = new LinkedList<>();
        alovera_queue.add(alovera_start);
        alovera_colors.put(alovera_start, 0);
        while (!alovera_queue.isEmpty()) {
            int alovera_node = alovera_queue.poll();
            int alovera_color = alovera_colors.get(alovera_node);
            for (int alovera_neighbor : alovera_adjList.get(alovera_node)) {
                if (!alovera_colors.containsKey(alovera_neighbor)) {
                    alovera_colors.put(alovera_neighbor, 1 - alovera_color);
                    alovera_queue.add(alovera_neighbor);
                } else if (alovera_colors.get(alovera_neighbor) == alovera_color) {
                    return false;
                }
            }
        }
        return true;
    }
}

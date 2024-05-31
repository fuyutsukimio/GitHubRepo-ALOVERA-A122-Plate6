package renewedpackage;
import java.util.*;

public class GraphIsomorphism {
    private static Map<Integer, List<Integer>> alovera_adjList1;
    private static Map<Integer, List<Integer>> alovera_adjList2;

    public static void main(String[] args) {
        Scanner alovera_scanner = new Scanner(System.in);

        for (int alovera_t = 1; alovera_t <= 5; alovera_t++) {
            alovera_adjList1 = new HashMap<>();
            alovera_adjList2 = new HashMap<>();
            System.out.println("Test case " + alovera_t + ":");
            System.out.println("Enter the number of edges for the first graph:");
            int alovera_numEdges1 = alovera_scanner.nextInt();
            System.out.println("Enter the edges for the first graph (format: node1 node2):");
            for (int alovera_i = 0; alovera_i < alovera_numEdges1; alovera_i++) {
                int alovera_u = alovera_scanner.nextInt();
                int alovera_v = alovera_scanner.nextInt();
                alovera_adjList1.computeIfAbsent(alovera_u, k -> new ArrayList<>()).add(alovera_v);
                alovera_adjList1.computeIfAbsent(alovera_v, k -> new ArrayList<>()).add(alovera_u);
            }

            System.out.println("Enter the number of edges for the second graph:");
            int alovera_numEdges2 = alovera_scanner.nextInt();
            System.out.println("Enter the edges for the second graph (format: node1 node2):");
            for (int alovera_i = 0; alovera_i < alovera_numEdges2; alovera_i++) {
                int alovera_u = alovera_scanner.nextInt();
                int alovera_v = alovera_scanner.nextInt();
                alovera_adjList2.computeIfAbsent(alovera_u, k -> new ArrayList<>()).add(alovera_v);
                alovera_adjList2.computeIfAbsent(alovera_v, k -> new ArrayList<>()).add(alovera_u);
            }

            System.out.println("Are Isomorphic: " + areIsomorphic());
            System.out.println();
        }
        alovera_scanner.close();
    }

    private static boolean areIsomorphic() {
        if (alovera_adjList1.size()!= alovera_adjList2.size()) return false;
        Map<Integer, Integer> alovera_mapping = new HashMap<>();
        return isIsomorphic(new ArrayList<>(alovera_adjList1.keySet()), new ArrayList<>(alovera_adjList2.keySet()), alovera_mapping);
    }

    private static boolean isIsomorphic(List<Integer> alovera_nodes1, List<Integer> alovera_nodes2, Map<Integer, Integer> alovera_mapping) {
        if (alovera_nodes1.isEmpty() && alovera_nodes2.isEmpty()) return true;
        if (alovera_nodes1.size()!= alovera_nodes2.size()) return false;

        int alovera_node1 = alovera_nodes1.get(0);
        for (int alovera_node2 : alovera_nodes2) {
            if (isValidMapping(alovera_node1, alovera_node2, alovera_mapping)) {
                alovera_mapping.put(alovera_node1, alovera_node2);
                List<Integer> alovera_nextNodes1 = new ArrayList<>(alovera_nodes1);
                List<Integer> alovera_nextNodes2 = new ArrayList<>(alovera_nodes2);
                alovera_nextNodes1.remove(Integer.valueOf(alovera_node1));
                alovera_nextNodes2.remove(Integer.valueOf(alovera_node2));
                if (isIsomorphic(alovera_nextNodes1, alovera_nextNodes2, alovera_mapping)) return true;
                alovera_mapping.remove(alovera_node1);
            }
        }
        return false;
    }

    private static boolean isValidMapping(int alovera_node1, int alovera_node2, Map<Integer, Integer> alovera_mapping) {
        for (int alovera_neighbor1 : alovera_adjList1.get(alovera_node1)) {
            if (alovera_mapping.containsKey(alovera_neighbor1)) {
                int alovera_neighbor2 = alovera_mapping.get(alovera_neighbor1);
                if (!alovera_adjList2.get(alovera_node2).contains(alovera_neighbor2)) return false;
            }
        }
        return true;
    }
}
package renewedpackage;
import java.util.*;

public class IncidenceMatrix {
    public static void main(String[] args) {
        Scanner alovera_scanner = new Scanner(System.in);

        for (int alovera_t = 1; alovera_t <= 5; alovera_t++) {
            System.out.println("Test case " + alovera_t + ":");
            System.out.println("Enter the number of edges:");
            int alovera_numEdges = alovera_scanner.nextInt();
            int[][] alovera_edges = new int[alovera_numEdges][2];
            int[] alovera_occurrences = new int[alovera_numEdges];

            System.out.println("Enter the edges (format: node1 node2):");
            for (int alovera_i = 0; alovera_i < alovera_numEdges; alovera_i++) {
                alovera_edges[alovera_i][0] = alovera_scanner.nextInt();
                alovera_edges[alovera_i][1] = alovera_scanner.nextInt();
            }

            System.out.println("Enter the occurrences of each edge:");
            for (int alovera_i = 0; alovera_i < alovera_numEdges; alovera_i++) {
                alovera_occurrences[alovera_i] = alovera_scanner.nextInt();
            }

            testIncidenceMatrix(alovera_edges, alovera_occurrences);
            System.out.println();
        }
        alovera_scanner.close();
    }

    private static void testIncidenceMatrix(int[][] alovera_edges, int[] alovera_occurrences) {
        int alovera_n = getMaxNode(alovera_edges) + 1;
        int alovera_e = alovera_edges.length;
        int[][] alovera_incidenceMatrix = new int[alovera_n][alovera_e];

        for (int alovera_i = 0; alovera_i < alovera_e; alovera_i++) {
            int[] alovera_edge = alovera_edges[alovera_i];
            alovera_incidenceMatrix[alovera_edge[0]][alovera_i] = alovera_occurrences[alovera_i];
            alovera_incidenceMatrix[alovera_edge[1]][alovera_i] = alovera_occurrences[alovera_i];
        }

        for (int[] alovera_row : alovera_incidenceMatrix) {
            System.out.println(arrayToString(alovera_row));
        }
    }

    private static int getMaxNode(int[][] alovera_edges) {
        int alovera_max = 0;
        for (int[] alovera_edge : alovera_edges) {
            for (int alovera_node : alovera_edge) {
                if (alovera_node > alovera_max) {
                    alovera_max = alovera_node;
                }
            }
        }
        return alovera_max;
    }

    public static String arrayToString(int[] alovera_array) {
        StringBuilder alovera_sb = new StringBuilder();
        alovera_sb.append("[");
        for (int alovera_i = 0; alovera_i < alovera_array.length; alovera_i++) {
            alovera_sb.append(alovera_array[alovera_i]);
            if (alovera_i < alovera_array.length - 1) {
                alovera_sb.append(", ");
            }
        }
        alovera_sb.append("]");
        return alovera_sb.toString();
    }
}

import java.util.*;

public class DijkstraAlgorithm {
    static final int INF = Integer.MAX_VALUE;

    int findMinDistance(int[] distance, boolean[] visited, int vertices) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void dijkstra(int[][] graph, int source, int vertices) {
        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            distance[i] = INF;
            visited[i] = false;
        }

        distance[source] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = findMinDistance(distance, visited, vertices);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        distance[u] != INF &&
                        distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        System.out.println("\nShortest distances from source vertex " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + " -> " +
                    (distance[i] == INF ? "∞" : distance[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DijkstraAlgorithm da = new DijkstraAlgorithm();

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix (0 if no edge):");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex (0 - " + (vertices - 1) + "): ");
        int source = sc.nextInt();

        da.dijkstra(graph, source, vertices);
        sc.close();
    }
}

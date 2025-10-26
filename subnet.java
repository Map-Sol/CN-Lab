import java.util.*;

public class BroadcastTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes (hosts/switches): ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter adjacency matrix (1 if connected, 0 if not):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source node (root of broadcast, 0 to " + (n - 1) + "): ");
        int src = sc.nextInt();

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        System.out.println("\nBFS traversal (broadcast order):");
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.add(v);
                }
            }
        }

        System.out.println("\n\nBroadcast Tree (Parent → Child edges):");
        for (int i = 0; i < n; i++) {
            if (parent[i] != -1) {
                System.out.println(parent[i] + " → " + i);
            }
        }

        sc.close();
    }
}

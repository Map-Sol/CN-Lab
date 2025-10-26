import java.util.*;

public class DistanceVectorRouting {
    static final int INF = 9999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        System.out.println("Enter cost matrix (use 9999 for no direct link):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int[][] dist = new int[n][n];
        int[][] nextHop = new int[n][n];

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = cost[i][j];
                if (cost[i][j] != INF && i != j)
                    nextHop[i][j] = j;
                else
                    nextHop[i][j] = -1;
            }
        }

       
        for (int k = 0; k < n - 1; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        if (dist[i][l] + dist[l][j] < dist[i][j]) {
                            dist[i][j] = dist[i][l] + dist[l][j];
                            nextHop[i][j] = nextHop[i][l];
                        }
                    }
                }
            }
        }

       
        for (int i = 0; i < n; i++) {
            System.out.println("\nRouting table for Node " + i + ":");
            System.out.println("Destination\tCost\tNext Hop");
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                System.out.println(j + "\t\t" + dist[i][j] + "\t" + nextHop[i][j]);
            }
        }

        sc.close();
    }
}


import java.util.*;

public class DVR {
    static final int INF = 9999;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = s.nextInt();
        int[][] c = new int[n][n];
        System.out.println("Enter cost matrix (use 9999 for no direct link):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                c[i][j] = s.nextInt();

        int[][] d = new int[n][n];
        int[][] nh = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = c[i][j];
                if (c[i][j] != INF && i != j)
                    nh[i][j] = j;
                else
                    nh[i][j] = -1;
            }
            d[i][i] = 0;
            nh[i][i] = -1;
        }

        for (int k = 0; k < n - 1; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    for (int l = 0; l < n; l++)
                        if (d[i][l] < INF && d[l][j] < INF && d[i][l] + d[l][j] < d[i][j]) {
                            d[i][j] = d[i][l] + d[l][j];
                            nh[i][j] = nh[i][l];
                        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nRouting table for Node " + i + ":");
            System.out.println("Destination\tCost\tNext Hop");
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                String cs = (d[i][j] >= INF) ? "INF" : String.valueOf(d[i][j]);
                String hs = (nh[i][j] == -1) ? "-" : String.valueOf(nh[i][j]);
                System.out.println(j + "\t\t" + cs + "\t" + hs);
            }
        }
        s.close();
    }
}


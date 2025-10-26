import java.util.*;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bucket capacity: ");
        int bucketCapacity = sc.nextInt();

        System.out.print("Enter output rate (per time unit): ");
        int outputRate = sc.nextInt();

        System.out.print("Enter number of incoming packets: ");
        int n = sc.nextInt();

        int[] incoming = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter packet(s) arriving at time unit " + (i + 1) + ": ");
            incoming[i] = sc.nextInt();
        }

        int bucketLevel = 0;

        System.out.println("\nTime\tIncoming\tTransmitted\tDropped\tBucket Level");
        for (int i = 0; i < n; i++) {
            int drop = 0;

            if (bucketLevel + incoming[i] > bucketCapacity) {
                drop = (bucketLevel + incoming[i]) - bucketCapacity;
                bucketLevel = bucketCapacity;
            } else {
                bucketLevel += incoming[i];
            }

            int transmitted = Math.min(bucketLevel, outputRate);
            bucketLevel -= transmitted;

            System.out.println((i + 1) + "\t" + incoming[i] + "\t\t" + transmitted + "\t\t" + drop + "\t" + bucketLevel);
        }

        sc.close();
    }
}

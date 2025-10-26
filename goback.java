import java.util.*;

public class GoBackN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of frames to send: ");
        int totalFrames = sc.nextInt();

        System.out.print("Enter window size: ");
        int windowSize = sc.nextInt();

        int sent = 0;

        while (sent < totalFrames) {
            int end = Math.min(sent + windowSize, totalFrames);
            System.out.println("\nSending frames: " + sent + " to " + (end - 1));

            for (int i = sent; i < end; i++) {
                System.out.println("Frame " + i + " sent.");
            }

            System.out.print("Enter lost frame number (-1 if none lost): ");
            int lost = sc.nextInt();

            if (lost == -1) {
                System.out.println("All frames acknowledged successfully.");
                sent = end;
            } else if (lost >= sent && lost < end) {
                System.out.println("Frame " + lost + " lost! Retransmitting from frame " + lost + "...");
                sent = lost;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        System.out.println("\nAll frames sent and acknowledged successfully!");
        sc.close();
    }
}

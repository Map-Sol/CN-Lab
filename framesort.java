import java.util.*;

class Frame {
    int seqNo;
    String data;

    Frame(int seqNo, String data) {
        this.seqNo = seqNo;
        this.data = data;
    }
}

public class FrameSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames in buffer: ");
        int n = sc.nextInt();
        sc.nextLine();

        Frame[] buffer = new Frame[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter sequence number for frame " + (i + 1) + ": ");
            int seq = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter data for frame " + seq + ": ");
            String data = sc.nextLine();
            buffer[i] = new Frame(seq, data);
        }

        Arrays.sort(buffer, Comparator.comparingInt(f -> f.seqNo));

        System.out.println("\nFrames sorted by sequence number:");
        for (Frame f : buffer) {
            System.out.println("SeqNo: " + f.seqNo + " | Data: " + f.data);
        }

        sc.close();
    }
}

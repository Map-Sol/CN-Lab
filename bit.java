import java.util.*;

public class FramingMethods {

   
    static void characterCountFraming(String[] frames) {
        System.out.println("\n--- Character Count Framing ---");
        StringBuilder result = new StringBuilder();
        for (String frame : frames) {
            int count = frame.length() + 1;
            result.append(count).append(frame);
        }
        System.out.println("Framed Data: " + result);
    }

   
    static void characterStuffing(String data) {
        System.out.println("\n--- Character Stuffing ---");
        String flag = "DLESTX";
        String end = "DLEETX";
        String stuffed = data.replace("DLE", "DLEDLE");
        String framed = flag + stuffed + end;
        System.out.println("Stuffed Frame: " + framed);
    }

   
    static void bitStuffing(String data) {
        System.out.println("\n--- Bit Stuffing ---");
        String flag = "01111110";
        StringBuilder stuffed = new StringBuilder();
        int count = 0;

        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);
            stuffed.append(bit);
            if (bit == '1') {
                count++;
                if (count == 5) {
                    stuffed.append('0');
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        String framed = flag + stuffed + flag;
        System.out.println("Stuffed Frame: " + framed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames for Character Count method: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] frames = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter frame " + (i + 1) + ": ");
            frames[i] = sc.nextLine();
        }
        characterCountFraming(frames);

        System.out.print("\nEnter data for Character Stuffing: ");
        String data1 = sc.nextLine();
        characterStuffing(data1);

        System.out.print("\nEnter bit sequence for Bit Stuffing: ");
        String data2 = sc.nextLine();
        bitStuffing(data2);

        sc.close();
    }
}

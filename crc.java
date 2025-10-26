import java.util.*;

public class CRCComputation {
    static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < b.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();
    }

    static String computeCRC(String data, String generator) {
        int genLen = generator.length();
        String appendedData = data + "0".repeat(genLen - 1);
        String temp = appendedData.substring(0, genLen);

        for (int i = genLen; i < appendedData.length(); i++) {
            if (temp.charAt(0) == '1')
                temp = xor(generator, temp) + appendedData.charAt(i);
            else
                temp = xor("0".repeat(genLen), temp) + appendedData.charAt(i);
        }

        if (temp.charAt(0) == '1')
            temp = xor(generator, temp);
        else
            temp = xor("0".repeat(genLen), temp);

        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data bits: ");
        String data = sc.next();

        String crc12 = "1100000001111";
        String crc16 = "11000000000000101";
        String crcCCITT = "10001000000100001";

        System.out.println("\n--- CRC Computation Results ---");

        String remainder12 = computeCRC(data, crc12);
        System.out.println("CRC-12: " + remainder12);

        String remainder16 = computeCRC(data, crc16);
        System.out.println("CRC-16: " + remainder16);

        String remainderCCITT = computeCRC(data, crcCCITT);
        System.out.println("CRC-CCITT: " + remainderCCITT);

        sc.close();
    }
}

import java.util.Scanner;

public class XorEncryptDecrypt {
    
    // XOR Encryption and Decryption function
    static String xorEncryptDecrypt(String text, char key) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = (char)(text.charAt(i) ^ key);  // XOR each character
            output.append(ch);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter single-character key: ");
        char key = sc.next().charAt(0);

        String encrypted = xorEncryptDecrypt(text, key);
        String decrypted = xorEncryptDecrypt(encrypted, key);

        System.out.println("\nEncrypted text: " + encrypted);

        System.out.print("Encrypted ASCII values: ");
        for (int i = 0; i < encrypted.length(); i++) {
            System.out.print((int)encrypted.charAt(i) + " ");
        }

        System.out.println("\nDecrypted text: " + decrypted);

        sc.close();
    }
}

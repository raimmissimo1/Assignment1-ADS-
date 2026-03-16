import java.util.Scanner;

public class Main {

    public static int countChars(String s) {
        if (s.isEmpty()) {
            return 0; // base case
        }
        return 1 + countChars(s.substring(1)); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        System.out.println(countChars(s));
    }
}

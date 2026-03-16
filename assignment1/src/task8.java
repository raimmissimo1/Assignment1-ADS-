import java.util.Scanner;

public class Main {

    public static boolean checkDigits(String s, int index) {
        if (index == s.length()) {
            return true; // base case
        }

        if (!Character.isDigit(s.charAt(index))) {
            return false;
        }

        return checkDigits(s, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        if (checkDigits(s, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

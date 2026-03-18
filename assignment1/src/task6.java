////
import java.util.Scanner;

public class Main {

    public static long power(long a, long n) {
        if (n == 0) {
            return 1; // base case
        }
        return a * power(a, n - 1); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long n = scanner.nextLong();

        System.out.println(power(a, n));
    }
}

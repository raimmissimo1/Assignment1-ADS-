
////
import java.util.Scanner;

public class Main {

    public static boolean isPrime(int n, int i) {
        if (n <= 2) return n == 2;

        if (i == n) return true;

        if (n % i == 0) return false;

        return isPrime(n, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (isPrime(n, 2))
            System.out.println("Prime");
        else
            System.out.println("Composite");
    }
}

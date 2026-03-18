
////
import java.util.Scanner;

public class Main {

    public static void reversePrint(int n, Scanner scanner) {
        if (n == 0) {
            return; // base case
        }

        int num = scanner.nextInt();

        reversePrint(n - 1, scanner); 

        System.out.print(num + " "); 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        reversePrint(n, scanner);
    }
}

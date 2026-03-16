import java.util.Scanner;

public class Main {
    
    public static void printDigits(int n) {
        if (n == 0) {
            return;
        }
       
       	printDigits(n / 10);
        System.out.println(n % 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printDigits(n);
    }
}

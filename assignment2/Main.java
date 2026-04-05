import java.util.*;

class BankAccount {
    private String accountNumber;
    private String username;
    private double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Username: " + username + ", Balance: " + String.format("%.2f", balance);
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> transactionHistory = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> accountRequests = new LinkedList<>();

    static BankAccount[] predefinedAccounts = new BankAccount[3];

    public static void main(String[] args) {
        setupInitialData();
        mainMenu();
    }

    public static void setupInitialData() {
        predefinedAccounts[0] = new BankAccount("ACC001", "Ali", 150000);
        predefinedAccounts[1] = new BankAccount("ACC002", "Sara", 220000);
        predefinedAccounts[2] = new BankAccount("ACC003", "Dana", 175000);

        accounts.add(predefinedAccounts[0]);
        accounts.add(predefinedAccounts[1]);
        accounts.add(predefinedAccounts[2]);

        billQueue.add("Electricity Bill");
        billQueue.add("Internet Bill");
    }

    public static void mainMenu() {
        int choice;
        do {
            System.out.println("\n===== MINI BANKING SYSTEM =====");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Task 1-6 Demo");
            System.out.println("5 - Exit");
            System.out.print("Choose option: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    bankMenu();
                    break;
                case 2:
                    atmMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
                case 4:
                    runAllTasksDemo();
                    break;
                case 5:
                    System.out.println("Thank you for using the banking system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);
    }

    public static void bankMenu() {
        int choice;
        do {
            System.out.println("\n----- BANK MENU -----");
            System.out.println("1 - Submit account opening request");
            System.out.println("2 - Deposit money");
            System.out.println("3 - Withdraw money");
            System.out.println("4 - Pay bill");
            System.out.println("5 - Display all accounts");
            System.out.println("6 - Search account by username");
            System.out.println("7 - Back");
            System.out.print("Choose option: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    submitAccountRequest();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    addBillPayment();
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 6:
                    searchAccountByUsername();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 7);
    }

    public static void atmMenu() {
        int choice;
        do {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Back");
            System.out.print("Choose option: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);
    }

    public static void adminMenu() {
        int choice;
        do {
            System.out.println("\n----- ADMIN MENU -----");
            System.out.println("1 - View pending account requests");
            System.out.println("2 - Process next account request");
            System.out.println("3 - View bill payment queue");
            System.out.println("4 - Process next bill payment");
            System.out.println("5 - View last transaction");
            System.out.println("6 - Undo last transaction record");
            System.out.println("7 - Print array of predefined accounts");
            System.out.println("8 - Back");
            System.out.print("Choose option: ");
            choice = readInt();

            switch (choice) {
                case 1:
                    displayPendingRequests();
                    break;
                case 2:
                    processAccountRequest();
                    break;
                case 3:
                    displayBillQueue();
                    break;
                case 4:
                    processBillPayment();
                    break;
                case 5:
                    showLastTransaction();
                    break;
                case 6:
                    undoLastTransaction();
                    break;
                case 7:
                    printArrayAccounts();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 8);
    }

    public static void addNewAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter balance: ");
        double balance = readDouble();

        accounts.add(new BankAccount(accountNumber, username, balance));
        System.out.println("Account added successfully.");
    }

    public static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\nAccounts List:");
        int index = 1;
        for (BankAccount account : accounts) {
            System.out.println(index + ". " + account.getUsername() + " - Balance: " + String.format("%.2f", account.getBalance()));
            index++;
        }
    }

    public static BankAccount findAccountByUsername(String username) {
        for (BankAccount account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    public static void searchAccountByUsername() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        BankAccount account = findAccountByUsername(username);

        if (account != null) {
            System.out.println("Account found: " + account);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void depositMoney() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        BankAccount account = findAccountByUsername(username);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Deposit amount: ");
        double amount = readDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        account.deposit(amount);
        String transaction = "Deposit " + String.format("%.2f", amount) + " to " + account.getUsername();
        transactionHistory.push(transaction);

        System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
    }

    public static void withdrawMoney() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        BankAccount account = findAccountByUsername(username);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Withdraw amount: ");
        double amount = readDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (account.withdraw(amount)) {
            String transaction = "Withdraw " + String.format("%.2f", amount) + " from " + account.getUsername();
            transactionHistory.push(transaction);
            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public static void addBillPayment() {
        System.out.print("Enter bill name: ");
        String bill = scanner.nextLine();
        billQueue.add(bill);
        transactionHistory.push("Bill payment request added: " + bill);
        System.out.println("Bill added to queue.");
    }

    public static void displayBillQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
            return;
        }

        System.out.println("\nBill Payment Queue:");
        for (String bill : billQueue) {
            System.out.println("- " + bill);
        }
    }

    public static void processBillPayment() {
        if (billQueue.isEmpty()) {
            System.out.println("No bills to process.");
            return;
        }

        String processedBill = billQueue.poll();
        transactionHistory.push("Processed bill payment: " + processedBill);
        System.out.println("Processing: " + processedBill);
    }

    public static void submitAccountRequest() {
        System.out.print("Enter new account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = readDouble();

        BankAccount request = new BankAccount(accountNumber, username, balance);
        accountRequests.add(request);
        System.out.println("Account opening request submitted.");
    }

    public static void displayPendingRequests() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        System.out.println("\nPending Account Requests:");
        for (BankAccount request : accountRequests) {
            System.out.println(request);
        }
    }

    public static void processAccountRequest() {
        if (accountRequests.isEmpty()) {
            System.out.println("No account requests to process.");
            return;
        }

        BankAccount approvedAccount = accountRequests.poll();
        accounts.add(approvedAccount);
        transactionHistory.push("Account request approved for " + approvedAccount.getUsername());
        System.out.println("Processed and added to main account list: " + approvedAccount.getUsername());
    }

    public static void showLastTransaction() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions in history.");
            return;
        }

        System.out.println("Last transaction: " + transactionHistory.peek());
    }

    public static void undoLastTransaction() {
        if (transactionHistory.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        System.out.println("Undo -> " + transactionHistory.pop() + " removed");
    }

    public static void showBalance() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        BankAccount account = findAccountByUsername(username);

        if (account != null) {
            System.out.println("Current balance: " + String.format("%.2f", account.getBalance()));
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void printArrayAccounts() {
        System.out.println("\nPredefined Accounts in Array:");
        for (int i = 0; i < predefinedAccounts.length; i++) {
            System.out.println((i + 1) + ". " + predefinedAccounts[i]);
        }
    }

    public static void runAllTasksDemo() {
        System.out.println("\n===== TASK DEMONSTRATION =====");

        System.out.println("\nTask 1: LinkedList account storage");
        displayAllAccounts();

        System.out.println("\nTask 2: Deposit and Withdraw");
        BankAccount ali = findAccountByUsername("Ali");
        if (ali != null) {
            ali.deposit(50000);
            transactionHistory.push("Deposit 50000.00 to Ali");
            System.out.println("Deposit 50000 to Ali");
            System.out.println("New balance: " + String.format("%.2f", ali.getBalance()));

            if (ali.withdraw(20000)) {
                transactionHistory.push("Withdraw 20000.00 from Ali");
                System.out.println("Withdraw 20000 from Ali");
                System.out.println("New balance: " + String.format("%.2f", ali.getBalance()));
            }
        }

        System.out.println("\nTask 3: Stack transaction history");
        showLastTransaction();
        undoLastTransaction();

        System.out.println("\nTask 4: Bill payment queue");
        displayBillQueue();
        processBillPayment();
        displayBillQueue();

        System.out.println("\nTask 5: Account opening queue");
        accountRequests.add(new BankAccount("ACC010", "Aruzhan", 300000));
        accountRequests.add(new BankAccount("ACC011", "Nursultan", 120000));
        displayPendingRequests();
        processAccountRequest();
        displayAllAccounts();

        System.out.println("\nTask 6: Physical data structure (Array)");
        printArrayAccounts();
    }

    public static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }

    public static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}

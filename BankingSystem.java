interface BankingOperations {
    void createAccount(String accountHolder, double initialDeposit);
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

class BankAccount implements BankingOperations {
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
    }

    @Override
    public void createAccount(String accountHolder, double initialDeposit) {
        System.out.println("Account already created for: " + this.accountHolder);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }

    @Override
    public double checkBalance() {
        System.out.println("Current Balance: $" + balance);
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        // Create an account
        BankAccount account = new BankAccount("John Doe", 500.0);

        // Perform operations
        account.deposit(200.0);
        account.withdraw(100.0);
        account.checkBalance();
    }
}

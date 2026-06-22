class BankAccount {
    private String accountNumber;
    private String holder;
    private double balance;

    static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void getStatement() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Holder: " + holder);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("101", "Yash", 10000);
        BankAccount a2 = new BankAccount("102", "Rahul", 15000);
        BankAccount a3 = new BankAccount("103", "Amit", 20000);

        a1.deposit(1000);
        a1.withdraw(500);
        a1.deposit(2000);
        a1.withdraw(1000);
        a1.deposit(300);

        a2.deposit(500);
        a2.withdraw(200);
        a2.deposit(700);
        a2.withdraw(400);
        a2.deposit(100);

        a3.deposit(2000);
        a3.withdraw(1500);
        a3.deposit(1000);
        a3.withdraw(500);
        a3.deposit(500);

        a1.getStatement();
        a2.getStatement();
        a3.getStatement();

        System.out.println("\nTotal Accounts = " + totalAccounts);
    }
}
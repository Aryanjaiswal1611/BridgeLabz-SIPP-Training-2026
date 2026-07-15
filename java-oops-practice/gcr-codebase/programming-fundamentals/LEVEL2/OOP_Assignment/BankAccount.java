class BankAccount {

```
static String bankName = "SBI";
static int totalAccounts = 0;

String accountHolderName;
final int accountNumber;

public BankAccount(String accountHolderName, int accountNumber) {
    this.accountHolderName = accountHolderName;
    this.accountNumber = accountNumber;
    totalAccounts++;
}

public void display() {
    System.out.println("Bank : " + bankName);
    System.out.println("Holder : " + accountHolderName);
    System.out.println("Account No : " + accountNumber);
}

public static void getTotalAccounts() {
    System.out.println("Total Accounts : " + totalAccounts);
}

public static void main(String[] args) {

    BankAccount b1 =
            new BankAccount("Yash", 101);

    BankAccount b2 =
            new BankAccount("Rahul", 102);

    if (b1 instanceof BankAccount) {
        b1.display();
    }

    getTotalAccounts();
}
```

}

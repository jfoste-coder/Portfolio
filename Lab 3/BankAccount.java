public class BankAccount {

    // Declare the fields of the class
    public double balance;
    public double interestRate;
    public String ownerName;

    // constructor 
    public BankAccount(double balance, double interestRate, String ownerName) {
        this.balance = balance;
        this.interestRate = interestRate;
        this.ownerName = ownerName;
    }

    // constructor
    public BankAccount() {
        this.balance = 0;
        this.interestRate = 0.0;
        this.ownerName = "unassigned";
    }
    

    // Define a method to deposit money into the account
    public void deposit(double dep){
        this.balance += dep;
    }

    // method to withdraw money from the account
    public void withdraw(double dep){
            this.balance -= dep;
    }

    // Define a method to transfer between accounts
    public void transfer(BankAccount alt, double transfer){
            this.balance -= transfer;
            alt.balance += transfer;
    }

    // method to set name
    public void setName(String name){
        this.ownerName = name;
    }


    // method to display the information of the account
    public void display() {
        // Print the owner name, balance, and interest rate of the account
        System.out.println("Owner name: " + this.ownerName);
        System.out.println("Balance: $" + this.balance);
        System.out.println("Interest rate: " + this.interestRate + "%");
        System.out.println();
    }

    // make sure only one main function is active in your code, other wise you will encounter error.
    public static void main(String[] args) {
       // Create an object called account
        BankAccount anAccount = new BankAccount();

        // Display the initial information of the account
        anAccount.display();

        // other account creation and dipslay
        BankAccount otherAccount = new BankAccount();
        otherAccount.display();

        // task 00

        // Display the initial information of the account
        anAccount.display();
        // deposit
        anAccount.deposit(500);
        // display after deposit
        anAccount.display();

        // task 01

        // change name
        otherAccount.setName("Ridley");
        // display
        otherAccount.display();
        

        // withdraw
        otherAccount.withdraw(200);
        otherAccount.display();

        // transfer money from anAccount to otherAccount
        anAccount.transfer(otherAccount, 300);
        anAccount.display();
        otherAccount.display();
    }
}





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BankAccount{
    private double checkingAccount;
    private double savingsAccount;
    private String accountNumber;
    public static int numberOfAccounts = 0;
    private static double totalAccountMoney=0;
    private static Random random = new Random();
    public BankAccount() {
        this.accountNumber = BankAccount.accountNumberGenerator();
        this.checkingAccount = 0.00;
        this.savingsAccount = 0.00;
        numberOfAccounts += 1;
        System.out.println("new account number: " + accountNumber );
        System.out.println("Number of accounts created" + numberOfAccounts);
    }

    public BankAccount(double checkingAccount, double savingsAccount) {
        this.accountNumber = BankAccount.accountNumberGenerator();
        this.checkingAccount = checkingAccount;
        this.savingsAccount = savingsAccount;
        numberOfAccounts += 1;
        totalAccountMoney += (this.checkingAccount + this.savingsAccount);
        System.out.println("New user created with account number: " + accountNumber);
        System.out.println("Total accounts created: " + numberOfAccounts);
        System.out.println("Total amount stored: " + totalAccountMoney);
    }




//getters
public double getcheckingAccount() {
return checkingAccount;
}
public double getsavingsAccount() {
return savingsAccount;
}

//setters
public void setcheckingAccount(double checkingAccount) {
    this.checkingAccount = checkingAccount;
    
}
public void setsavingsAccount(double savingsAccount) {
    this.savingsAccount = savingsAccount;

}

private static String accountNumberGenerator() {
        return Integer.toString(random.nextInt((1000000000) + 1000000000));
    }

public void deposit(double Amount, String accountType) {
        if (accountType == "checkingAccount") {
            this.checkingAccount += Amount;
            totalAccountMoney += Amount;
            System.out.println("the following " + Amount + " was deposited into your checkings account " + this.accountNumber);
        } else if (accountType == "savingsAccount") {
            this.savingsAccount += Amount;
            totalAccountMoney += Amount;
            System.out.println("$" + Amount + " was deposited into your savings account " + this.accountNumber);

        }
}


public void withdraw(double withdrawAmount, String accountType) {
        if (accountType == "checkingAccount") {
            if (withdrawAmount <= checkingAccount) {
                this.checkingAccount -= withdrawAmount;
                totalAccountMoney -= withdrawAmount;
                System.out.println(withdrawAmount + " was withdrawn from your checking account " + this.accountNumber);
            }
            else {
                System.out.println("You don't have enough fund in your checking account");
                System.out.println("Your checking account balance is: " + this.getcheckingAccount());
            }
        }
        else if (accountType == "savingsAccount") {
            if (withdrawAmount <= this.savingsAccount) {
                this.savingsAccount -= withdrawAmount;
                totalAccountMoney -= withdrawAmount;
                System.out.println(withdrawAmount + " was withdrawn from your saving account " + this.accountNumber);
            }
            else {
                System.out.println("Insufficient funds in your savings account");
                System.out.println("Your saving account balance is:" + this.getsavingsAccount());
            }
        }
}

    public void Balance() {
        System.out.println("The total money in the bank is : " + (this.getcheckingAccount() + this.getsavingsAccount()));
        System.out.println("The total money in your savings Account : " +  this.getsavingsAccount());
        System.out.println("The total money in your checking Account : " + this.getcheckingAccount());
    
    }
    }


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
class BankAccountTest {
public static void main(String[] args) {

        BankAccount Mohammad = new BankAccount(12.32, 44.55);
        BankAccount Mussab = new BankAccount(200, 500);
        BankAccount Qutaiba = new BankAccount(400, 1500);
        BankAccount Saad = new BankAccount(400, 1500);

        //Account balance of each account:
        Mohammad.Balance();
        Mussab.Balance();
        Qutaiba.Balance();
        System.out.println();

        //Total number of accounts in the bank:
        // System.out.println("Bank total number of customers: " + BankAccount.numberOfAccounts());
        // System.out.println();


        //Do some transactions:
        Mohammad.deposit(500, "checking");
        Mussab.withdraw(350.73, "saving");
        Qutaiba.withdraw(405.13, "checking");
        System.out.println();


        //Account balance of each account after transactions are made:
        Mohammad.Balance();
        Mussab.Balance();
        Qutaiba.Balance();
        System.out.println();

        //Total amount stored in the bank balance:
        // System.out.println("Amount in bank's balance is: $" + BankAccount.totalAccountMoney());
    }
}







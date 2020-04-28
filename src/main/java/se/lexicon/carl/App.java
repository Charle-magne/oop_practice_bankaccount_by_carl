package se.lexicon.carl;
import java.util.Scanner;
/*

This is my variant of the Bank Account. It's a bit crude but it works.

*/

public class App 
{

    public static void main( String[] args )
    {
        setUser();
        menu();
    }

    private static double balance;

    public static void setUser() {
        BankAccount b1 = new BankAccount();
        b1.setBalance(balance);
        b1.setPhoneNumber(123456);
        b1.setEmail("This is an email adress");
        b1.setCustomerName("Erik Svensson");
        b1.setAccountNumber(0001);
    }

    public static void addFunds(){

        System.out.println("Enter sum to deposit:");
        Scanner input = new Scanner(System.in);
        double add = input.nextDouble();
        balance = (balance + add);
        menu();
    }

    public static void withdrawFunds(){

        System.out.println("Enter sum to withdraw:");
        Scanner input = new Scanner(System.in);
        double withdraw = input.nextDouble();

        if (withdraw <= balance){
            balance = (balance - withdraw);
        }
        else {
            System.out.println("Not enough funds in the account.");
        }
        menu();
    }

    public static void checkBalance(){
        System.out.println("The balance is " + balance + ".");
        menu();
    }

    public static void menu(){

        System.out.println("Welcome to a mostly trustworthy bank.");
        System.out.println("Would you like to deposit(1), withdraw(2), check balance(3) or exit(9)?");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        boolean keepGoing = true;
        do {
            if (choice == 1) {
                addFunds();
                break;
            } else if (choice == 2) {
                withdrawFunds();
                break;
            } else if (choice == 3) {
                checkBalance();
                break;
            } else if (choice == 9) {
                keepGoing = false;
            } else {
                System.out.println("Not a number, try again.");
            }
        } while (keepGoing);
    }
}

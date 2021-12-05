/* Author: Abdurrahman kursat ozkan Version: 20/11/2021 */

import java.util.Scanner;

public class ATM_20210808047 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your first name >> ");
        String name = scan.nextLine();
        System.out.print("Please enter your surname >> ");
        String surname = scan.nextLine();
        surname = surname.toUpperCase();

        double balance = 0;
        int a = 0;
        while (a == 0) {
            System.out.print("Please enter your starting balance >> ");
             balance = scan.nextDouble();
            if (balance >= 0){
                a++;
            }
            else{
                System.out.println("ERROR: Invalid balance");
            }
        }


        int stop = 0;
        while (stop == 0) {
            System.out.println("");

            System.out.println("Hello " + name + " " + surname);
            System.out.println("What would you like to do today?");
            System.out.println("1 for Account Balance");
            System.out.println("2 for Cash Deposit");
            System.out.println("3 for cash withdrawal");
            System.out.println("0 to quit");
            System.out.print("Please enter your selection >> ");
            int selection = scan.nextInt();

            switch (selection) {
                case 1 :
                    System.out.println("Your account balance is " + balance); break;
                case 2 :
                    System.out.print("How much are you depositing? ");
                    double deposit = scan.nextDouble();
                    if (isDepositValid(deposit)) {
                        balance += deposit ;
                    }
                    else {
                        System.out.println("ERROR: Invalid deposit amount");
                    } break;
                case 3 :
                    System.out.print("How much are you withdrawing? ");
                    double withdrawal = scan.nextDouble();
                    if (isWithdrawalValid(balance , withdrawal)) {
                        System.out.println("You will receive the following:");
                        System.out.print(moneyGiven(withdrawal));
                        balance -= withdrawal ;
                    }
                    else {
                        System.out.println("ERROR: Invalid withdrawal amount");
                    } break;
                case 0 :
                    System.out.println("Thank you for using our ATM. Have a nice day!");
                    stop++; break;
                default :
                    System.out.println("Invalid choice. Exiting System.");
                    stop++; break;
            }


        }

    }

    public static boolean isDepositValid( double deposit) {
        if (deposit > 0){
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean isWithdrawalValid (double balance , double withdrawal) {
        if (withdrawal > 0 && balance - withdrawal >= 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static String moneyGiven (double withdrawn) {
        withdrawn = withdrawn * 100;

        int a = (int) Math.floor(withdrawn / 20000);
        withdrawn = withdrawn - a * 20000;

        int b = (int) Math.floor(withdrawn / 10000);
        withdrawn = withdrawn - b * 10000;

        int c = (int) Math.floor(withdrawn / 5000);
        withdrawn = withdrawn - c * 5000;

        int d = (int) Math.floor(withdrawn / 2000);
        withdrawn = withdrawn - d * 2000;

        int e = (int) Math.floor(withdrawn / 1000);
        withdrawn = withdrawn - e * 1000;

        int f = (int) Math.floor(withdrawn / 500);
        withdrawn = withdrawn - f * 500;

        int g = (int) Math.floor(withdrawn / 100);
        withdrawn = withdrawn - g * 100;

        int h = (int) Math.floor(withdrawn / 50);
        withdrawn = withdrawn - h * 50;

        int i = (int) Math.floor(withdrawn / 25);
        withdrawn = withdrawn - i * 25;

        int k = (int) Math.floor(withdrawn / 10);
        withdrawn = withdrawn - k * 10;

        int l = (int) Math.floor(withdrawn / 5);
        withdrawn = withdrawn - l * 5;

        int m = (int) Math.floor(withdrawn / 1);
        withdrawn = withdrawn - m * 1;



        return a + " - 200\n" + b + " - 100\n" + c + " - 50\n" + d +" - 20\n" + e + " - 10\n" + f + " - 5\n" + g + " - 1\n" +
                h + " - 0.50\n" + i + " - 0.25\n" + k + " - 0.10\n" + l + " - 0.05\n" + m + " - 0.01";
    }

    }


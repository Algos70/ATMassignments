/* Author: Abdurrahman Kursat Ozkan Version: 10/08/2021 */


import java.util.Scanner;

public class ATM_20210808047 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Shows what numbers can be used as balance
        System.out.print("Please enter the balance: ");
        double balance = scan.nextDouble();
        if (balance < 0) {
            System.out.println("ERROR! Invalid number. Exiting System. Please use a non-negative number.");
        } else {
            System.out.println("What would you want to do today?");
            System.out.println("1 for Balance ");
            System.out.println("2 for Deposit ");
            System.out.println("3 for withdrawal ");
            System.out.println("0 to Quit");
            System.out.print("Please enter your selection: ");

            //Ifs for each selections are here
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("The current balance is: " + balance);
                System.out.println("Have a nice day!");
            } else if (choice == 2) {
                System.out.print("Please enter the amount to deposit: ");
                double deposit = scan.nextDouble();
                if (deposit <= 0) {
                    System.out.println("ERROR! You can not deposit any number smaller or equal than 0.");
                    System.out.println("The current balance is: " + balance);
                    System.out.println("Have a nice day!");
                } else {
                    System.out.println("Current balance is: " + (balance + deposit));
                    System.out.println("Have a nice day!");
                }

            } else if (choice == 3) {
                System.out.print("Please enter the amount to withdrawal: ");
                double withdrawal = scan.nextDouble();
                if (withdrawal > balance){
                    System.out.println("ERROR! Not enough balance! ");
                    System.out.println("The current balance is: " + balance);
                    System.out.println("Have a nice day!");
                }
                else if (withdrawal <= 0) {
                    System.out.println("ERROR! You can not withdrawal any number smaller or equal than 0.");
                    System.out.println("The current balance is: " + balance);
                    System.out.println("Have a nice day!");
                } else{
                    System.out.println("The current balance is:" + (balance - withdrawal));
                System.out.println("Have a nice day!");}
            }

            else if (choice == 0) {

            } else
                System.out.println("ERROR! Invalid number. Exiting system.");

        }
    }
}



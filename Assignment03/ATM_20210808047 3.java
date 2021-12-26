/* Author: Abdurrahman Kursat Ozkan Version: 04/12/2021 */
import java.util.Scanner;
public class ATM_20210808047 {
    
    //You can pass a scanner object as a parameter
    public static int menuDisplay(String[] items , Scanner input) {
        System.out.println("1 - " + items[0]);
        System.out.println("2 - " + items[1]);
        System.out.println("3 - " + items[2]);
        System.out.println("4 - " + items[3]);
        System.out.println("0 to Quit");
        System.out.print("Please enter your selection >> ");
        return input.nextInt();
    }
    public static void atm(String[] names, String[] surnames, double[] balances, int index, Scanner input) {
        int stop = 0;
        while (stop == 0) {
            System.out.println("");
            surnames[index] = surnames[index].toUpperCase();
            String first = names[index].substring(0,1);
            String last = names[index].substring(1);
            names[index] = first.toUpperCase() + last;
            System.out.println("Hello " + names[index] + " " + surnames[index]);
            System.out.println("What would you like to do today?");
            int choice = menuDisplay(
                    new String[]{"Account Balance", "Deposit", "Withdrawal", "Change Name"},
                    input);
            if (choice == 1) {
                System.out.println("Your account balance is " + balances[index]);
            }
            else if (choice == 2) {
                System.out.print("How much are you depositing? ");
                double deposit = input.nextDouble();
                if (isDepositValid(deposit)) {
                    balances[index] += deposit;
                }
                else {
                    System.out.println("ERROR: Invalid deposit amount");
                }
            }
            else if (choice == 3) {
                System.out.print("How much are you withdrawing? ");
                double withdrawal = input.nextDouble();
                if (isWithdrawalValid(balances[index], withdrawal)) {
                    System.out.println("You will receive the following:");
                    System.out.print(moneyGiven(withdrawal));
                    balances[index] -= withdrawal ;
                    System.out.println("");
                }
                else {
                    System.out.println("ERROR: Invalid withdrawal amount");
                }
            }
            //look into down!!!
            else if (choice == 4) {
                System.out.print("Please enter your name >> ");
                input.nextLine();
                String name = input.nextLine();
                String firstchr = name.substring(0 , 1);
                String leftchr = name.substring(1);
                name = firstchr.toUpperCase() + leftchr;
                names[index] = name;
                System.out.print("Please enter your surname >> ");
                String surname = input.next();
                surnames[index] = surname.toUpperCase();

            }
            else if (choice == 0) {
                System.out.println("Thank you for using our ATM. Have a nice day!");
                stop++;
            }
            else {
                System.out.println("Invalid choice. Exiting System.");
                stop++;
            }
        }
    }
    //finds the index of acctNum in acctNums array, and returns that value. If it cant find acctNum in acctNums array it returns -1
    public static int findAcct(int[] acctNums , int acctNum) {
        for (int i = 0; i < acctNums.length; i++) {
            if(acctNums[i] == acctNum) {
                return i;
            }
        }
        return -1;
    }

    public static void bankLogin(int[] acctNums, String[] acctNames, String[] acctSurnames, String[] acctPINs, double[] acctBalances) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your account number >> ");
        int num = scan.nextInt();
        int indexes = findAcct(acctNums , num) ;
        if (indexes == -1) {
            System.out.println("ERROR: Account/PIN combination not found.");
        }
        else {
            System.out.print("Please enter your PIN >> ");

            String PIN = scan.next();

            if (acctNums[indexes] == num && acctPINs[indexes].equals(PIN)) {
                atm(acctNames, acctSurnames, acctBalances, indexes, scan);
            } else {
                System.out.println("ERROR: Account/PIN combination not found.");
            }
        }
    }


    // return deposit >0;, you can write only this too.
    public static boolean isDepositValid( double deposit) {
        if (deposit > 0){
            return true;
        }
        else {
            return false;
        }

    }
    // same with line 77.

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

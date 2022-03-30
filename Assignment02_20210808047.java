/*  Author: Abdurrahman Kursat Ozkan  Version: 30/03/2022 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Assignment02_20210808047 {

}

class Bank {
    private String name;
    private String address;
    private ArrayList<Customer> customers;
    private ArrayList<Company> companies;
    private ArrayList<Account> accounts;
}

class Account {}

class PersonalAccount extends Account {}

class BusinessAccount extends Account {}

class Customer {}

class Company {}

class AccountNotFoundException extends RuntimeException {
    private String acctNum;

    public AccountNotFoundException(String newAcctNum) {
        this.acctNum = newAcctNum;
    }

    @Override
    public String toString() {
        return "AccountNotFoundException: " + this.acctNum;
    }

}

class BalanceRemainingException extends RuntimeException {
    private double balance;

    public BalanceRemainingException(double newBalance) {
        this.balance = newBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "BalanceRemainingException: " + this.balance;
    }
}

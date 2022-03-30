/*  Author: Abdurrahman Kursat Ozkan  Version: 30/03/2022 */

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

class CompanyNotFoundException extends RuntimeException {
    private int id;
    private String name;

    public CompanyNotFoundException(int newId) {
        this.id = newId;
        this.name = null;
    }

    public CompanyNotFoundException(String newName) {
        this.name = newName;
        this.id = 0;
    }

    @Override
    public String toString() {
        if (name != null) {
            return "CompanyNotFoundException: name - " + this.name;
        } else {
            return "CompanyNotFoundException: id - " + this.id;
        }
    }
}

class CustomerNotFoundException extends RuntimeException {
    private int id;
    private String name;
    private String surname;

    public CustomerNotFoundException(int newId) {
        this.id = newId;
        this.name = null;
        this.surname = null;
    }

    public CustomerNotFoundException(String newName, String newSurname) {
        this.name = newName;
        this.surname = newSurname;
        this.id = 0;
    }

    @Override
    public String toString() {
        if (this.name != null && this.surname != null) {
            return "CustomerNotFoundException: name - " + this.name + " " + this.surname;
        } else {
            return "CustomerNotFoundException: id - " + this.id;
        }
    }
}

class InvalidAmountException extends RuntimeException {
    private double amount;

    public InvalidAmountException(double newAmount) {
        this.amount = newAmount;
    }

    @Override
    public String toString() {
        return "InvalidAmountException: " + this.amount;
    }
}



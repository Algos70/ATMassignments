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

    public Bank(String newName, String newAddress) {
        this.name = newName;
        this.address = newAddress;
        customers = new ArrayList<>();
        companies = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public void addCustomer(int newId, String newName, String newSurname) {

    }
}

class Account {
    private String acctNumber;
    private double balance;

    public Account(String newAcctNumber) {
        this.acctNumber = newAcctNumber;
        this.balance = 0;
    }

    public Account(String newAcctNumber, double newBalance) {
        this.acctNumber = newAcctNumber;

        if (newBalance < 0) {
            RuntimeException exception = new RuntimeException();
            throw exception;
        } else {
            this.balance = newBalance;
        }
    }

    public String getAcctNum() {
        return this.acctNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount >= 0) {
            this.balance += amount;
        } else {
            RuntimeException exception = new RuntimeException();
            throw exception;
        }
    }

    public void withdrawal(double amount) {
        if (amount >= 0 && (this.balance - amount >= 0)) {
            this.balance -= amount;
        } else {
            throw new RuntimeException();
        }
    }

    public String toString() {
        return "Account " + this.acctNumber + " has " + this.balance;
    }
}

class PersonalAccount extends Account {
    private String name;
    private String surname;
    private String pin;

    public PersonalAccount(String newAcctNumber, String newName, String newSurname) {
        this(newAcctNumber, newName, newSurname, 0);

    }

    public PersonalAccount(String newAcctNumber, String newName, String newSurname, double newBalance) {
        super(newAcctNumber, newBalance);
        this.name = newName;
        this.surname = newSurname;
        this.pin = "";

        for (int i = 0; i < 4; i++) {
            int random = (int)Math.round(Math.random() * 10);
            this.pin += random;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPIN() {
        return this.pin;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    public void setPIN(String newPin) {
        this.pin = newPin;
    }

    public String toString() {
        return "Account " + this.getAcctNum() + " belonging to " + this.name + " " + this.surname.toUpperCase() +
                " has " + super.getBalance();
    }
}

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



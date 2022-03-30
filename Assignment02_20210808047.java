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
            RuntimeException exception = new InvalidAmountException(amount);
            throw exception;
        }
    }

    public void withdrawal(double amount) {
        if (amount >= 0 && (this.balance - amount >= 0)) {
            this.balance -= amount;
        } else {
            throw new InvalidAmountException(amount);
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

class BusinessAccount extends Account {
    private double interestRate;

    public BusinessAccount(String newAcctNumber, double newInterestRate) {
        this(newAcctNumber, 0 , newInterestRate);
    }

    public BusinessAccount(String newAcctNumber,double newBalance, double newInterestRate) {
        super(newAcctNumber, newBalance);
        if (newInterestRate > 0) {
            this.interestRate = newInterestRate;
        } else {
            throw new RuntimeException();
        }
    }

    public double getRate() {
        return this.interestRate;
    }

    public void setRate(double newInterestRate) {
        if (newInterestRate > 0) {
            this.interestRate = newInterestRate;
        } else {
            throw new RuntimeException();
        }
    }

    public double calculateInterest() {
        return super.getBalance() * this.interestRate;
    }
}

class Customer {
    private int id;
    private String name;
    private String surname;
    private ArrayList<PersonalAccount> personalAccounts;

    public Customer(String newName, String newSurname) {
        this.name = newName;
        this.surname = newSurname;
        this.personalAccounts = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int newId) {
        if (newId > 0) {
            this.id = newId;
        } else {
            throw new RuntimeException();
        }

    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    public void openAccount(String newAcctNumber) {
        this.personalAccounts.add(new PersonalAccount(newAcctNumber, this.name , this.surname , 0));
    }

    //Look into this later!!
    public PersonalAccount getAccount(String acctNumToSearch) {
        for (PersonalAccount account : personalAccounts) {
            if (account.getAcctNum().equals(acctNumToSearch)) {
                return account;
            }
        }
        throw new AccountNotFoundException(acctNumToSearch);
    }

    public void closeAccount(String acctNumber) {
        boolean isFound = false;
        for (PersonalAccount account : personalAccounts) {
            if (account.getAcctNum().equals(acctNumber)) {
                if (account.getBalance() == 0) {
                    personalAccounts.remove(account);
                    isFound = true;
                } else {
                    throw new BalanceRemainingException(account.getBalance());
                }
            }
        }

        if (!isFound) {
            throw new AccountNotFoundException(acctNumber);
        }
    }

    public String toString() {
        return this.name + " " + this.surname.toUpperCase();
    }
}

class Company {
    private int id;
    private String name;
    private ArrayList<BusinessAccount> accounts;

    public Company(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int newId) {
        if (newId > 0) {
            this.id = newId;
        } else {
            throw new RuntimeException();
        }

    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void openAccount(String newAcctNumber, double newInterestRate) {
        accounts.add(new BusinessAccount(newAcctNumber, 0 , newInterestRate));
    }

    public BusinessAccount getAccount(String acctNumToSearch) {
        for (BusinessAccount businessAcct : accounts) {
            if (businessAcct.getAcctNum().equals(acctNumToSearch)) {
                return businessAcct;
            }
        }

        throw new AccountNotFoundException(acctNumToSearch);
    }

    public void closeAccount(String acctNum) {
        boolean isFound = false;
        for (BusinessAccount businessAcct : accounts) {
            if (businessAcct.getAcctNum().equals(acctNum)) {
                if (businessAcct.getBalance() == 0) {
                    accounts.remove(businessAcct);
                    isFound = true;
                } else {
                    throw new BalanceRemainingException(businessAcct.getBalance());
                }

            }
        }

        if (!isFound) {
            throw new AccountNotFoundException(acctNum);
        }
    }

    public String toString() {
        return this.name;
    }
}

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



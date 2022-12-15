package com.bank.bank_of_lebanon;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Account {

    Client client = new Client();
    private int account_number;
    private SimpleDoubleProperty balance;
    private SimpleBooleanProperty isLoan;
    private SimpleBooleanProperty isInterest;
    private SimpleDoubleProperty loan_amount;
    private SimpleDoubleProperty interest_amount;
    public Account(){
        this.account_number = client.getAccNb();
        this.balance = new SimpleDoubleProperty();
        this.isLoan = new SimpleBooleanProperty();
        this.isInterest = new SimpleBooleanProperty();
        this.loan_amount = new SimpleDoubleProperty();
        this.interest_amount = new SimpleDoubleProperty();
    }

    public Account(int account_number, double balance,boolean isLoan, boolean isInterest, double loan_amount, double interest_amount){
        this.account_number = account_number;
        this.balance = new SimpleDoubleProperty(balance);
        this.isLoan = new SimpleBooleanProperty(isLoan);
        this.isInterest = new SimpleBooleanProperty(isInterest);
        this.loan_amount = new SimpleDoubleProperty(loan_amount);
        this.interest_amount = new SimpleDoubleProperty(interest_amount);
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public int getAccount_number() {
        return account_number;
    }


    public Double getBalance() {
        return balance.get();
    }

    public SimpleDoubleProperty BalanceProperty() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance.set(balance);
    }

    public boolean isIsLoan() {
        return isLoan.get();
    }

    public SimpleBooleanProperty isLoanProperty() {
        return isLoan;
    }

    public void setIsLoan(boolean isLoan) {
        this.isLoan.set(isLoan);
    }

    public boolean isIsInterest() {
        return isInterest.get();
    }

    public SimpleBooleanProperty isInterestProperty() {
        return isInterest;
    }

    public void setIsInterest(boolean isInterest) {
        this.isInterest.set(isInterest);
    }

    public double getLoan_amount() {
        return loan_amount.get();
    }

    public SimpleDoubleProperty loan_amountProperty() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount.set(loan_amount);
    }

    public double getInterest_amount() {
        return interest_amount.get();
    }

    public SimpleDoubleProperty interest_amountProperty() {
        return interest_amount;
    }

    public void setInterest_amount(double interest_amount) {
        this.interest_amount.set(interest_amount);
    }

}

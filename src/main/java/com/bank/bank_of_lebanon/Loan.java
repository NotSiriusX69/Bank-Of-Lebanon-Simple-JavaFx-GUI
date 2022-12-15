package com.bank.bank_of_lebanon;

import javafx.scene.control.TextField;

public class Loan {
    private double interest,principal;
    private int year;

    public Loan(){

    }
    public Loan(double Principal,double interest, int years){
        this.principal = Principal;
        this.year = years;
        this.interest = interest;

    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year<0 || year>15)
            System.out.println("invalid");
        else
            this.year=year;
    }
    public double getYearlyInterest() {
        double YearlyInterestValue;
        YearlyInterestValue = this.principal * (1 + this.interest/100.0 * this.year);
        return YearlyInterestValue;

    }
    public void calculateLoan(TextField tfYears, TextField tfInterest, TextField tfLoanAmount, TextField tfFinalAmount) {

        Integer Years = GeneralUtil.convertTextToInteger(tfYears);

        Double  YearlyInterest = GeneralUtil.convertTextToDouble(tfInterest);

        Double LoanAmount = GeneralUtil.convertTextToDouble(tfLoanAmount);

        if (Years == null || YearlyInterest == null || LoanAmount == null)
            return;

        Loan loan = new Loan(LoanAmount,YearlyInterest,Years);

        tfFinalAmount.setText(String.format(String.valueOf(loan.getYearlyInterest())));
    }
}

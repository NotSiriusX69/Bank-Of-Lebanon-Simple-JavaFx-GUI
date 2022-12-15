package com.bank.bank_of_lebanon;

import javafx.scene.control.TextField;

public class Interest {

    private double interest,principal;
    private int year;
    public Interest(){

    }
    public Interest(double Principal,double interest,int years){

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
    public double getMonthlyInterest() {
        double MonthlyInterestValue;
        MonthlyInterestValue = this.principal * (1 + this.interest/100.0 * (this.year * 12));
        return MonthlyInterestValue;
    }
    public double getYearlyInterest() {
        double YearlyInterestValue;
        YearlyInterestValue = this.principal * (1 + this.interest/100.0 * this.year);
        return YearlyInterestValue;

    }
    public void calculateYInterest(TextField tfYears, TextField tfInterest, TextField tfAmount, TextField tfFinalAmount) {

        Integer Years = GeneralUtil.convertTextToInteger(tfYears);

        Double  YearlyInterest = GeneralUtil.convertTextToDouble(tfInterest);

        Double Amount = GeneralUtil.convertTextToDouble(tfAmount);

        if (Years == null || YearlyInterest == null || Amount == null)
            return;

        Interest interest = new Interest(Amount,YearlyInterest,Years);

        tfFinalAmount.setText(String.format(String.format(String.valueOf(interest.getYearlyInterest()))));
    }
    public void calculateMInterest(TextField tfYears, TextField tfInterest, TextField tfAmount, TextField tfFinalAmount) {

        Integer Years = GeneralUtil.convertTextToInteger(tfYears);

        Double  YearlyInterest = GeneralUtil.convertTextToDouble(tfInterest);

        Double Amount = GeneralUtil.convertTextToDouble(tfAmount);

        if (Years == null || YearlyInterest == null || Amount == null)
            return;

            Interest interest = new Interest(Amount,YearlyInterest,Years);

        tfFinalAmount.setText(String.format(String.format(String.valueOf(interest.getMonthlyInterest()))));

    }
}

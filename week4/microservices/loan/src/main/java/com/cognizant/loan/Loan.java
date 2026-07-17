package com.cognizant.loan;

public class Loan {
    private String number;
    private String type;
    private double loanAmount;
    private double emi;
    private int tenure;

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }

    public double getEmi() { return emi; }
    public void setEmi(double emi) { this.emi = emi; }

    public int getTenure() { return tenure; }
    public void setTenure(int tenure) { this.tenure = tenure; }
}
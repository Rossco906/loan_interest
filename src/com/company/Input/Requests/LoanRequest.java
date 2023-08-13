package com.company.Input.Requests;

import com.company.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanRequest implements Request {
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal loanAmount;
    private Currency currency;
    private BigDecimal baseInterest;
    private BigDecimal margin;

    @Override
    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    @Override
    public void setEndDate(LocalDate date) {
        this.endDate = date;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setLoanAmount(BigDecimal loanAmount){
        this.loanAmount = loanAmount;
    }

    public void setBaseInterest(BigDecimal interest){
        this.baseInterest = interest;
    }

    public void setMargin(BigDecimal margin){
        this.margin = margin;
    }

    @Override
    public LocalDate getStartDate(){
        return startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getLoanAmount(){
        return loanAmount;
    }

    public Currency getCurrency(){
        return currency;
    }

    public BigDecimal getBaseInterest(){
        return baseInterest;
    }

    public BigDecimal getMargin(){
        return margin;
    }
}

package com.company.Calculation;

import com.company.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class DayResult {
    private final Currency currency;
    private LocalDate accrualDate;
    private String interestWithoutMargin;
    private String dailyAccrued;
    private int numberOfDaysElapsed;
    private String totalInterestToDate;

    public DayResult(Currency currency){
        this.currency = currency;
    }
    public LocalDate getAccrualDate() {
        return accrualDate;
    }

    public void setAccrualDate(LocalDate accrualDate) {
        this.accrualDate = accrualDate;
    }

    public String getInterestWithoutMargin() {
        return interestWithoutMargin;
    }

    public void setInterestWithoutMargin(BigDecimal interestWithoutMargin) {
        String value = currency + interestWithoutMargin.setScale(2, RoundingMode.DOWN).toString();
        this.interestWithoutMargin = value;
    }

    public String getDailyAccrued() {
        return dailyAccrued;
    }

    public void setDailyAccrued(BigDecimal dailyAccrued) {
        String value = currency + dailyAccrued.setScale(2, RoundingMode.DOWN).toString();
        this.dailyAccrued = value;
    }

    public int getNumberOfDaysElapsed() {
        return numberOfDaysElapsed;
    }

    public void setNumberOfDaysElapsed(int numberOfDaysElapsed) {
        this.numberOfDaysElapsed = numberOfDaysElapsed;
    }

    public String getTotalInterestToDate() {
        return totalInterestToDate;
    }

    public void setTotalInterestToDate(BigDecimal totalInterestToDate) {
        String value = currency + totalInterestToDate.setScale(2, RoundingMode.DOWN).toString();
        this.totalInterestToDate = value;
    }

    @Override
    public String toString() {
        return "DayResult{" +
                "accrualDate=" + accrualDate +
                ", interestWithoutMargin=" + interestWithoutMargin +
                ", dailyAccrued=" + dailyAccrued +
                ", numberOfDaysElapsed=" + numberOfDaysElapsed +
                ", totalInterestToDate=" + totalInterestToDate +
                '}';
    }
}

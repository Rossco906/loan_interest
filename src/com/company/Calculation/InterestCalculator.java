package com.company.Calculation;

import com.company.Calculation.DayResult;
import com.company.Input.Requests.LoanRequest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class InterestCalculator {

    private final LoanRequest loanRequest;

    private LocalDate runningDate;
    private BigDecimal runningAmountIncludingInterest;
    private BigDecimal runningInterest;

    private List<DayResult> fullResult;

    public InterestCalculator(LoanRequest loanRequest){
        this.loanRequest = loanRequest;
    }

    public void calculate(){
        this.runningDate = loanRequest.getStartDate();
        this.runningAmountIncludingInterest = loanRequest.getLoanAmount();
        this.runningInterest = new BigDecimal("0");
        this.fullResult = new ArrayList<>();
        long numberOfDays = ChronoUnit.DAYS.between(loanRequest.getStartDate(), loanRequest.getEndDate());

        int idx = 0;
        while (idx < numberOfDays+1){
            fullResult.add(calculateDayResult(idx));
            idx += 1;
        }
    }
    private DayResult calculateDayResult(int iteration){
        DayResult result = new DayResult(loanRequest.getCurrency());
        result.setInterestWithoutMargin(calculateInterestWithoutMargin());
        BigDecimal dailyAccrued = calculateInterestWithMargin();
        result.setDailyAccrued(dailyAccrued);
        result.setAccrualDate(runningDate);
        runningDate = runningDate.plusDays(1);
        result.setNumberOfDaysElapsed(iteration);

        BigDecimal newRunningInterest  = runningInterest.add(dailyAccrued);
        result.setTotalInterestToDate(newRunningInterest);
        runningInterest = newRunningInterest;

        return result;
    }

    private BigDecimal calculateInterestWithoutMargin(){
        BigDecimal baseRate = loanRequest.getBaseInterest();
        return runningAmountIncludingInterest.multiply(baseRate);
    }

    private BigDecimal calculateInterestWithMargin(){
        BigDecimal baseRate = loanRequest.getBaseInterest();
        BigDecimal margin = loanRequest.getMargin();

        BigDecimal totalInterestRate = baseRate.add(margin);

        BigDecimal totalInterestAmount = runningAmountIncludingInterest.multiply(totalInterestRate);
        runningAmountIncludingInterest = runningAmountIncludingInterest.add(totalInterestAmount);
        return totalInterestAmount;
    }

    public List<DayResult> getFullResult(){
        return fullResult;
    }

}

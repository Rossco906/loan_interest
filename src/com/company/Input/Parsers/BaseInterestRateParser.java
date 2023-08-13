package com.company.Input.Parsers;

import com.company.Input.Requests.LoanRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BaseInterestRateParser implements Parser<LoanRequest> {
    private final String[] payload;
    private final int inputOrder;


    public BaseInterestRateParser(String[] payload, int inputOrder){
        this.payload = payload;
        this.inputOrder = inputOrder;
    }
    @Override
    public void parse(LoanRequest request, List<String> validationContext) {
        BigDecimal interestRate = null;
        BigDecimal denominator = new BigDecimal("100");
        try{
            interestRate = new BigDecimal(payload[inputOrder]);
            if (hasMoreThan2DecimalPlaces(interestRate)){
                validationContext.add("BaseInterestRate cannot be lower than one basis point");
            }else{
                interestRate = interestRate.divide(denominator).setScale(4, RoundingMode.DOWN);
            }
        }catch(NumberFormatException e){
            validationContext.add("BaseInterestRate cannot be parsed to double");
        }
        request.setBaseInterest(interestRate);
    }

    private boolean hasMoreThan2DecimalPlaces(BigDecimal value){
        BigDecimal scaledValue = value.setScale(2, RoundingMode.DOWN);
        BigDecimal difference = value.subtract(scaledValue);
        return difference.compareTo(BigDecimal.ZERO) > 0;
    }
}

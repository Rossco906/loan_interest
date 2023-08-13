package com.company.Input.Parsers;

import com.company.Input.Requests.LoanRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class MarginParser implements Parser<LoanRequest> {
    private final String[] payload;
    private final int inputOrder;

    public MarginParser(String[] payload, int inputOrder){
        this.payload = payload;
        this.inputOrder = inputOrder;
    }
    @Override
    public void parse(LoanRequest request, List<String> validationContext) {
        BigDecimal margin = null;
        BigDecimal denominator = new BigDecimal("100");
        try{
            margin = new BigDecimal(payload[inputOrder]);
            if (hasMoreThan2DecimalPlaces(margin)){
                validationContext.add("Margin cannot be lower than one basis point");
            }else{
                margin = margin.divide(denominator).setScale(4, RoundingMode.DOWN);
            }
        }catch(NumberFormatException e){
            validationContext.add("margin cannot be parsed to double");
        }
        request.setMargin(margin);
    }

    private boolean hasMoreThan2DecimalPlaces(BigDecimal value){
        BigDecimal scaledValue = value.setScale(2, RoundingMode.DOWN);
        BigDecimal difference = value.subtract(scaledValue);
        return difference.compareTo(BigDecimal.ZERO) > 0;
    }
}

package com.company.Input.Parsers;

import com.company.Input.Requests.LoanRequest;

import java.math.BigDecimal;
import java.util.List;

public class LoanAmountParser implements Parser<LoanRequest> {
    private final String[] payload;
    private final int inputOrder;
    public LoanAmountParser(String[] payload, int inputOrder){
        this.payload = payload;
        this.inputOrder = inputOrder;
    }
    @Override
    public void parse(LoanRequest request, List<String> validationContext) {
        BigDecimal amount = null;
        try{
            amount = new BigDecimal(payload[inputOrder]);
        }catch(NumberFormatException e){
            validationContext.add("LoanAmount cannot be parsed to double");
        }
        request.setLoanAmount(amount);
    }
}

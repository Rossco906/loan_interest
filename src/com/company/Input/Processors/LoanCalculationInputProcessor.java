package com.company.Input.Processors;

import com.company.Input.Parsers.*;
import com.company.Input.Requests.LoanRequest;

public class LoanCalculationInputProcessor extends AbstractInputProcessor<LoanRequest> {
    private final String[] payload;

    public LoanCalculationInputProcessor(String[] payload){
        this.payload = payload;
    }

    public void registerParsers(){
        addValidator(new StartDateParser(payload, 0));
        addValidator(new EndDateParser(payload, 1));
        addValidator(new LoanAmountParser(payload, 2));
        addValidator(new CurrencyParser(payload, 3));
        addValidator(new BaseInterestRateParser(payload, 4));
        addValidator(new MarginParser(payload, 5));
    }

    @Override
    LoanRequest createResponse(){
        return new LoanRequest();
    }
}

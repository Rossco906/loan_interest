package com.company.Input.Parsers;

import com.company.Currency;
import com.company.Input.Requests.LoanRequest;
import com.company.ReferenceData;

import java.util.List;

public class CurrencyParser implements Parser<LoanRequest> {
    private final String[] payload;
    private final int inputOrder;

    public CurrencyParser(String[] payload, int inputOrder){
        this.payload = payload;
        this.inputOrder = inputOrder;
    }
    @Override
    public void parse(LoanRequest request, List<String> validationContext) {
        String currencyInput = payload[inputOrder];
        if (isValidCurrency(currencyInput)){
            Currency currency = ReferenceData.CURRENCY_MAP.get(currencyInput);
            request.setCurrency(currency);
        }
        else{
            validationContext.add("Currency is either unsupported or invalid");
        }
    }

    private boolean isValidCurrency(String currency){
        return ReferenceData.CURRENCY_MAP.containsKey(currency);
    }
}

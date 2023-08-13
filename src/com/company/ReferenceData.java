package com.company;

import java.util.HashMap;
import java.util.Map;

public class ReferenceData {

    public static final Map<String, Currency> CURRENCY_MAP;
    static{
        Map<String, Currency> currency_reference_data = new HashMap<>();
        currency_reference_data.put("GBP", Currency.GBP);
        currency_reference_data.put("EUR", Currency.EUR);
        currency_reference_data.put("USD", Currency.USD);
        CURRENCY_MAP = currency_reference_data;
    }
}

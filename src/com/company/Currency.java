package com.company;

public enum Currency {
    GBP(2),
    EUR(2),
    USD(2);

    private final int decimalPlaces;

    Currency(int decimalPlaces){
        this.decimalPlaces = decimalPlaces;
    }

    private int getDecimalPlaces(){
        return decimalPlaces;
    }
}

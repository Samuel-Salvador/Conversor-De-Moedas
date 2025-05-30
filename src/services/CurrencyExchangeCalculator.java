package services;

import entities.Currency;

public class CurrencyExchangeCalculator {

    private static Double money;

    public static void setMoney(Double money) {
        CurrencyExchangeCalculator.money = money;
    }

    public static Double convertToBase(Currency curr1, Currency curr2){
        return money / curr1.getConversionRates().get(curr2.getBaseCurrency());
    }

    public static Double convertFromBase(Currency curr1, Currency curr2){
        return money * curr1.getConversionRates().get(curr2.getBaseCurrency());
    }
}

package entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import resources.ExchangeRateAPI;

import java.util.HashMap;
import java.util.Map;

public class Currency {

    private final String baseCurrency;
    private final Map<String,Double> conversionRates = new HashMap<>(6);
    private static final String[] currencies = {"ARS","BOB","BRL","CLP","COP","USD"};

    public Currency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void populateConversionRate(){

        JsonObject allConversionRates = ExchangeRateAPI.getAllConversionRates(this);

        for (String currency : currencies) {
            JsonElement conversionRateBuffer = allConversionRates.get(currency);
            getConversionRates().put(currency,conversionRateBuffer.getAsDouble());
        }
    }

    public void printConversionRate() {
        StringBuilder printable =
                new StringBuilder("Base-Currency: " + baseCurrency + "\n" +
                        "Conversion-Rates: \n");
        for (Map.Entry<String, Double> entry : conversionRates.entrySet()) {
            printable.append("\t")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }

        System.out.println(printable);

    }
}

package resources;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entities.Currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPI {

    private static final String APIkey = "d27c6851b6272ca9793cf5d8";

    public static JsonObject getAllConversionRates(Currency currentCurrency){

        String url = "https://v6.exchangerate-api.com/v6/"+APIkey+"/latest/"+currentCurrency.getBaseCurrency();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(uri).build();

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement responseJSON = JsonParser.parseString(response.body());
            JsonObject responseJsonObject = responseJSON.getAsJsonObject();

            return responseJsonObject.getAsJsonObject("conversion_rates");

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

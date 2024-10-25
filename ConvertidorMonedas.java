import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ConvertidorMonedas {

    private static final String API_KEY = "9b3e3ae218bf6c2acfc624ca"; // Reemplaza con tu clave API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double ConvertidorMonedas(String MonedaOrigen, String MonedaDestino, double cantidad) throws IOException {
        String urlString = API_URL + URLEncoder.encode(MonedaOrigen, StandardCharsets.UTF_8);
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != 200) {
            throw new IllegalArgumentException("Error en la API: " + connection.getResponseCode());
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        String jsonResponse = response.toString();
        if (!jsonResponse.contains("conversion_rates")) {
            throw new IllegalArgumentException("Moneda base no válida.");
        }

        String rateString = jsonResponse.split("\"" + MonedaDestino + "\":")[1].split(",")[0];
        double rate = Double.parseDouble(rateString);
        return cantidad * rate;
    }
}
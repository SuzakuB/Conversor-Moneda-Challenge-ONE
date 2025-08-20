import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiHandler {

    // Este método se conecta a la API y obtiene todas las tasas de cambio para una moneda base.
    public static JsonObject getExchangeRates(String apiKey, String baseCurrency) throws IOException, InterruptedException {
        // Construimos la URL para la solicitud a la API[cite: 51].
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

        // Creamos el cliente HttpClient, que actuará como nuestro "navegador"[cite: 47].
        HttpClient client = HttpClient.newHttpClient();

        // Creamos la solicitud HttpRequest, especificando la URL[cite: 51].
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .build();

        // Enviamos la solicitud y recibimos la respuesta del servidor[cite: 54].
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Verificamos si la solicitud fue exitosa (código 200).
        if (response.statusCode() != 200) {
            throw new IOException("Error en la respuesta de la API: " + response.statusCode());
        }

        // Usamos Gson para analizar la respuesta JSON y convertirla en un objeto[cite: 56, 60].
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
}
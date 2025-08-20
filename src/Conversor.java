import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Scanner;

public class Conversor {

    public static void main(String[] args) {
        // ===============================================================
        // ==      IMPORTANTE: Coloca tu clave de API personal aquí      ==
        // ===============================================================
        String apiKey = "28034ad7794a3e724d0ad83c";

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n***********************************************");
                System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
                System.out.println("1) Dólar =>> Peso Argentino");
                System.out.println("2) Peso Argentino =>> Dólar");
                System.out.println("3) Dólar =>> Real Brasileño");
                System.out.println("4) Real Brasileño =>> Dólar");
                System.out.println("5) Dólar =>> Peso Colombiano");
                System.out.println("6) Peso Colombiano =>> Dólar");
                System.out.println("7) Salir");
                System.out.print("Elija una opción válida: ");
                System.out.println("\n***********************************************");

                int option = scanner.nextInt();

                if (option == 7) {
                    System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                    break;
                }

                if (option < 1 || option > 6) {
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    continue;
                }

                System.out.print("Ingrese el valor que desea convertir: ");
                double amount = scanner.nextDouble();

                // Definimos las monedas de origen y destino según la opción del usuario.
                String fromCurrency = "";
                String toCurrency = "";

                switch (option) {
                    case 1: fromCurrency = "USD"; toCurrency = "ARS"; break;
                    case 2: fromCurrency = "ARS"; toCurrency = "USD"; break;
                    case 3: fromCurrency = "USD"; toCurrency = "BRL"; break;
                    case 4: fromCurrency = "BRL"; toCurrency = "USD"; break;
                    case 5: fromCurrency = "USD"; toCurrency = "COP"; break;
                    case 6: fromCurrency = "COP"; toCurrency = "USD"; break;
                }

                // Obtenemos todas las tasas de cambio para la moneda de origen.
                JsonObject rates = ApiHandler.getExchangeRates(apiKey, fromCurrency).getAsJsonObject("conversion_rates");

                // Obtenemos la tasa específica para la moneda de destino[cite: 62].
                double exchangeRate = rates.get(toCurrency).getAsDouble();

                // Calculamos el resultado.
                double result = amount * exchangeRate;

                // Mostramos el resultado al usuario.
                System.out.printf("\nEl valor de %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n",
                        amount, fromCurrency, result, toCurrency);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al consultar la API: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Conversor {

    public static void main(String[] args) {
        // ===============================================================
        // ==      IMPORTANTE: Coloca la clave de API personal aquí      ==
        // ===============================================================
        String apiKey = "28034ad7794a3e724d0ad83c";

        // Lista de las monedas disponibles para la conversión.
        List<String> currencies = List.of("USD", "MXN", "KRW", "JPY", "CNY", "ARS", "BRL", "COP");
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n***************************************************");
                System.out.println("Sea bienvenido/a al Conversor de Moneda Universal");

                // Menú para la moneda de ORIGEN
                System.out.println("\nElija la moneda de ORIGEN:");
                printCurrencyMenu(currencies);
                System.out.print("Su opción (o 0 para salir): ");
                int fromIndex = scanner.nextInt();

                if (fromIndex == 0) {
                    break; // Salir del bucle principal
                }

                // Menú para la moneda de DESTINO
                System.out.println("\nElija la moneda de DESTINO:");
                printCurrencyMenu(currencies);
                System.out.print("Su opción (o 0 para salir): ");
                int toIndex = scanner.nextInt();

                if (toIndex == 0) {
                    break; // Salir del bucle principal
                }

                // Validar selección
                if (fromIndex < 1 || fromIndex > currencies.size() || toIndex < 1 || toIndex > currencies.size()) {
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    continue;
                }

                // Obtener los códigos de moneda
                String fromCurrency = currencies.get(fromIndex - 1);
                String toCurrency = currencies.get(toIndex - 1);

                // Solicitar el monto
                System.out.print("\nIngrese el valor que desea convertir de " + fromCurrency + " a " + toCurrency + ": ");
                double amount = scanner.nextDouble();

                // Llamar a la API
                JsonObject rates = ApiHandler.getExchangeRates(apiKey, fromCurrency).getAsJsonObject("conversion_rates");
                double exchangeRate = rates.get(toCurrency).getAsDouble();
                double result = amount * exchangeRate;

                // Mostrar resultado
                System.out.printf("\nEl valor de %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n",
                        amount, fromCurrency, result, toCurrency);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al consultar la API: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado. Verifique su entrada.");
        } finally {
            scanner.close();
            System.out.println("\nGracias por usar el conversor. ¡Hasta luego! 👋");
        }
    }

    // Método auxiliar para imprimir el menú de monedas.
    private static void printCurrencyMenu(List<String> currencies) {
        for (int i = 0; i < currencies.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, currencies.get(i));
        }
    }
}
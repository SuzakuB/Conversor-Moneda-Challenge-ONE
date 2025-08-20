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
                System.out.println("\n***************************************************");
                System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
                System.out.println("Moneda Base: Peso Mexicano (MXN)");
                System.out.println("\n--- Conversiones con Dólar Estadounidense ---");
                System.out.println("1) Peso Mexicano (MXN) =>> Dólar (USD)");
                System.out.println("2) Dólar (USD) =>> Peso Mexicano (MXN)");
                System.out.println("\n--- Conversiones con Monedas Asiáticas ---");
                System.out.println("3) Peso Mexicano (MXN) =>> Won surcoreano (KRW)");
                System.out.println("4) Won surcoreano (KRW) =>> Peso Mexicano (MXN)");
                System.out.println("5) Peso Mexicano (MXN) =>> Yen Japonés (JPY)");
                System.out.println("6) Yen Japonés (JPY) =>> Peso Mexicano (MXN)");
                System.out.println("7) Peso Mexicano (MXN) =>> Yuan Chino (CNY)");
                System.out.println("8) Yuan Chino (CNY) =>> Peso Mexicano (MXN)");
                System.out.println("\n9) Salir");
                System.out.print("Elija una opción válida: ");
                System.out.println("\n***************************************************");

                int option = scanner.nextInt();

                if (option == 9) {
                    System.out.println("Gracias por usar el conversor. ¡Hasta luego! 👋");
                    break;
                }

                if (option < 1 || option > 8) {
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    continue;
                }

                System.out.print("Ingrese el valor que desea convertir: ");
                double amount = scanner.nextDouble();

                String fromCurrency = "";
                String toCurrency = "";

                // Lógica para asignar las monedas según la opción del usuario
                switch (option) {
                    case 1: fromCurrency = "MXN"; toCurrency = "USD"; break;
                    case 2: fromCurrency = "USD"; toCurrency = "MXN"; break;
                    case 3: fromCurrency = "MXN"; toCurrency = "KRW"; break;
                    case 4: fromCurrency = "KRW"; toCurrency = "MXN"; break;
                    case 5: fromCurrency = "MXN"; toCurrency = "JPY"; break;
                    case 6: fromCurrency = "JPY"; toCurrency = "MXN"; break;
                    case 7: fromCurrency = "MXN"; toCurrency = "CNY"; break;
                    case 8: fromCurrency = "CNY"; toCurrency = "MXN"; break;
                }

                // Llamamos a la API para obtener las tasas de cambio
                JsonObject rates = ApiHandler.getExchangeRates(apiKey, fromCurrency).getAsJsonObject("conversion_rates");

                // Obtenemos la tasa específica que necesitamos
                double exchangeRate = rates.get(toCurrency).getAsDouble();

                // Calculamos el resultado
                double result = amount * exchangeRate;

                // Mostramos el resultado formateado
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
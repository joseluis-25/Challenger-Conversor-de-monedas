import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc;
        do {
            System.out.println("**************************************");
            System.out.println();
            System.out.println("  BIENVENIDO AL CONVERSOR DE MONEDAS");
            System.out.println();
            System.out.print("  1) Dólar =>> Peso argentino");
            System.out.println();
            System.out.print("  2) Peso argentino =>> Dólar");
            System.out.println();
            System.out.print("  3) Dólar =>> Real Brasileño");
            System.out.println();
            System.out.print("  4) Real Brasileño =>> Dólar");
            System.out.println();
            System.out.print("  5) Dólar =>> Peso colombiano");
            System.out.println();
            System.out.print("  6) Peso colombiano =>> Dólar");
            System.out.println();
            System.out.print("  7) Dólar =>> Soles");
            System.out.println();
            System.out.print("  8) Soles =>> Dólar");
            System.out.println();
            System.out.println("  9) Salir");
            System.out.println();
            System.out.println("**************************************");
            System.out.println("Seleccione una opción de conversión:");
            opc = scanner.nextInt();

            if (opc == 9) {
                System.out.println("Saliendo del menú...");
                break;
            }

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            String monedaOrigen = "";
            String monedaDestino = "";

            switch (opc) {
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    break;
                case 2:
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    break;
                case 3:
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    break;
                case 4:
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    break;
                case 5:
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    break;
                case 6:
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    break;
                case 7:
                    monedaOrigen = "USD";
                    monedaDestino = "PEN";
                    break;
                case 8:
                    monedaOrigen = "PEN";
                    monedaDestino = "USD";
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    continue; // Regresar al inicio del bucle
            }

            // Lógica de conversión
            try {
                double convertedAmount = ConvertidorMonedas.ConvertidorMonedas(monedaOrigen, monedaDestino, cantidad);
                System.out.printf("%.2f %s son %.2f %s%n", cantidad, monedaOrigen, convertedAmount, monedaDestino);
            } catch (IOException e) {
                System.out.println("Error al obtener los datos de la API: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (opc != 9);
        scanner.close(); // Cerrar el scanner
    }
}

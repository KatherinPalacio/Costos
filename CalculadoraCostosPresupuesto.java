package libJNICalculadora;

import java.util.Scanner;

public class CalculadoraCostosPresupuesto {

    // Cargar la librería nativa
    static {
        System.loadLibrary("calculadoracostos"); // Nombre del archivo .so sin la extensión
    }

    // Declaración de los métodos nativos
    public native double precioVentaAbsor(double matPrima, double mod, double cifVar, double cifFijo, double porcUtil);
    public native double precioVentaDir(double matPrima, double mod, double cifVar, double gastosVar, double porcUtil);

    public static void main(String[] args) {
        // Crear una instancia de la clase
        CalculadoraCostosPresupuesto calculadora = new CalculadoraCostosPresupuesto();
        Scanner scanner = new Scanner(System.in);

        // Solicitar valores al usuario para el cálculo con costeo por absorción
        System.out.println("Cálculo del precio de venta con Costeo por Absorción:");
        System.out.print("Ingrese el costo de la materia prima: ");
        double matPrima = scanner.nextDouble();

        System.out.print("Ingrese el costo de la mano de obra directa: ");
        double mod = scanner.nextDouble();

        System.out.print("Ingrese el costo indirecto de fabricación variable: ");
        double cifVar = scanner.nextDouble();

        System.out.print("Ingrese el costo indirecto de fabricación fijo: ");
        double cifFijo = scanner.nextDouble();

        System.out.print("Ingrese el porcentaje de utilidad (como decimal, ej: 0.25 para 25%): ");
        double porcUtil = scanner.nextDouble();

        // Calcular y mostrar el precio de venta con costeo por absorción
        double precioAbsorcion = calculadora.precioVentaAbsor(matPrima, mod, cifVar, cifFijo, porcUtil);
        System.out.println("Precio de venta (Costeo por Absorción): " + precioAbsorcion);

        // Solicitar valores al usuario para el cálculo con costeo directo
        System.out.println("\nCálculo del precio de venta con Costeo Directo:");
        System.out.print("Ingrese el costo de los gastos variables: ");
        double gastosVar = scanner.nextDouble();

        // Calcular y mostrar el precio de venta con costeo directo
        double precioDirecto = calculadora.precioVentaDir(matPrima, mod, cifVar, gastosVar, porcUtil);
        System.out.println("Precio de venta (Costeo Directo): " + precioDirecto);

        // Cerrar el scanner
        scanner.close();
    }
}


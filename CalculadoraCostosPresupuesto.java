
package libJNICalculadora;

import java.util.Scanner;

public class CalculadoraCostosPresupuesto {

    // Carga la biblioteca nativa
    static {
        System.loadLibrary("calpresupuesto");
    }

    // Métodos nativos en C
    public native double calcularPrecioVentaAbsorcion(double materiaPrima, double mod, double cifVariables, double cifFijos, double porcentajeUtilidad);
    public native double calcularPrecioVentaDirecto(double materiaPrima, double mod, double cifVariables, double gastosVentasVariables, double porcentajeUtilidad);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entradas del usuario
        System.out.print("Ingrese el costo de la Materia Prima: ");
        double materiaPrima = scanner.nextDouble();

        System.out.print("Ingrese el costo de Mano de Obra Directa (M.O.D): ");
        double mod = scanner.nextDouble();

        System.out.print("Ingrese los Costos Indirectos de Fabricación (C.I.F.) Variables: ");
        double cifVariables = scanner.nextDouble();

        System.out.print("Ingrese el porcentaje de utilidad (como decimal): ");
        double porcentajeUtilidad = scanner.nextDouble();

        // Instancia del calculador
         CalculadoraCostosPresupuesto calculadora = new  CalculadoraCostosPresupuesto ();

        // Calculo de Costeo por Absorción
        System.out.print("Ingrese los Costos Indirectos de Fabricación (C.I.F.) Fijos: ");
        double cifFijos = scanner.nextDouble();
        double precioVentaAbsorcion = calculadora.calcularPrecioVentaAbsorcion(materiaPrima, mod, cifVariables, cifFijos, porcentajeUtilidad);
        System.out.printf("Precio de Venta (Costeo por Absorción): %.2f%n", precioVentaAbsorcion);

        // Calculo de Costeo Directo
        System.out.print("Ingrese los Gastos de Ventas Variables: ");
        double gastosVentasVariables = scanner.nextDouble();
        double precioVentaDirecto = calculadora.calcularPrecioVentaDirecto(materiaPrima, mod, cifVariables, gastosVentasVariables, porcentajeUtilidad);
        System.out.printf("Precio de Venta (Costeo Directo): %.2f%n", precioVentaDirecto);

        scanner.close();
    }
}

package libJNICalculadora;

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

        // Valores de prueba para calcular el precio de venta con costeo por absorción
        double matPrima = 100.0;
        double mod = 50.0;
        double cifVar = 20.0;
        double cifFijo = 30.0;
        double porcUtil = 0.25; // 25%

        // Calcular precio de venta con costeo por absorción
        double precioAbsorcion = calculadora.precioVentaAbsor(matPrima, mod, cifVar, cifFijo, porcUtil);
        System.out.println("Precio de venta (Costeo por Absorción): " + precioAbsorcion);

        // Valores de prueba para calcular el precio de venta con costeo directo
        double gastosVar = 10.0;

        // Calcular precio de venta con costeo directo
        double precioDirecto = calculadora.precioVentaDir(matPrima, mod, cifVar, gastosVar, porcUtil);
        System.out.println("Precio de venta (Costeo Directo): " + precioDirecto);
    }
}


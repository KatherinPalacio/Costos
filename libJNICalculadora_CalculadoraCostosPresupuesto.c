
#include <jni.h>

// Función para calcular precio de venta usando costeo por absorción

JNIEXPORT jdouble JNICALL Java_libJNICalculadora_CalculadoraCostosPresupuesto_calcularPrecioVentaAbsorcion
(JNIEnv *env, jobject obj, jdouble materiaPrima, jdouble mod, jdouble cifVariables, jdouble cifFijos, jdouble porcentajeUtilidad){

 // Calcular total de costos
    double totalCostos = materiaPrima + mod + cifVariables + cifFijos;

    // Calcular costo unitario
    double costoUnitario = totalCostos / (1 - porcentajeUtilidad);

    return costoUnitario; // Retornar el costo unitario

}

JNIEXPORT jdouble JNICALL Java_libJNICalculadora_CalculadoraCostosPresupuesto_calcularPrecioVentaDirecto
(JNIEnv *env, jobject obj, jdouble materiaPrima, jdouble mod, jdouble cifVariables, jdouble gastosVentasVariables, jdouble porcentajeUtilidad) {

// Calcular total de costos
    double totalCostos = materiaPrima + mod + cifVariables + gastosVentasVariables;

    // Calcular costo unitario
    double costoUnitario = totalCostos / (1 - porcentajeUtilidad);

    return costoUnitario; // Retornar el costo unitario
}

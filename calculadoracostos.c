#include <jni.h>
#include "libJNICalculadora_CalculadoraCostosPresupuesto.h"

// Implementación del método para calcular el precio de venta con costeo por absorción
JNIEXPORT jdouble JNICALL Java_libJNICalculadora_CalculadoraCostosPresupuesto_precioVentaAbsor
(JNIEnv *env, jobject obj, jdouble matPrima, jdouble mod, jdouble cifVar, jdouble cifFijo, jdouble porcUtil) {
    
    // Calcular el total de costos y el precio de venta
    double totalCostos = matPrima + mod + cifVar + cifFijo;
    return totalCostos / (1 - porcUtil); // Retornar el precio de venta con margen de utilidad
}

// Implementación del método para calcular el precio de venta con costeo directo
JNIEXPORT jdouble JNICALL Java_libJNICalculadora_CalculadoraCostosPresupuesto_precioVentaDir
(JNIEnv *env, jobject obj, jdouble matPrima, jdouble mod, jdouble cifVar, jdouble gastosVar, jdouble porcUtil) {
    
    // Calcular el total de costos y el precio de venta
    double totalCostos = matPrima + mod + cifVar + gastosVar;
    return totalCostos / (1 - porcUtil); // Retornar el precio de venta con margen de utilidad
}


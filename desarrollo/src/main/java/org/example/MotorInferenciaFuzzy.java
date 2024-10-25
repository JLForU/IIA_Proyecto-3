
// package
package org.example ;


// imports
import java.util.HashMap;
import java.util.Map;



public class MotorInferenciaFuzzy {
    private BaseConocimiento baseConocimiento;
    private Map<ConjuntoDifuso, Double> resultadoIntermedio;

    public MotorInferenciaFuzzy(BaseConocimiento baseConocimiento) {
        this.baseConocimiento = baseConocimiento;
        this.resultadoIntermedio = new HashMap<>();
    }

    // Realiza la inferencia fuzzy tipo Mamdani
    public void inferir(double valorEntrada1, double valorEntrada2) {
        for (ReglaDifusa regla : baseConocimiento.getReglas()) {
            if (regla.evaluar(valorEntrada1, valorEntrada2)) {
                ConjuntoDifuso consecuente = regla.getConsecuente();
                double pertenencia = Math.min(1.0, valorEntrada1); // Ejemplo de lógica de inferencia
                resultadoIntermedio.put(consecuente, pertenencia);
            }
        }
    }

    // Método para desfuzificar el resultado
    public double desfuzificar() {
        // Implementación para desfuzificar el valor fuzzy y devolver un valor preciso
        // Ejemplo de desfuzificación utilizando el método del centroide
        double numerador = 0.0;
        double denominador = 0.0;
        for (Map.Entry<ConjuntoDifuso, Double> entrada : resultadoIntermedio.entrySet()) {
            double valor = entrada.getValue(); // Grado de pertenencia
            numerador += valor; // Ejemplo básico
            denominador += valor;
        }
        return (denominador == 0) ? 0 : (numerador / denominador);
    }

    public void mostrarResultadoIntermedio() {
        for (Map.Entry<ConjuntoDifuso, Double> entrada : resultadoIntermedio.entrySet()) {
            System.out.println(entrada.getKey().getNombre() + ": " + entrada.getValue());
        }
    }
}

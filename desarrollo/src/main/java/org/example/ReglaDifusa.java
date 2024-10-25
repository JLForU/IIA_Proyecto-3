
// package
package org.example ;


// imports
import java.util.ArrayList;
import java.util.List;



public class ReglaDifusa {
    private List<CondicionDifusa> condiciones;
    private ConjuntoDifuso consecuente;

    public ReglaDifusa() {
        this.condiciones = new ArrayList<>();
        // Se debe definir el consecuente y las condiciones
    }

    public ReglaDifusa(List<CondicionDifusa> condiciones, ConjuntoDifuso consecuente) {
        this.condiciones = condiciones;
        this.consecuente = consecuente;
    }

    public ConjuntoDifuso getConsecuente () {
        return this.consecuente ;
    }

    // Evaluar una regla con dos valores de entrada
    public boolean evaluar(double valorEntrada1, double valorEntrada2) {
        // Lógica para evaluar la regla con las condiciones
        // Ejemplo de evaluación básica
        for (CondicionDifusa condicion : condiciones) {
            if (!condicion.evaluar(valorEntrada1, valorEntrada2)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Si ");
        for (CondicionDifusa condicion : condiciones) {
            sb.append(condicion.toString()).append(" ");
        }
        sb.append("Entonces ").append(consecuente.getNombre());
        return sb.toString();
    }
}

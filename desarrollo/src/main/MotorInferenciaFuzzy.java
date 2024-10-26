import java.util.List;

public class MotorInferenciaFuzzy {
    private List<VariableLinguistica> variables;

    public MotorInferenciaFuzzy(List<VariableLinguistica> variables) {
        this.variables = variables;
    }

    public void realizarInferencia(double[] valoresEntrada) {
        if (valoresEntrada.length != variables.size()) {
            throw new IllegalArgumentException("Número de valores de entrada no coincide con el número de variables.");
        }

        for (int i = 0; i < valoresEntrada.length; i++) {
            variables.get(i).fuzzificar(valoresEntrada[i]);
        }

        // Aquí se realiza la inferencia y se podría mostrar la traza
        System.out.println("Resultado de la inferencia:");
        for (VariableLinguistica variable : variables) {
            System.out.println("Variable: " + variable.getNombre());
            variable.getValoresPertenencia().forEach((conjunto, pertenencia) -> {
                System.out.println("  Conjunto: " + conjunto + " -> Grado de pertenencia: " + pertenencia);
            });
        }
    }
}

import java.util.List;

public class SistemaFuzzy {
    private List<VariableLinguistica> variables;
    private MotorInferenciaFuzzy motorInferencia;

    public SistemaFuzzy(List<VariableLinguistica> variables, MotorInferenciaFuzzy motorInferencia) {
        this.variables = variables;
        this.motorInferencia = motorInferencia;
    }

    // Cargar el sistema desde archivos
    public void cargarSistema(String archivoVariables, String archivoReglas) {
        // Implementar la carga de variables y reglas desde los archivos
        // Posiblemente utilice métodos de las clases BaseConocimiento y VariableLinguistica
    }

    // Realizar el proceso completo de inferencia
    public double realizarInferencia(double entrada1, double entrada2) {
        motorInferencia.inferir(entrada1, entrada2);
        return motorInferencia.desfuzificar();
    }
}

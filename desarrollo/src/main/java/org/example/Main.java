import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<VariableLinguistica> variables = VariableLinguistica.cargarDesdeArchivo("src/resources/variables.txt");

            MotorInferenciaFuzzy motor = new MotorInferenciaFuzzy(variables);

            double[] valoresEntrada = {70.0, 45.0}; // Ejemplo de valores para "Distancia" y "Velocidad"
            motor.realizarInferencia(valoresEntrada);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

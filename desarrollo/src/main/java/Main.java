
import java.io.IOException ;
import java.util.List ;


public class Main {


    public static void main(String[] args) {

        try {

            // Get the class path for the resource folder dynamically
            String classPath = String.valueOf(Main.class.getClassLoader().getResource(""));
            classPath = classPath.replace("file:", "").replace("\\", "/");

            // Construct the path to the "variables.txt" file
            String variablesFilePath = classPath + "variables.txt";

            // Load the variables from the file
            List<VariableLinguistica> variables = VariableLinguistica.cargarDesdeArchivo(variablesFilePath);

            MotorInferenciaFuzzy motor = new MotorInferenciaFuzzy(variables);

            double[] valoresEntrada = {54.0, 54.0}; // Ejemplo de valores para "Servicio" y "Comida"
            motor.realizarInferencia(valoresEntrada);
            double servicio = valoresEntrada[0];
            double comida = valoresEntrada[1];

            double propinaRecomendada = motor.calcularPropina(servicio, comida);
            System.out.println("La propina recomendada es: " + propinaRecomendada + "%");


        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

    }


}


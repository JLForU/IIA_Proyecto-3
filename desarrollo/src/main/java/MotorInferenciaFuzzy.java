
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

        System.out.println("Resultado de la inferencia:");
        for (VariableLinguistica variable : variables) {
            System.out.println("Variable: " + variable.getNombre());
            variable.getValoresPertenencia().forEach((conjunto, pertenencia) -> {
                System.out.println("  Conjunto: " + conjunto + " -> Grado de pertenencia: " + pertenencia);
            });
        }
    }

    public double calcularPropina(double servicio, double comida) {
        // Obtener variables
        VariableLinguistica servicioVariable = getVariable("Servicio");
        VariableLinguistica comidaVariable = getVariable("Comida");

        // Calcular grados de pertenencia
        double gradoServicioBajo = servicioVariable.gradoPertenenciaConjunto("Bajo", servicio);
        double gradoServicioMedio = servicioVariable.gradoPertenenciaConjunto("Medio", servicio);
        double gradoServicioAlto = servicioVariable.gradoPertenenciaConjunto("Alto", servicio);
        double gradoComidaSalada = comidaVariable.gradoPertenenciaConjunto("Salada", comida);
        double gradoComidaInsipida = comidaVariable.gradoPertenenciaConjunto("insipida", comida);
        double gradoComidaDulce = comidaVariable.gradoPertenenciaConjunto("Dulce", comida);

        // Reglas de inferencia
        double propinaBaja = Math.max(gradoServicioBajo, gradoComidaInsipida);
        double propinaMedia = Math.max(gradoServicioMedio, gradoComidaSalada);
        double propinaAlta = Math.max(gradoServicioAlto, gradoComidaDulce);

        // Defuzzificación
        double propina = (propinaBaja * 10 + propinaMedia * 15 + propinaAlta * 20) /
                (propinaBaja + propinaMedia + propinaAlta);

        return propina;
    }

    private VariableLinguistica getVariable(String nombre) {
        return variables.stream()
                .filter(var -> var.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Variable no encontrada: " + nombre));
    }



}


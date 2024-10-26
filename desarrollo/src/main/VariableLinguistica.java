import java.io.*;
import java.util.*;

public class VariableLinguistica {
    private String nombre;
    private List<ConjuntoDifuso> conjuntosDifusos;
    private Map<String, Double> valoresPertenencia;

    public VariableLinguistica(String nombre) {
        this.nombre = nombre;
        this.conjuntosDifusos = new ArrayList<>();
        this.valoresPertenencia = new HashMap<>();
    }

    public void agregarConjuntoDifuso(ConjuntoDifuso conjunto) {
        conjuntosDifusos.add(conjunto);
    }

    public void fuzzificar(double valor) {
        for (ConjuntoDifuso conjunto : conjuntosDifusos) {
            double pertenencia = conjunto.calcularPertenencia(valor);
            valoresPertenencia.put(conjunto.getNombre(), pertenencia);
        }
    }

    public Map<String, Double> getValoresPertenencia() {
        return valoresPertenencia;
    }

    // Método para cargar variables lingüísticas y sus conjuntos desde un archivo de texto
    public static List<VariableLinguistica> cargarDesdeArchivo(String archivo) throws IOException {
        List<VariableLinguistica> variables = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;

        VariableLinguistica variableActual = null;

        while ((linea = reader.readLine()) != null) {
            if (linea.startsWith("Variable:")) {
                // Nueva variable lingüística
                String nombreVariable = linea.split(":")[1].trim();
                variableActual = new VariableLinguistica(nombreVariable);
                variables.add(variableActual);
            } else if (linea.startsWith("Conjunto:") && variableActual != null) {
                // Nuevo conjunto difuso
                String[] partes = linea.split(":")[1].trim().split(",");
                String nombreConjunto = partes[0].trim();
                String tipoFuncion = partes[1].trim();

                FuncionPertenencia funcion;
                if (tipoFuncion.equalsIgnoreCase("triangular")) {
                    double a = Double.parseDouble(partes[2].trim());
                    double b = Double.parseDouble(partes[3].trim());
                    double c = Double.parseDouble(partes[4].trim());
                    funcion = new FuncionTriangular(a, b, c);
                } else if (tipoFuncion.equalsIgnoreCase("trapezoidal")) {
                    double a = Double.parseDouble(partes[2].trim());
                    double b = Double.parseDouble(partes[3].trim());
                    double c = Double.parseDouble(partes[4].trim());
                    double d = Double.parseDouble(partes[5].trim());
                    funcion = new FuncionTrapezoidal(a, b, c, d);
                } else {
                    throw new IllegalArgumentException("Tipo de función no soportado: " + tipoFuncion);
                }

                ConjuntoDifuso conjunto = new ConjuntoDifuso(nombreConjunto, funcion);
                variableActual.agregarConjuntoDifuso(conjunto);
            }
        }

        reader.close();
        return variables;
    }

    public String getNombre() {
        return nombre;
    }
}

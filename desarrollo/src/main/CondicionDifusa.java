public class CondicionDifusa {
    private VariableLinguistica variable;
    private ConjuntoDifuso conjunto;

    public CondicionDifusa(VariableLinguistica variable, ConjuntoDifuso conjunto) {
        this.variable = variable;
        this.conjunto = conjunto;
    }

    // Evaluar si un valor pertenece al conjunto difuso de la condición
    public boolean evaluar(double valorEntrada1, double valorEntrada2) {
        // Implementar evaluación fuzzy aquí
        double pertenencia = conjunto.getFuncionPertenencia().calcular(valorEntrada1);
        return pertenencia > 0;  // Ejemplo de lógica simple
    }

    @Override
    public String toString() {
        return variable.getNombre() + " es " + conjunto.getNombre();
    }
}

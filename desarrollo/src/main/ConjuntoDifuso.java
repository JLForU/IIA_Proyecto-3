public class ConjuntoDifuso {
    private String nombre;
    private FuncionPertenencia funcion;

    public ConjuntoDifuso(String nombre, FuncionPertenencia funcion) {
        this.nombre = nombre;
        this.funcion = funcion;
    }

    public String getNombre() {
        return nombre;
    }

    public FuncionPertenencia getFuncionPertenencia() {
        return funcionPertenencia;
    }

    public double calcularPertenencia(double valor) {
        return funcion.calcular(valor);
    }

    @Override
    public String toString() {
        return nombre;
    }
}

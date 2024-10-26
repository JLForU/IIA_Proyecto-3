public class FuncionTriangular extends FuncionPertenencia {
    private double a;  // Punto izquierdo del triángulo
    private double b;  // Punto superior (máximo) del triángulo
    private double c;  // Punto derecho del triángulo

    public FuncionTriangular(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Implementación del método calcular para la función triangular
    @Override
    public double calcular(double valor) {
        if (valor <= a || valor >= c) {
            return 0.0;
        } else if (valor == b) {
            return 1.0;
        } else if (valor > a && valor < b) {
            return (valor - a) / (b - a);
        } else {
            return (c - valor) / (c - b);
        }
    }

    @Override
    public String toString() {
        return "Triangular(" + a + ", " + b + ", " + c + ")";
    }
}

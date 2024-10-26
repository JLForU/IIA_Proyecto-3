
// package
package org.example ;


// imports


public class FuncionTrapezoidal extends FuncionPertenencia {


    private double a;  // Punto izquierdo inferior
    private double b;  // Punto izquierdo superior
    private double c;  // Punto derecho superior
    private double d;  // Punto derecho inferior

    public FuncionTrapezoidal(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    // Implementación del método calcular para la función trapezoidal
    @Override
    public double calcular(double valor) {
        if (valor <= a || valor >= d) {
            return 0.0;
        } else if (valor >= b && valor <= c) {
            return 1.0;
        } else if (valor > a && valor < b) {
            return (valor - a) / (b - a);
        } else {
            return (d - valor) / (d - c);
        }
    }

    @Override
    public String toString() {
        return "Trapezoidal(" + a + ", " + b + ", " + c + ", " + d + ")";
    }


}


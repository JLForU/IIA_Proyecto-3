
// package
package org.example ;


// imports



public class ConjuntoDifuso {


    private String nombre;
    private FuncionPertenencia funcionPertenencia;

    public ConjuntoDifuso(String nombre, FuncionPertenencia funcionPertenencia) {
        this.nombre = nombre;
        this.funcionPertenencia = funcionPertenencia;
    }

    public String getNombre() {
        return nombre;
    }

    public FuncionPertenencia getFuncionPertenencia() {
        return funcionPertenencia;
    }

    public double calcularPertenencia(double valor) {
        return funcionPertenencia.calcular(valor);
    }

    @Override
    public String toString() {
        return nombre + " con función de pertenencia " + funcionPertenencia.toString();
    }


}



// package
package org.example ;


// imports
import java.util.ArrayList;
import java.util.List;



public class BaseConocimiento {


    private List<ReglaDifusa> reglas;

    public BaseConocimiento() {
        this.reglas = new ArrayList<>();
    }

    // Cargar reglas desde un archivo (puede necesitar una implementación detallada)
    public void cargarReglasDesdeArchivo(String archivo) {
        // Implementación para leer el archivo y cargar las reglas
        // Por simplicidad, aquí solo se muestra un ejemplo de agregar reglas
        ReglaDifusa regla = new ReglaDifusa();
        // Añadir regla al sistema
        reglas.add(regla);
    }

    // Mostrar reglas cargadas
    public void mostrarReglas() {
        for (ReglaDifusa regla : reglas) {
            System.out.println(regla.toString());
        }
    }

    // Obtener todas las reglas
    public List<ReglaDifusa> getReglas() {
        return reglas;
    }


}


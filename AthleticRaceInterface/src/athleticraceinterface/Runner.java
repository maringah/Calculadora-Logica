package athleticraceinterface;

/**
Nombre completo: Hugo Iván Marín Galicia
Fecha de elaboración: 22 de Junio de 2024
Nombre del Módulo: Topicos Avanzados de Programación
Nombre del Asesor: Andrés Espinal Jiménez
* 
* @author hugot
*/

// Runner.java
public class Runner {
    private String name;
    private int speed;

    // Constructor
    public Runner(String name) {
        this.name = name;
        this.speed = (int) (Math.random() * 30); // Velocidad aleatoria entre 0 y 30
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

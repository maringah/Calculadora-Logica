package athleticraceinterface;

/**
Nombre completo: Hugo Iván Marín Galicia
Fecha de elaboración: 22 de Junio de 2024
Nombre del Módulo: Topicos Avanzados de Programación
Nombre del Asesor: Andrés Espinal Jiménez
* 
* @author hugot
*/

// RunnableRunner.java
import javax.swing.JTextArea;

public class RunnableRunner implements Runnable {
    private Runner runner;
    private JTextArea resultArea;

    // Constructor
    public RunnableRunner(Runner runner, JTextArea resultArea) {
        this.runner = runner;
        this.resultArea = resultArea;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        try {
            Thread.sleep(runner.getSpeed() * 1000); // Dormir según la velocidad del corredor
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000; // Convertir el tiempo total a segundos

        // Agregar el nombre del corredor y su tiempo al área de resultados
        synchronized(resultArea) {
            resultArea.append(runner.getName() + " ha llegado a la meta en " + totalTime + " segundos!\n");
        }
    }
}



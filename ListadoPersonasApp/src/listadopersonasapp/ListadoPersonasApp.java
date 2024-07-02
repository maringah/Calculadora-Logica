package listadopersonasapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hugot
 */
public class ListadoPersonasApp {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        // Creación y definición de lista fuera del ciclo while.
        List<Persona> personas = new ArrayList<>();
        // Iniciar menu.
        var salir = false;
        while (!salir) {
            mostrarMenu();
            try{ // Manejo de excepciones.
            salir = ejecutarOperacion(consola, personas);// Función para salir del ciclo while.
            } catch(Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();

        }

    }

    private static void mostrarMenu() {
        // Mostrar opciones.
        System.out.println("""
                           ****Listado Personas App****
                           1. Agregar
                           2. Listar
                           3. Salir
                           """);
        System.out.println("Selecciona una opcion: ");

    }
    
    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opción selecionada con la estructura Switch.
        switch(opcion){
            case 1 -> {// Agregar persona a la lista.
                System.out.println("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Proporciona el apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Proporciona el telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Proporciona el email: ");
                var email = consola.nextLine();
                // Crear el objeto Persona.
                var persona = new Persona(nombre, apellido, telefono, email);
                // Agregamos el objeto Persona a la lista.
                personas.add(persona); // El metodo '.add' agrega una persona a la lista.
                System.out.println("La lista tiene: " + personas.size()+ " elementos");// El metodo '.size' muestra la cantidad de elementos.
                
            } // Fin caso 1.
            
            case 2 -> {// Listar personas.
                System.out.println("Listado de personas: ");
                // Mejora lambda y metodo de referencia para imprimir la lista e iterar cada elemento de la lista.
                // personas.forEach((persona)-> System.out.println(persona)); Metodo lambda.
                personas.forEach(System.out::println); // Metodo de referencia.
            }
            
            case 3 -> {// Salimos del ciclo.
                System.out.println("Hasta pronto....");
                salir = true;
            }
            default -> System.out.println("Operacion erronea: " + opcion);
                  
        } // Fin switch.
        return salir;
    
    }

}

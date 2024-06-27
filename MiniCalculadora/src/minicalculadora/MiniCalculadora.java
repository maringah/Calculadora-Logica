package minicalculadora;

import java.util.Scanner;

/**
 *
 * @author hugot
 */
public class MiniCalculadora {

    @SuppressWarnings("fallthrough")
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        while (true) {
            System.out.println("****Mini Calculadora****");

            //Mostrar menu para elección de operación.
            //System.out.println("1.Suma \n2.Resta \n3.Multiplicación \n4. División"); para mostrar una lista.
            System.out.println("""
                           1. Suma
                           2. Resta
                           3. Multiplicacion
                           4. Division
                           5. Salir
                           """);//Para mostrar una lista
            System.out.println("Elige la operacion a realizar: ");
            try { // Nos va a permitir manejar excepciones en caso de ingresar una letra como operacion a realizar.
                var operacion = Integer.parseInt(consola.nextLine());
                // Revisar que este dentro de las opciones 
                if (operacion >= 1 && operacion <= 4) {
                    System.out.println("Proporciona un numero: ");
                    var operando1 = Integer.parseInt(consola.nextLine());
                    System.out.println("Proporciona otro numero: ");
                    var operando2 = Integer.parseInt(consola.nextLine());
                    int resultado;
                    // Estructura Switch.
                    switch (operacion) {
                        case 1 -> { // Suma
                            resultado = operando1 + operando2;
                            System.out.println("Resultado de la suma: " + resultado);
                        }

                        case 2 -> { // Resta
                            resultado = operando1 - operando2;
                            System.out.println("Resultado de la resta: " + resultado);
                        }

                        case 3 -> { // Multiplicacion
                            resultado = operando1 * operando2;
                            System.out.println("Resultado de la multiplicacion: " + resultado);
                        }

                        case 4 -> { // Division
                            if (operando2 == 0) {
                                System.out.println("No es posible dividir entre cero");
                            } else {
                                resultado = operando1 / operando2;
                                System.out.println("Resultado de la division: " + resultado);
                            }
                        }

                        default -> {
                            System.out.println("Opcion erronea: " + operacion);
                        }
                    }

                } else if (operacion == 5) {// Opcion Salir
                    System.out.println("Hasta pronto....");
                    break;// Permite romper el ciclo infinito while

                } else {// En caso de que no se elija una opcion del 1 al 5
                    System.out.println("Opcion erronea: " + operacion);
                }
                // Aplicar un salto de linea, en este caso para repetir la opcion del menu.
                System.out.println();
            }// Fin de Try
            catch (Exception e) {
                // Manda un mensaje respecto a cual fue el error de ingreso de opcion de operacion.
                System.out.println("Ha ocurrido un error: " + e.getMessage());
                System.out.println();
            }
        }// Fin de while
    }// Fin de main
}// Fin de clase

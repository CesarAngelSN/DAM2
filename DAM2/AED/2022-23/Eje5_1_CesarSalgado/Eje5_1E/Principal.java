/**
 * @author César Ángel Salgado Navarro
 * Asignatura: Programación
 * Actividad: Ejercicios del Tema 5
 * Curso: Desarrollo de Aplicaciones Multiplataforma
 */

package HojaEjercicios.Eje5_1E;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import HojaEjercicios.Eje5_1E.exceptions.InvalidInput;

import HojaEjercicios.Eje5_1E.methods.Complejo;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Principal {
    static Scanner sc = new Scanner(System.in);
    //Variable estática que se usará para dar una salida determinada por pantalla.
    private static int contador = 0;
    
    static ArrayList<Complejo> lista = new ArrayList<>();

    /**
     * Método main.
     * @param args
     */
    public static void main(String[] args) throws InvalidInput, InputMismatchException, CloneNotSupportedException{
        //Creamos dos objetos de tipo Complejo.
        Complejo C1 = new Complejo();
        Complejo C2 = new Complejo();
        System.out.println("--OPERACIONES CON NÚMEROS COMPLEJOS EN FORMATO (a, bi)--");

        //Validamos la entrada de la parte real e invocamos al método "nuevaParteReal()", que es un setter para la parte
        //real del número complejo.
        C1.nuevaParteReal(validarEntrada());
        //Aumentamos el contador para que cambie la salida en "validarEntrada()";
        contador++;
        
        //Se valida la entrada de la parte imaginaria del complejo y se invoca al setter de la parte imaginaria del complejo.
        C1.nuevaParteImaginaria(validarEntrada());
        contador++;
        System.out.println("[i] Número complejo 1 introducido -> " + C1.toString());
        lista.add(C1);
       
        //Realizamos lo mismo para el segundo número complejo
        C2.nuevaParteReal(validarEntrada());
        contador++;
        C2.nuevaParteImaginaria(validarEntrada());
        System.out.println("[i] Número complejo 2 introducido -> " + C2.toString());
        lista.add(C2);

        System.out.println("------- MUESTRA DE OPERACIONES -------");

        //Invocamos a los métodos de suma, resta y producto para mostrar el resultado de las operaciones.
        C1.sumaComplejos(C2);
        C1.restaComplejos(C2);
        C1.productoComplejos(C2);
        C1.divisionComplejos(C2);
        System.out.println("--> VALOR ABSOLUTO (PRIMER COMPLEJO): |" + C1.toString() + "| = " + C1.valorAbsoluto());
        System.out.println("--> VALOR ABSOLUTO (SEGUNDO COMPLEJO): |" + C2.toString() + "| = " + C2.valorAbsoluto());
        
        //Realizamos el redondeo del valor absoluto de cada complejo, creando nuevos objetos de tipo BigDecimal.
        BigDecimal c1redondeo = new BigDecimal(C1.valorAbsoluto()).setScale(3, RoundingMode.HALF_DOWN);
        BigDecimal c2redondeo = new BigDecimal(C2.valorAbsoluto()).setScale(3, RoundingMode.HALF_DOWN);

        //Al crear el tercer complejo, realizamos la conversión de tipo BigDecimal a double.
        Complejo C3 = new Complejo(c1redondeo.doubleValue(), c2redondeo.doubleValue());
        
        System.out.println("[i] Número complejo 3 generado: " + C3.toString());
        lista.add(C3);
        
        Complejo C4 = new Complejo();
        
        //Se realiza la clonación superficial del tercer complejo.
        try {
            C4 = (Complejo)C3.clone();
        }
        catch (CloneNotSupportedException e) {
            System.out.println("El número complejo no ha podido clonarse");
        }
        
        
        System.out.println("[i] Se autogenera el complejo 4 con parte real " + C4.obtenerParteReal() + " parte imaginaria " + C4.obtenerParteImaginaria());
        lista.add(C4);
        
        //Ordenamos la lista de complejos.
        Collections.sort(lista);
        
        System.out.println("------- LISTADO ORDENADO -------");
        System.out.println(lista);
    }

    /**
     * Método que validará la entrada de las partes real e imaginaria de cada complejo.
     * @return valor validado.
     */
    public static double validarEntrada() throws InvalidInput, InputMismatchException{
        double entrada = .0;
        boolean invalido;

        do {
            invalido = false;
            try {
                //Dependiendo del valor que tome la variable "contador", se mostrará un mensaje determinado.
                if (contador == 0) {
                    System.out.print("Introducir la parte real [a] del primer número complejo "
                            + "(parte entera con dos decimales, y parte flotante con tres decimales): ");
                }
                else if (contador == 1) {
                    System.out.print("Introducir la parte imaginaria [b] del primer número complejo "
                            + "(parte entera con dos decimales, y parte flotante con tres decimales): ");
                }
                else if (contador == 2) {
                    System.out.print("Introducir la parte real[a] del segundo número complejo "
                            + "(parte entera con dos decimales, y parte flotante con tres decimales): ");
                }
                else if (contador == 3) {
                    System.out.print("Introducir la parte imaginaria [b] del segundo número complejo "
                            + "(parte entera con dos decimales, y parte flotante con tres decimales): ");
                }

                entrada = sc.nextDouble();
                String entradaString = String.valueOf(entrada);
                //Si no se valida que la parte entera sea dos dígitos y la parte decimal tres dígitos,
                //saltará la excepción.
                if (!entradaString.matches("^-?\\d{2}.\\d{3}$")) {
                    throw new InvalidInput("Detectado valor no válido. Debe ser parte entera con dos decimales, y parte flotante con tres decimales");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Detectado valor no válido. Debe ser un número flotante. Introducirlo de nuevo. ");
                invalido = true;
                sc.nextLine();
            }
            catch (InvalidInput e) {
                System.out.println(e.getMessage());
                invalido = true;
                sc.nextLine();
            }
        } while (invalido);

        return entrada;
    }
}

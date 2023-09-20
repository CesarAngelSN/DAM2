/**
 * @author César Ángel Salgado Navarro
 * Asignatura: Programación
 * Actividad: Ejercicios del Tema 5
 * Curso: Desarrollo de Aplicaciones Multiplataforma
 */

package HojaEjercicios.Eje5_1F;

import java.util.*;

import HojaEjercicios.Eje5_1F.methods.Methods;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Methods method = new Methods();

        //Instanciamos dos matrices de 6x6, con las que operaremos.
        int[][] matriz1 = new int[6][6];
        int[][] matriz2 = new int[6][6];

        //En "operador" recogeremos el operador por teclado.
        String operador = "";

        //Invocamos al método rellenaMatriz() que rellenará las matrices con números enteros aleatorios.
        method.rellenaMatriz(matriz1);
        method.rellenaMatriz(matriz2);

        //Invocamos al método muestraMatriz() que mostrará la matriz rellena por pantalla.
        System.out.println("\n[i] La Matriz 1 tiene por elementos:");
        method.muestraMatriz(matriz1);
        System.out.println("\n[i] La Matriz 2 tiene por elementos:");
        method.muestraMatriz(matriz2);

        System.out.print("\n--> Elegir una operación pulsando [+] para sumar o [x] para multiplicar: ");
        
        //Con el método booleano esValido() evaluaremos que la entrada sea válida. Si no lo es, se seguirá pidiendo la entrada.
        do {
            operador = sc.nextLine();
        } while (!method.esValido(operador));

        //Si el operador es un "+", invocaremos al método sumaMatrices(), que realizará la suma de las matrices.
        if (operador.equals("+")) {
            System.out.println("[i] La suma de las dos matrices resulta: ");
            System.out.println();
            method.sumaMatrices(matriz1, matriz2);
        }
        //Si el operador es un "x", invocaremos al método productoMatrices(), que realizará el producto de las matrices.    
        else {
            System.out.println("[i] El producto de las dos matrices resulta: ");
            System.out.println();
            method.productoMatrices(matriz1, matriz2);
        }


    }

}

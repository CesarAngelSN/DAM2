package HojaEjercicios.Eje5_1F.methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Methods {

    /*
     * Método que, mediante la generación de números aleatorios, rellena la matriz que se pasa por parámetro.
     */
    public void rellenaMatriz (int[][] matriz) {
        Random random = new Random();

        //Guardamos números aleatorios del 1 al 100 en la matriz.
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (random.nextInt(100) + 1);
            }
        }
    }
    
     /*
     * Método que muestra la matriz con la que se va a operar por pantalla.
     */
    public void muestraMatriz (int[][] matriz) {
        System.out.println("\n *** *** *** *** *** ***");

        //Utilizamos bucles foreach para imprimir la matriz.
        for (int[] i : matriz) {
            for (int j : i) {
                System.out.printf("%4d", j);
            }
            System.out.println();
        }

        System.out.println(" *** *** *** *** *** ***");
    }
    
     /*
     * Método booleano que devuelve true si el operador es un '+' o un 'x'. En otro caso, devuelve false.
     */
    public boolean esValido (String operador) {
        if (!operador.equals("+") && !operador.equals("x")) {
            System.out.println("Entrada incorrecta. Elegir una operación pulsando [+] para sumar o [x] para multiplicar: ");
            return false;
        }
        else return true;
    }
    
    /*
     * Método que crea una nueva matriz donde se guardará el resultado de la operación de suma de las dos matrices
     * que se pasan por parámetro. Para mostrar el resultado, se llama al método muestraResultado().
     */
    public void sumaMatrices (int[][] matriz1, int[][] matriz2) {
        int[][] resultado = new int[6][6];

        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];  
            }
        }

        //Invocamos el método muestraResultado(), que mostrará la suma de matrices con formato. Se pasa un "+" por
        //parámetro para la impresión.
        muestraResultado(matriz1, matriz2, resultado, "+"); 
        analizarResultado(resultado);
    }
    
    /*
     * Método que crea una nueva matriz donde se guardará el resultado de la operación de producto de las dos matrices
     * que se pasan por parámetro. Para mostrar el resultado, se llama al método muestraResultado().
     */
    public void productoMatrices (int[][] matriz1, int[][] matriz2) {
        int[][] resultado = new int[6][6];

        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                resultado[i][j] = matriz1[i][0] * matriz2[0][j] + matriz1[i][1] * matriz2[1][j] + matriz1[i][2] * matriz2[2][j] + 
                matriz1[i][3] * matriz2[3][j] + matriz1[i][4] * matriz2[4][j] + matriz1[i][5] * matriz2[5][j];  
            }
        }

        //Invocamos el método muestraResultado(), que mostrará el producto de matrices con formato. Se pasa un "x" por
        //parámetro para la impresión
        muestraResultado(matriz1, matriz2, resultado, "x");
        analizarResultado(resultado);
    }
    
        /*
     * Método que muestra las matrices por pantalla. Se crea un bucle que recorrerá 6 filas, puesto que
     * todas las matrices tienen las mismas dimensiones, y dentro se creará un bucle por cada matriz, para
     * que imprima la misma fila de cada matriz en cada iteración del bucle externo.
     */
    public void muestraResultado (int[][] matriz1, int[][] matriz2, int[][] resultado, String operador) {

        //Empleamos un bucle for externo que recorrerá las filas de cada matriz.
        for (int i = 0; i < matriz1.length; i++) {

            //Bucle que recorrerá y mostrará las filas de la primera matriz.
            for (int k = 0; k < matriz1[i].length; k++) {
                System.out.printf("%4d", matriz1[i][k]);
            }

            //Si el bucle externo se encuentra en la cuarta iteración, se imprimirá el operador correspondiente. En otro caso,
            //se imprimirá un espacio
            System.out.print((i == 3) ? "   " + operador + "  " : "      ");

            //Bucle que recorrerá y mostrará las filas de la segunda matriz.
            for (int k = 0; k < matriz2.length; k++) {
                System.out.printf("%4d", matriz2[i][k]);
            }

            //Si el bucle externo se encuentra en la cuarta iteración, se imprimirá un "=". En otro caso, se imprimirá un espacio.
            System.out.print((i == 3) ? "    =" : "     ");

            ////Bucle que recorrerá y mostrará las filas de la matriz de resultado.
            for (int k = 0; k < matriz2.length; k++) {
                System.out.printf("%7d", resultado[i][k]);
            }

            System.out.println();
        }
    }
    
    /**
     * Método que extiende a la interfaz Comparable que realiza un ordenamiento de cada 
     * una de las filas de la matriz resultado. Recibe como parámetro una lista que 
     * representa a la fila.
     * @param <Elemento>
     * @param valor 
     */
    public <Elemento extends Comparable<Elemento>> void ordenar(ArrayList<Elemento> valor) {
        Collections.sort(valor);
    }
    
    /**
     * Método que realiza la conversión de cada uno de los elementos de la matriz
     * de tipo dato primitivo a tipo wrapper, para que después el método "sort" 
     * pueda realizar la ordenación de los elementos.
     * @param matriz 
     */
    public void analizarResultado(int[][] matriz) {
        ArrayList<Integer> temporal = new ArrayList<>();
        
        System.out.println("\n------- Análisis de los datos del resultado -------\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf("%-7d", matriz[i][j]);
                temporal.add(matriz[i][j]);
            }
            ordenar(temporal);
            //El valor máximo será el último de la lista ordenada.
            System.out.print("[i] Valor máximo: " + temporal.get(temporal.size() - 1));
            //Limpiamos el contenido de la lista que contiene los datos de la fila.
            temporal.clear();
            System.out.println();
        }
    }
}

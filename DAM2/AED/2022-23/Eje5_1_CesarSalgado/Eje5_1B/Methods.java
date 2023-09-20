package HojaEjercicios.Eje5_1B;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import HojaEjercicios.Eje5_1B.exceptions.SinExtension;
import HojaEjercicios.Eje5_1B.exceptions.ExtensionPermitida;
import HojaEjercicios.Eje5_1B.exceptions.Coincidencia;
import HojaEjercicios.Eje5_1B.exceptions.RutaInvalida;
import HojaEjercicios.Eje5_1B.exceptions.ArchivoInexistente;
import java.io.FileNotFoundException;

/**
 * Clase que incluye los métodos de validación de nombre, de ruta
 * y volcado de los datos.
 * @author casn1
 */
public class Methods {
    static Scanner sc = new Scanner(System.in);
    private File archivo;
    private String nombreArchivo; 
    
    /**
     * Método que valida la recogida del nombre, mediante expresiones regex.
     * @throws SinExtension
     * @throws ExtensionPermitida
     * @throws Coincidencia 
     */
    public void recogerNombre() throws SinExtension, ExtensionPermitida, Coincidencia{
        String nombre = "";
        boolean valido = false;
        
        do {
            System.out.print("Introducir nombre del fichero .txt: ");
            try {
                nombre = sc.next();
                sc.nextLine();
                if (nombre.matches("^ejercicio5_1.txt$")){
                    nombreArchivo = nombre;
                    valido = true;
                }
                else if (nombre.matches("^[a-zA-Z0-9_-]+$")) {
                    throw new SinExtension("[ i ] El nombre del fichero no indica extensión.");
                }
                else if (nombre.matches("^[a-zA-Z0-9[-*+!%&¿¡]+]+.txt$")) {
                    throw new Coincidencia("[ i ] Este fichero no coincide con el esperado.");
                }
                else {
                    throw new ExtensionPermitida("[ i ] Atención. La extensión permitida sólo puede ser .txt.");
                }
            }
            catch(Coincidencia co) {
                System.out.println(co.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
            catch(SinExtension se) {
                System.out.println(se.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
            catch(ExtensionPermitida ep) {
                System.out.println(ep.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
        } while(!valido);
    }
    
    /**
     * Método que valida la recogida de la ruta donde se encuentra
     * el fichero.
     * @throws RutaInvalida
     * @throws ArchivoInexistente
     * @throws IOException 
     */
    public void recogerRuta() throws RutaInvalida, ArchivoInexistente, IOException{
        String nombreRuta = "";
        boolean valido = false;
        
        do {
            System.out.print("Introducir ruta al directorio de trabajo: ");
            try {
                nombreRuta = sc.next();
                sc.nextLine();
                System.out.println(nombreRuta);
                if (nombreRuta.matches("^(([A-Z]:)?(\\\\?[a-zA-Z0-9_-]+)+\\\\?)$")){
                    archivo = new File(nombreRuta, nombreArchivo);
                    if (!archivo.exists()) {
                        throw new ArchivoInexistente("[ i ] El fichero " + nombreArchivo + " no existe en este directorio. ");
                    }
                    else {
                        System.out.println("[ i ] Ruta absoluta al fichero: " + archivo.getAbsolutePath());
                        System.out.println("[ i ] El fichero " + nombreArchivo + " existe y se va a analizar.");
                    }
                    valido = true;
                }
                else {
                    throw new RutaInvalida("[ i ] El formato de la ruta es erróneo. ");
                }
            }
            catch(RutaInvalida ri) {
                System.out.println(ri.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
            catch(ArchivoInexistente ai) {
                System.out.println(ai.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
        } while(!valido);
    }
    
    /**
     * Método que se centra en el volcado de datos del fichero.
     * @throws FileNotFoundException 
     */
    public void volcarDatos() throws FileNotFoundException{
        System.out.println("--> El fichero [" + nombreArchivo + "] tiene:");
        contarElementos();
        renombrarArchivo();
        mostrarPadre();
    }
    
    /**
     * Método que cuenta los elementos del fichero.
     * @throws FileNotFoundException 
     */
    public void contarElementos() throws FileNotFoundException{
        int numCaracteres = 0;
        int numPalabras = 0;
        int numLineas = 0;
        String linea = "";
        String[] palabras;
        
        try (Scanner lectura = new Scanner(archivo)) { 
            while(lectura.hasNext()) {
                numLineas++;
                linea = lectura.nextLine();
                palabras = linea.split(" ");
                for (int i = 0; i < palabras.length; i++) {
                    numPalabras++;
                }
            }
            
            System.out.println("- " + archivo.length() + " caracteres.");
            System.out.println("- " + numPalabras + " palabras.");
            System.out.println("- " + numLineas + " líneas.");
        }
    }
    
    /**
     * Método que renombra el archivo.
     */
    public void renombrarArchivo() {
        String nuevoNombre = "ejercicioX5_1.txt";
        String ruta = archivo.getParent();
        File nuevaRuta = new File(ruta);
        File archivoRenombrar = new File(nuevaRuta, nuevoNombre);
        
        if (archivo.renameTo(archivoRenombrar)) {
            System.out.println("[ i ] El fichero leído se ha marcado como [" + nuevoNombre + "]");
        }
        else {
            System.out.println("[ ! ] El archivo no ha podido renombrarse.");
        }   
    }
    
    /**
     * Método que muestra la lista de ficheros que se encuentran
     * en el padre del fichero actual.
     */
    public void mostrarPadre() {
        File padre = new File(archivo.getParent());
        String[] contenido = padre.list();
        System.out.println("--> Contenido del fichero: ");
        for (int i = 0; i < contenido.length; i++) {
            System.out.println(contenido[i]);
        }
    }
}

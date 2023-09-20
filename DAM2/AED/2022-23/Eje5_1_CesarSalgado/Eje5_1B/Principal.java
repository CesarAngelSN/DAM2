/**
 * @author César Ángel Salgado Navarro
 * Asignatura: Programación
 * Actividad: Ejercicios del Tema 5
 * Curso: Desarrollo de Aplicaciones Multiplataforma
 */

package HojaEjercicios.Eje5_1B;

import HojaEjercicios.Eje5_1B.exceptions.ArchivoInexistente;
import HojaEjercicios.Eje5_1B.exceptions.Coincidencia;
import java.io.IOException;

import HojaEjercicios.Eje5_1B.exceptions.SinExtension;
import HojaEjercicios.Eje5_1B.exceptions.ExtensionPermitida;
import HojaEjercicios.Eje5_1B.exceptions.RutaInvalida;

/**
 * Clase principal.
 * @author casn1
 */
public class Principal {
    static Methods metodo = new Methods();
    
    /**
     * Método main.
     * @param args
     * @throws SinExtension
     * @throws ExtensionPermitida
     * @throws Coincidencia
     * @throws RutaInvalida
     * @throws ArchivoInexistente
     * @throws IOException 
     */
    public static void main(String[] args) throws SinExtension, ExtensionPermitida, Coincidencia, RutaInvalida, ArchivoInexistente, IOException{
        metodo.recogerNombre();
        metodo.recogerRuta();
        metodo.volcarDatos();
    } 
}

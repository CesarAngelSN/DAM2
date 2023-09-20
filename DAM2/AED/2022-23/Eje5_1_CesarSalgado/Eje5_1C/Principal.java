/**
 * @author César Ángel Salgado Navarro
 * Asignatura: Programación
 * Actividad: Ejercicios del Tema 5
 * Curso: Desarrollo de Aplicaciones Multiplataforma
 */

package HojaEjercicios.Eje5_1C;

import HojaEjercicios.Eje5_1C.exceptions.Coincidencia;
import HojaEjercicios.Eje5_1C.exceptions.ExtensionPermitida;
import HojaEjercicios.Eje5_1C.exceptions.LetraIncorrecta;
import HojaEjercicios.Eje5_1C.exceptions.SinExtension;
import HojaEjercicios.Eje5_1C.exceptions.ValorInvalido;
import HojaEjercicios.Eje5_1C.methods.Methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Clase principal del programa.
 * @author casn1
 */
public class Principal {
    
    static Methods method = new Methods();
    
    /**
     * Método main.
     * @param args
     * @throws SinExtension
     * @throws ExtensionPermitida
     * @throws Coincidencia
     * @throws IOException
     * @throws ValorInvalido
     * @throws FileNotFoundException
     * @throws LetraIncorrecta 
     */
    public static void main(String[] args) throws SinExtension, ExtensionPermitida, Coincidencia, IOException, 
            ValorInvalido, FileNotFoundException, LetraIncorrecta{
        method.recogerNombre();
    }
}

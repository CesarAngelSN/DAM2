/**
 * @author César Ángel Salgado Navarro
 * Asignatura: Programación
 * Actividad: Ejercicios del Tema 5
 * Curso: Desarrollo de Aplicaciones Multiplataforma
 */

package HojaEjercicios.Eje5_1A;
import HojaEjercicios.Eje5_1A.methods.Methods;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.io.IOException;

import HojaEjercicios.Eje5_1A.exceptions.SinExtension;
import HojaEjercicios.Eje5_1A.exceptions.ExtensionPermitida;

/**
 * Clase principal.
 * @author casn1
 */
public class Principal {
    
    private static File archivo;
    private static String url;
    static Methods metodo = new Methods();
    
    /**
     * Método principal.
     * @param args
     * @throws SinExtension
     * @throws ExtensionPermitida
     * @throws IOException
     * @throws MalformedURLException
     * @throws URISyntaxException 
     */
    public static void main(String[] args) throws SinExtension, ExtensionPermitida, IOException, MalformedURLException, URISyntaxException{
        archivo = metodo.recogerFichero();
        url = metodo.recogerURL();
        Object tipo = metodo.getTipo();
        metodo.mostrarDatosURL(tipo);
    }
}

//https://www.instructables.com/Laser-Cut-Infinity-Dodecahedron-Fusion-360/

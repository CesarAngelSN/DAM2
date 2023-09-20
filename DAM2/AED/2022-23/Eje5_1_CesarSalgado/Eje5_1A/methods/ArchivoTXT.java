package HojaEjercicios.Eje5_1A.methods;

import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.net.URL;

/**
 * Clase para los archivos de tipo TXT.
 * @author casn1
 */
public class ArchivoTXT {
    private File fichero;
    private int tamanio;
    
    /**
     * Constructor del fichero TXT.
     * @param ruta
     * @param cadena 
     */
    public ArchivoTXT(File ruta, String cadena) {
        fichero = new File(ruta, cadena);
    }
    
    /**
     * Método que vuelca los datos en el fichero TXT.
     * @param url
     * @throws IOException 
     */
    public void volcadoDatos(URL url) throws IOException{
        Scanner lecturaURL = new Scanner(url.openStream());
        PrintWriter insertador = new PrintWriter(fichero);
        
        while (lecturaURL.hasNext()) {
            insertador.println(lecturaURL.nextLine());
        }
        
        System.out.println("--> La información fue guardada en la ruta: " + fichero.getPath());
        System.out.println("--> Tamaño del fichero generado: " + fichero.length() + " bytes.");
    }
}

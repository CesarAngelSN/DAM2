package HojaEjercicios.Eje5_1A.methods;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.net.URL;

/**
 * Clase para los archivos de tipo HTML. El volcado de los
 * datos en el fichero se realiza mediante JSOUP.
 * @author casn1
 */
public class ArchivoHTML {
    private File fichero;
    private int tamanio;
    private Document documento;
    
    /**
     * Constructor de un archivo HTML.
     * @param ruta
     * @param cadena 
     */
    public ArchivoHTML(File ruta, String cadena) {
        fichero = new File(ruta, cadena);
    }
    
    /**
     * Método que vuelca el contenido HTML en el fichero.
     * @param url
     * @throws IOException
     * @throws FileNotFoundException 
     */
    public void volcadoDatos(URL url) throws IOException, FileNotFoundException{
        PrintWriter insertador = new PrintWriter(fichero);
        
        try {
            documento = Jsoup.connect(url.toString()).get();
            insertador.println(documento.outerHtml());
            insertador.close();
            System.out.println("[ i ] El archivo se ha traspasado correctamente.");
        }
        catch (IOException io) {
            System.out.println("[ i ] No se ha podido traspasar el archivo.");
        }
        
        System.out.println("--> La información fue guardada en la ruta: " + fichero.getPath());
        System.out.println("--> Tamaño del fichero generado: " + fichero.length() + " bytes.");
    }
}

package HojaEjercicios.Eje5_1A.methods;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import HojaEjercicios.Eje5_1A.exceptions.SinExtension;
import HojaEjercicios.Eje5_1A.exceptions.ExtensionPermitida;

/**
 * Clase que incorpora los métodos de manejo del fichero y su ruta.
 * @author casn1
 */
public class Methods {
    static Scanner sc = new Scanner(System.in);
    private File ruta = new File("C:\\Users\\casn1\\OneDrive\\Escritorio\\DAM1\\PRO\\CodigosPRO\\Tema4\\EjerciciosTema4\\src\\main\\java\\HojaEjercicios\\Eje5_1A");
    private File archivo;
    private URL url;
    private static Object tipo;
    
    /**
     * Método que comprueba que la extensión del fichero sea la permitida.
     * @return
     * @throws SinExtension
     * @throws ExtensionPermitida
     * @throws IOException 
     */
    public File recogerFichero() throws SinExtension, ExtensionPermitida, IOException{
        boolean valido = false;
        boolean creado = false;
        String cadena = "";
        
        do {
            System.out.print("Introducir nombre del fichero: .txt | .html: ");
            try {
                cadena = sc.next();
                if (cadena.matches("^[a-zA-Z0-9]+\\.txt$") || cadena.matches("^[a-zA-Z0-9]+\\.html$")) {
                    if (cadena.matches("^[a-zA-Z0-9]+\\.txt$")) {
                        tipo = new ArchivoTXT(ruta, cadena);
                    }
                    else {
                        tipo = new ArchivoHTML(ruta, cadena);
                    }
                    archivo = new File(ruta, cadena);
                    if (!archivo.exists()) {
                        creado = archivo.createNewFile();
                        System.out.println((creado) ? "[ i ] El archivo es nuevo en el directorio" : "No ha podido crearse el fichero");
                    }
                    else {
                        System.out.println("El archivo ya existe en el directorio y va a sobreescribirse.");
                        if (archivo.delete()) {
                            creado = archivo.createNewFile();
                            System.out.println((creado) ? "[ i ] El archivo se ha sobrescrito correctamente" : "No ha podido sobrescribirse el archivo");
                        }
                    }
                    valido = true;
                }
                else if (cadena.matches("^[a-zA-Z0-9]+$")) {
                    throw new SinExtension("[ i ] El nombre del fichero no indica extensión.");
                }
                else {
                    throw new ExtensionPermitida("[ i ] Atención. La extensión permitida sólo puede ser .txt | .html");
                }
            }
            catch(SinExtension se) {
                System.out.println(se.getMessage());
                sc.nextLine();
            }
            catch(ExtensionPermitida ep) {
                System.out.println(ep.getMessage());
                sc.nextLine();
            }
        } while(!valido);
        
        return archivo;
    }
    
    /**
     * Método que comprueba que la URL sea válida.
     * @return
     * @throws MalformedURLException
     * @throws URISyntaxException 
     */
    public String recogerURL() throws MalformedURLException, URISyntaxException{
        String entrada = "";
        Scanner sc = new Scanner (System.in);
        boolean valido = false;
        
        do {
            try {
                System.out.print("--> Introducir la dirección correcta de la página Web: ");
                entrada = sc.nextLine();
                new URL(entrada).toURI();
                url = new URL(entrada);
                valido = true;
            }
            catch (MalformedURLException m) {
                System.out.println("Dirección no válida: " + m.getMessage());
                System.out.print("[ i ] Se necesita una URL correcta. Pulsar INTRO para continuar.");
                sc.nextLine();
            }
            catch (URISyntaxException s) {
                System.out.println(s.getMessage());
                System.out.print("[ i ] Se necesita una URL correcta. Pulsar INTRO para continuar.");
                sc.nextLine();
            }
        } while(!valido);
        
        return entrada;
    }
    
    /**
     * Método que, mediante el uso de casting de objetos, volcará los datos
     * de la web en un fichero HTML o TXT, dependiendo del parámetro que reciba
     * el objeto.
     * @param tipo podrá ser de tipo ArchivoHTML o ArchivoTXT
     * @throws IOException 
     */
    public void mostrarDatosURL(Object tipo) throws IOException{
        
        System.out.println("El número total de palabras presentes en la web es de: " + contarPalabras());
        
        if (tipo instanceof ArchivoHTML) {
            ((ArchivoHTML)tipo).volcadoDatos(url);
        }
        else if (tipo instanceof ArchivoTXT) {
            ((ArchivoTXT)tipo).volcadoDatos(url);
        }
    }
    
    /**
     * Método que realizará el conteo de palabras de la web mediante el uso de
     * JSOUP.
     * @return
     * @throws MalformedURLException
     * @throws IOException 
     */
    public int contarPalabras() throws MalformedURLException, IOException{
        int numeroPalabras = 0;
        String frase = "";
        
        Document documento = Jsoup.connect(url.toString()).get();
        Elements contenido = documento.select("body").first().getAllElements();
        
        for (Element el : contenido) {
            numeroPalabras += el.text().split("\\s+").length;
        }
        
        return numeroPalabras;
    }
    
    /**
     * Método que devuelve el tipo del objeto.
     * @return 
     */
    public Object getTipo() {
        return tipo;
    }
}

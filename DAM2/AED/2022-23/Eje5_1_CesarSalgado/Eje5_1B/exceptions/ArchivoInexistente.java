package HojaEjercicios.Eje5_1B.exceptions;

/**
 * Excepción personalizada para controlar si existe el archivo.
 * @author casn1
 */
public class ArchivoInexistente extends Exception{
    public ArchivoInexistente (String cadena) {
        super(cadena);
    }
}

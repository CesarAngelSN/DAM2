package HojaEjercicios.Eje5_1B.exceptions;

/**
 * Excepción personalizada para controlar si el archivo tiene
 * extensión.
 * @author casn1
 */
public class SinExtension extends Exception{
    public SinExtension (String cadena) {
        super(cadena);
    }
}

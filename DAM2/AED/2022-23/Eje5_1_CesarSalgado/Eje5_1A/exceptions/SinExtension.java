package HojaEjercicios.Eje5_1A.exceptions;

/**
 * Excepción personalizada para las archivos sin extensión.
 * @author casn1
 */
public class SinExtension extends Exception{
    public SinExtension (String cadena) {
        super(cadena);
    }
}

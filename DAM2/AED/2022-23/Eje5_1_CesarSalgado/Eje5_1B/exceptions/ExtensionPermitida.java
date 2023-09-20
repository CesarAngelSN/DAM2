package HojaEjercicios.Eje5_1B.exceptions;

/**
 * Excepción personalizada para controlar si la extensión del archivo
 * es la correcta.
 * @author casn1
 */
public class ExtensionPermitida extends Exception{
    public ExtensionPermitida (String cadena) {
        super(cadena);
    }
}

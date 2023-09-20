package HojaEjercicios.Eje5_1B.exceptions;

/**
 * Excepción personalizada para controlar si la ruta introducida
 * es válida.
 * @author casn1
 */
public class RutaInvalida extends Exception{
    public RutaInvalida (String cadena) {
        super(cadena);
    }
}

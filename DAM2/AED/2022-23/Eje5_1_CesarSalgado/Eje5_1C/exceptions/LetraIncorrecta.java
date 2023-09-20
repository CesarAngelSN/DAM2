package HojaEjercicios.Eje5_1C.exceptions;

/**
 * Excepción personalizada que saltará cuando se introduzca una letra
 * que no se encuentra en la palabra.
 * @author casn1
 */
public class LetraIncorrecta extends Exception{
    public LetraIncorrecta (String cadena) {
        super(cadena);
    }
}
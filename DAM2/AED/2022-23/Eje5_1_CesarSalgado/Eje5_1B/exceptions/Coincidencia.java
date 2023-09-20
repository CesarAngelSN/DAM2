package HojaEjercicios.Eje5_1B.exceptions;

/**
 * Excepción personalizada para controlar si, teniendo la extensión
 * adecuada, el fichero no coincide con el esperado.
 * @author casn1
 */
public class Coincidencia extends Exception{
    public Coincidencia (String cadena) {
        super(cadena);
    }
}

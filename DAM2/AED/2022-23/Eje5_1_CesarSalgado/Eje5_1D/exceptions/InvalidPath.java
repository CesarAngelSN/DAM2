package HojaEjercicios.Eje5_1D.exceptions;

/**
 * Excepción personalizada para las rutas inválidas.
 * @author casn1
 */
public class InvalidPath extends Exception{
    public InvalidPath (String string) {
        super(string);
    }
}

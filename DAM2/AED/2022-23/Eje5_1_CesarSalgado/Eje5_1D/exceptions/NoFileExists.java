package HojaEjercicios.Eje5_1D.exceptions;

/**
 * Excepción personalizada que salta cuando el archivo no exista.
 * @author casn1
 */
public class NoFileExists extends Exception{
    public NoFileExists (String string) {
        super(string);
    }
}

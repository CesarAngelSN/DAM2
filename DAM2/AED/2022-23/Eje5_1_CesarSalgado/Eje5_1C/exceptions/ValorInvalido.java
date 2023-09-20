package HojaEjercicios.Eje5_1C.exceptions;

/**
 * Excepción personalizada que salta cuando se ha introducido 
 * una palabra con caracteres numéricos.
 * @author casn1
 */
public class ValorInvalido extends Exception{
    public ValorInvalido (String cadena) {
        super(cadena);
    }
}

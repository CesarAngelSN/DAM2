package HojaEjercicios.Eje5_1E.exceptions;

/**
 * Excepción personalizada que saltará cuando se haya introducido 
 * un complejo que no tenga exactamente dos dígitos para la parte
 * real y tres dígitos para la parte imaginaria.
 * @author casn1
 */
public class InvalidInput extends Exception{
    public InvalidInput (String message) {
        super(message);
    }
}

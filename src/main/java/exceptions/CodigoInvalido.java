package exceptions;

public class CodigoInvalido extends Exception{
    public CodigoInvalido() {
        super("[!] El código introducido es inválido.");
    }
}

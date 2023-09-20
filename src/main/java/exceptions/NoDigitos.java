package exceptions;

public class NoDigitos extends Exception{
    public NoDigitos() {
        super("[!] Las cadenas no admiten dígitos.");
    }
}

package exceptions;

public class NoSimbolos extends Exception{
    public NoSimbolos() {
        super("[!] Las cadenas no admiten símbolos.");
    }
}

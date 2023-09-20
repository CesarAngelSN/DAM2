package HojaEjercicios.Eje5_1G.methods;

/**
 * Enumerador que contiene los números de la baraja.
 * @author casn1
 */
public enum Numbers {
    TWO("--> Dos "), THREE("--> Tres "), FOUR("--> Cuatro "), FIVE("--> Cinco "), 
    SIX("--> Seis "), SEVEN("--> Siete "), EIGHT("--> Ocho "), NINE("--> Nueve "), 
    TEN("--> Diez "), JACK("--> Sota "), QUEEN("--> Reina "), KING("--> Rey "), 
    AS("--> As ");
    private String number;
    
    /**
     * Constructor del enumerador
     * @param number 
     */
    Numbers(String number) {
        this.number = number;
    }
    
    /**
     * Getter del valor del enumerador.
     * @return 
     */
    public String getNumber() {
        return number;
    }
}

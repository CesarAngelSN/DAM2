package HojaEjercicios.Eje5_1G.methods;

/**
 * Enumerador que contiene los palos de la baraja.
 * @author casn1
 */
public enum Suits {
    HEART("de Corazones"), DIAMOND("de Diamantes"), CLUB("de Tréboles"), SPADE("de Espadas");
    private String suit;
    
    /**
     * Constructor del enumerador.
     * @param suit 
     */
    Suits(String suit) {
        this.suit = suit;
    }
    
    /**
     * Getter del valor del enumerador.
     * @return 
     */
    public String getSuit() {
        return suit;
    }
}

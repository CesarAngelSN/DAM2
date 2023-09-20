/**
 * @author César Ángel Salgado Navarro
 * Asignatura: Programación
 * Actividad: Ejercicios del Tema 5
 * Curso: Desarrollo de Aplicaciones Multiplataforma
 */

package HojaEjercicios.Eje5_1G;

import HojaEjercicios.Eje5_1G.methods.PokerDeck;

public class Principal {
    
    static PokerDeck pokerDeck = new PokerDeck();
    
    /**
     * Método main.
     * @param args 
     */
    public static void main(String[] args) {
        pokerDeck.showDeck();
    }
}

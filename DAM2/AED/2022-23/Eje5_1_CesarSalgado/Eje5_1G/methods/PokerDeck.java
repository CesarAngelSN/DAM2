package HojaEjercicios.Eje5_1G.methods;

import java.util.*;

/**
 * Clase que montará una baraja de cartas mediante enumeradores.
 * @author casn1
 */
public class PokerDeck {
    List<String> pokerDeck = new ArrayList<>();
    
    /**
     * Método que crea dos listas en base a los valores de los enumeradores
     * de los palos y los valores de las cartas. Después, se unen en una 
     * única lista.
     */
    public PokerDeck() {
        List<Numbers> numbers = Arrays.asList(Numbers.values());
        List<Suits> suits = Arrays.asList(Suits.values());
        
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < suits.size(); j++) {
                pokerDeck.add(numbers.get(i).getNumber() + suits.get(j).getSuit());
            }
        }
    }
    
    /**
     * Método que desordena los elementos de la baraja mediante un shuffle(),
     * y después se divide en dos listas. Su contenido se mostrará visualmente 
     * en dos columnas y, en caso de que en ambas listas se vaya a imprimir en
     * la misma iteración una carta que contenga la palabra "As", se mostrará
     * un mensaje de pareja de ases.
     */
    public void showDeck() {
        int halfSize = pokerDeck.size() / 2;
        Collections.shuffle(pokerDeck);
        List<String> firstHalf = new ArrayList<>(pokerDeck.subList(0, halfSize));
        List<String> secondHalf = new ArrayList<>(pokerDeck.subList(halfSize, pokerDeck.size()));
 
        for (int i = 0; i < halfSize; i++) {
            System.out.printf("%-25s    %-25s", firstHalf.get(i), secondHalf.get(i));

            if (firstHalf.get(i).contains("As") && secondHalf.get(i).contains("As")) {
                System.out.println("\n[i] Pareja AA de Ases\n");
            }
            System.out.println();
        }
    }
}


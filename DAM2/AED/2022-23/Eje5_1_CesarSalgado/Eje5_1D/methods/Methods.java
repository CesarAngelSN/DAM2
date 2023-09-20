package HojaEjercicios.Eje5_1D.methods;

import java.io.*;
import java.util.*;

import HojaEjercicios.Eje5_1D.Beer;
import HojaEjercicios.Eje5_1D.interfaces.Medible;

/**
 * Clase que contendrá los métodos de manejo de la lista de cervezas.
 * @author casn1
 */
public class Methods {
    
    ArrayList<Beer> beers = new ArrayList<>();
    int size;
    
    /**
     * Método que añade una nueva cerveza a la lista.
     * @param beer 
     */
    public void addBeer(Beer beer){
        beers.add(beer);
    }
    
    /**
     * Método que retorna un objeto de tipo Medible de la lista.
     * @param i
     * @return 
     */
    public Medible getBeer (int i) {
        return beers.get(i);
    }
    
    /**
     * Método setter del tamaño de la lista.
     * @param size 
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Método que devuelve el tamaño de la lista.
     * @return 
     */
    public int getSize() {
        return beers.size();
    }
    
    /**
     * Método que calcula la media de la superficie de las latas
     * y la muestra.
     */
    public void showAverage() {
        double average = 0.0;
        double sum = 0.0;
        String result = "";
        
        for (int i = 0; i < beers.size(); i++) {
            sum += beers.get(i).obtenerMedida();
        }
        
        average = sum / beers.size();
        
        result = String.format("[i] La superficie media empleada es de (%.2f)cm\u00B2", average / 100);
        
        System.out.println(result);
    }
    
    /**
     * Método que muestra el objeto con la mayor superficie.
     */
    public void showBigger() {
        Collections.sort(beers);
        System.out.println("[i] El registro con mayor superficie es " + beers.get(beers.size() - 1).toString());
    }
    
    /**
     * Método que realiza el volcado de los datos de las cervezas.
     */
    public void showInfo() {
        for(int i = 0; i < beers.size(); i++) {
            System.out.println(beers.get(i).toString());
        }
        System.out.println("[i] El fichero cuenta con " + beers.size() + " registros de información.");
    }
}

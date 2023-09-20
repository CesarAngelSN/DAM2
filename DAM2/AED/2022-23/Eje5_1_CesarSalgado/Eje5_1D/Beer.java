package HojaEjercicios.Eje5_1D;

import HojaEjercicios.Eje5_1D.interfaces.Medible;
import java.io.Serializable;

/**
 * Clase que representa a cada cerveza y guardará sus datos. 
 * Implementa Serializable ya que trabajamos con ficheros binarios.
 * @author casn1
 */
public class Beer implements Serializable, Medible, Comparable<Beer>{
    String name;
    double height;
    double radius;
    
    /**
     * Constructor vacío.
     */
    public Beer(){}
    
    /**
     * Constructor con parámetros.
     * @param name
     * @param height
     * @param radius 
     */
    public Beer (String name, double height, double radius) {
        this.name = name;
        this.height = height;
        this.radius = radius;
    }
    
    /**
     * Getter del nombre de la cerveza.
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Getter de la altura de la cerveza.
     * @return 
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Getter del radio de la cerveza.
     * @return 
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * Setter del nombre de la cerveza.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Setter de la altura de la cerveza.
     * @param height 
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    /**
     * Setter del radio de la cerveza.
     * @param radius 
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    /**
     * Getter del área de la cerveza.
     * @return 
     */
    public double getArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
    
    /**
     * Método sobrescrito de la interfaz Medible que devuelve 
     * el área de la cerveza.
     * @return 
     */
    @Override
    public double obtenerMedida() {
        return this.getArea();
    }
    
    /**
     * Método sobrescrito de la interfaz Comparable que compara 
     * cervezas mediante sus superficies.
     * @param beer
     * @return 
     */
    @Override
    public int compareTo(Beer beer) {
        if (this.obtenerMedida() == beer.obtenerMedida()) {
            return 0;
        }
        else if (this.obtenerMedida() > beer.obtenerMedida()) {
            return 1;
        }
        else return -1;
    }
    
    /**
     * Método sobrescrito toString para imprimir el objeto cerveza.
     * @return 
     */
    @Override
    public String toString() {
        String string = name + " (" + height + " mm)" + " (" + radius + " mm)";
        return string;
    }
}

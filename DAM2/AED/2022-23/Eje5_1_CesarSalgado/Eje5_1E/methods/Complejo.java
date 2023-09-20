/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HojaEjercicios.Eje5_1E.methods;

/**
 * Clase que contiene la información de un número complejo.
 */
public class Complejo implements Cloneable, Comparable<Complejo>{
    //Variable que almacenará la parte real del complejo.
    private double parteReal;
    //Variable que almacenará la parte imaginaria del complejo.
    private double parteImaginaria;
    //Variable estática que almacenará el número de complejos creados.
    static int numeroDeCreados;

    /**
     * Constructor sin argumentos. Inicializa los valores a 0.
     */
    public Complejo(){
        parteReal = .0;
        parteImaginaria = .0;
    }

    /**
     * Constructor con parámetros, a pesar de que en este código no se emplea.
     * @param parteReal parte real del complejo.
     * @param parteImaginaria parte imaginaria del complejo.
     */
    public Complejo (double parteReal, double parteImaginaria){
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }
    
    /**
     * Constructor que construye un complejo sólo con su parte real.
     * @param parteReal 
     */
    public Complejo(double parteReal) {
        this.parteReal = parteReal;
        this.parteImaginaria = .0;
    }

    /**
     * Getter de la parte real del complejo.
     * @return parte real.
     */
    public double obtenerParteReal() {
        return parteReal;
    }

    /**
     * Getter de la parte imaginaria del complejo.
     * @return parte imaginaria.
     */
    public double obtenerParteImaginaria() {
        return parteImaginaria;
    }

    /**
     * Setter de la parte real del complejo.
     * @param parteReal nueva parte real.
     */
    public void nuevaParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    /**
     * Setter de la parte imaginaria del complejo.
     * @param parteImaginaria nueva parte imaginaria.
     */
    public void nuevaParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    /**
     * Método sobreescrito de la clase Object que mostrará el contenido del complejo.
     * @return String con el contenido del complejo.
     */
    @Override
    public String toString() {
        numeroDeCreados++;
        String cadena;
        if (parteImaginaria == .0) {
            cadena = "(" + parteReal + ")";
        }
        else {
            cadena = "(" + parteReal + " + " + parteImaginaria + "i)";
        }
        return cadena;
    }
    
    /**
     * Método sobrescrito de la interfaz Comparable que hará la comparación
     * de dos complejos en base a su valor absoluto.
     * @param C2
     * @return 
     */
    @Override
    public int compareTo(Complejo C2) {
        if (this.valorAbsoluto() == C2.valorAbsoluto()) {
            return 0;
        }
        else if (this.valorAbsoluto() > C2.valorAbsoluto()) {
            return 1;
        }
        else return -1;
    }
    
    /**
     * Método sobrescrito de la interfaz Cloneable que realiza la clonación
     * superficial de un objeto.
     * @return
     * @throws CloneNotSupportedException 
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Método que realiza la suma del complejo que invoca el método y el que se pasa por parámetro.
     * @param C2 objeto de tipo Complejo.
     */
    public void sumaComplejos(Complejo C2) {
        double parteRealSuma = this.parteReal + C2.obtenerParteReal();
        double parteImaginariaSuma = this.parteImaginaria + C2.obtenerParteImaginaria();
        String cadena = "--> SUMA: " + this.toString() + " + " + C2.toString() + " = (" + parteRealSuma + " + " + parteImaginariaSuma + "i)";
        System.out.println(cadena);
    }

    /**
     * Método que realiza la resta entre el complejo que invoca el método y el que se pasa por parámetro.
     * @param C2 objeto de tipo Complejo.
     */
    public void restaComplejos(Complejo C2) {
        double parteRealResta = this.parteReal - C2.obtenerParteReal();
        double parteImaginariaResta = this.parteImaginaria - C2.obtenerParteImaginaria();
        String cadena = "--> RESTA: " + this.toString() + " - " + C2.toString() + " = (" + parteRealResta + " + " + parteImaginariaResta + "i)";
        System.out.println(cadena);
    }

    /**
     * Método que realiza el producto entre el complejo que invoca el método y el que se pasa por parámetro.
     * @param C2 objeto de tipo Complejo.
     */
    public void productoComplejos(Complejo C2) {
        double parteRealProducto = this.parteReal * C2.obtenerParteReal() - (this.parteImaginaria * C2.obtenerParteImaginaria());
        double parteImaginariaProducto = this.parteReal * C2.obtenerParteImaginaria() + this.parteImaginaria * C2.obtenerParteReal();
        String cadena = "--> PRODUCTO: " + this.toString() + " * " + C2.toString() + " = (" + parteRealProducto + " + " + parteImaginariaProducto + "i)";
        System.out.println(cadena);
    }
    
    /**
     * Método que realiza el cociente entre el complejo que invoca el método y el que se pasa por parámetro.
     * @param C2 
     */
    public void divisionComplejos(Complejo C2) {
        double parteRealDivision = (this.parteReal * C2.obtenerParteReal() + (this.parteImaginaria * C2.obtenerParteImaginaria())) / 
                (Math.pow(C2.obtenerParteReal(), 2.) + Math.pow(C2.obtenerParteImaginaria(), 2.));
        double parteImaginariaDivision = (this.parteReal * C2.obtenerParteImaginaria() - this.parteImaginaria * C2.obtenerParteReal()) /
                (Math.pow(C2.obtenerParteReal(), 2.) + Math.pow(C2.obtenerParteImaginaria(), 2.));
        String cadena = "--> DIVISIÓN: " + this.toString() + " * " + C2.toString() + " = (" + parteRealDivision + " + " + parteImaginariaDivision + "i)";
        System.out.println(cadena);
    }
    
    /**
     * Método que devuelve el valor absoluto del complejo invocante.
     * @return 
     */
    public double valorAbsoluto() {
        double valorAbsoluto = Math.sqrt(Math.pow(parteReal, 2.) + Math.pow(parteImaginaria, 2.));
        return valorAbsoluto;
    }
}

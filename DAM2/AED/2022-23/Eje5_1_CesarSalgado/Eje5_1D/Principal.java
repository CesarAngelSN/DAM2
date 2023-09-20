/**
 * @author César Ángel Salgado Navarro
 * Asignatura: Programación
 * Actividad: Ejercicios del Tema 5
 * Curso: Desarrollo de Aplicaciones Multiplataforma
 */

package HojaEjercicios.Eje5_1D;

import java.io.*;
import java.util.*;

import HojaEjercicios.Eje5_1D.methods.Methods;

import HojaEjercicios.Eje5_1D.exceptions.InvalidPath;
import HojaEjercicios.Eje5_1D.exceptions.NoFileExists;

/**
 * Clase principal, que invocará a los métodos.
 * @author casn1
 */
public class Principal {
    static Scanner sc = new Scanner(System.in);
    static File file;
    static String fileName;
    static Methods method = new Methods();
    
    /**
     * Método main.
     * @param args
     * @throws InvalidPath
     * @throws NoFileExists
     * @throws IOException 
     */
    public static void main(String[] args) throws InvalidPath, NoFileExists, IOException{
        openFile();
        System.out.println("\n------- Datos (modelo, altura y radio en mm) -------\n");
        method.showInfo();
        System.out.println("\n------- Tratamiento de los Datos -------\n");
        method.showAverage();
        method.showBigger();
    }
    
    /**
     * Métod que se encarga de leer el archivo mediante una ruta que se pide por
     * teclado.
     * @throws InvalidPath
     * @throws NoFileExists
     * @throws IOException
     * @throws EOFException 
     */
    static public void openFile() throws InvalidPath, NoFileExists, IOException, EOFException{
        boolean valid = false;
        
        do {
            System.out.print("Introducir nombre del fichero binario .bin: ");
            try {
                fileName = sc.next();
                sc.nextLine();
                if (fileName.matches("^(([A-Z]:)?(\\\\?[a-zA-Z0-9_-]+)+\\\\?).bin$")){
                    System.out.print("Introducir ruta: ");
                    String string = sc.next();
                    File path = new File(string);
                    file = new File(path, fileName);
                    if (!file.exists()) {
                        throw new NoFileExists("[ i ] El fichero " + file.getName() + " no existe en este directorio. ");
                    }
                    valid = true;
                }
                else {
                    throw new InvalidPath("[ i ] El formato de la ruta es erróneo o no existe el archivo el la ruta especificada. ");
                }
            }
            catch(InvalidPath e) {
                System.out.println(e.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
            catch(NoFileExists e) {
                System.out.println(e.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
        } while(!valid);
        
        //Creamos el objeto FileInputStream, que realizará la lectura de los bytes 
        //del archivo. Después, pasamos este objeto a un DataInputStream, que podrá
        //extraer los valores en el formato en que fueron escritos en el fichero.
        try (DataInputStream data = new DataInputStream(new FileInputStream(file))) {
            String firstPart = "";
            String secondPart = "";
            String thirdPart = "";
            double height = .0;
            double radius = .0;

            try {
                //Mientras haya contenido en el fichero.
                while(data.available() > 0) {
                    String register = data.readUTF();
                    String[] parts = register.split(" ");
                    firstPart = parts[0] + " ";
                    secondPart = parts[1] + " ";
                    thirdPart = parts[2];
                    height = data.readDouble();
                    radius = data.readDouble();
                    //Añadimos un nuevo objeto Beer a la lista.
                    method.addBeer(new Beer(firstPart + secondPart + thirdPart, height, radius));
                }
            }
            catch (IOException e) {
                System.out.println("No se ha podido leer el fichero");
                e.printStackTrace();
            }
        }
        
        //Aprovechamos el método para imprimir el contenido en bruto del binario.
        System.out.println("\n------------ Contenido binario ------------\n");
        
        FileInputStream binary = new FileInputStream(file);
        byte[] arrayBytes = binary.readAllBytes();
        String bytes = new String(arrayBytes);
        
        System.out.println(bytes);
        
    }
}

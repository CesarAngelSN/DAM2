package HojaEjercicios.Eje5_1C.methods;

import HojaEjercicios.Eje5_1C.exceptions.Coincidencia;
import HojaEjercicios.Eje5_1C.exceptions.ExtensionPermitida;
import HojaEjercicios.Eje5_1C.exceptions.LetraIncorrecta;
import HojaEjercicios.Eje5_1C.exceptions.SinExtension;
import HojaEjercicios.Eje5_1C.exceptions.ValorInvalido;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

public class Methods {
    static Scanner sc = new Scanner(System.in);
    private File archivo;
    private String nombreArchivo; 
    StringBuilder oculta = new StringBuilder();
    char letra = ' ';
    int fallos;
    
    /**
     * Método que comprueba si el nombre del fichero es correcto y si
     * se encuentra en el directorio de trabajo.
     * @throws SinExtension
     * @throws ExtensionPermitida
     * @throws Coincidencia
     * @throws IOException
     * @throws ValorInvalido
     * @throws LetraIncorrecta 
     */
    public void recogerNombre() throws SinExtension, ExtensionPermitida, Coincidencia, IOException, ValorInvalido, LetraIncorrecta{
        String nombre = "";
        boolean valido = false;
        
        do {
            System.out.print("Introducir nombre del fichero .txt: ");
            try {
                nombre = sc.next();
                sc.nextLine();
                if (nombre.matches("^ahorcado.txt$")){
                    nombreArchivo = nombre;
                    File path = new File("C:\\Users\\casn1\\OneDrive\\Escritorio\\DAM1\\PRO\\CodigosPRO\\"
                            + "Tema4\\EjerciciosTema4\\src\\main\\java\\HojaEjercicios\\Eje5_1C");
                    archivo = new File(path, nombreArchivo);
                    if (archivo.exists()) {
                        System.out.println("[i] El archivo ya existe.");
                        if (archivo.length() == 0) {
                            //Si el archivo existe y se encuentra vacío, pasará a rellenarse.
                            rellenarFichero();
                        }
                        else {
                            //Si existe y no está vacío, se jugará directamente.
                            jugarAhorcado();
                        }
                    }
                    else {
                        System.out.println("[i] El archivo no existe y va a ser creado.");
                        if(archivo.createNewFile()) {
                            System.out.println("[i] Archivo creado correctamente.");
                            //Si el archivo no existe, se creará y se rellenará.
                            rellenarFichero();
                        }
                    }
                    valido = true;
                }
                else if (nombre.matches("^[a-zA-Z0-9_-]+$")) {
                    throw new SinExtension("[ i ] El nombre del fichero no indica extensión.");
                }
                else if (nombre.matches("^[a-zA-Z0-9[-*+!%&¿¡]+]+.txt$")) {
                    throw new Coincidencia("[ i ] Este fichero no coincide con el esperado.");
                }
                else {
                    throw new ExtensionPermitida("[ i ] Atención. La extensión permitida sólo puede ser .txt.");
                }
            }
            catch(Coincidencia e) {
                System.out.println(e.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
            catch(SinExtension e) {
                System.out.println(e.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
            catch(ExtensionPermitida e) {
                System.out.println(e.getMessage());
                System.out.println("--> Pulsar INTRO para continuar.");
                sc.nextLine();
            }
            catch(IOException e) {
                System.out.println("No ha sido posible crear el archivo.");
            }
        } while(!valido);
    }
    
    /**
     * Método que rellanará el fichero con los datos de entrada del usuario.
     * @throws FileNotFoundException
     * @throws ValorInvalido
     * @throws LetraIncorrecta 
     */
    public void rellenarFichero() throws FileNotFoundException, ValorInvalido, LetraIncorrecta{
        PrintWriter rellenador = new PrintWriter(archivo);
        
        String[] filas = new String[2];
        boolean valido;
        int j = 1;
        System.out.println("Introducir 2 filas de palabras. Pulsar ENTER para terminar.");
            
            for (int i = 0; i <= 1; i++) {
                do {
                    valido = false;
                    try {
                        System.out.println("Introducir fila [" + (j) + "]:");
                        filas[i] = sc.nextLine();
                        //Si se encuentra algún carácter numérico, saltará la excepción.
                        if (filas[i].matches(".*\\d.*")) {
                            throw new ValorInvalido("[!] Detectada alguna cifra.");
                        }
                        valido = true;
                    }
                    catch(ValorInvalido e) {
                        System.out.println(e.getMessage());
                        sc.nextLine();
                    }
                } while(!valido);   
                j++;
            }
            
            for (int i = 0; i < filas.length; i++) {
                    rellenador.println(filas[i].toLowerCase());
            }
            rellenador.close();
            //Una vez relleno el fichero, se pasará al juego.
            jugarAhorcado();
    }
    
    /**
     * Método que implementa el juego del ahorcado.
     * @throws FileNotFoundException
     * @throws LetraIncorrecta 
     */
    public void jugarAhorcado() throws FileNotFoundException, LetraIncorrecta{
        Scanner lector = new Scanner(archivo);
        String[] entrada;
        ArrayList<String> palabras = new ArrayList<>();
        
        Pattern pattern = Pattern.compile("^[a-zA-Z\\u00C0-\\u017F]+$");
        
        //Se guarda el contenido de cada fila en un String y, aplicando un split,
        //añadimos cada palabra a un array que contendrá todas las palabras.
        while (lector.hasNext()) {
            entrada = lector.nextLine().split(" ");
            for (int i = 0; i < entrada.length; i++) {
                if (pattern.matcher(entrada[i]).matches()) {
                    palabras.add(entrada[i]);
                }
            }
        }
        System.out.println("[i] ¡Fichero listo!");
        
        Random random = new Random();
        int aleatorio;
        String palabraElegida;
        String opcion;
        
        //Se elige aleatoriamente una palabra y se rellena con asteriscos.
        do {
            aleatorio = random.nextInt(palabras.size() - 1);
            palabraElegida = palabras.get(aleatorio);
            for (int i = 0; i < palabraElegida.length(); i++) {
                oculta.append('*');
            }

            do {
                //Metemos la estructura que intriduce la letra en un try, para que salte 
                //la excepción en caso de que no sea correcta.
                try {
                    System.out.print("[i] Palabra elegida. ¿Qué letra apuestas que existe oculta?: " + oculta + "   --> ");
                    adivinarPalabra(palabraElegida);
                }
                catch(LetraIncorrecta e) {
                    //Se incrementa el número de fallos.
                    fallos++;
                    System.out.println(e.getMessage());
                }
            } while(oculta.indexOf("*") != -1);
            
            if (fallos == 0) {
                System.out.println("[i] ¡Felicidades! Has adivinado la palabra [" + palabraElegida + "] sin cometer ningún error.");
            }
            else {
                System.out.println("[i] ¡Felicidades! Has adivinado la palabra [" + palabraElegida + "], aunque has cometido " + fallos + (fallos != 1 ? " fallos." : " fallo."));
            }
            
            //Reiniciamos el valor de la palabra oculta por si el usuario quiere volver a jugar.
            oculta = new StringBuilder();
            System.out.print("[i] ¿Deseas probar suerte con otra palabra? (S/N): ");
            opcion = sc.next();
        } while(!(opcion.equals("n") || opcion.equals("N")));
        
    }
    
    /**
     * Método que comprueba si la letra introducida se encuentra en la palabra.
     * @param palabra
     * @throws LetraIncorrecta 
     */
    public void adivinarPalabra(String palabra) throws LetraIncorrecta{
        letra = sc.next().charAt(0);
        if (palabra.contains(String.valueOf(letra))){
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    //En caso de encontrarse la letra en la palabra, se reemplaza el asterisco por la letra.
                    oculta.replace(i, (i + 1), String.valueOf(letra));
                }
            }
        }
        else {
            throw new LetraIncorrecta("     [" + letra + "] no está en la palabra.");
        }
    }
}

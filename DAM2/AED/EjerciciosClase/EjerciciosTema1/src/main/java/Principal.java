import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import exceptions.*;
import java.util.Scanner;

public class Principal {

    static ArrayList<Cliente> personas = new ArrayList<>();
    public static void main(String[] args) throws NoSuchAlgorithmException {
        recogerDatos();
        System.out.println();
        mostrarDatos();
    }

    public static void recogerDatos() throws NoSuchAlgorithmException{
        recogerCliente();
        recogerEmpleado();
        recogerEstudiante();
        recogerFacultativo();
    }

    public static void mostrarDatos() {
        System.out.println("------ ACCESO A DATOS ------");
        for (Object persona: personas) {
            System.out.println(persona.toString());
        }
    }

    public static void recogerCliente() throws NoSuchAlgorithmException{
        Scanner sc = new Scanner(System.in);
        boolean valido = false;

        do {
            System.out.print("¿De cuántos clientes desea recoger información? ");
            try {
                int nClientes = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < nClientes; i++) {
                    do {
                        valido = false;
                        System.out.print("Introducir nombre del cliente nº" + (i + 1) + ": ");
                        try {
                            String nombre = sc.nextLine();
                            if (nombre.matches("^[A-Za-z\\s]+$")) {
                                do {
                                    valido = false;
                                    System.out.print("Indicar código: ");
                                    try {
                                        int codigo = sc.nextInt();
                                        sc.nextLine();
                                        if (codigo < 100 || codigo > 300) {
                                            throw new CodigoInvalido();
                                        }
                                        else {
                                            personas.add(new Cliente(nombre, codigo));
                                            valido = true;
                                        }
                                    }
                                    catch (InputMismatchException e) {
                                        System.out.println("[!] Debe ser un valor entero.");
                                        sc.nextLine();
                                    }
                                    catch (CodigoInvalido e) {
                                        System.out.println(e.getMessage());
                                        sc.nextLine();
                                    }
                                } while(!valido);
                            }
                            else if (nombre.matches("^[A-Za-z0-9\\s]+$")) {
                                throw new NoDigitos();
                            }
                            else if (!nombre.matches("^[A-Za-z\\s]+$")) {
                                throw new NoSimbolos();
                            }
                        }
                        catch (NoDigitos e) {
                            System.out.println(e.getMessage());
                        }
                        catch (NoSimbolos e) {
                            System.out.println(e.getMessage());
                        }
                    } while(!valido);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("[!] El valor debe ser un número entero.");
                sc.nextLine();
            }
        } while(!valido);
    }

    public static void recogerEmpleado() throws NoSuchAlgorithmException{
        Scanner sc = new Scanner(System.in);
        boolean valido = false;

        do {
            System.out.print("¿De cuántos empleados desea recoger información? ");
            try {
                int nEmpleados = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < nEmpleados; i++) {
                    do {
                        valido = false;
                        System.out.print("Introducir nombre del empleado nº" + (i + 1) + ": ");
                        try {
                            String nombre = sc.nextLine();
                            if (nombre.matches("^[A-Za-z\\\\s]+$")) {
                                personas.add(new Empleado(nombre));
                                valido = true;
                            }
                            else if (nombre.matches("^[A-Za-z0-9\\\\s]+$")) {
                                throw new NoDigitos();

                            }
                            else if (!nombre.matches("^[A-Za-z\\\\s]+$")) {
                                throw new NoSimbolos();
                            }
                        }
                        catch (NoDigitos e) {
                            System.out.println(e.getMessage());
                            sc.nextLine();
                        }
                        catch (NoSimbolos e) {
                            System.out.println(e.getMessage());
                            sc.nextLine();
                        }
                    } while(!valido);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("[!] El valor debe ser un número entero.");
                sc.nextLine();
            }
        } while(!valido);
    }

    public static void recogerEstudiante() throws NoSuchAlgorithmException{
        Scanner sc = new Scanner(System.in);
        boolean valido = false;

        do {
            System.out.print("¿De cuántos estudiantes desea recoger información? ");
            try {
                int nEstudiante = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < nEstudiante; i++) {
                    do {
                        valido = false;
                        System.out.print("Introducir nombre del estudiante nº" + (i + 1) + ": ");
                        try {
                            String nombre = sc.nextLine();
                            if (nombre.matches("^[A-Za-z\\\\s]+$")) {
                                personas.add(new Estudiante(nombre));
                                valido = true;
                            }
                            else if (nombre.matches("^[A-Za-z0-9\\\\s]+$")) {
                                throw new NoDigitos();
                            }
                            else if (!nombre.matches("^[A-Za-z\\\\s]+$")) {
                                throw new NoSimbolos();
                            }
                        }
                        catch (NoDigitos e) {
                            System.out.println(e.getMessage());
                            sc.nextLine();
                        }
                        catch (NoSimbolos e) {
                            System.out.println(e.getMessage());
                            sc.nextLine();
                        }
                    } while(!valido);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("[!] El valor debe ser un número entero.");
                sc.nextLine();
            }
        } while(!valido);
    }

    public static void recogerFacultativo() throws NoSuchAlgorithmException{
        Scanner sc = new Scanner(System.in);
        boolean valido = false;

        do {
            System.out.print("¿De cuántos facultativos desea recoger información? ");
            try {
                int nFacultativo = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < nFacultativo; i++) {
                    do {
                        valido = false;
                        System.out.print("Introducir nombre del facultativo nº" + (i + 1) + ": ");
                        try {
                            String nombre = sc.nextLine();
                            if (nombre.matches("^[A-Za-z\\\\s]+$")) {
                                personas.add(new Facultativo(nombre));
                                valido = true;
                            }
                            else if (nombre.matches("^[A-Za-z0-9\\\\s]+$")) {
                                throw new NoDigitos();
                            }
                            else if (!nombre.matches("^[A-Za-z\\\\s]+$")) {
                                throw new NoSimbolos();
                            }
                        }
                        catch (NoDigitos e) {
                            System.out.println(e.getMessage());
                            sc.nextLine();
                        }
                        catch (NoSimbolos e) {
                            System.out.println(e.getMessage());
                            sc.nextLine();
                        }
                    } while(!valido);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("[!] El valor debe ser un número entero.");
                sc.nextLine();
            }
        } while(!valido);
    }
}

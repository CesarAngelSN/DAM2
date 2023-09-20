import java.security.NoSuchAlgorithmException;

public class Estudiante extends Cliente{
    public final int titulado = 1;
    public final int temporal = 2;

    public Estudiante() {}

    public Estudiante(String nombre) throws NoSuchAlgorithmException {
        super(nombre);
    }

    @Override
    public String toString() {
        return "Nombre: [i] Estudiante " + nombre;
    }}

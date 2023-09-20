import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Cliente {
    protected String nombre;
    protected int codigo;
    protected int aleatorio;
    protected String direccion;
    protected String numeroMovil;
    protected String email;

    public Cliente() {}

    public Cliente(String nombre) throws NoSuchAlgorithmException{
        this.nombre = nombre;
        aleatorio = generarAleatorio();
    }

    public Cliente(String nombre, int codigo) throws NoSuchAlgorithmException{
        this.nombre = nombre;
        this.codigo = codigo;
        aleatorio = generarAleatorio();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private int generarAleatorio() throws NoSuchAlgorithmException {
        SecureRandom aleatorio = SecureRandom.getInstance("SHA1PRNG");
        int random = aleatorio.nextInt(999999999) - 100;
        return ((random + codigo) + "").length() != 9 ? generarAleatorio() : random;
    }

    @Override
    public String toString() {
        return "Nombre Cliente: " + nombre + ", Código seguro ---[" + (aleatorio) + "]";
    }
}

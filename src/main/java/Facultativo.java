import java.security.NoSuchAlgorithmException;

public class Facultativo extends Empleado{
    public final int tecnico = 1;
    public final int licenciado = 2;
    protected String horario;
    protected int especialidad;


    public Facultativo() {}

    public Facultativo(String nombre) throws NoSuchAlgorithmException {
        super(nombre);
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Nombre: [i] Facultativo " + nombre;
    }
}

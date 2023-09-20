import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

public class Empleado extends Cliente{
    protected String turno;
    protected double salario;
    protected java.util.Calendar fechaContrato;

    public Empleado(){}

    public Empleado(String nombre) throws NoSuchAlgorithmException {
        super(nombre);
    }

    public Empleado(String turno, double salario) {
        this.salario = salario;
        this.turno = turno;
        fechaContrato = Calendar.getInstance();
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Calendar getFechaContrato() {
        return this.fechaContrato;
    }

    public void setFechaContrato(Calendar fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    @Override
    public String toString() {
        return "Nombre: [i] Empleado " + nombre;
    }
}

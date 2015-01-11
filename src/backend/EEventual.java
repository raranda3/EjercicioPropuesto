package backend;

/**
  * @author JCarlos;
 */
public class EEventual extends Empleado implements SaldoEventual {
    private float pagoHora;
    private int horasTotales; // Es calculado.
    private int horasNormales;
    private Fecha finContrato;
    private float salarioTotal; // Es calculado.

    public EEventual(float pagoHora, int horasNormales, Fecha finContrato, String codigo, int horasExtras, Fecha fechaIngreso, String area, String cargo, String DNI, String nombre, String apellido, Fecha fechaNacimiento, String direccion, String procedencia) {
        super(codigo, horasExtras, fechaIngreso, area, cargo, DNI, nombre, apellido, fechaNacimiento, direccion, procedencia);
        this.pagoHora = pagoHora;
        this.horasNormales = horasNormales;
        this.finContrato = finContrato;
    }

    @Override
    public void calcularHorasTotales() {
        horasTotales = horasNormales + horasExtras;
    }

    @Override
    public void calcularSalario() {
        salarioTotal = pagoHora*horasTotales; 
    }

    @Override
    public float getSalario() {
        return salarioTotal;
    }
    
    
    
}

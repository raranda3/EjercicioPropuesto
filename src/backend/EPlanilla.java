package backend;

/**
  * @author JCarlos;
 */
public class EPlanilla extends Empleado implements SaldoPlanilla {
    private float salarioMensual;
    private float pAdicional;

    public EPlanilla(float pAdicional, String codigo, int horasExtras, Fecha fechaIngreso, String area, String cargo, String DNI, String nombre, String apellido, Fecha fechaNacimiento, String direccion, String procedencia) {
        super(codigo, horasExtras, fechaIngreso, area, cargo, DNI, nombre, apellido, fechaNacimiento, direccion, procedencia);
        this.pAdicional = pAdicional;
    }

    @Override
    public void calcularSalario() {
        salarioMensual = (1+pAdicional/100)*SALARIO_BASE;
    }

    @Override
    public float getSalario() {
        return salarioMensual;
    }
    
    
}

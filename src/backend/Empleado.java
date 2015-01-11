package backend;

/**
  * @author JCarlos;
 */
public class Empleado extends Persona {
    private String codigo;
    protected int horasExtras;
    private Fecha fechaIngreso;
    private String area;
    private String cargo;

    public Empleado(String codigo, int horasExtras, Fecha fechaIngreso, String area, String cargo, String DNI, String nombre, String apellido, Fecha fechaNacimiento, String direccion, String procedencia) {
        super(DNI, nombre, apellido, fechaNacimiento, direccion, procedencia);
        this.codigo = codigo;
        this.horasExtras = horasExtras;
        this.fechaIngreso = fechaIngreso;
        this.area = area;
        this.cargo = cargo;
    }
    
}

package backend;

/**
  * @author JCarlos;
 */
public class Persona {
    private String DNI;
    private String nombre;
    private String apellido;
    private Fecha fechaNacimiento;
    private String direccion;
    private String procedencia;

    public Persona(String DNI, String nombre, String apellido, Fecha fechaNacimiento, String direccion, String procedencia) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.procedencia = procedencia;
    }
    
    @Override
    public String toString()
    {
        return    "\nDNI: "+DNI
                + "\nNombre: "+nombre
                + "\nApellido: "+apellido
                + "\nFecha de nacimiento: "+fechaNacimiento.toString()
                + "\nDirección: "+direccion
                + "\nCiudad de procedencia: "+procedencia;
    }
    
}

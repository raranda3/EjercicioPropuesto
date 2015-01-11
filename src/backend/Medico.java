package backend;

import java.util.ArrayList;

/**
  * @author JCarlos;
 */
public class Medico extends Persona {
    private String especialidad;
    private String servicio;
    private int nroConsultorio;
    ArrayList<CitaMedica> citas = new ArrayList();

    public Medico(String especialidad, String servicio, int nroConsultorio, String DNI, String nombre, String apellido, Fecha fechaNacimiento, String direccion, String procedencia) {
        super(DNI, nombre, apellido, fechaNacimiento, direccion, procedencia);
        this.especialidad = especialidad;
        this.servicio = servicio;
        this.nroConsultorio = nroConsultorio;
    }
    
    public int getCantidadCitas()
    {
        return citas.size();
    }
    
    public String getFechaCita(int pos)
    {
        return citas.get(pos).fechaCita.toString();
    }
    
    public String getPaciente(int pos)
    {
        return citas.get(pos).nombrePaciente;
    }
    
    public void agregarCita(Fecha f, String n)
    {
        citas.add( new CitaMedica(f, n) );
    }
    
    public void limpiarCitas()
    {
        citas.clear();
    }
    
    public int getNroConsultorio()
    {
        return nroConsultorio;   
    }
    
    public String getEspecialidad()
    {
        return especialidad;
    }
    
    @Override
    public String toString()
    {
        return super.toString()
                + "\nEspecialidad: "+especialidad
                + "\nServicio: "+servicio
                + "\nNro consultorio: "+nroConsultorio;
    }
    
    class CitaMedica
    {
        private Fecha fechaCita;
        private String nombrePaciente;
        public CitaMedica(Fecha f, String n)
        {
            fechaCita=f; 
            nombrePaciente=n;
        }
    }
}

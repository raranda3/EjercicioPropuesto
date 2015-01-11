package backend;

/**
  * @author JCarlos;
 */
public class Paciente extends Persona {
    private int historiaClinica;
    private boolean sexo; // 0-Femenino 1-Masculino.
    private String grupoS; // Grupo sanguíneo.
    private String medicamentos[]; // Medicamentos a los que es alérgico.

    public Paciente(int historiaClinica, boolean sexo, String grupoS, String[] medicamentos, String DNI, String nombre, String apellido, Fecha fechaNacimiento, String direccion, String procedencia) {
        super(DNI, nombre, apellido, fechaNacimiento, direccion, procedencia);
        this.historiaClinica = historiaClinica;
        this.sexo = sexo;
        this.grupoS = grupoS;
        this.medicamentos = medicamentos;
    }
    
}

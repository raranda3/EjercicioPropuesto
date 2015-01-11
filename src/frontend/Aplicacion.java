package frontend;

import backend.EEventual;
import backend.EPlanilla;
import backend.Empleado;
import backend.Fecha;
import backend.Medico;
import backend.Paciente;
import java.util.ArrayList;

/**
  * @author JCarlos;
 */
public class Aplicacion {
    
    public static final int EMPLEADO = 0;
    public static final int PACIENTE = 1;
    public static final int MEDICO = 2;
    
    // Creamos bases de datos.
    ArrayList<Empleado> ListaEmpleados = new ArrayList();
    ArrayList<Paciente> ListaPacientes = new ArrayList();
    ArrayList<Medico> ListaMedicos = new ArrayList();    
    
    
    public void run()
    {
        int opt;
        
        do{
            opt = menu();
            switch(opt)
            {
                case 1:
                    System.out.println("Registrando un nuevo empleado ...");
                    registrar(EMPLEADO);
                    break;
                case 2: 
                    System.out.println("Registrando un nuevo paciente ...");
                    registrar(PACIENTE);
                    break;
                case 3:
                    System.out.println("Registrando un nuevo médico ...");
                    registrar(MEDICO);
                    break;
                case 4:
                    System.out.println("Registrando cita médica ...");
                    int consultorioRegistro = Integer.parseInt("Ingrese nro de consultorio del médico");
                    int posR = BuscarMedico(consultorioRegistro);
                    if( posR == -1 )
                    {
                        System.err.println("No existe consultorio con tal número.");
                    }else{ // Sí se encontro.
                        System.out.println("Datos sobre la fecha de la cita.");
                        int diaC = Integer.parseInt( Lector.leer("- Día de la cita") );
                        int mesC = Integer.parseInt( Lector.leer("- Mes de la cita") );
                        int anioC = Integer.parseInt( Lector.leer("- Anio de la cita") );
                        String paciente = Lector.leer("Ingrese nombre del paciente");
                        ListaMedicos.get(posR).agregarCita(new Fecha(diaC, mesC, anioC), paciente);
                    }                    
                    break;
                case 5:
                    // Siempre antes de mostrar ordenamos por especialidad.
                    for(int i=0; i<ListaMedicos.size()-1; ++i)
                        for(int j=i+1; j<ListaMedicos.size(); ++j)
                            if(ListaMedicos.get(i).getEspecialidad().compareToIgnoreCase(ListaMedicos.get(j).getEspecialidad()) > 0)
                            {
                                Medico temporal = ListaMedicos.get(i);
                                ListaMedicos.set( i, ListaMedicos.get(j) );
                                ListaMedicos.set(j, temporal);
                            }
                    // Ahora simplemente mostramos.
                    System.out.println("Médicos ordenados según especialidad, descendentemente.");
                    for(int i=0; i<ListaMedicos.size(); ++i)
                        System.out.println( ListaMedicos.get(i).toString() );
                    break;
                case 6:
                    System.out.println("Buscando pacientes citados por un médico.");
                    int consultorioBusqueda = Integer.parseInt( Lector.leer("Ingrese nro de consultorio del médico") );
                    int posB = BuscarMedico(consultorioBusqueda);
                    if( posB == -1 )
                    {
                        System.err.println("No existe consultorio con tal número.");
                    }else{ // Sí se encontro.
                        int cantCitas = ListaMedicos.get(posB).getCantidadCitas();
                        System.out.println("El médico actualmente tiene "+cantCitas+" citas con pacientes.");
                        for(int i=0; i<cantCitas; ++i)
                            System.out.println("La fecha "+ListaMedicos.get(posB).getFechaCita(i)+" con el paciente "+ListaMedicos.get(posB).getPaciente(i));
                    }
                case 7:
                    System.out.println("Ha cerrado el programa exitosamente . . .");
                    break;
                default:
                    System.err.println("¡ Ha ingresado una opción inválida !");
            }
        }
        while(opt!=7);
    }
    
    public int menu()
    {
        System.out.println(
                  "\n1. Registrar empleado."
                + "\n2. Registrar paciente."
                + "\n3. Registrar médico."
                + "\n4. Registrar cita médica."
                + "\n5. Listar médicos según especialidad."
                + "\n6. Obtener pacientes atendidos por un médico."
                + "\n7. Salir del programa."
                );
        return Integer.parseInt( Lector.leer("Ingrese opción") );
    }
    
    private void registrar(int Type)
    {
        // Leemos lo que requiere cada persona.
        String DNI = Lector.leer("Ingrese DNI");
        String nombre = Lector.leer("Ingrese nombre");
        String apellido = Lector.leer("Ingrese apellido");
        System.out.println("Datos sobre la fecha de nacimiento.");
        int diaN = Integer.parseInt( Lector.leer("- Ingrese día") );
        int mesN = Integer.parseInt( Lector.leer("- Ingrese mes") );
        int anioN = Integer.parseInt( Lector.leer("- Ingrese anio") );
        Fecha fechaNacimiento = new Fecha(diaN, mesN, anioN);
        String direccion = Lector.leer("Ingrese dirección");
        String procedencia = Lector.leer("Ingrese ciudad de procedencia");
        
        switch(Type)
        {
            case EMPLEADO:
                String codigo = Lector.leer("Ingrese código");
                int horasExtras = Integer.parseInt( Lector.leer("Ingrese horas extras") );
                System.out.println("Datos sobre la fecha de ingreso.");
                int diaI = Integer.parseInt( Lector.leer("- Ingrese día") );
                int mesI = Integer.parseInt( Lector.leer("- Ingrese mes") );
                int anioI = Integer.parseInt( Lector.leer("- Ingrese anio") );                
                Fecha fechaIngreso = new Fecha(diaI, mesI, anioI);
                String area = Lector.leer("Ingrese área de trabajo");
                String cargo = Lector.leer("Ingrese cargo a ocupar");
                boolean eventual = Boolean.parseBoolean("Tipo de contrato(0-Planilla, 1-Eventual)");
                if(eventual)
                {
                    float pagoHora = Float.parseFloat("Ingrese honorarios por hora");
                    int horasNormales = Integer.parseInt("Ingrese horas de trabajo normal");
                    System.out.println("Datos sobre la fecha de fin de contrato.");
                    int diaF = Integer.parseInt( Lector.leer("- Ingrese día") );
                    int mesF = Integer.parseInt( Lector.leer("- Ingrese mes") );
                    int anioF = Integer.parseInt( Lector.leer("- Ingrese anio") );                      
                    Fecha finContrato = new Fecha(diaF, mesF, anioF);
                    ListaEmpleados.add( new EEventual(pagoHora, horasNormales, finContrato, codigo, horasExtras, fechaIngreso, area, cargo, DNI, nombre, apellido, fechaNacimiento, direccion, procedencia) );
                }else{                
                    float pAdicional = Float.parseFloat( Lector.leer("Ingrese porcentaje adicional") );
                    ListaEmpleados.add( new EPlanilla(pAdicional, codigo, horasExtras, fechaIngreso, area, cargo, DNI, nombre, apellido, fechaNacimiento, direccion, procedencia) );
                }
                break;
            case PACIENTE:
                int historiaClinica = Integer.parseInt( Lector.leer("Número de historia clínica") );
                boolean sexo = Boolean.parseBoolean( Lector.leer("Ingrese sexo (0-Femenino, 1-Masc)") );
                String grupoS = Lector.leer("Ingrese grupo sanguíneo"); // Grupo sanguíneo.
                System.out.println("Datos sobre los medicamentos a los que es alérgico.");                
                int cant = Integer.parseInt( Lector.leer("Cantidad de medicamentos") );
                String medicamentos[] = new String[cant];
                for(int i=0; i<cant; ++i)
                    medicamentos[i] = Lector.leer("- Medicamento "+i);
                ListaPacientes.add( new Paciente(historiaClinica, sexo, grupoS, medicamentos, DNI, nombre, apellido, fechaNacimiento, direccion, procedencia) );
                break;
            case MEDICO:
                String especialidad = Lector.leer("Ingrese especialidad del médico");
                String servicio = Lector.leer("Ingrese servicio brindado");
                int nroConsultorio = Integer.parseInt( Lector.leer("Ingrese nro de consultorio") );   
                ListaMedicos.add( new Medico(especialidad, servicio, nroConsultorio, DNI, nombre, apellido, fechaNacimiento, direccion, procedencia) );
                break;                                  
        }
    }
    
    private int BuscarMedico(int nroC)
    {
        for(int i=0; i<ListaMedicos.size(); ++i)
            if(ListaMedicos.get(i).getNroConsultorio() == nroC)
                return i;
        return -1;
    }
}
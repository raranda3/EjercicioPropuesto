package backend;

/**
  * @author JCarlos;
 */
public class Fecha {
    
    private int dia;
    private int mes;
    private int anio;
    
    public Fecha(int d, int m, int a)
    {
        dia=d; mes=m; anio=a;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }
    
    @Override
    public String toString()
    {
        return (dia<=9?"0":"")+dia +"/"+ (mes<=9?"0":"")+mes +"/"+ anio;
    }
    
}

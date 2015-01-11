package frontend;

import java.util.Scanner;

/**
  * @author JCarlos;
 */
public class Lector {
    private static Scanner L = new Scanner( System.in );
    public static String leer(String msje)
    {
        System.out.print(msje+": ");
        return L.nextLine();
    }
}

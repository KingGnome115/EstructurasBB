package Arreglos;

/**
 *
 * @author Kevin
 */
public class Recursividad
{
    
    
    public static void desplegar(int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.println("HOla puto");
        }
    }
    
    public static void desp(int i, int n)
    {
        if (i<=n)
        {
            System.out.println("Hola mundo");
            desp(i+1, n);
        }
    }
    
}

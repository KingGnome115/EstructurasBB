package ColasDyPilasD;

/**
 *
 * @author Kevin
 */
public class PrbColas
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ColasD pruebas = new ColasD();
        
        Nodo n1 = new Nodo("5");
        Nodo n2 = new Nodo("21");
        Nodo n3 = new Nodo("35");
        
        pruebas.inserta(n1);
        pruebas.inserta(n2);
        pruebas.inserta(n3);
        
        System.out.println(pruebas.elimina().getEtq());
        System.out.println(pruebas.elimina().getEtq());
        System.out.println(pruebas.elimina().getEtq());
    }
    
}

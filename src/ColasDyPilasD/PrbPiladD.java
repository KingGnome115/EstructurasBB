package ColasDyPilasD;

/**
 *
 * @author Kevin
 */
public class PrbPiladD
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        PilasD prueba = new PilasD();
        Nodo n1 = new Nodo("5");
        Nodo n2 = new Nodo("21");
        Nodo n3 = new Nodo("35");

        prueba.inserta(n1);
        prueba.inserta(n2);
        prueba.inserta(n3);

        //21
        PilasD aux = new PilasD();
        boolean ban = true;
        while (ban)
        {
            Nodo auxiliar = prueba.elimina();
            if (auxiliar.getEtq().compareTo("21") != 0)
            {
                aux.inserta(auxiliar);
            } else
            {
                ban = false;
            }
        }

        Nodo auxiliar = aux.elimina();
        while (auxiliar != null)
        {
            prueba.inserta(auxiliar);
            auxiliar = aux.elimina();
        }

        System.out.println(prueba.elimina().getEtq());
        System.out.println(prueba.elimina().getEtq());
    }

}

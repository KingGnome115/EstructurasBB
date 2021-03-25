package TipoListas;

/**
 *
 * @author Kevin
 */
public class PrbListas
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        LCD prueba = new LCD();

        NodoL n1 = new NodoL("4");
        NodoL n2 = new NodoL("1");
        NodoL n3 = new NodoL("3");
        NodoL n4 = new NodoL("6");
        NodoL n5 = new NodoL("2");
        NodoL n6 = new NodoL("0");
        NodoL n7 = new NodoL("5");

        prueba.inserta(n1);
        prueba.inserta(n2);
        prueba.inserta(n3);
        prueba.inserta(n4);
        prueba.inserta(n5);
        prueba.inserta(n6);
        prueba.inserta(n7);

        System.out.println(prueba.desp(prueba.getRaiz()));

        //0 1 2 3 4 5 6
        NodoL en;
        en = prueba.buscar("3");
        if (en!=null)
        {
            System.out.println(en.getEtq()+" Encontrado");
        } else
        {
            System.out.println("No existe el elemento en la lista");
        }
        
    }
}

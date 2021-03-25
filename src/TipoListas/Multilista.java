package TipoListas;

/**
 *
 * @author Kevin
 */
public class Multilista
{

    /**
     * Metodo que busca el nivel para insertar el dato nuceo
     *
     * @param raiz apartir de donde se buscara la sublista
     * @param nuevo el nuevo elemento a insertar
     * @param nivel el nivel de la lista a la cual se hara la insercion
     * @param etq arreglo de etq con la cual se buscara el elemente y su
     * sublista
     * @return la raiz con el nuevo elemento
     */
    public static NodoL inserta(NodoL raiz, NodoL nuevo, int nivel, String etq[])
    {
        /**
         * Preguntamos si el nivel esta a la altura de la cantidad de etq de ser
         * así entonces creamos una nueva lista (no importa cual tipo sea)
         * despues le asignamos a esa lista la raiz enviada y procedemos a
         * insertar el dato
         */
        if (nivel == etq.length - 1)
        {
            LCD lista = new LCD();
            lista.setRaiz(raiz);
            lista.inserta(nuevo);
            raiz = lista.getRaiz();
        } else
        {
            NodoL aux = busca(raiz, etq[nivel]);
            if (aux!=null)
            {
                
            } else
            {
            }
            return raiz;
        }
        return null;
    }

    public static NodoL busca(NodoL r, String etq)
    {
        NodoL aux = null;
        while (r != null)
        {
            if (r.getEtq().equals(etq))
            {
                return r;
            } else
            {
                r = r.getSig();
            }
        }
        return aux;
    }

}

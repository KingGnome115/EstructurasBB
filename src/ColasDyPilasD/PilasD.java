package ColasDyPilasD;

/**
 *
 * @author Kevin
 */
public class PilasD
{

    private Nodo tope = null;

    /**
     * @return the tope
     */
    public Nodo getTope()
    {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(Nodo tope)
    {
        this.tope = tope;
    }

    public boolean inserta(Nodo nuevo)
    {
        if (nuevo == null)
        {
            return false;
        } else
        {
            nuevo.setSig(tope);
            tope = nuevo;
            return true;
        }
    }
    
    public Nodo elimina()
    {
        if (tope==null)
        {
            return null;
        } else
        {
            Nodo aux = tope;
            tope=aux.getSig();
            aux.setSig(null);
            return aux;
        }
    }

}

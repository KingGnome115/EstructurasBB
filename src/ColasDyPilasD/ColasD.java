package ColasDyPilasD;

/**
 *
 * @author Kevin
 */
public class ColasD
{
    
    private Nodo f;
    private Nodo a;

    /**
     * @return the f
     */
    public Nodo getF()
    {
        return f;
    }

    /**
     * @param f the f to set
     */
    public void setF(Nodo f)
    {
        this.f = f;
    }

    /**
     * @return the a
     */
    public Nodo getA()
    {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Nodo a)
    {
        this.a = a;
    }
    
    public boolean inserta(Nodo n)
    {
        if (n == null)
        {
            return false;
        } else
        {
            if (f == null)
            {
                f = a = n;
            } else
            {
                a.setSig(n);
                a = n;
            }
            return true;
        }
    }
    
    public Nodo elimina()
    {
        if (f == null)
        {
            return null;
        } else
        {
            Nodo aux = f;
            if (f == a)
            {
                f = a = null;
            } else
            {
                f = aux.getSig();
                aux.setSig(null);
            }
            return aux;
        }
    }
}

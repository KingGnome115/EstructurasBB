package ColasDyPilasD;

/**
 *
 * @author Kevin
 */
public class Nodo
{

    private Object obj;
    private String etq;
    private Nodo sig;

    public Nodo()
    {
    }

    public Nodo(String etq)
    {
        this.etq = etq;
    }

    public Nodo(Object obj, String etq, Nodo sig)
    {
        this.obj = obj;
        this.etq = etq;
        this.sig = sig;
    }

    /**
     * @return the obj
     */
    public Object getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    /**
     * @return the etq
     */
    public String getEtq()
    {
        return etq;
    }

    /**
     * @param etq the etq to set
     */
    public void setEtq(String etq)
    {
        this.etq = etq;
    }

    /**
     * @return the sig
     */
    public Nodo getSig()
    {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Nodo sig)
    {
        this.sig = sig;
    }

}

package TipoListas;

/**
 *
 * @author Kevin
 */
public class NodoL
{

    private String etq;
    private Object obj = null;
    private NodoL sig = null;
    private NodoL ant = null;
    private NodoL abj=null;
    private NodoL arb=null;

    public NodoL()
    {
    }

    public NodoL(String etq)
    {
        this.etq = etq;
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
     * @return the sig
     */
    public NodoL getSig()
    {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(NodoL sig)
    {
        this.sig = sig;
    }

    /**
     * @return the ant
     */
    public NodoL getAnt()
    {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(NodoL ant)
    {
        this.ant = ant;
    }

    /**
     * @return the abj
     */
    public NodoL getAbj()
    {
        return abj;
    }

    /**
     * @param abj the abj to set
     */
    public void setAbj(NodoL abj)
    {
        this.abj = abj;
    }

    /**
     * @return the arb
     */
    public NodoL getArb()
    {
        return arb;
    }

    /**
     * @param arb the arb to set
     */
    public void setArb(NodoL arb)
    {
        this.arb = arb;
    }

}

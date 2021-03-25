package TipoListas;

/**
 * Listas Doblemente Ligadas
 * Este tipo de listas saben que dato va antes y despues
 * Si no hay elementos antes de la raiz o despues del ultimo elemento los
 * apuntadores daran a null
 * @author Kevin
 */
public class LDL
{

    private NodoL raiz = null;
    private int tamanio = 0;

    /**
     * @return the raiz
     */
    public NodoL getRaiz()
    {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoL raiz)
    {
        this.raiz = raiz;
    }

    /**
     * @return the tamanio
     */
    public int getTamanio()
    {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio)
    {
        this.tamanio = tamanio;
    }

    public boolean inserta(NodoL nuevo)
    {
        //Si no se envio nada entonces no se pude insertar nada
        if (nuevo == null)
        {
            return false;
        } else
        {
            //Si es la primera vez que se inserta algo entonces ese elemento se vuelve la raiz de todo
            if (raiz == null)
            {
                raiz = nuevo;
            } else
            {
                /**
                 * Si el nuevo elemento es menor a la raiz entonces el nuevo
                 * elemento apuntara a la raiz (valor antiguo) y la raiz
                 * apuntara atras al nuevo elemento y finalmente el nuevo
                 * elemento sera la nueva raiz
                 */
                if (nuevo.getEtq().compareTo(raiz.getEtq()) < 0)
                {
                    nuevo.setSig(raiz);
                    raiz.setAnt(nuevo);
                    raiz = nuevo;
                } else
                {
                    /**
                     * Debemos recorrer la raiz con una variable auxiliar y con
                     * la ventaja de que podemos saber quien es antes y quien
                     * despues
                     */
                    NodoL aux = raiz;
                    boolean bandera = true;
                    while (aux.getSig() != null && bandera)
                    {
                        /**
                         * Preguntamos si el elemento es mayor al auxiliar y menor
                         * al siguiente elemento para saber si va en medio de estos
                         * de ser así el nuevo elemento apuntara al auxiliar siguiente
                         * auxiliar siguiente sera el nuevo elemento
                         * el nuevo elemento atras apuntara a aux
                         * y nuevo siguiente atras apuntara al nuevo elemento
                         * de lo contrario aux sera aux siguiente
                         */
                        if (nuevo.getEtq().compareTo(aux.getEtq()) > 0 && nuevo.getEtq().compareTo(aux.getSig().getEtq()) < 0)
                        {
                            nuevo.setSig(aux.getSig());
                            aux.setSig(nuevo);
                            nuevo.setAnt(aux);
                            nuevo.getSig().setAnt(nuevo);
                            bandera = false;
                        } else
                        {
                            aux = aux.getSig();
                        }
                    }
                    /**
                     * El elemento nuevo es mayor al ultimo elemento en la lista
                     * por ende el ultimo elemento apuntara al nuevo y el nuevo
                     * atras apuntara al aux
                     */
                    if (bandera)
                    {
                        aux.setSig(nuevo);
                        nuevo.setAnt(aux);
                    }
                }
            }
            tamanio++;
            return true;
        }
    }

    public NodoL eliminar(String etq)
    {
        //Si es la primera vez que se inserta algo entonces ese elemento se vuelve la raiz de todo
        if (raiz == null)
        {
            return null;
        } else
        {
            NodoL encontrado = null;
            /**
             * Si la raiz es igual a la etq y su siguiente es null entonces la
             * lista se vacia
             */
            if (raiz.getEtq().equals(etq) && raiz.getSig() == null)
            {
                encontrado = raiz;
                raiz = null;
            } else
            {
                /**
                 * Si la etiqueta es igual a la raiz y esta tiene un siguiente
                 * entonces encontrado es igual a raiz, la raiz ahora es su
                 * elemento siguiente, encontrado ya no apunta a nadie y la
                 * nueva raiz atras no apuntara a nada
                 */
                if (etq.compareTo(raiz.getEtq()) == 0)
                {
                    encontrado = raiz;
                    raiz = raiz.getSig();
                    encontrado.setSig(null);
                    raiz.setAnt(null);
                } else
                {
                    /**
                     * Debemos recorrer la lista sin comprometer la posicion de
                     * la raiz para eso nos apoyamos de un auxiliar
                     */
                    NodoL aux = raiz.getSig();
                    while (aux != null)
                    {
                        /**
                         * Si la etq es igual al aux entonces encontrado es
                         * igual al auxiliar creamos dos variables temporales,
                         * siguiente y anterior que obtendran sus respectivos
                         * valores de aux aislamos a encontrado
                         */
                        if (etq.equals(aux.getEtq()))
                        {
                            encontrado = aux;
                            NodoL siguiente = aux.getSig();
                            NodoL anterior = aux.getAnt();
                            /**
                             * Preguntamos si hay algo despues del aux de lo
                             * contrario el penultimo elemento apuntara a null y
                             * si hay elementos despues del aux entonces
                             * siguiente apuntara a anterior y anterior apuntara
                             * a siguiente
                             */
                            if (siguiente != null)
                            {
                                siguiente.setAnt(anterior);
                                anterior.setSig(siguiente);
                            } else
                            {
                                anterior.setSig(null);
                            }
                            encontrado.setAnt(null);
                            encontrado.setSig(null);
                            break;
                        } else
                        {
                            aux = aux.getSig();
                        }
                    }
                }
            }
            tamanio--;
            return encontrado;
        }
    }

    /**
     * Método que despliega todo los datos de la lista
     *
     * @param raiz variable que es auxiliar y recibe a la original como copia
     * @return todas las etq
     */
    public String despConN(NodoL raiz)
    {
        String s = "";
        while (raiz != null)
        {
            if (raiz.getAnt() == null)
            {
                s += "Null <-" + raiz.getEtq() + "->" + raiz.getSig().getEtq();
            } else
            {
                if (raiz.getSig() == null)
                {
                    s += raiz.getAnt().getEtq() + "<-" + raiz.getEtq() + "-> Null";
                } else
                {
                    s += raiz.getAnt().getEtq() + "<-" + raiz.getEtq() + "->" + raiz.getSig().getEtq();
                }
            }
            s += "\n";
            raiz = raiz.getSig();
        }
        return s;
    }
    
    public NodoL buscar(String etq)
    {
        NodoL encontrado = null;
        NodoL aux = raiz;
        while (aux != null)
        {
            if (aux.getEtq().equals(etq))
            {
                encontrado = aux;
                break;
            } else
            {
                aux=aux.getSig();
            }
        }
        return encontrado;
    }

    /**
     * Método que despliega todo los datos de la lista
     *
     * @param raiz variable que es auxiliar y recibe a la original como copia
     * @return todas las etq
     */
    public String desp(NodoL raiz)
    {
        String s = "";
        while (raiz != null)
        {
            s += raiz.getEtq();
            raiz = raiz.getSig();
        }
        return s;
    }

}

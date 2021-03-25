package TipoListas;

/**
 * Listas Circulares Doblemente Ligadas El el más complejo y al mismo tiempo el
 * más importante, pues nunca apuntara a null, pero sobre todo el inicio y el
 * final estan conectados con lo cual podemos saber si el elemento existe dentro
 * de la lista con una sola comparación
 *
 * @author Kevin
 */
public class LCD
{

    private NodoL raiz = null;
    private NodoL ultimo = null;
    private int tamanio = 0;

    public LCD()
    {
    }

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
     * @return the ultimo
     */
    public NodoL getUltimo()
    {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(NodoL ultimo)
    {
        this.ultimo = ultimo;
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
        if (nuevo == null)
        {
            return false;
        } else
        {
            /**
             * si la raiz esta vacia entonces se va insertar por primera vez los
             * tres se igualan, el sig y ant apuntaran finalmente a la raiz
             */
            if (raiz == null)
            {
                raiz = ultimo = nuevo;
                raiz.setSig(raiz);
                raiz.setAnt(raiz);
            } else
            {
                /**
                 * Si el nuevo elemento es menor a la raiz entonces el ultimo
                 * sig apuntara al nuevo nuevo anterior apuntara al ultimo raiz
                 * anterior apuntara a nuevo nuevo siguiente apuntara a la raiz
                 * finalmente la raiz es igual al nuevo
                 */
                if (nuevo.getEtq().compareTo(raiz.getEtq()) < 0)
                {
                    ultimo.setSig(nuevo);
                    nuevo.setAnt(ultimo);
                    raiz.setAnt(nuevo);
                    nuevo.setSig(raiz);
                    raiz = nuevo;
                } else
                {
                    /**
                     * Si el elemento es mayor a la raiz entonces va en medio o
                     * al final, así que preguntamos si es mayor al ultimo si es
                     * mayor al ultimo entonces ultimo siguiente apuntara a
                     * nuevo nuevo siguiente apuntara a la raiz raiz anterior
                     * apuntara a nuevo nuevo anterior apuntara a ultimo ultimo
                     * sera nuevo
                     */
                    if (nuevo.getEtq().compareTo(ultimo.getEtq()) > 0)
                    {
                        ultimo.setSig(nuevo);
                        nuevo.setSig(raiz);
                        raiz.setAnt(nuevo);
                        nuevo.setAnt(ultimo);
                        ultimo = nuevo;
                    } else
                    {
                        /**
                         * Debemos recorrer la raiz con una variable auxiliar y
                         * con la ventaja de que podemos saber quien es antes y
                         * quien despues
                         */
                        NodoL aux = raiz.getSig();
                        while (true)
                        {

                            if (nuevo.getEtq().compareTo(aux.getEtq()) > 0 && nuevo.getEtq().compareTo(aux.getSig().getEtq()) < 0)
                            {
                                nuevo.setSig(aux.getSig());
                                aux.setSig(nuevo);
                                nuevo.setAnt(aux);
                                nuevo.getSig().setAnt(nuevo);
                                break;
                            } else
                            {
                                aux = aux.getSig();
                            }
                        }
                    }
                }
            }
            tamanio++;
            return true;
        }
    }

    public NodoL eliminar(String etq)
    {
        if (raiz == null)
        {
            return null;
        } else
        {
            /**
             * Requerimos un nodo que retorno el elemento que fue eliminado
             */
            NodoL encontrado = null;

            /**
             * Si la raiz y el ultimo elemento es igual entonces eliminaremos el
             * único elemento existente y ambos valores se van a nulo
             */
            if (etq.equals(raiz.getEtq()) && etq.equals(ultimo) && raiz == ultimo)
            {
                encontrado = raiz;
                raiz = null;
                ultimo = null;
                encontrado.setAnt(null);
                encontrado.setSig(null);
            } else
            {
                /**
                 * Si la etq es igual a la raiz entonces encontrado es igual a
                 * la raiz raiz es igual al siguiente elemento raiz anterior
                 * apunta al ultimo elemento ultimo siguiente apunta a la raiz y
                 * finalmente desconectamos a encontrado
                 */
                if (etq.equals(raiz.getEtq()))
                {
                    encontrado = raiz;
                    raiz = raiz.getSig();
                    raiz.setAnt(ultimo);
                    ultimo.setSig(raiz);
                    encontrado.setAnt(null);
                    encontrado.setSig(null);
                } else
                {
                    /**
                     * Preguntamos si la etq es igual al ultimo elemento de ser
                     * así encontrado sera ultimo elemento ultimo sera igual al
                     * elemento que esta antes ultimo siguiente apuntara a la
                     * raiz raiz anterior apuntara de nuevo a ultimo
                     * desconectamos a encontrado
                     */
                    if (etq.equals(ultimo.getEtq()))
                    {
                        encontrado = ultimo;
                        ultimo = ultimo.getAnt();
                        ultimo.setSig(raiz);
                        raiz.setAnt(ultimo);
                        encontrado.setAnt(null);
                        encontrado.setSig(null);
                    } else
                    {
                        /**
                         * Debemos recorrer la lista sin comprometer la posicion
                         * de la raiz para eso nos apoyamos de un auxiliar
                         */
                        NodoL aux = raiz.getSig();
                        while (aux != null)
                        {
                            /**
                             * Si la etq es igual al aux entonces encontrado es
                             * igual al auxiliar creamos dos variables
                             * temporales, siguiente y anterior que obtendran
                             * sus respectivos valores de aux aislamos a
                             * encontrado
                             */
                            if (etq.equals(aux.getEtq()))
                            {
                                encontrado = aux;
                                NodoL siguiente = aux.getSig();
                                NodoL anterior = aux.getAnt();

                                siguiente.setAnt(anterior);
                                anterior.setSig(siguiente);

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
            }
            return encontrado;
        }
    }

    /**
     * Método que busca en la lista circular
     *
     * @param etq la etiqueta del elemento
     * @return NodoL con la etq o Null si no hay nada
     */
    public NodoL buscar(String etq)
    {
        NodoL encontrado = null;
        /**
         * Preguntamos si la raiz es igual a ultimo de ser así volvemos a preguntar
         * si la etq es igual a la raiz de lo contrario no existe el elemento 
         * en dicha lista
         */
        if (raiz == ultimo)
        {
            if (etq.compareTo(raiz.getEtq()) == 0)
            {
                encontrado = raiz;
            }
        } else
        {
            /**
             * Preguntamos si el elemento es igual o mayor a la raiz Preguntamos
             * si el elemento es igual o menor al ultimo
             */
            if (etq.compareTo(raiz.getEtq()) >= 0 && etq.compareTo(ultimo.getEtq()) <= 0)
            {
                /**
                 * Preguntamos si el elemento es igual a la raiz de ser así
                 * encontrado es igual a la raiz
                 */
                if (etq.compareTo(raiz.getEtq()) == 0)
                {
                    encontrado = raiz;
                } else
                {
                    /**
                     * Preguntamos si el elemento es igual al ultimo de ser así
                     * encontrado es igual al ultimo
                     */
                    if (etq.compareTo(ultimo.getEtq()) == 0)
                    {
                        encontrado = ultimo;
                    } else
                    {
                        /**
                         * De no ser igual a la raiz o al ultimo recorremos la
                         * lista apartir del siguiente elemento de raiz pero
                         * antes verificamos que haya algo despues de raiz
                         */
                        NodoL aux = raiz.getSig();
                        for (int i = 0; i < tamanio; i++)
                        {
                            if (aux.getEtq().equals(etq))
                            {
                                encontrado = aux;
                                break;
                            } else
                            {
                                aux = aux.getSig();
                            }
                        }
                    }
                }
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
    public String despConN(NodoL raiz)
    {
        String s = "";
        for (int i = 0; i < tamanio; i++)
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

    /**
     * Método que despliega todo los datos de la lista
     *
     * @param raiz variable que es auxiliar y recibe a la original como copia
     * @return todas las etq
     */
    public String desp(NodoL raiz)
    {
        String s = "";
        for (int i = 0; i < tamanio; i++)
        {
            s += raiz.getEtq();
            raiz = raiz.getSig();
        }
        return s;
    }
}

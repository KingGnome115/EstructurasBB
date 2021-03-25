package TipoListas;

/**
 * Listas Circulares Simple Ligadas el ultimo elemento de la lista apunta al
 * primero por lo cual ningun elemento apuntara nunca a un valor null
 *
 * @author Kevin
 */
public class LCL
{

    private NodoL raiz = null;
    private NodoL ultimo = null;
    private int tamanio = 0;

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
            /**
             * Si es el primer elemento en ser insertado la raiz,ultimo y nuevo
             * entonces todos son iguales y el ultimo apunta a la raiz
             */
            if (raiz == null)
            {
                raiz = ultimo = nuevo;
                ultimo.setSig(raiz);
            } else
            {
                /**
                 * Debemos revisar que el elemento sea menor a la raiz en caso
                 * de ser así entonces el nuevo elemento apuntara al nuevo
                 * elemento y la raiz ahora sera ese elemento y el pasado sera
                 * el ultimo que apuntara a la nueva raiz
                 */
                if (nuevo.getEtq().compareTo(raiz.getEtq()) < 0)
                {
                    nuevo.setSig(raiz);
                    ultimo.setSig(nuevo);
                    raiz = nuevo;
                } else
                {
                    /**
                     * Ahora si el nuevo elemento es mayor al ultimo debemos
                     * hacer al nuevo que apunte a la raiz, el ultimo que se
                     * quedo atras ahora apunta al nuevo y el ultimo sera el
                     * nuevo elemento
                     */
                    if (nuevo.getEtq().compareTo(ultimo.getEtq()) > 0)
                    {
                        nuevo.setSig(raiz);
                        ultimo.setSig(nuevo);
                        ultimo = nuevo;
                    } else
                    {
                        /**
                         * Como el nuevo elemento es mayor a la raiz y menor al
                         * ultimo elemento, debemos insertarlo en medio de la
                         * lista. Esto es porque necesitamos recorrer la lista
                         * pero sin dañar a la raiz por eso creamos la variable
                         * auxiliar
                         */
                        NodoL aux = raiz;
                        /**
                         * Se recorrera la lista hasta encontrar el lugar al que
                         * pertenece o hasta que la lista haya sido revisada por
                         * completo
                         */
                        while (aux.getSig() != null)
                        {
                            /**
                             * Como sabemos que el nuevo elemento no es menor a
                             * la raiz preguntamos si es menor al elemento
                             * siguiente de ser así entonces es más grande que
                             * aux por ende esta en medio así que lo insertamos
                             * entre aux y aux.getSig de lo contrario la aux se
                             * movera al siguiente elemento
                             */
                            if (nuevo.getEtq().compareTo(aux.getSig().getEtq()) < 0)
                            {
                                nuevo.setSig(aux.getSig());
                                aux.setSig(nuevo);
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
             * Preguntamos si la etq sea igual o mayor a la raiz pues de lo
             * contraria dicho elemento no existe en la lista
             */
            if (etq.compareTo(raiz.getEtq()) >= 0)
            {
                /**
                 * Preguntamos si la etq de la raiz es igual a la etq que nos
                 * enviaron, de ser así entonces encontramos el elemento a
                 * eliminar que es el primero en la lista y el encontrado es
                 * igual a la raiz la raiz es igual al elemento que sigue y el
                 * encontrado ya no apunta nadie de lo contrario debemos buscar
                 * en toda la lista
                 */
                if (raiz.getEtq().equals(etq))
                {
                    encontrado = raiz;
                    raiz = raiz.getSig();
                    ultimo.setSig(raiz);
                    encontrado.setSig(null);
                } else
                {
                    /**
                     * Creamos un aux que sea igual a la raiz y una bandera por
                     * si se elimino el elemento
                     */
                    NodoL aux = raiz.getSig();
                    while (aux.getSig() != null)
                    {
                        /**
                         * Como sabemos que la etq es mayor a la raiz
                         * preguntamos si es igual al elemento que le sigue de
                         * ser así encontramos el elemento al cual guardamos en
                         * la primera auxiliar
                         */
                        if (aux.getSig().getEtq().equals(etq))
                        {
                            /**
                             * Preguntamos si la variable es igual al ultimo
                             * elemento de ser así entonces encontrado es igual
                             * a aux siguiente aux siguiente ahora apunta a la
                             * raiz ultimo es ahora aux desconectamos a
                             * encontrado
                             */
                            if (aux.getSig().getEtq().equals(ultimo.getEtq()))
                            {
                                encontrado = aux.getSig();
                                aux.setSig(raiz);
                                ultimo = aux;
                                encontrado.setSig(null);
                            } else
                            {
                                /**
                                 * Como el elemento esta en medio de la lista
                                 * simplemente encontrado es aux sig aux sig es
                                 * el elemento que le sigue a encontrado
                                 * desconectamos a encontrado
                                 */
                                encontrado = aux.getSig();
                                aux.setSig(encontrado.getSig());
                                encontrado.setSig(null);
                            }
                            break;
                        } else
                        {
                            aux = aux.getSig();
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

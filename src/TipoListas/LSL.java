package TipoListas;

/**
 * Clase de Listas Simplemente Ligadas Este tipo de lista es la más sencilla
 * pues solo requiere saber cual elemento es el que sigue
 *
 * @author Kevin
 */
public class LSL
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
                 * Debemos revisar que el elemento sea menor a la raiz en caso
                 * de ser así entonces el nuevo elemento apuntara al nuevo
                 * elemento y la raiz ahora sera ese elemento
                 */
                if (nuevo.getEtq().compareTo(raiz.getEtq()) < 0)
                {
                    nuevo.setSig(raiz);
                    raiz = nuevo;
                } else
                {
                    /**
                     * Esto es porque necesitamos recorrer la lista pero sin
                     * dañar a la raiz por eso creamos la variable auxiliar
                     */
                    NodoL aux = raiz;
                    boolean bandera = true;
                    /**
                     * Se recorrera la lista hasta encontrar el lugar al que
                     * pertenece o hasta que la lista haya sido revisada por
                     * completo
                     */
                    while (aux.getSig() != null && bandera)
                    {
                        /**
                         * Como sabemos que el nuevo elemento no es menor a la
                         * raiz preguntamos si es menor al elemento siguiente de
                         * ser así entonces es más grande que aux por ende esta
                         * en medio así que lo insertamos entre aux y aux.getSig
                         * de lo contrario la aux se movera al siguiente
                         * elemento
                         */
                        if (nuevo.getEtq().compareTo(aux.getSig().getEtq()) < 0)
                        {
                            nuevo.setSig(aux.getSig());
                            aux.setSig(nuevo);
                            bandera = false;
                        } else
                        {
                            aux = aux.getSig();
                        }
                    }
                    /**
                     * Si no se interto nunca en la lista quiere decir que es el
                     * elemento más grande y va al final
                     */
                    if (bandera)
                    {
                        aux.setSig(nuevo);
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
                    encontrado.setSig(null);//<-Se puede quitar y poner despues de ifelse
                } else
                {
                    /**
                     * Creamos un aux que sea igual a la raiz y una bandera por
                     * si se elimino el elemento
                     */
                    NodoL aux = raiz;
                    boolean bandera = true;
                    while (aux.getSig() != null && bandera)
                    {
                        /**
                         * Como sabemos que la etq es mayor a la raiz
                         * preguntamos si es igual al elemento que le sigue de
                         * ser así encontramos el elemento al cual guardamos en
                         * la primera auxiliar
                         */
                        if (aux.getSig().getEtq().equals(etq))
                        {
                            encontrado = aux.getSig();
                            aux.setSig(encontrado.getSig());
                            encontrado.setSig(null);//<-Se puede quitar y poner despues de ifelse
                            bandera = false;
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

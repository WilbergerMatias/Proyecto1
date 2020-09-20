package TDALista;

/**
 * Interface de una posicion que guarda un elemento.
 * @author HP
 *
 * @param <E> objeto generico.
 */
public interface Position<E> {

	/**
	 * Metodo para obtener el elemento guardado de una posicion.
	 * @return E elemento.
	 */
	public E element();
}

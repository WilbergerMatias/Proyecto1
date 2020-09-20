package TDA;

public interface Bag<E> extends Iterable<E> {

	/**
	 * Agrega un elemento a la bolsa
	 * @param elem
	 */
	public void add (E elem);
	/**
	 * nos repsonde si la bolsa esta vacia
	 * @return boolean true si no hay elementos, false en caso contrario
	 */
	public boolean isEmpty();
	/**
	 * nos responde con la cantidad de elementos en la bolsa
	 * @return int cantidad  de elementos de la bolsa
	 */
	public int size();
	/**
	 * elimina un elemento perteneciente a la bolsa
	 * @param elem elemento a ser eliminado
	 */
	public void remove(E elem);
	/**
	 * nos permite saber la cantidad de veces que aparece un elemento en la bolsa
	 * @param elem a ser buscado
	 * @return int cantidad de veces que se encontro el elemento en la bolsa
	 */
	public int getCount(E elem);
}

package TDA;

import EXCEPTIONS.EmptyQueueException;

public interface Queue<E> {

	/**
	 * Metodo que retorna el tamaño de la cola (0 a n)
	 * @return entero (tamaño de la cola).
	 */
	public int size();
	/**
	 * metodo que nos indica si la cola esta vacia
	 * @return True si la cantidad de elementos en la cola es 0. False en caso contrario.
	 */
	public boolean isEmpty();
	/**
	 * Metodo que retorna el elemento en el frente de la cola. Error si la cola esta vacia
	 * @return E elemento
	 * @throws EmptyQueueException
	 */
	public E front() throws EmptyQueueException;
	/**
	 * Metodo que encola un elemento
	 * @param elem de tipo E
	 */
	public void enqueue(E elem);
	/**
	 * Metodo que elimina un elemento de la cola y lo retorna. Error si la cola esta vacia
	 * @return E elemento
	 * @throws EmptyQueueException
	 */
	public E dequeue() throws EmptyQueueException;
}

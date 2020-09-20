package TDALista;

import TDALista.Position;
/**
 * Clase de un nodo con doble enlaze.
 * @author HP
 *
 * @param <E> objeto generico.
 */
public class DNodo<E> implements Position<E> {

	protected DNodo<E> Siguiente, Anterior;
	protected E element;
	
	/**
	 * Constructor de la clase DNodo.
	 * @param elem elemento del nodo.
	 * @param sig nodo siguiente al actual.
	 * @param ant nodo anterior al actual.
	 */
	public DNodo(E elem, DNodo<E> sig,DNodo<E> ant){
		element = elem;
		Siguiente = sig;
		Anterior = ant;
	}
	
	@Override
	public E element() {
		// TODO Auto-generated method stub
		return element;
	}
	
	/**
	 * Metodo para actualizar el elemento guardado en el nodo.
	 * @param elem elemento a reemplazar con el guardado en el nodo.
	 */
	public void setElement(E elem) {
		element = elem;
	}
	
	/**
	 * Metodo para actualizar el nodo siguiente al actual.
	 * @param sig nuevo nodo siguiente.
	 */
	public void setSiguiente(DNodo<E> sig) {
		Siguiente = sig;
	}
	
	/**
	 * Metodo actualizar el nodo anterior al actual.
	 * @param ant nuevo nodo anterior.
	 */
	public void setAnterior(DNodo<E> ant) {
		Anterior = ant;
	}
	
	/**
	 * Metodo para obtener el nodo siguiente al actual.
	 * @return DNodo nodo siguiente.
	 */
	public DNodo<E> getSiguiente(){
		return Siguiente;
	}
	
	/**
	 * Metodo para obtener el nodo anterior al actual.
	 * @return DNodo nodo anterior.
	 */
	public DNodo<E> getAnterior(){
		return Anterior;
	}
}
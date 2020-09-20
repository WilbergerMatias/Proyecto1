package TDA;

import EXCEPTIONS.EmptyStackException;

public interface Stack<E> {
	
	/**
	 * metodo para saber cuantos elementos hay en la pila 
	 * @return entero, cantidad de elementos
	 */
	public int size();
	
	/**
	 * metodo para conocer si la lista tiene auqnue sea un elemento, o si esta vacia
	 * @return boolean, true si la lista esta vacia, false si tiene uno o mas elementos
	 */
	public boolean isEmpty();
	
	/**
	 * metodo para agregar un elemento a la pila
	 * @param elemento a agregar de tipo E (generico)
	 */
	public void push(E elem);
	
	/**
	 * metodo para conocer el elemento en el tope de la pila, error si la pila esta vacai
	 * @return E (generico) elemento de la pila
	 * @throws EmptyStackException si la pila esta vacia
	 */
	public E top()throws EmptyStackException;
	
	/**
	 * elimina el ultimo elemento agregado a la pila (que no haya sido eliminado), error si la pila esta vacia
	 * @return elemento eliminado de la pila
	 * @throws EmptyStackException si la pila esta vacia
	 */
	public E pop()throws EmptyStackException;
}
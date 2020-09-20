package TDA;

import java.util.Iterator;

import EXCEPTIONS.BoundaryViolationException;
import EXCEPTIONS.EmptyListException;
import EXCEPTIONS.InvalidPositionException;

public interface PositionList<E> extends Iterable<E> {
	
	/**
	 * este procedimiento sirve para conocer el tamaño de la lista
	 * @return entero, tamaño de la lista
	 */
	public int size();
	
	/**
	 * este procedimiento nos ayuda a determinar si la lista esta vacia o no
	 * @return boolean verdadero si esta vacia, falso en caso contrario
	 */
	public boolean isEmpty();
	
	/**
	 * nos permite conocer el primer elemento de la lista. Error si la lista esta vacia
	 * @return Position<E> posicion del primer elemento	 
	 * @throws EmptyListException si la lista esta vacia
	 */
	public Position<E> first() throws EmptyListException;
	
	/**
	 *nos permite conocer el ultimo elemento de la lista. Error si la lista esta vacia
	 * @return Position<E> posicion del ultimo elemento
	 * @throws EmptyListException si la lista esta vacia
	 */
	public Position<E> last() throws EmptyListException;
	
	/**
	 * nos permite conocer el elemento previo al pasado por parametro dentro de la lista. error si el elemento es centinela, o si el elemento pertenece a otra lista
	 @param Position<E> posicion p de un elemento de una lista
	 * @return Position<E> posicion del elemento previo
	 * @throws InvalidPositionException si la posicion no pertenece a la lista
	 * @throws BoundaryViolationException si la posicion buscada es un centinela
	 */
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException; //IPE se lanza si recibo la posicion de otra lista, BVE se lanza si se realiza la operacion sobre un sentinela
	
	/**
	 *nos permite conocerl el elemento proximo al pasado por parametro dentro de la lista. error si el elemento es centinela, o si el elemento pertenece a otra lista 
	 *@param Position<E> posicion p de un elemento de una lista
	 * @return Position<E> posicion del elemento proximo
	 * @throws InvalidPositionException si la posicion no pertenece a la lista
	 * @throws BoundaryViolationException si la posicion buscada es un centinela
	 */
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException;
	
	/**
	 * nos permite asignarle el elemento de tipo E a la posicion p de la lista
	 * @param E elemento a setear
	 * @param Position<E> p posicion a cambiar elemento
	 * @return E elemento
	 */
	public E set(Position<E> p, E elem) throws InvalidPositionException;
	
	/**
	 * este metodo agrega un elemento como primer elemento en la lista
	 * @param E elemento a insertar
	 */
	public void addFirst(E elem);
	
	/**
	 * este metodo agrega un elemento como unltimo elemento en la lista
	 * @param E elemento a insertar
	 */
	public void addLast(E elem);
	
	/**
	 * agrega un elemento en la posicion siguiente a la pasada por parametro, con el elemento pasado por parametro
	 * @param Position<E> posicion a buscar
	 * @param E elemento a insertar
	 * @throws InvalidPositionException si la posicion no pertenece a la lista
	 * @throws EmptyListException si la lista es vacia
	 */
	public void addAfter(Position<E> p, E elem) throws InvalidPositionException, EmptyListException;
	
	/**
	 * agrega un elemento en la posicion anterior a la pasada por parametro, con el elemento pasado por parametro
	 * @param Position<E> posicion a buscar
	 * @param E elento a insertar
	 * @throws InvalidPositionException si la posicion no pertenece a la lista
	 * @throws EmptyListException si la lista es vacia
	 */
	public void addBefore(Position<E> p,E elem) throws InvalidPositionException, EmptyListException;
	
	/**
	 * elimina el elemento de la posicion p de la lista
	 * @param Position<E> posicion a buscar y eliminar
	 * @throws InvalidPositionException si la posicion no pertenece a la lista
	 * @return E elemento eliminado de la lista
	 */
	public E remove (Position<E> p) throws InvalidPositionException;
	
	/**
	 * nos devuelve un iterador de la lista
	 * @return Iterator <E> iterador
	 */
	public Iterator<E> iterator();
	
	/**
	 * nos devuelve una coleccion iterable de los elementos de la lista
	 * @return Iterable<Position<E>> coleccion iterable
	 */
	public Iterable<Position<E>> positions();
}

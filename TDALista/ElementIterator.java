package TDALista;
import java.util.*;

import Auxiliares.BoundaryViolationException;
import Auxiliares.EmptyListException;
import Auxiliares.InvalidPositionException;

/**
 * Clase de un iterador de elementos.
 * @author HP
 *
 * @param <E> objeto generico.
 */
public class ElementIterator<E> implements Iterator<E>{

	protected PositionList<E> list;
	protected Position<E> cursor;
	
	/**
	 * Constructor del iterador.
	 * @param l lista a recorrer.
	 */
	public ElementIterator(PositionList<E> l) {
		try {
			list = l;
			if (list.isEmpty()) cursor=null;
			else cursor = list.first();
			} catch (EmptyListException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return cursor!=null;
	}

	@Override
	public E next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (cursor==null) {
			throw new NoSuchElementException("Error: No hay siguiente");
		}
		E toReturn = null;
		try {
			toReturn= cursor.element();
			cursor = (cursor==list.last())?null: list.next(cursor);
			/**
			* Es un if then else que me compara el cursor y si es el ultimo nos da null, en caso contrario cambia
			* al siguiente de cursor.
			*/
			
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BoundaryViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toReturn;
	}
}
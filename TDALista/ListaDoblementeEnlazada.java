package TDALista;

import Auxiliares.BoundaryViolationException;
import Auxiliares.EmptyListException;
import Auxiliares.InvalidPositionException;
import TDALista.Position;
import TDALista.PositionList;
import TDALista.ElementIterator;

/**
 * Clase ListaDoblementeEnlazada, modela una lista con criterio de enlace doble.
 * @author HP
 *
 * @param <E> objeto generico.
 */
public class ListaDoblementeEnlazada<E> implements PositionList<E> {

	protected DNodo<E> header, trailer;
	protected int size;
	
	/**
	 * Constructor de una lista con doble enlace.
	 */
	public ListaDoblementeEnlazada() {
		header = new DNodo<E> (null,null,null);
		trailer = new DNodo<E> (null,null, header);
		header.setSiguiente(trailer);
		size = 0;
	}
	/**
	 * Metodo para clonar una lista.
	 * @return PositionList nueva lista identica a la actual.
	 */
	public PositionList<E> clone (){
		PositionList<E>TR = new ListaDoblementeEnlazada<E>();
		DNodo<E> p = header.getSiguiente();
		while (p!= trailer) {
			TR.addLast(p.element());
			p = p.getSiguiente();
		}
		return TR;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public Position<E> first() throws EmptyListException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new EmptyListException ("operacion 'first' de lista vacia");
		return header.getSiguiente();
	}

	@Override
	public Position<E> last() throws EmptyListException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new EmptyListException ("operacion 'last' de lista vacia");
		return trailer.getAnterior();
	}

	@Override
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new InvalidPositionException ("La lista esta vacia");
		DNodo<E> aux = checkPosition(p);
		try {
			if (aux.equals(first())) throw new BoundaryViolationException ("No se puede realizar la operacion 'prev' del nodo cabecera");
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aux.getAnterior();
	}

	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new InvalidPositionException ("La lista esta vacia");
		DNodo<E> aux = checkPosition(p);
		try {
			if (aux==last()) throw new BoundaryViolationException ("No se puede realizar la operacion 'next' del nodo centinela");
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  aux.getSiguiente();
	}

	@Override
	public E set(Position<E> p, E elem) throws InvalidPositionException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new InvalidPositionException ("La lista esta vacia");
		E ret=null;
		DNodo<E> aux = checkPosition(p);
		ret = aux.element;
		aux.setElement(elem);
		return ret;
	}

	@Override
	public void addFirst(E elem) {
		// TODO Auto-generated method stub
		DNodo<E> aux = header.getSiguiente();
		header.setSiguiente (new DNodo<E>(elem,aux,header));
		aux.setAnterior(header.getSiguiente());
		size++;
	}

	@Override
	public void addLast(E elem) {
		// TODO Auto-generated method stub
		DNodo<E> aux = trailer.getAnterior();
		trailer.setAnterior (new DNodo<E>(elem,trailer,aux));
		aux.setSiguiente(trailer.getAnterior());
		size++;
	}

	@Override
	public void addAfter(Position<E> p, E elem) throws InvalidPositionException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new InvalidPositionException("La lista esta vacia (addAfter)");
		DNodo<E> ant = checkPosition (p);
		DNodo<E> sig = ant.getSiguiente();
		DNodo<E> nu = new DNodo<E> (elem,sig,ant);
		ant.setSiguiente (nu);
		sig.setAnterior(nu);
		size++;
	}

	@Override
	public void addBefore(Position<E> p, E elem) throws InvalidPositionException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new InvalidPositionException("La lista esta vacia (addBefore)");
		DNodo<E> sig = checkPosition (p);
		DNodo<E> ant = sig.getAnterior();
		DNodo<E> nu = new DNodo<E> (elem,sig,ant);
		sig.setAnterior (nu);
		ant.setSiguiente(nu);
		size++;
	}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		// TODO Auto-generated method stub
		if (isEmpty()) throw new InvalidPositionException ("operacion 'remove' de lista vacia");
		DNodo<E> n = checkPosition (p);
		E aux = n.element();
		n.getAnterior().setSiguiente(n.getSiguiente());
		n.getSiguiente().setAnterior(n.getAnterior());
		size--;
		return aux;
	}
	
	/**
	 * Metodo auxiliar para analizar la validez una posicion dada.
	 * @param p posicion a ser analizada.
	 * @return DNodo la posicion como nodo.
	 * @throws InvalidPositionException en el caso de que la posicion dada sea invalida (posicion nula, una posicion que no es nodo, o un nodo centinela).
	 */
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		try {
			if (p==null||p.equals(header)||p.equals(trailer)) 
				throw new InvalidPositionException ("La posicion es nula");
			return (DNodo<E>) p; 
		} catch(ClassCastException e) {
			throw new InvalidPositionException ("Posicion invalida (no es una posicion)");
		}
	}

	@Override
	public ElementIterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ElementIterator<E> (this);
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		PositionList<Position<E>> iterable = new ListaDoblementeEnlazada<Position<E>>();
		DNodo<E> aux = header.getSiguiente();	
		while (!(aux.equals(trailer))) {
			iterable.addLast(aux);
			aux = aux.getSiguiente();
		}
		return iterable;
	}
}
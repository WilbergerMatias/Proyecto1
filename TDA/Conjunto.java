package TDA;

import java.util.Iterator;

public interface Conjunto<E> extends java.lang.Iterable<E>{
	
	public void insert(E elem);
	public void delete (E elem);
	public boolean member (E elem);
	public PositionList<E> intersection(Conjunto<E> S);
	public PositionList<E> union (Conjunto<E> S);
	public PositionList<E> complement(); /* SOLAMENTE SE PUEDE REALIZAR SI TENEMOS CONJUNTO UNIVERSAL, SI HAY UN CONJUNTO S FINITO Y ESTE ES EL UNIVERSAL*/
	public Iterator<E> iterator();
}

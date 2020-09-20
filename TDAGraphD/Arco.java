package TDAGraphD;

import TDALista.Position;

public class Arco<V, E> implements Edge<E> {

	public E element;
	public Position<Edge<E>> PosEnLista;
	public Vertex<V> v1,v2;
	
	
	public Arco (E element, Vertex<V> v, Vertex<V> w ) {
		this.element = element;
		v1 = v;
		v2 = w;
	}
	
	@Override
	public E element() {
		// TODO Auto-generated method stub
		return element;
	}
	
	public Position<Edge<E>> getPosicionEnLista(){
		return PosEnLista;
	}

	public void setPosicionEnLista(Position<Edge<E>> p) {
		PosEnLista = p;
	}
	
	public Vertex<V> getV1(){
		return v1;
	}
	
	public Vertex<V> getV2(){
		return v2;
	}
	
}

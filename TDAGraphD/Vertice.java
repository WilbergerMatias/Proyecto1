package TDAGraphD;

import TDALista.Position;
import TDAMapeo.MapeoconHashAbierto;

public class Vertice<V> extends MapeoconHashAbierto<Object,Object> implements Vertex<V> {

	public V element;
	public Position<Vertex<V>> PosEnLista;
	
	public Vertice(V element, Position<Vertex<V>> P) {
		this.element = element;
		PosEnLista = P;
	}
	
	@Override
	public V element() {
		// TODO Auto-generated method stub
		return element;
	}
	
	public void setElement(V x) {
		element = x;
	}
	
	public Position<Vertex<V>> getPosicionenLista(){
		return PosEnLista;
	}
	
	public void setPosicionenLista(Position<Vertex<V>> position) {
		PosEnLista = position;
	}
}

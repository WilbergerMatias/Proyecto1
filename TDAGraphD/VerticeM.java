package TDAGraphD;

import TDALista.Position;
import TDAMapeo.MapeoconHashAbierto;

public class VerticeM<V> extends MapeoconHashAbierto<Object,Object> implements Vertex<V> {

	public V element;
	public Position<Vertex<V>> PosEnLista;
	public int Indice;
	
	public VerticeM (V element, int indice) {
		this.element = element;
		Indice = indice;
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
	
	public int getIndice() {
		return Indice;
	}
	
	public void setIndice(int n) {
		Indice = n;
	}
}

package TDAGraphD;

import TDALista.ListaDoblementeEnlazada;
import TDALista.Position;
import TDALista.PositionList;
import TDAMapeo.MapeoconHashAbierto;

public class VerticeD<V, E> extends MapeoconHashAbierto<Object,Object> implements Vertex<V> {

	
	public V element;
	public boolean visitado;
	public PositionList<Edge<E>> adyacentes;
	public Position<VerticeD<V,E>> posicionEnNodos;    
	
	@Override
	public V element() {
		return element;
	}
	
	public VerticeD ( V rotulo ) {
		this.element = rotulo;  
		adyacentes = new ListaDoblementeEnlazada<Edge<E>>();
		}
 
	public void setRotulo(V nuevoRotulo) {
		element = nuevoRotulo;
	}
	
	public PositionList<Edge<E>> getAdyacentes() {
		return adyacentes;
	} 
	
	public void setPosicionEnNodos(Position<VerticeD<V,E>> p ) { 
		posicionEnNodos = p;
	} 
	
	public Position<VerticeD<V,E>> getPosicionEnNodos() {
		return posicionEnNodos;	
	} 
	
	public void setEstado (boolean b) {
		visitado = b;
	}
	
	public boolean getEstado() {
		return visitado;
	}
} 
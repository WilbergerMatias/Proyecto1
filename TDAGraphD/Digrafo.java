package TDAGraphD;

import Auxiliares.EmptyListException;
import Auxiliares.InvalidPositionException;
import EXCEPTIONS.InvalidEdgeException;
import EXCEPTIONS.InvalidVertexException;
import TDALista.ListaDoblementeEnlazada;
import TDALista.Position;
import TDALista.PositionList;

public class Digrafo<V,E> implements GraphD<V,E>  { 
	
	protected PositionList<VerticeD<V,E>> nodos;
	
	public Digrafo()  {
		nodos = new ListaDoblementeEnlazada<VerticeD<V,E>>(); 
	} 
	
	@Override
	public Iterable<Vertex<V>> vertices() { 
		PositionList<Vertex<V>> lista = new ListaDoblementeEnlazada<Vertex<V>>();
		for(Vertex<V> v : nodos)
			lista.addLast(v);
		return lista;
	} 

	@Override
	public Iterable<Edge<E>> edges() {
		PositionList<Edge<E>> lista = new ListaDoblementeEnlazada<Edge<E>>();  
		for( Vertex<V> v : nodos ) 
			for( Edge<E> e : emergentEdges(v))
				lista.addLast(e); 
		return lista;
    } 

	@SuppressWarnings("unchecked")
	public Iterable<Edge<E>> emergentEdges( Vertex<V> v) {
		PositionList<Edge<E>> lista = new ListaDoblementeEnlazada<Edge<E>>();
		VerticeD<V,E> vert = (VerticeD<V,E>) v;
		for( Edge<E> e : vert.getAdyacentes())
			lista.addLast(e); 
		return lista;
	} 

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException {
		if (v == null)
			throw new InvalidVertexException("El vertice es invalido.");
		PositionList<Edge<E>> TR = new ListaDoblementeEnlazada<Edge<E>>();
		for( Edge<E> e : edges()) {
			Arco<V,E> ee = (Arco<V,E>)e;
			if (ee.v2==v || ee.v1==v)
				TR.addLast(e);
		}
		return TR;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidVertexException, InvalidEdgeException {
		// TODO Auto-generated method stub
		if (e==null)
			throw new InvalidEdgeException("El arco pasado por parametro es invalido.");
		if (v==null)
			throw new InvalidVertexException("El vertice pasado por parametro es invalido.");
		Arco<V,E> ee = (Arco)e;
		Vertex<V> aux = ee.v1;
		Vertex<V> aux2 = ee.v2;
		if (v!=aux && v!= aux2)
			throw new InvalidEdgeException("El Arco dado no posee el vertice pasado por parametro.");
		if (v==aux)
			return aux2;
		else
			return aux;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vertex<V>[] endvertices(Edge<E> e) throws InvalidEdgeException {
		// TODO Auto-generated method stub
		if (e==null)
			throw new InvalidEdgeException("El arco pasado por parametro es invalido.");
		Vertex<V> [] TR = (Vertex<V>[]) new Vertex[2];
		Arco<V,E> ee = (Arco<V, E>)e;
		TR[0] = ee.v1;
		TR[1] =	ee.v2;	
		return TR;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) throws InvalidVertexException {
		if (v==null||w==null)
			throw new InvalidVertexException ("Los vertices pasados por parametro son invalidos.");
		VerticeD<V,E> vv = (VerticeD<V,E>)v;
		VerticeD<V,E> ww = (VerticeD<V,E>)w;
		for (Edge<E> e: vv.getAdyacentes()) {
			Arco <V,E> ee = (Arco<V,E>)e;
			if (ee.v1.equals(v) && ee.v2.equals(w))
				return true;
		}
		for (Edge<E> e: ww.getAdyacentes()) {
			Arco <V,E> ee = (Arco<V,E>)e;
			if (ee.v2.equals(v) && ee.v1.equals(w))
				return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V replace(Vertex<V> v, V x) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v==null)
			throw new InvalidVertexException("El vertice es invalido.");
		VerticeD<V,E> vv = (VerticeD<V,E>)v;
		V TR = vv.element;
		vv.setRotulo(x);
		return TR;
	}

	@Override
	public Vertex<V> insertVertex(V x) {
		VerticeD<V,E> v = new VerticeD<V,E>(x);
		nodos.addLast(v); 
		try {
			v.setPosicionEnNodos(nodos.last());
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return v;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E e) throws InvalidVertexException {
		if (v == null || w == null)
			throw new InvalidVertexException ("Los vertices pasados por parametro no son validos.");
		VerticeD<V,E> vv = (VerticeD<V,E>) v;
		VerticeD<V,E> ww = (VerticeD<V,E>) w;
		Arco<V,E> arco = new Arco<V,E>( e, vv, ww );
		vv.getAdyacentes().addLast(arco);
		try {
			arco.setPosicionEnLista(vv.getAdyacentes().last());
		} catch (EmptyListException e1) {
			 // TODO Auto-generated catch block
			 e1.printStackTrace();
		}
		return arco;
	}


	@SuppressWarnings("unchecked")
	@Override
	public V removeVertex(Vertex<V> v) throws InvalidVertexException {
		if (v == null)
			throw new InvalidVertexException ("El vertice es invalido.");
		V TR = null;
		try {
			Position<VerticeD<V,E>> pos = ((VerticeD<V,E>) v).getPosicionEnNodos();
			TR = nodos.remove(pos).element();
		} catch(InvalidPositionException e) {
			e.printStackTrace(); 
		}
		return TR;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public E removeEdge(Edge<E> e) throws InvalidEdgeException {
		if (e==null)
			throw new InvalidEdgeException("El arco pasado por parametro es invalido.");
		try {
			Arco<V,E> ee = (Arco<V,E>) e;
			Position<Edge<E>> pee = ee.getPosicionEnLista();
			VerticeD<V,E> pred = (VerticeD)ee.v1;
			return pred.getAdyacentes().remove(pee).element();
		} catch(InvalidPositionException e1) {
			e1.printStackTrace();
		return null;  
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Edge<E>> succesorEdges(Vertex<V> v) throws InvalidVertexException {
		if (v==null)
			throw new InvalidVertexException("El vertice es invalido");
		PositionList<Edge<E>> lista = new ListaDoblementeEnlazada<Edge<E>>();
		VerticeD<V,E> vert = (VerticeD<V,E>) v;
		for( Edge<E> e : vert.getAdyacentes())
			lista.addLast(e); 
		return lista;
	}
}

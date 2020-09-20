package TDAGraphD;

import Auxiliares.EmptyListException;
import Auxiliares.InvalidPositionException;
import EXCEPTIONS.InvalidEdgeException;
import EXCEPTIONS.InvalidVertexException;
import TDALista.ListaDoblementeEnlazada;
import TDALista.PositionList;

public class GrafoND<V,E> implements Graph<V,E> {

	PositionList <Vertex<V>> vertices;
	PositionList <Edge<E>> arcos;
	
	public GrafoND () {
		vertices = new ListaDoblementeEnlazada<Vertex<V>>();
		arcos = new ListaDoblementeEnlazada<Edge<E>>();
	}
	
	@Override
	public Iterable<Vertex<V>> vertices() {
		// TODO Auto-generated method stub
		PositionList <Vertex<V>> TR = new ListaDoblementeEnlazada<Vertex<V>>();
		for (Vertex<V> v: vertices)
			TR.addLast(v);
		return TR;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		// TODO Auto-generated method stub
		PositionList <Edge<E>> TR = new ListaDoblementeEnlazada<Edge<E>>();
		for (Edge<E> e: arcos)
			TR.addLast(e);
		return TR;
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidVertexException, InvalidEdgeException {
		// TODO Auto-generated method stub
		if (e==null)
			throw new InvalidEdgeException("El arco pasado por parametro es invalido.");
		if (v==null)
			throw new InvalidVertexException("El vertice pasado por parametro es invalido.");
		Arco<V,E> ee = (Arco<V,E>)e;
		Vertex<V> aux = ee.v1;
		Vertex<V> aux2 = ee.v2;
		if (v!=aux && v!= aux2)
			throw new InvalidEdgeException("El Arco dado no posee el vertice pasado por parametro.");
		if (v==aux)
			return aux2;
		else
			return aux;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public Vertex<V>[] endvertices(Edge<E> e) throws InvalidEdgeException {
		// TODO Auto-generated method stub
		if (e==null)
			throw new InvalidEdgeException("El arco pasado por parametro es invalido.");
		Vertex<V> [] TR = (Vertex<V>[]) new Vertex[2];
		Arco<V,E> ee = (Arco<V,E>)e;
		TR[0] = ee.v1;
		TR[1] =	ee.v2;	
		return TR;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v==null||w==null)
			throw new InvalidVertexException ("Los vertices pasados por parametro son invalidos.");
		for (Edge<E> e: arcos) {
			Arco <V,E> ee = (Arco<V,E>)e;
			if ((ee.v1.equals(v) && ee.v2.equals(w))||(ee.v1.equals(w) && ee.v2.equals(v)))
				return true;
		}
		return false;
	}

	@Override
	public V replace(Vertex<V> v, V x) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if(v==null)
			throw new InvalidVertexException("El vertice pasado por parametro es invalido.");
		Vertice<V> vv = (Vertice<V>)v;
		V TR = vv.element();
		vv.setElement(x);
		return TR;
	}

	@Override
	public Vertex<V> insertVertex(V x) {
		// TODO Auto-generated method stub
		Vertice<V> v = new Vertice<V>(x, null);
		vertices.addLast(v);
		try {
			v.setPosicionenLista(vertices.last());
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E e) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v==null||w==null)
			throw new InvalidVertexException("Los vertices pasados por parametro son invalidos.");
		Arco<V,E> a = new Arco<V,E> (e, v, w);
		arcos.addLast(a);
		Edge<E> TR = null;
		try {
			TR = arcos.last().element();
			a.setPosicionEnLista(arcos.last());
		} catch (EmptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return TR;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public V removeVertex(Vertex<V> v) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v==null)
			throw new InvalidVertexException("El vertice no es valido.");
		Vertice<V> vv = (Vertice<V>)v;
		V TR = vv.element();
		for (Edge<E> e: arcos) {
			Arco<V,E> ee = (Arco<V,E>)e;
			if (ee.v1==v||ee.v2==v)
				try {
					removeEdge(e);
				} catch (InvalidEdgeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		try {
			vertices.remove(vv.getPosicionenLista());
		} catch (InvalidPositionException e1) {
			// TODO Auto-generated catch block
			throw new InvalidVertexException("El vertice no esta en la lista del grafo.");
		}
		vv.setPosicionenLista(null);
		return TR;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public E removeEdge(Edge<E> e) throws InvalidEdgeException {
		// TODO Auto-generated method stub
		if (e==null)
			throw new InvalidEdgeException ("El arco dado no es valido.");
		Arco<V,E> ee = (Arco<V,E>)e;
		try {
			arcos.remove(ee.getPosicionEnLista());
		} catch (InvalidPositionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ee.setPosicionEnLista(null);
		return ee.element();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v==null)
			throw new InvalidVertexException ("El vertice pasado por parametro es nulo.");
		PositionList<Edge<E>> TR = new ListaDoblementeEnlazada<Edge<E>>();
		for (Edge<E> e:arcos) {
			Arco<V,E> ee = (Arco<V,E>)e;
			if (ee.v1==v||ee.v2==v)
				TR.addLast(e);
		}
		return TR;
	}
}

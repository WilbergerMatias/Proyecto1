package TDAGraphD;

import Auxiliares.EmptyListException;
import Auxiliares.InvalidPositionException;
import EXCEPTIONS.InvalidEdgeException;
import EXCEPTIONS.InvalidVertexException;
import TDALista.ListaDoblementeEnlazada;
import TDALista.PositionList;

public class GrafoConMatriz<V,E> implements Graph<V,E>{

	
	public PositionList<Vertex<V>> vertices;
	public PositionList<Edge<E>> arcos;
	public int cant;
	public Edge<E>[][] matriz; 
	private int TOPE;
	
	@SuppressWarnings("unchecked")
	public GrafoConMatriz() {
		cant=0;
		TOPE = 100;
		vertices = new ListaDoblementeEnlazada<Vertex<V>>();
		arcos = new ListaDoblementeEnlazada<Edge<E>>();
		matriz = (Edge<E>[][]) new Arco[TOPE][TOPE]; 
	}
	
	@Override
	public Iterable<Vertex<V>> vertices() {
		// TODO Auto-generated method stub
		PositionList <Vertex<V>> vertices = new ListaDoblementeEnlazada<Vertex<V>>();
		for (Vertex<V> v:this.vertices)
			vertices.addLast(v);
		return vertices;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		// TODO Auto-generated method stub
		PositionList <Edge<E>> arcos = new ListaDoblementeEnlazada<Edge<E>>();
		for (Edge<E> v:this.arcos)
			arcos.addLast(v);
		return arcos;
	}

	@Override
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v==null)
			throw new InvalidVertexException("El vertice es nulo.");
		VerticeM<V> vv = (VerticeM<V>)v;
		PositionList<Edge<E>> TR = new ListaDoblementeEnlazada<Edge<E>>();
		int fil = vv.getIndice();
		for (int col = 0; col<cant;col++)
			if (matriz [fil][col]!=null)
				TR.addLast(matriz[fil][col]);
		return TR;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidVertexException, InvalidEdgeException {
		// TODO Auto-generated method stub
		if (v == null)
			throw new InvalidVertexException("Vertice nulo.");
		if (e == null)
			throw new InvalidEdgeException("Arco nulo.");
		Arco<V,E> ee = (Arco<V,E>)e;
		if (ee.getV1()==v)
			return ee.getV2();
		else
			if (ee.getV2()==v)
				return ee.getV1();
			else
				throw new InvalidEdgeException("Arco corrupto");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vertex<V>[] endvertices(Edge<E> e) throws InvalidEdgeException {
		// TODO Auto-generated method stub
		Vertex<V>[] TR = (Vertex[]) new Vertex[2];
		if (e==null)
			throw new InvalidEdgeException ("Arco nulo");
		Arco<V,E> ee = (Arco<V,E>)e;
		TR[0] = ee.getV1();
		TR[1] = ee.getV2();
		return TR;
	}

	@Override
	public boolean areAdjacent(Vertex<V> v, Vertex<V> w) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v==null||w==null)
			throw new InvalidVertexException("Uno de los vertices o ambos, es/son nulo/s");
		VerticeM<V> vv = (VerticeM<V>)v;
		VerticeM<V> ww = (VerticeM<V>)w;
		return matriz[vv.getIndice()][ww.getIndice()]!=null;
	}

	@Override
	public V replace(Vertex<V> v, V x) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v == null)
			throw new InvalidVertexException("Vertice nulo");
		VerticeM<V>vv = (VerticeM<V>)v;
		V TR = vv.element();
		vv.setElement(x);
		return TR;
	}

	@Override
	public Vertex<V> insertVertex(V x) {
		// TODO Auto-generated method stub
		if (cant>=TOPE)
			resize();
		VerticeM<V> v = new VerticeM<V> (x,cant++);
		vertices.addLast(v);
		try {
			v.setPosicionenLista(vertices.last());
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		// TODO Auto-generated method stub
		TOPE = 2*cant;
		Edge<E>[][] nuevo = (Edge<E>[][]) new Arco[TOPE][TOPE];
		for (int i = 0;i<cant;i++) 
			for (int c = 0;c<=cant;c++) {
				nuevo[i][c] = matriz[i][c];
			}
		matriz = nuevo;
	}

	@Override
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E e) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v==null||w==null)
			throw new InvalidVertexException("Uno de los vertices pasados por parametro es invalido");
		Arco<V,E> a = new Arco<V,E>(e,v,w);
		VerticeM<V> vv = (VerticeM<V>)v;
		VerticeM<V> ww = (VerticeM<V>)w;
		int fil = vv.getIndice();
		int col = ww.getIndice();
		matriz[fil][col] = matriz[col][fil] = a;
		arcos.addLast(a);
		try {
			a.setPosicionEnLista(arcos.last());
		} catch (EmptyListException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return a;
	}

	@Override
	public V removeVertex(Vertex<V> v) throws InvalidVertexException {
		// TODO Auto-generated method stub
		if (v==null)
			throw new InvalidVertexException("Vertice invalido.");
		VerticeM<V> vv =(VerticeM<V>)v;
		int fil = vv.getIndice();
		for (int col = 0; col<cant;col++) {
			Edge<E> e = matriz[fil][col];
			if (e!=null)
				try {
					removeEdge(e);
				} catch (InvalidEdgeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		try {
			vertices.remove(vv.getPosicionenLista());
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vv.element();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E removeEdge(Edge<E> e) throws InvalidEdgeException {
		// TODO Auto-generated method stub
		if (e==null)
			throw new InvalidEdgeException("El arco es nulo.");
		Arco<V,E> ee = (Arco<V,E>)e;
		VerticeM<V> v = (VerticeM<V>)ee.getV1();
		VerticeM<V> w = (VerticeM<V>)ee.getV2();
		int fil = v.getIndice();
		int col = w.getIndice();
		matriz[fil][col] = matriz[col][fil] = null;
		try {
			arcos.remove(ee.PosEnLista);
		} catch (InvalidPositionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ee.element();
	}
}

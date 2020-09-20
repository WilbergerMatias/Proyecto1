package grafodirigidonopesado;

import EXCEPTIONS.InvalidEdgeException;
import EXCEPTIONS.InvalidVertexException;
import TDAGraphD.Arco;
import TDAGraphD.Edge;
import TDAGraphD.Vertex;
import TDAGraphD.VerticeD;
import Auxiliares.EmptyListException;
import Auxiliares.InvalidPositionException;
import TDALista.ListaDoblementeEnlazada;
import TDALista.Position;
import TDALista.PositionList;
import java.util.logging.*;

public class GrafoDirigidoNoPesado<Integer, Boolean> implements GraphD<Integer, Boolean> {

	protected PositionList<VerticeD<Integer,Boolean>> nodos;
	private static Logger logger;
	
	public GrafoDirigidoNoPesado() {
		nodos = new ListaDoblementeEnlazada<VerticeD<Integer,Boolean>>();
		if (logger == null) {
			
			logger = logger.getLogger(GrafoDirigidoNoPesado.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.INFO);
			
			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);				
			}
		}
	}
	
	public void addNode(int Node) {
		boolean encontre = false;
		java.lang.Integer e = Node;
		VerticeD <Integer, Boolean> v = new VerticeD <Integer, Boolean>((Integer) e);
		for (VerticeD<Integer,Boolean> v1 : nodos) {
			if (v1.element.equals(e))
				encontre = true;
		}
		if (encontre)
			logger.warning("El elemento a insertar: "+ Node + " ya se ha insertado previamente en el grafo.");
		else {
			nodos.addLast(v);
			logger.info("El elemento a insertar: "+ Node + " fue insertado en el grafo.");
			try {
				v.setPosicionEnNodos(nodos.last());
			} catch (EmptyListException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}
	
	public void addEdge(int Node1, int Node2) {
		boolean encontre1 = false;
		boolean encontre2 = false;
		java.lang.Integer e1 = Node1;
		java.lang.Integer e2 = Node2;
		Vertex <Integer> v1 = new VerticeD <Integer, Boolean>((Integer) e1);
		Vertex <Integer> v2 = new VerticeD <Integer, Boolean>((Integer) e2);
		for (VerticeD<Integer,Boolean> v : nodos) {
			if (v.element.equals(e1)) {
				encontre1 = true;
				v1 = v;
				logger.info("El vertice con nodo" + Node1 + " se encontro.");
			}
			if (v.element.equals(e2)) {
				encontre2 = true;
				v2 = v;
				logger.info("El vertice con nodo" + Node2 + " se encontro.");
			}
		}
		if (!encontre1 || !encontre2)
			logger.warning("Uno o ambos de los vertices/nodos del nuevo arco a insertar, no habian sido insertados como vertices previamente.");
		else {
			boolean encontreArco = false;
			for (Edge<Boolean> E : ((VerticeD<Integer, Boolean>) v1).getAdyacentes()) {
				Arco<Integer,Boolean> EE = (Arco<Integer, Boolean>) E;
				if (EE.getV1().equals(v1) && EE.getV2().equals(v2))
					encontreArco = true;
			}
			if(!encontreArco) {
				java.lang.Boolean b = false;
				Arco <Integer, Boolean> A = new Arco<Integer, Boolean>((Boolean)b, v1,v2);
				((VerticeD<Integer, Boolean>) v1).getAdyacentes().addLast(A);
				try {
					A.setPosicionEnLista(((VerticeD<Integer, Boolean>) v1).getAdyacentes().last());
				} catch (EmptyListException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logger.info("Se inserto un nuevo arco con vertices: "+Node1+ " y " +Node2);
			}
			else
				logger.warning("No se inserto el arco, con vertices: "+ Node1 + " y " + Node2 +" porque este ya se encontraba insertado.");
		}
	}
	
	public void removeNode(int Node){
		for (VerticeD<Integer,Boolean> v: nodos) {
			if(v.element().equals(Node))
				try {
					nodos.remove(v.getPosicionEnNodos());
				} catch (InvalidPositionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void removeEdge(int Node1, int Node2) {
		boolean encontre1 = false;
		boolean encontre2 = false;
		java.lang.Integer e1 = Node1;
		java.lang.Integer e2 = Node2;
		Vertex <Integer> v1 = new VerticeD <Integer, Boolean>((Integer) e1);
		Vertex <Integer> v2 = new VerticeD <Integer, Boolean>((Integer) e2);
		for (VerticeD<Integer,Boolean> v : nodos) {
			if (v.element.equals(e1)) {
				encontre1 = true;
				v1 = v;
			}
			if (v.element.equals(e2)) {
				encontre2 = true;
				v2 = v;
			}
		}
		if (!encontre1 || !encontre2)
			logger.warning("No existe en la estructura, uno de los siguientes nodos: "+ Node1 + " o " + Node2);
		else {
			boolean encontreArco = false;
			for (Edge<Boolean> E : ((VerticeD<Integer, Boolean>) v1).getAdyacentes()) {
				Arco<Integer,Boolean> EE = (Arco<Integer, Boolean>) E;
				if (EE.getV1().equals(v1) && EE.getV2().equals(v2))
					encontreArco = true;
			}
			if(!encontreArco) {
				java.lang.Boolean b = false;
				((VerticeD<Integer, Boolean>) v1).getAdyacentes().addLast(new Arco<Integer, Boolean>((Boolean)b, v1,v2));
				logger.warning("No se encontro el arco, con vertices: "+ Node1 + " y " + Node2 +" en la estructura.");
			}
			else
				logger.info("Se elimino el arco con vertices: "+Node1+ " y " +Node2);
		}
	}
	

	
		
		public Iterable<Edge<Boolean>> emergentEdges( Vertex<Integer> v) {
			PositionList<Edge<Boolean>> lista = new ListaDoblementeEnlazada<Edge<Boolean>>();
			VerticeD<Integer,Boolean> vert = (VerticeD<Integer,Boolean>) v;
			for( Edge<Boolean> e : vert.getAdyacentes())
				lista.addLast(e); 
			return lista;
		}

		@Override
		public Iterable<grafodirigidonopesado.Vertex<Integer>> vertices() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<grafodirigidonopesado.Edge<Boolean>> incidentEdges(grafodirigidonopesado.Vertex<Integer> v)
				throws InvalidVertexException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<grafodirigidonopesado.Edge<Boolean>> succesorEdges(grafodirigidonopesado.Vertex<Integer> v)
				throws InvalidVertexException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public grafodirigidonopesado.Vertex<Integer> opposite(grafodirigidonopesado.Vertex<Integer> v,
				grafodirigidonopesado.Edge<Boolean> e) throws InvalidVertexException, InvalidEdgeException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public grafodirigidonopesado.Vertex<Integer>[] endvertices(grafodirigidonopesado.Edge<Boolean> e)
				throws InvalidEdgeException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean areAdjacent(grafodirigidonopesado.Vertex<Integer> v, grafodirigidonopesado.Vertex<Integer> w)
				throws InvalidVertexException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Integer replace(grafodirigidonopesado.Vertex<Integer> v, Integer x) throws InvalidVertexException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public grafodirigidonopesado.Vertex<Integer> insertVertex(Integer x) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public grafodirigidonopesado.Edge<Boolean> insertEdge(grafodirigidonopesado.Vertex<Integer> v,
				grafodirigidonopesado.Vertex<Integer> w, Boolean e) throws InvalidVertexException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Integer removeVertex(grafodirigidonopesado.Vertex<Integer> v) throws InvalidVertexException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean removeEdge(grafodirigidonopesado.Edge<Boolean> e) throws InvalidEdgeException {
			// TODO Auto-generated method stub
			return null;
		} 
		
		@Override
		public Iterable<grafodirigidonopesado.Edge<Boolean>> edges() {
			PositionList<Edge<Boolean>> lista = new ListaDoblementeEnlazada<Edge<Boolean>>();  
			for( VerticeD<Integer,Boolean> v : nodos ) 
				for( Edge<Boolean> e : emergentEdges(v))
					lista.addLast(e); 
			return null;
		}
		
}

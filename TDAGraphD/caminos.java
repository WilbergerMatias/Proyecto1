package TDAGraphD;

import java.util.Iterator;

import Auxiliares.EmptyListException;
import Auxiliares.InvalidKeyException;
import Auxiliares.InvalidPositionException;
import EXCEPTIONS.InvalidEdgeException;
import EXCEPTIONS.InvalidVertexException;
import TDALista.ListaDoblementeEnlazada;
import TDALista.PositionList;

public class caminos<V, E> {
	
	private final Object ESTADO = new Object();
	private final Object VISITADO = new Object();
	private final Object NOVISITADO = new Object();
	
	public boolean hallarCamino(Graph<V,E> G, Vertex<V> origen, VerticeD<V,E> destino) {
		for (Vertex<V> v: G.vertices()) {
			try {
				v.put(ESTADO, NOVISITADO);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PositionList <Vertex<V>> camino = new ListaDoblementeEnlazada<Vertex<V>>();
		return hallarCaminoAux(G, origen, destino, camino);
	}
	
	private boolean hallarCaminoAux(Graph<V,E> G, Vertex<V> origen, Vertex<V> destino, PositionList <Vertex<V>> camino) {
		boolean encontre;
		try {
			origen.put(ESTADO, VISITADO);
		} catch (InvalidKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		camino.addLast(origen);
		if (origen == destino)
			return true;
		else
			try {
				for (Edge<E> e : G.incidentEdges(origen)) {
					Vertex<V> v = G.opposite(origen, e);
					if (v.get(ESTADO)==NOVISITADO) {
						encontre = hallarCaminoAux( G, v, destino, camino );
						if (encontre) {
							return true;
						}
					}
				}
			} catch (InvalidVertexException | InvalidEdgeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			camino.remove(camino.last());
		} catch (InvalidPositionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void hallarCiclo (Graph<V,E> G, Vertex<V> v, PositionList<Vertex<V>> ciclo) {
		for (Vertex<V> ver: G.vertices()) {
			try {
				ver.put(ESTADO, NOVISITADO);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		boolean encontre = false;
		try {
		Iterator <Edge<E>> it = G.incidentEdges(v).iterator();
			while (!encontre && it.hasNext()) {
				Edge<E> e = it.next();
				Vertex<V> w = G.opposite(v, e);
				encontre = hallarCaminoAux (G, w, v, ciclo);
			}
		} catch (InvalidVertexException | InvalidEdgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

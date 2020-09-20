package grafodirigidonopesado;

public class testerGrafo {
	
	public static void main (String [] args) {
		GrafoDirigidoNoPesado g = new GrafoDirigidoNoPesado();
		System.out.println("INICIO TESTEO DE LOGGER Y MENSAJES DE TIPO INFO Y WARNING.");
		System.out.println("------------------------------------------------------------------");
		g.addNode(12);
		g.addNode(14);
		g.addEdge(12, 14);
		g.addEdge(13, 15);
		g.removeEdge(12, 14);
		g.removeNode(12);
		g.removeNode(14);
		g.removeNode(16);
		System.out.println("------------------------------------------------------------------");
		System.out.println("FIN DEL TESTEO.");
	}
}

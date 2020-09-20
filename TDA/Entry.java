package TDA;

/**
 *  Interfaz para la implementacion de una entrada, una entrada es un par K,V donde se guardan 'llaves' y con estas 
 *  se accede a 'valores'
 * @author HP
 *
 * @param <K>
 * @param <V>
 */
public interface Entry<K, V> {
	
	/**
	 * Metodo para conseguir la llave k en la entrada 
	 * @return K llave
	 */
	public K getKey();
	
	/**
	 * Metodo para conseguir el valor en la entrada 
	 * @return V valor
	 */
	public V getValue ();
	
	/**
	 * Metodo que muestra por consola los contenidos de la entrada y los devuelve en una cadena
	 * @return String cadena conteniendo los datos contenidos en la entrada
	 */
	public String toString ();
}

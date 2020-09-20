package TDA;

import EXCEPTIONS.InvalidKeyException;

public interface Map<K, V> extends java.lang.Iterable<Entry<K,V>> {
	
	/**
	 * metodo para conocer la cantidad de elementos en el mapeo
	 * @return int tamaño del mapeo
	 */
	public int size();
	
	/**
	 * metodo para conocer si el mapeo es vacio o no 
	 * @return boolean, true si el mapeo es vacio, false en caso contrario
	 */
	public boolean isEmpty();
	
	/**
	 * metodo para obtener el valor V asociado a una llave K
	 * @param key llave a buscar
	 * @return V valor si existe la llave K en el mapeo, null en caso contrario
	 */
	public V get (K key) throws InvalidKeyException;
	
	/**
	 * Si el mapeo no tiene una entrada con clave key, inserta una entrada con clave key y valor value en el mapeo y devuelve null. 
	 * Si el mapeo ya tiene una entrada con clave key, entonces remplaza su valor y retorna el viejo valor. 
	 * @param key Clave de la entrada a crear. 
	 * @param value Valor de la entrada a crear. 
	 * @return Valor de la vieja entrada. 
	 * @throws InvalidKeyException si la clave pasada por parámetro es inválida. 
	 */
	public V put (K key, V value) throws InvalidKeyException;
	
	/**
	 * metodo para remover una entrada con elemento key de tipo K del mapoe
	 * @param key llave a buscar en el mapeo
	 * @return V valor asociado a la llave K eliminada, null si la llave no pertenecia al mapeo
	 */
	public V remove (K key) throws InvalidKeyException;
	
	/**
	 * metodo para conseguir una coleccion de llaves
	 * @return Iterable<K> coleccion de llaves
	 */
	public Iterable<K> keys ();
	
	/**
	 * metodo para conseguir una coleccion de valores
	 * @return Iterable<V> coleccion de valores
	 */
	public Iterable <V> values();
	
	/**
	 * metodo para conseguir una coleccion de entradas
	 * @return Iterable<Entry<K,V>> coleccion de entradas
	 */
	public Iterable<Entry<K,V>> entries ();
}

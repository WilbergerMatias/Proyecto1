package TDA;

import EXCEPTIONS.InvalidKeyException;
import EXCEPTIONS.NonExistentEntryException;

public interface Dictionary<K, V> extends java.lang.Iterable<Entry<K,V>>{
	
	/**
	 * metodo para conocer la cantidad de elementos en el diccionario
	 * @return int tamaño del mapeo
	 */
	public int size();
	
	/**
	 * metodo para conocer si el diccionario es vacio o no 
	 * @return boolean, true si el diccionario es vacio, false en caso contrario
	 */
	public boolean isEmpty();
	
	/**
	 * metodo para obtener un valor V asociado a una llave K perteneciente al diccionario
	 * @param key llave a buscar
	 * @return Entry<K,V> entrada con llave k y valor v perteneciente al diccionario, null si no hay llave k en el diccionario
	 */
	public Entry<K,V> find (K key) throws InvalidKeyException;
	
	/**
	 * metodo para obtener todos los valores V asociados a la llave K
	 * @param key llave a buscar
	 * @return Iterable<V> coleccion de valores asociados a la llave K en el diccionario
	 * @throws InvalidKeyException
	 */
	public Iterable<Entry<K,V>> findAll (K key) throws InvalidKeyException;
	
	/**
	 * metodo para agregar una entrada con los elementos llave K, y valor V al diccionario
	 * @param key llave a agregar
	 * @param value valor a agregar
	 * @return Entry<K,V> entrada agregada
	 * @throws InvalidKeyException
	 */
	public Entry<K,V> insert (K key, V value) throws InvalidKeyException;
	
	/**
	 * metodo para remover una entrada e del diccionario
	 * @param key llave a buscar en el mapeo
	 * @return Entry<K,V> entrada eliminada
	 * @throws InvalidEntryException error si al entrada no pertenece al diccionario
	 */
	public Entry<K,V> remove (Entry<K,V> e) throws NonExistentEntryException;
	
	/**
	 * metodo para conseguir una coleccion de entradas
	 * @return Iterable<Entry<K,V>> coleccion de entradas
	 */
	public Iterable<Entry<K,V>> entries ();
}
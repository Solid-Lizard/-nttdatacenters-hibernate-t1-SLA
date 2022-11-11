package com.persistence;

// IMPORTS //
import java.util.List;

/**
 * CommonDAOI - Interfaz común para el patrón DAO
 * 
 * @see com.persistence.CommonDAOImpl
 * 
 * @author Santiago
 *
 */
public interface CommonDAOI<T> {		
	// Métodos CRUD //
		
	/**
	 * create - Crea una entidad en la BBD
	 * 
	 * @param client - Entidad generada (El nombre del atributo se debe a que solo existe una tabla en la BDD)
	 * 
	 * @return true - Si la entidad se ha generado correctamente
	 */
	public boolean create(final T client);	
	
	/**
	 * read - Método sobrecargado - Devuelve una entidad con la misma ID
	 * 
	 * @param id - Id de la entidad
	 * 
	 * @return T - Entidad
	 * 
	 */
	public T read(int id);
		
	/**
	 * read - Método sobrecargado - Devuelve una lista de entidades con el mismo nombre
	 * 
	 * @param name
	 * 
	 * @return List - Lista de entidades
	 * 
	 */
	public List<T> read(String name);	
	
	/**
	 * read - Método sobrecargado - Devuelve una lista de entidades con el mismo nombre y apellido1
	 * 
	 * @param name
	 * @param surname1
	 * 
	 * @return List - Lista de entidades
	 * 
	 */
	public List<T> read(String name, String surname1);
	
	/**
	 * update - Actualiza los datos de una entidad en la BDD
	 * 
	 * @param client
	 * 
	 * @return boolean - True si los datos se han actualizado correctamente
	 * 
	 */
	public boolean update(final T client);
	
	/**
	 * delete - Elimina la entidad de la BDD
	 * 
	 * @param client
	 * 
	 * @return boolean - True si los datos se han eliminado correctamente
	 * 
	 */
	public boolean delete(final T client);
	
	// Otros métodos //
	
	/**
	 * searchAll - Devuelve una lista con todas las entidades de una tabla en la BDD
	 * 
	 * @return List
	 */
	public List<T> searchAll();
	
}

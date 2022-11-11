package com.persistence;

// IMPORTS //
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cliente - Mapeo de la entidad "Cliente" 
 * 
 * @implements Serializable
 * @author Santiago
 * @see {@link java.io.Serializable}
 */

/**
 * @author Solid Lizard
 *
 */
@Entity
@Table (name="Cliente")
public class Client implements Serializable{
	
	//Implements Serializable //
	private static final long serialVersionUID = 1L;	
	
	// Mapeo de los atributos //	
	/**
	 * Dni del cliente
	 */
    @Column(name = "DNI", length = 9, unique = true)     
	private String dni;	
	  
    /**
	 * Id del cliente
	 */
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")	
	private int id;
	
    /**
	 * Nombre del cliente
	 */
	@Column (name="Nombre")
	private String name;
	
	/**
	 * Apellido1 del cliente
	 */
	@Column (name="Apellido1")
	private String firstSurname;
	
	/**
	 * Apellido2 del cliente
	 */
	@Column (name="Apellido2")
	private String secondSurname;
	
	// Getters y Setters //		
	/**
	 * getDni - Devuelve el DNI del cliente
	 * @return String - dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * setDni - Asigna el DNI del cliente
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * getId - Asigna la ID del cliente
	 * @return int - id
	 */
	public int getId() {
		return id;
	}

	/**
	 * setId - Asigna la id del cliente
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getFirstSurname - Devuelve el apellido1 del cliente
	 * @return String - apellido1
	 */
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * setFirstSurname - Asigna el apellido1 del cliente del cliente
	 * @param firstSurname
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * getSecondSurname - Devuelve el apellido2 del cliente
	 * @return String - apellido2
	 */
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * setSecondSurname - Asigna el apellido2 del cliente del cliente
	 * @param secondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}	
	
	/**
	 * getName - Devuelve el nombre del cliente
	 * @return String - nombre
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName - Asigna el nombre del cliente
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	// toString //	
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", id=" + id + ", name=" + name + ", firstSurname=" + firstSurname
				+ ", secondSurname=" + secondSurname + "]";
	}		
	
}

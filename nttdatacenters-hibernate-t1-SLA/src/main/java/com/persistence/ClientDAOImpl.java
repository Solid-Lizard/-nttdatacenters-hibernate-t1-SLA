package com.persistence;

// IMPORTS //
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.services.SessionManager;

/**
 * ClientDAOImpl - Implementación DAO para la entidad "Cliente" de la interfaz ClientDAOI
 * 
 * 
 * @see com.persistence CommonDAOImpl
 * @see com.persistence.ClientDAOI
 * 
 * @author Santiago
 */
public class ClientDAOImpl extends CommonDAOImpl<Client> implements ClientDAOI{			

	// OBJETOS Y CONSTANTES //
	private static final String CLIENTE_DEVUELTO_OK = "Cliente/s buscado/s correctamente, cliente/s devuelto/s: {}";
		
	// Logger //
	private static final Logger LOG = LoggerFactory.getLogger(ClientDAOImpl.class);
	
	
	// MÉTODOS //
	
	/**
	 * ClientDAOImpl - Constructor, asigna el SessionManager
	 * @param sm
	 */
	public ClientDAOImpl(SessionManager sm) {
		super(sm);			
	}
	
	// Override Methods //
	
	// CRUD //
	@Override
	public boolean create(Client client) {
		LOG.debug("Insertando cliente: {}", client.getDni());
		
		if (super.create(client)) {			
			LOG.debug("Cliente insertado correctamente");
			return true;
			
		} else {
			LOG.error("Error al buscar al cliente");
			return false;
		}
			
	}

	@Override
	public List<Client> read(String name) {
		LOG.debug("Buscando cliente por nombre: {}", name);
		
		List<Client> c = super.read(name);
		
		StringBuilder mssg = new StringBuilder("");
		
		for (Client cli : c) {
			mssg.append(cli.getDni() + ", ");
		}
		
		LOG.debug (CLIENTE_DEVUELTO_OK, mssg);
		
		return c;
	}

	@Override
	public Client read(int id) {
		LOG.debug("Buscando cliente por ID: {}", id);
		
		Client c = super.read(id);
		
		LOG.debug (CLIENTE_DEVUELTO_OK, c.getDni());
		
		return c;
	}

	@Override
	public List<Client> read(String name, String surname1) {	
		LOG.debug("Buscando cliente por Nombre y Apellido1: {} {}", name, surname1);
		
		List<Client> c = super.read(name, surname1);
		
		StringBuilder mssg = new StringBuilder("");
		
		for (Client cli : c) {
			mssg.append(cli.getDni() + ", ");
		}
		
		LOG.debug(CLIENTE_DEVUELTO_OK, mssg);
		
		return c;
	}

	@Override
	public boolean update(Client client) {
		LOG.debug("Actualizando cliente: {}", client.getDni());
		
		if (super.update(client)) {
			LOG.debug("Cliente actualizado correctamente");
			return true;
			
		} else {
			LOG.debug("Error al actualizar el cliente");
			return false;
		}
		
	}

	@Override
	public boolean delete(Client client) {
		LOG.debug("Eliminando cliente: {}", client.getDni());
		
		if (super.delete(client)) {			
			LOG.debug("Cliente eliminado correctamente");	
			return true;
			
		} else {
			LOG.debug("Error al eliminar cliente}");
			return false;
		}
	}

	// Otros métodos //
	@Override
	public List<Client> searchAll() {
		LOG.debug("Obteniendo lista de clientes");
		
		List<Client> clientes = super.searchAll();
		
		LOG.debug("Lista de clientes obtenida satisfactoriamente: {}", clientes);
		
		return clientes;
	}		

}

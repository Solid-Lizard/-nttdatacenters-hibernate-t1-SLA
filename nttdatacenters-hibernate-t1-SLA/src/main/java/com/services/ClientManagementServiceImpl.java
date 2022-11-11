package com.services;

// IMPORTS // 
import java.util.List;
import com.persistence.Client;
import com.persistence.ClientDAOImpl;

/**
 * ClientManagementServiceImpl - Implementación de la entidad "ClientManagementServiceI" del servicio
 * para la entidad "Cliente"
 * 
 * <br>
 * <br>
 * 
 * Utiliza los métodos de ClientDAOImpl para realizar las operaciones CRUD con la entidad "Client" 
 * 
 * @author Santiago
 * 
 * @see com.persistence.Client
 * @see com.persistence.ClientDAOImpl
 * @see com.services.ClientManagementServiceI
 */
public class ClientManagementServiceImpl implements ClientManagementServiceI {
	
	// ClienteDAOImpl para utilizar sus métodos ya definidos
	private ClientDAOImpl clienteDAO;
	
	/**
	 * ClientManagementServiceImpl - Método constructor, asigna el ClientDAOImpl.
	 * 
	 * @param sm - SessionManager - SessionManager que se asigna al constructor de
	 * ClientDAOImpl
	 */
	public ClientManagementServiceImpl(SessionManager sm) {
		clienteDAO = new ClientDAOImpl(sm);
	}
	
	
	// Override Methods //
	@Override
	public boolean create(Client client) {	
		return clienteDAO.create(client);
	}

	@Override
	public Client read(int id) {
		return clienteDAO.read(id);
	}

	@Override
	public List<Client> read(String name) {
		return clienteDAO.read(name);
	}

	@Override
	public List<Client> read(String name, String surname1) {
		return clienteDAO.read(name, surname1);
	}

	@Override
	public boolean update(Client client) {
		return clienteDAO.update(client);
	}

	@Override
	public boolean delete(Client client) {
		return clienteDAO.delete(client);
	}

	@Override
	public List<Client> searchAll() {
		return clienteDAO.searchAll();			
	}

}

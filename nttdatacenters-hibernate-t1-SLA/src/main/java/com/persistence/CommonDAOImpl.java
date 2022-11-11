package com.persistence;

// IMPORTS // 
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.services.SessionManager;
import java.lang.reflect.ParameterizedType;

/**
 * Clase Abstracta - Implementación común de la interfaz CommonDAOI
 * 
 * @see com.persistence.CommonDAOI
 * 
 * @author Santiago
 */
public abstract class CommonDAOImpl <T> implements CommonDAOI<T>{	
	// PARAMETROS CONSTANTES //	
	// LOG //
	private static final Logger LOG = LoggerFactory.getLogger(CommonDAOImpl.class);
	
	// Parámetro repetido y que sonar nos aconseja extraer en una constante
	private static final String FROM = "FROM ";
	
	// Mensajes //
	private static final String LECTURA_SATISFACTORIA = "Lectura realizada satisfactoriamente";
	private static final String REALIZANDO_LECTURA = "Realizando lectura de entidad";

	/** 
	 * Session manager 
	 * @see {@link com.services.SessionManager}
	 */
	private final SessionManager sm;
	
	
	// Tipo de la clase	
	private Class<T> entityClass;			
		
	// MÉTODOS //
	/**
	 * CommonDAOImpl - Constructor de la clase, inicializa el objeto de tipo "SessionManager"
	 * 
	 * @param sm - SessionManager
	 * 
	 * @see {@link com.services.SessionManager}
	 */
	@SuppressWarnings("unchecked")
	protected CommonDAOImpl (SessionManager sm) {
		
		LOG.info("Inicializando SessionManager y Tipo de la clase");
		
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		LOG.info("Tipo de la clase inicializado satisfactoriamente");
		
		this.sm = sm;
		LOG.info("SessionManager inicializado satisfactoriamente");
	}
	
	// Métodos heredados //
	@Override
	public boolean create(T client) {					
		LOG.info("Iniciando creación de entidad");
		sm.checkTransaction();
		
		sm.getSession().save(client);				
		
		sm.getSession().flush();
				
		sm.commitTransaction();		
		
		LOG.info("Entidad creada satisfactoriamente");
						
		return true;															
	}

	@Override
	public List<T> read(String name) {
		LOG.info(REALIZANDO_LECTURA);
		
		sm.checkTransaction();
						
		@SuppressWarnings("unchecked")
		final List<T> matchesList = sm.getSession().createQuery(FROM + this.entityClass.getName() + " WHERE Nombre='" + name+"'").list();		
		
		LOG.info(LECTURA_SATISFACTORIA);
		
		return matchesList; 									
	}

	@Override
	public T read(int id) {	
		LOG.info(REALIZANDO_LECTURA);
		
		sm.checkTransaction();
		
		LOG.info(LECTURA_SATISFACTORIA);
		
		return sm.getSession().get(entityClass, id);		 								
	}

	@Override
	public List<T> read(String name, String surname1) {
		LOG.info(REALIZANDO_LECTURA);
		
		sm.checkTransaction();
		
		@SuppressWarnings("unchecked")
		final List<T> matchesList = sm.getSession().createQuery(FROM + this.entityClass.getName() + " WHERE Nombre='" + name + "' AND Apellido1='" + surname1 + "'").list();

		LOG.info(LECTURA_SATISFACTORIA);
		
		return matchesList; 	
	}
	

	@Override
	public boolean update(T client) {	
		LOG.info("Actualizando entidad");
		
		sm.checkTransaction();
		
		sm.getSession().saveOrUpdate(client);
		sm.commitTransaction();				
				
		LOG.info("Actualización de entidad realizada satisfactoriamente");
		
		return true;						
		
	}

	@Override
	public boolean delete(T client) {	

		LOG.info("Eliminando entidad");
		
		sm.checkTransaction();		
		
		sm.getSession().delete(client);
		sm.commitTransaction();		
		
		LOG.info("Entidad eliminada satisfactoriamente");
						
		return true;	
	}					
					
	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {
		LOG.info(REALIZANDO_LECTURA);
		
		sm.checkTransaction();
		
		LOG.info(LECTURA_SATISFACTORIA);
		
		return sm.getSession().createQuery(FROM + this.entityClass.getName()).list();
	}
	
	// Getters y Setters //
	/**
	 * getEntityClasss - Devuelve el tipo de la clase
	 * @return Class - Tipo de la clase 
	 * 
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * setEntityClasss - Asigna el tipo de la clase
	 * @param entityClass - Tipo de la clase 
	 * 
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}	
	
	
}

package com.nttdata.main;

// IMPORTS //
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.persistence.Client;
import com.services.ClientManagementServiceImpl;
import com.services.SessionManager;

/**
 * App - Clase principal de la aplicación
 * @author Santiago
 */
public class App {
	// PARAMETROS CONSTANTES //
	
	// Al ser parámetros repetidos, sonarLint nos da un aviso para extraer la expresión como
	// una constante y, posteriormente, hacer referencia a la misma
	private static final String ARREDONDO = "Arredondo";
	private static final String LOPEZ = "Lopez";	
	private static final String SANTIAGO = "Santiago";
	
	// OBJETOS //
		
	// LOG //
	private static final Logger LOG = LoggerFactory.getLogger(App.class);		
	
	// MÉTODOS //
	
	/**
	 * Main - Método de entrada a la aplicación
	 * @param args	 
	 */
	public static void main( String[] args ) {		
		
        LOG.debug("INICIO DE TRAZA");         
        
        // INICIO DE SESIÓN HIBERNATE //        
        LOG.debug("Iniciando sesion");
        
        SessionManager sm = new SessionManager();
    	sm.openSession();
                
    	LOG.debug("Sesión iniciada correctamente");
    	
        // GENERACIÓN DE CLIENTES //    	
    	LOG.debug("----------GENERACIÓN DE CLIENTES----------");
    	
    	// Cliente 1 //
        final Client c1 = new Client();
        c1.setDni("30259182z");
        c1.setName(SANTIAGO);
        c1.setFirstSurname(LOPEZ);
        c1.setSecondSurname(ARREDONDO);        
              
        LOG.debug("Cliente 1 generado correctamente");
        
        // Cliente 2 //
        final Client c2 = new Client();
        c2.setDni("30259182s");
        c2.setName(SANTIAGO);
        c2.setFirstSurname(ARREDONDO);
        c2.setSecondSurname(LOPEZ);  
        
        LOG.debug("Cliente 2 generado correctamente");
             
        // Cliente 3 //
        final Client c3 = new Client();               
        c3.setDni("12345678a");
        c3.setName("Peter");
        c3.setFirstSurname("Parker");
        c3.setSecondSurname("Spiderman"); 
        
        LOG.debug("Cliente 3 generado correctamente");
              
        // Cliente 4 //
        final Client c4 = new Client();               
        c4.setDni("87654321a");
        c4.setName("Bruce");
        c4.setFirstSurname("Wayne");
        c4.setSecondSurname("Batman"); 
        
        LOG.debug("Cliente 4 generado correctamente");
        LOG.debug("Clientes generados correctamente");                     
              
        // CONSUMIR SERVICIOS //
        
        // Inicializamos servicios //
        LOG.debug("----------INICIALIZANDO SERVICIOS----------");
        
        final ClientManagementServiceImpl clientManager = new ClientManagementServiceImpl(sm);
        
        LOG.debug("----------SERVICIOS INICIALIZADOS CORRECTAMENTE----------");
               
        // Consumimos servicios //
        
        // Create //
        LOG.debug("----------INICIANDO CREACIÓN DE CLIENTES----------");
        
        clientManager.create(c1);          
        clientManager.create(c2);   
        clientManager.create(c3);
        clientManager.create(c4);
        
        LOG.debug("----------CLIENTES CREADOS SATISFACTORIAMENTE----------");
        
        // Read //                
        LOG.debug("----------CONSUMIENDO SERVICIOS DE LECTURA DE CLIENTES----------");
        String mssg = clientManager.read(1).toString();        
        LOG.debug(mssg);
        
        mssg = clientManager.read(SANTIAGO).toString();
        LOG.debug(mssg);
                
        mssg = clientManager.read(SANTIAGO, "López").toString();
        LOG.debug(mssg);
               
        
        for (Client c: clientManager.searchAll()) {
        	mssg = c.toString();
        	
        }
        
        LOG.debug(mssg);
        
        LOG.debug("----------SERVICIOS DE LECTURA CONSUMIDOS SATISFACTORIAMENTE----------");
        
        // Update //                
        LOG.debug("----------CONSUMIENDO SERVICIOS DE ACTUALIZACIÓN DE CLIENTES----------");
        
        c2.setDni("28195230s");
        c2.setName("Tiago");
        c2.setFirstSurname("San");
        c2.setSecondSurname(LOPEZ);   
                  
        clientManager.update(c2);
        
        LOG.debug("----------SERVICIOS CONSUMIDOS SATISFACTORIAMENTE----------");
        
        // Delete //
        LOG.debug("----------CONSUMIENDO SERVICIOS DE BORRADO DE CLIENTES----------");
        
        clientManager.delete(c3);
        
        LOG.debug("----------SERVICIOS CONSUMIDOS SATISFACTORIAMENTE----------");
        
        // Cierre de sesión //
        LOG.debug("----------CERRANDO SESIÓN----------");
        
        sm.closeSession();
        
        LOG.debug("----------SESIÓN CERRADA SATISFACTORIAMENTE----------");        
        LOG.debug("----------FIN DE TRAZA----------");
        
        System.out.println("---------- PORFAVOR, CONSULTAR EL ARCHIVO ./LOGS/logs.log PARA OBSERVAR EL FLUJO DE LA APLICACIÓN----------");
    }
}

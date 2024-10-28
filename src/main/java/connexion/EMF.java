package connexion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/** 
 * Class to get a connection to the database
 * 
 * @author Renaud DIANA
 */
public final class EMF {
	
	public static EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("couture");

	//constructeur
    private EMF() {}

    //m�thodes
    public static EntityManagerFactory getEMF() {
        return emfInstance;
    }
    
    public static EntityManager getEM() {
        return emfInstance.createEntityManager();
    }
 
 /*	Create EntityManager in others classes
  * EntityManager em = EMF.get().createEntityManager();
  * try {
  *     // ... do stuff with em ...
  * } finally {
  *     em.close();
  * }
  */
}

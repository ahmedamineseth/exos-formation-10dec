package medical.m2i.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {

	private DbConnection() {
		// TODO Auto-generated constructor stub
	}
	
	 /** Instance unique non préinitialisée */
    private static EntityManager em = null;
    
    /** Point d'accès pour l'instance unique du singleton */
    public static synchronized EntityManager getInstance()
    {           
        if (em == null)
        {  
        	//System.out.println("je crée l'instance");
        	EntityManagerFactory emf = Persistence.createEntityManagerFactory("medical7");
			em = emf.createEntityManager();
        }
        //System.out.println("je récupère l'instance");
        return em;
    }

}


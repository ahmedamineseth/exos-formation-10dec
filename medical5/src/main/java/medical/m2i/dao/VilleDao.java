package medical.m2i.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import medical.m2i.model.Ville;

public class VilleDao {

	EntityManagerFactory emf;
	EntityManager em;

	public VilleDao() {
		super();
		em = DbConnection.getInstance();
	}

	public int registerVille(Ville patient) throws ClassNotFoundException {
		int id = 0;

		// Récupération d’une transaction
		EntityTransaction tx = em.getTransaction();
		// Début des modifications
		try {
			tx.begin();
			em.persist(patient);
			tx.commit();
			id = patient.getId();
		} catch (Exception e) {
			e.getStackTrace();
			tx.rollback();
		} finally {
			// em.close();
			// emf.close();
		}
		System.out.println("id du patient : " + id);
		return id;

	}

	public List<Ville> getVilles() throws ClassNotFoundException {
		return em.createQuery("from Ville").getResultList();
	}

	public List<Ville> getVillesByPays(String pays) throws ClassNotFoundException {
		return em.createNamedQuery("Ville.findByPaysName", Ville.class).setParameter("name", pays).getResultList();
	}

}

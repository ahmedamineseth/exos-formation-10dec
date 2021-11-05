package medical.m2i.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import medical.m2i.model.Ville;

public class VilleDao {

	EntityManagerFactory emf;
	EntityManager em;

	public VilleDao() {
		super();
		em = DbConnection.getInstance();
	}

	public List<Ville> getVilles() throws ClassNotFoundException {
		return em.createQuery("from Ville").getResultList();
	}
	
	public List<Ville> getVillesByPays( String pays ) throws ClassNotFoundException {
		return em.createNamedQuery("Ville.findByPaysName", Ville.class).setParameter("name", pays).getResultList(); 
	}

}

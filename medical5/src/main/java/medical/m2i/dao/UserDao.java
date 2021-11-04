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

import medical.m2i.model.User;

public class UserDao {

	EntityManagerFactory emf;
	EntityManager em;

	public UserDao() {
		super();
		emf = Persistence.createEntityManagerFactory("medical7");
		em = emf.createEntityManager();

	}

	public List<User> getUsers() throws ClassNotFoundException {
		return em.createQuery("from User" , User.class).getResultList();
	}
	
	public List<User> getUsersByUsernameAndPassword( String pusername, String ppassword ) throws ClassNotFoundException {
		return em.createNamedQuery("User.findByUsernameAndPassword", User.class)
				.setParameter("username", pusername)
				.setParameter("password", ppassword)
				.getResultList(); 
	}

}

package medical.m2i.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Patient {
	private int id;
	private String nom;
	private String prenom;
	private Date datenaissance;
	private String adresse;
	private String pays;
	private String ville;
	
	

	public Patient(int id, String nom, String prenom, Date datenaissance, String adresse, String pays, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.pays = pays;
		this.ville = ville;
	}

	public Patient(String nom, String prenom, Date datenaissance, String adresse, String pays, String ville) {
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.pays = pays;
		this.ville = ville;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getLocalDatenaissance() {
		return datenaissance;
	}

	public void setLocalDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void savePatient() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical5?serverTimezone=UTC", "root",
				"");

		PreparedStatement stmt = con.prepareStatement(
				"INSERT INTO `patient` (`nom`, `prenom`, `datenaissance`, `adresse`, `ville`, `pays`) "
						+ "VALUES ( ? , ? , ? , ? , ? , ? ) ");

		stmt.setString(1, nom);
		stmt.setString(2, prenom);
		stmt.setDate(3, datenaissance);
		stmt.setString(4, adresse);
		stmt.setString(5, ville);
		stmt.setString(6, pays);

		stmt.executeUpdate();

	} 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Patient> getPatients() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");    
		Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/medical5?serverTimezone=UTC","root","");  
		
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from patient");  
		
		List<Patient> lp = new ArrayList<Patient>();
		
		Patient p;
		while(rs.next()) { 
			p = new Patient( rs.getInt("id") , rs.getString("nom") , rs.getString("prenom") , rs.getDate("datenaissance") , rs.getString("adresse") , rs.getString("pays") , rs.getString("ville") );
			lp.add(p);
		}
		
		con.close(); 
		
		return lp; 
	}

}

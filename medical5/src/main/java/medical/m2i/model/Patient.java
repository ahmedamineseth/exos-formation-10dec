/**
 * 
 */
package medical.m2i.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author DESGOUILLES Pierre
 *
 */
@Entity
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 150)
	private String nom;
	@Column(nullable = false, length = 150)
	private String prenom;
	@Column(nullable = false, name = "datenaissance", length = 150)
	private String naissance;
	@Column(nullable = false, length = 150)
	private String adresse;
	@Column(nullable = false, length = 150)
	private String pays;
	@Column(nullable = false, length = 150)
	private String ville;

	/**
	 * 
	 */
	public Patient() {
		super();
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param naissance
	 * @param adresse
	 * @param pays
	 * @param ville
	 */
	public Patient(Integer id, String nom, String prenom, String naissance, String adresse, String pays, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.adresse = adresse;
		this.pays = pays;
		this.ville = ville;
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param naissance
	 * @param adresse
	 * @param pays
	 * @param ville
	 */
	public Patient(String nom, String prenom, String naissance, String adresse, String pays, String ville) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.adresse = adresse;
		this.pays = pays;
		this.ville = ville;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the naissance
	 */
	public String getNaissance() {
		return naissance;
	}

	/**
	 * @param naissance the naissance to set
	 */
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
}

package medical.m2i.beans;

import java.io.Serializable;
import java.util.List;

import medical.m2i.dao.VilleDao;
import medical.m2i.model.Ville;

//@ManagedBean
//@SessionScoped
public class VillesBean implements Serializable {
	// villesBean

	/**
	 * 
	 */
	private static final long serialVersionUID = 4356685251785460886L;

	private List<Ville> listeVilles;
	private Ville ville;

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Ville> getListeVilles() {
		return listeVilles;
	}

	public void setListeVilles(List<Ville> listeVilles) {
		this.listeVilles = listeVilles;
	}

	public VillesBean() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		VilleDao vdao = new VilleDao();
		listeVilles = vdao.getVilles();

		ville = new Ville();
		System.out.println("Je suis dans init bean ville , taille de la liste = " + listeVilles.size());
	}

	public String saveVille() throws ClassNotFoundException {
		VilleDao vdao = new VilleDao();
		ville.setCode_postal(8888);
		vdao.registerVille(ville);
		// System.out.println(ville.getNom());
		return "/done.xhtml?faces-redirect=true";
	}

}

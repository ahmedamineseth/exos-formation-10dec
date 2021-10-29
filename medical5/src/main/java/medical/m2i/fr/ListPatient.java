package medical.m2i.fr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.model.Patient;

/**
 * Servlet implementation class ListPatient
 */
@WebServlet("/listpatient")
public class ListPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Patient pliste = new Patient();
		
		
		response.setContentType(" text / html ");
		PrintWriter out = response.getWriter();
		out.println("<html ><head><meta charset=\"UTF-8\"><title>Liste des patients</title></head>");
		// Charger la liste des patients
		out.println("<body>");
		
		out.println("<h1>Liste des patients</h1>");
		
		out.println("<table class='table' border='1'>");
		out.println("<tr>");
		out.println("<td>ID</td><td>Nom & prénom</td><td>Date de naissance</td><td>Adresse</td><td>Ville</td><td>Pays</td>");
		out.println("</tr>");
		
		try {
			for( Patient p : pliste.getPatients() ) {
				out.println("<tr>");
				out.println("<td>"+p.getId() + "</td><td>"+p.getNom() + " "+p.getPrenom()+"</td><td>"+p.getLocalDatenaissance()+"</td><td>"+p.getAdresse()+"</td><td>"+p.getVille()+"</td><td>"+p.getPays()+"</td>");
				out.println("</tr>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		out.println("</table>");
		
		out.println("</body>");
		
		out.println("</html>");
	}

}

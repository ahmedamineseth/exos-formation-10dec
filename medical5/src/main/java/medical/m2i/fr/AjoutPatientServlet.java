package medical.m2i.fr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.model.Patient;

/**
 * Servlet implementation class Test
 */
@WebServlet("/addpatient")
public class AjoutPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutPatientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Je suis bien dans la méthode post");

		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String datenaissance = request.getParameter("datenaissance");
		String adresse = request.getParameter("adresse");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");

		response.setContentType(" text / html ");
		PrintWriter out = response.getWriter();
		out.println("<html ><head><meta charset=\"UTF-8\"></head>");
		out.println("<body >");
		out.println("<h1 > Bonjour " + prenom + " " + nom + " ! </h1 >");
		out.println("<p>Vous êtes né le : "+datenaissance+"</p>"); // la date de naissance
		out.println("<p>Votre adresse est : "+adresse+" , "+ville+" "+pays+"</p>"); // à la place des **** : adresse + pays + ville
		out.println(" </body >");
		out.println(" </html >");
		
		try {
			saveData( prenom , nom , datenaissance , adresse , pays, ville );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void saveData( String prenom , String nom ,String datenaissance ,String adresse ,String pays,String ville ) throws Exception, SQLException {
		Patient p = new Patient( prenom , nom , Date.valueOf(datenaissance) , adresse , pays, ville );
		p.savePatient();
	}


}

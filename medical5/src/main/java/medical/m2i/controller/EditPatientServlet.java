package medical.m2i.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.dao.PatientDao;
import medical.m2i.model.Patient;

/**
 * Servlet implementation class EditPatientServlet
 */
@WebServlet("/edit")
public class EditPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PatientDao patientDao = new PatientDao();
		System.out.println( "ok dans edit patient" );
		Patient p = patientDao.getPatient( id );
		
		request.setAttribute("patientparam" ,  p); 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/patientedit.jsp");
		dispatcher.forward(request, response);

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les infos soumises
		
		System.out.println("Je suis bien dans la méthode post");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String naissance = request.getParameter("naissance");
		String adresse = request.getParameter("adresse");
		String pays = request.getParameter("pays");
		String ville = request.getParameter("ville");
		
		int id = Integer.parseInt( request.getParameter("id") );
		
		// Mettre à jour le patient en question 
		PatientDao patientDao = new PatientDao();
		System.out.println( "ok dans edit patient zz" + id );
		patientDao.editPatient( id , nom, prenom, naissance, adresse );
		
	}

}

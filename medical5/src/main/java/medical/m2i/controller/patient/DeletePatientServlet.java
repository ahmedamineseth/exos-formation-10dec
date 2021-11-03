package medical.m2i.controller.patient;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.dao.PatientDao;
import medical.m2i.model.Patient;

/**
 * Servlet implementation class DeletePatientServlet
 */
@WebServlet("/delete")
public class DeletePatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		//delete?id=valeur
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PatientDao patientDao = new PatientDao();
		System.out.println( "ok dans supprimer patient" );
		patientDao.deletePatient( id );
		
		response.sendRedirect(request.getContextPath() + "/ListPatientServlet");
		
	}

}

package medical.m2i.fr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		
		List<Patient> pl;
		try {
			pl = pliste.getPatients();
			request.setAttribute("listepatient", pl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		getServletContext().getRequestDispatcher("/listepatient.jsp").forward(request, response);
		
	}

}

package medical.m2i.controller.ville;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import medical.m2i.dao.PatientDao;
import medical.m2i.dao.VilleDao;

/**
 * Servlet implementation class VillesAjaxServlet
 */
@WebServlet("/villeajax")
public class VillesAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VillesAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String villeParam = request.getParameter("pays");
		
		VilleDao villeDao = new VilleDao();
		System.out.println( "ok dans get villes en ajax" );
		try {
			List lv = villeDao.getVilles();
			request.setAttribute("listeville", lv); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/villesajax.jsp");
		dispatcher.forward(request, response);
		
	}

}

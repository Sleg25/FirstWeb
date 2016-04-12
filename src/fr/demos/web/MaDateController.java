package fr.demos.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class MaDate
 */
@WebServlet("/MaDateController")
public class MaDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MaDateController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//d représente le model
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String s = sdf.format(d);
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH 'h' : mm 'min': ss 's'");
		String h = sdf1.format(d);
		Climatisation clim1 = new Climatisation(23, 30, "salle 204");
		
		//transfert du model
		request.setAttribute("dateDuJour", s);
		request.setAttribute("heure", h);
		request.setAttribute("clim1", clim1);
		
		//04/04/2016
		//Il est 14 heures 33 minutes
		
		// Appeler la vue
		RequestDispatcher rd = request.getRequestDispatcher("/madateview.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package fr.demos.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.FileClimatisationDAO;
import fr.demos.data.SQLClimasationDAO;

/**
 * Servlet implementation class NombreClimatisationsController
 */
@WebServlet("/NombreClimatisationsController")
public class NombreClimatisationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NombreClimatisationsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ClimatisationDAO dao = null;
		try {
			dao = new SQLClimasationDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nombreClimatiseurs = dao.nombreClimatisation("");
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain;charset=UTF-8");// Pour afficher le "é" dans le bon format dans le message
		out.println("Il y a " + nombreClimatiseurs + " climatisations enregistrées.");
//		request.setAttribute("nb", nombreClimatiseurs);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

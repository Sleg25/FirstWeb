package fr.demos.web;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.FileClimatisationDAO;
import fr.demos.data.SQLClimasationDAO;
import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class ListeController
 */
@WebServlet("/ListeController")
public class ListeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		RequestDispatcher rd = request.getRequestDispatcher("/ListeClimatisation.jsp");
		request.setCharacterEncoding("UTF-8");
		
		List<Climatisation> listeClimatiseurs = null;
		
		try {
			ClimatisationDAO dao = new SQLClimasationDAO();
			listeClimatiseurs = dao.rechercheTout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("rechercheToutErreur", e.getMessage());
		}
		
		request.setAttribute("listeClimatiseurs", listeClimatiseurs);
		
		rd.forward(request, response);
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package fr.demos.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.SQLClimasationDAO;
import fr.demos.formation.Climatisation;

/**
 * Servlet implementation class ClimatisationController
 */
@WebServlet("/ClimatisationController")
public class ClimatisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClimatisationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = request.getRequestDispatcher("/saisieClimatisation.jsp");
		rd.forward(request, response);
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//ArrayList<String> erreurs = new ArrayList<>();
		//request.setAttribute("erreurs", erreurs);
		Boolean erreur = false;
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd1 = request.getRequestDispatcher("/saisieClimatisation.jsp");
		
		String action = request.getParameter("valider");
		if (action != null && action.equals("Enregistrer")){
			String getName = request.getParameter("nom");
			String getTemperature = request.getParameter("temperature");
			String getPressure = request.getParameter("pression");
			String getHumidite = request.getParameter("tauxHumidite");
			
			request.setAttribute("nom", getName);
			request.setAttribute("temperature", getTemperature);
			request.setAttribute("pression", getPressure);
			request.setAttribute("tauxHumidite", getHumidite);
			
			double	temp = 0;
			double pres = 0;
			int taux = 0;

			
			try {
				temp = Integer.parseInt(getTemperature);
			} catch (NumberFormatException ex){				
					erreur = true;
					request.setAttribute("temperatureErreur", "nombre incorrect");
			}
				
			try{
				pres = Integer.parseInt(getPressure);
			} catch (NumberFormatException ex){
					erreur = true;
					request.setAttribute("pressionErreur", "nombre incorrect");
			}
				
			try{
				taux = Integer.parseInt(getHumidite);
			} catch (NumberFormatException ex){
				erreur = true;
				request.setAttribute("humiditeErreur", "nombre incorrect");
			}

			if(getName == null || getName.equals("")){
				erreur = true;
				request.setAttribute("nomErreur", "Il faut donner le nom de l'appareil");
			}
			
				
			if(!erreur){
				Climatisation clim1 = new Climatisation(temp, pres, getName);
				
				try {
					ClimatisationDAO dao = new SQLClimasationDAO();
					dao.sauve(clim1);
					rd1 = request.getRequestDispatcher("/SuccessClimatisation.jsp");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("SauvegardeErreur", e.getMessage());
					rd1 = request.getRequestDispatcher("/saisieClimatisation.jsp");
				}
			}	
		}
		rd1.forward(request, response);
	}
		//doGet(request, response);
}



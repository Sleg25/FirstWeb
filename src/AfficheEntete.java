

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficheEntete
 */
@WebServlet("/AfficheEntete")
public class AfficheEntete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheEntete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		Enumeration<String> nomsEntete = request.getHeaderNames();
		
		
		//objectfif affiche le nom de chaque entete et sa valeur
		
		
		try {
		out.println("<html>");
		out.println("<head>");
		out.println("<title> NomEnetete</title>");
		out.println("</head>");
		out.println("<body>");
		while(nomsEntete.hasMoreElements()){
			
			String nom = nomsEntete.nextElement();
			out.println(nom +" : " + request.getHeader(nom));
			out.println("<br>");
		}
		out.println("</body>");
		out.println("</html>");
		}
		finally {
		out.close(); }
		
		
		
		
	
		
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

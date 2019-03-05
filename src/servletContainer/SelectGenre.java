package servletContainer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Endpoint3
 */
@WebServlet("/Endpoint3")
public class SelectGenre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectGenre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(servletResponse(request));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String servletResponse(HttpServletRequest t) {
        String response;
        response = "<html lang=\"en\"><head><meta charset=\"UTF-8\"><title>Library</title></head><body><center><h1>Select the genre you are interested in:</h1><form method=\"GET\" action=\"DisplayBooks\"><br><input type=\"radio\" name=\"genre\" value=\"fantasy\" checked>FANTASY<br><input type=\"radio\" name=\"genre\" value=\"mystery\">MYSTERY<br><input type=\"radio\" name=\"genre\" value=\"fiction\">FICTION<br><br><input type=\"submit\" value=\"Display Books\"></form><br><p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></center></body></html>";
		return response;
	}
}

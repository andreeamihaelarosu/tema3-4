package servletContainer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		 String response = "";
	        response = "<html><body><h2>Please enter your login details below:</h2>\r\n" + 
	        		"<form method=\"POST\" action=\"LoginMsg\">\r\n" + 
	        		"  <br>Email:<br><input type=\"text\" name=\"email\" value=\"andreea.rosu@hartehanks.com\">\r\n" + 
	        		"  <br><br>Password:<br><input type=\"password\" name=\"pswd\" value=\"pswd987654\">\r\n" +
	        		"  <br><br>\r\n" + 
	        		"  <input type=\"submit\" value=\"Login\">\r\n" + 
	        		"</form><br><p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></body></html>";
		return response;
	}
}

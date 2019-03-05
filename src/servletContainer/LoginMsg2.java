package servletContainer;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginMsg2
 */
@WebServlet("/LoginMsg2")
public class LoginMsg2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMsg2() {
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
		response = "<html><body><h2>Login successful</h2><h3>What would you like to do today?</h3>"
			  		+ "<form action=\"question1.html\" method=\"POST\"><input type=\"submit\" value=\"English Quiz\"></form>"
					+ "<form action=\"pref1.html\" method=\"POST\"><input type=\"submit\" value=\"Choose car  \"></form>"
					+ "<form action=\"newCar.html\" method=\"POST\"><input type=\"submit\" value=\"Add car        \"></form>"
			  		+ "<br><br><p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></body></html>";
		
		return response;
	}
}

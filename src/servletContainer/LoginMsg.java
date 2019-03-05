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
 * Servlet implementation class LoginMsg
 */
@WebServlet("/LoginMsg")
public class LoginMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMsg() {
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
	    DBConnection db = new DBConnection();
		try {
		  //System.out.println("Email: " + t.getParameter("email") + " pswd: "+ t.getParameter("pswd"));
		  Class.forName("com.mysql.cj.jdbc.Driver");
	 	  db.setConn(DriverManager.getConnection("jdbc:mysql://localhost:3306/javacourse","root",""));
	 	  if (db.getConn().isValid(10)) {
	 		  System.out.println("Connected to MySQL 'javacourse' database");
	 		  } else {
	 			  System.out.println("Connection to MySQL 'javacourse' database has failed");
	 			  }
	 	  Statement statement = db.getConn().createStatement();
	 	  ResultSet rs = statement.executeQuery("Select * from users where email=\""+t.getParameter("email")+"\"");
	 	  while(rs.next()) {
	 		  //System.out.println(rs.getString("password"));
	 		  if (rs.getString("password").equals(t.getParameter("pswd"))) {
	 			  response = "<html><body><h3>Login successful</h3><br>"
	 			  		+ "<form action=\"question1.html\" method=\"POST\"><input type=\"submit\" value=\"Try Quiz\"></form>"
	 			  		+ "<br><br><p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></body></html>";
	 			  break;
	 		  } else {
	 			 response = "<html><body><h3>Login denied</h3><br><br><p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></body></html>";
	 			 db.closeConn();
	 			 break;
	 		  }
	 	  }
	 	  db.closeConn();
	    } catch(Exception sqle) {
	     	   sqle.printStackTrace();
	     	   System.err.println("Error with connection: " + sqle);
	     	   System.out.println("Connection to MySQL 'javacourse' database has failed");
	    }
	
		return response;
	}

}

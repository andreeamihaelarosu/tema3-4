package servletContainer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Endpoint2
 */
@WebServlet("/Endpoint1")
public class Endpoint1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	//private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Endpoint1() {
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
		String URI = "";
		String response = "";
		if(t.getQueryString() == null) {
			response = "<html><body><h1>Welcome to my simple server! </h1><p>1. <a href=\"http://localhost:8080/AR_WebApp/SelectGenre\">Get available books </a> by genre.</p><p>2. <a href=\"http://localhost:8080/AR_WebApp/TableParams\">Display parameters</a> in table.</p><p>3. <a href=\"http://localhost:8080/AR_WebApp/ExportParams\">Export parameters</a> to a txt file.</p>4. <a href=\"http://localhost:8080/AR_WebApp/DatabaseOps\">Database Operations</a></p><br><br>"
					+ "<form action=\"Login\" method=\"POST\"><input type=\"submit\" value=\"Login\"></form></body></html>";
		}
		else {
			URI = t.getQueryString();
			response = "<html><body><h1>Welcome to my simple server! </h1><p>1. <a href=\"http://localhost:8080/AR_WebApp/SelectGenre\">Get available books </a> by genre.</p><p>2. <a href=\"http://localhost:8080/AR_WebApp/TableParams?"+URI+"\">Display parameters</a> in table.</p><p>3. <a href=\"http://localhost:8080/AR_WebApp/ExportParams/?"+URI+"\">Export parameters</a> to a txt file.</p><p>4. <a href=\"http://localhost:8080/AR_WebApp/DatabaseOps\">Database Operations</a></p><br><br>"
					+ "<form action=\"Login\" method=\"POST\"><input type=\"submit\" value=\"Login\"></form></body></html>";
		}
		return response;
	}
	
	public ArrayList<String[]> selectToHtml(String dbTable) throws Exception {
		ArrayList<String[]> table = new ArrayList<String[]>();
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select * from " + dbTable);
		while (resultSet.next()) {
			String id = "" + resultSet.getInt("id");
			String sal = "" + resultSet.getString("salutation");
			String fname = resultSet.getString("firstname").replace("+", " ");
			String lname = resultSet.getString("lastname").replace("+", " ");
			String email = resultSet.getString("email");
			String pswd = resultSet.getString("password");
			String[] row = {id, sal, fname, lname, email, pswd};
			table.add(row);
		}
		resultSet.close();
		return table; 
	}
	
	//generate html of table with params
		public String getHtmlTable(ArrayList<String[]> m) {
			String link = "<html><body><table style=\"width:40%\" border=\"1px solid black\"><tr><th>ID</th><th>Name</th><th>Email</th><th>Phone no</th></tr>";
			for (String[] entry: m)
			{
				link = link + "<tr><td>" + entry[0] + "</td><td>"+ entry[1]+ "</td><td>" + entry[2] + "</td><td>" + entry[3] + "</td></tr>";
			}
			link = link + "</table></body></html>";
			
			return link;
		}
}

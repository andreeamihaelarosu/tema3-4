package servletContainer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TableParams
 */
@WebServlet("/TableParams")
public class TableParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableParams() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.getWriter().append(servletResponse(request));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String servletResponse(HttpServletRequest t) throws SQLException {
		String response;
		if (t.getQueryString() == null) { 
			response = "<html><body><h3>There are no parameters to display</h3>" + 
    				"<p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></body></html>";
	    }
	        else {
	        	String URI = t.getQueryString(); 
	        	System.out.println(URI);
	        	Map<String, String> m = getQueryParameters(URI);
	        	response = "<html><body><h1>Table of params </h1>"+ getHtmlTable(m)+"<br><br><form action=\"DisplayParams?\" method=\"GET\">\r\n" + 
	        				"<p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></body></html>";
	        }		
        return response;
	}
	
	//generate a key/value Map
	public static Map<String, String> getQueryParameters(String queryString) {
	    
	    String[] parameters = queryString.split("&");
	    Map<String, String> queryParameters = new HashMap<String, String>();

	    for (String parameter : parameters) {
	        String[] keyValuePair = parameter.split("=");
	        System.out.println(parameter);
	        queryParameters.put(keyValuePair[0], keyValuePair[1]);
	        System.out.println("Your " + keyValuePair[0] +" is " + keyValuePair[1]);
	    }
	    return queryParameters;    
	}
	
	//generate html of table with params
	public static String getHtmlTable(Map<String,String> m) {
		
		String link = "<html><body><table style=\"width:25%\" border=\"1px solid black\"><tr><th>Key</th><th>Value</th></tr>";
		for (Map.Entry<String, String> entry : m.entrySet())
		{
			link = link + "<tr><td>" + entry.getKey() + "</td><td>"+ entry.getValue()+ "</td></tr>";
		}
		link = link + "</table></body></html>";
		
		return link;
	}
}

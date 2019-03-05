package servletContainer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExportParams
 */
@WebServlet("/ExportParams")
public class ExportParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportParams() {
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

	public String servletResponse(HttpServletRequest t) throws IOException {
		String response;
		if (t.getQueryString() == null) { 
			response = "<html><body><h3>There are no parameters to export</h3>" + 
    				"<p><a href=\"http://localhost:8080/AR_WebApp/\">Home</a></p></body></html>"; 
	    }
	        else {
	        	BufferedWriter bfwriter = new BufferedWriter(new FileWriter("C:\\Users\\andreea.rosu\\eclipse-workspace\\AR_WebApp\\misc\\smth.txt",true));    	
	    	    bfwriter.write(t.getQueryString()+"\n");        	
	    	    bfwriter.close();
	        	response = "<html><body><h3>Parameters have been exported to /AR_WebApp/misc/smth.txt </h3>" + 
	        				"<p><a href=\"http://localhost:8080/AR_WebApp/\">Home</a></p></body></html>";
	        }
		return response;
	}
}

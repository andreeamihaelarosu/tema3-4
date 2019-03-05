package servletContainer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayBooks
 */
@WebServlet("/DisplayBooks")
public class DisplayBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayBooks() {
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
        String bookGenre = t.getParameter("genre");
        BookService b = new BookService();

        switch (bookGenre) {
        case "fantasy":
        	response = "<html><body><h1>These are the available books: </h1><br>";
        	for(String book: b.getAvailableGenres(BookGenre.FANTASY)){
        		response+=book+"<br>";
        	}
        	response += "<br><p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></body></html>";
        	break;
        case "mystery":
        	response = "<html><body><h1>These are the available books: </h1><br>";
        	for(String book: b.getAvailableGenres(BookGenre.MYSTERY)){
        		response+=book+"<br>";
        	}
        	response += "<br><p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></body></html>";
        	break;
        case "fiction":
        	response = "<html><body><h1>These are the available books: </h1><br>";
        	for(String book: b.getAvailableGenres(BookGenre.FICTION)){
        		response+=book+"<br>";
        	}
        	response += "<br><p><a href=\"http://localhost:8080/AR_WebApp/api1\">Home</a></p></body></html>";
        	break;
        default:
        	response = "";
        	break;
        }
        return response;
	}
}

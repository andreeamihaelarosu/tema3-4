package servletContainer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewCar
 */
@WebServlet("/NewCar")
public class NewCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Get output").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String fuel = request.getParameter("fuel");
		String gear = request.getParameter("gear");
		String year = request.getParameter("year");
		String price = request.getParameter("price");
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("make", make);
		request.getSession().setAttribute("model", model);
		request.getSession().setAttribute("fuel", fuel);
		request.getSession().setAttribute("gear", gear);
		request.getSession().setAttribute("year", year);
		request.getSession().setAttribute("price", price);
		response.sendRedirect("/AR_WebApp/newCar.jsp");
	}

}

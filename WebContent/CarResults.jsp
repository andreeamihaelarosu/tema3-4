<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete the sentences:</title>
</head>
<body>

	<span> Your gear option is: <%= session.getAttribute("gear") %></span><br>
	<span> Your fuel option is: <%= session.getAttribute("fuel") %></span><br>
	<span> Your year option is: <%= session.getAttribute("year") %></span><br>
	<span> Your price option is: <%= session.getAttribute("price") %></span><br><br>
	
	<%@ page import="javax.servlet.http.HttpServlet"%>
	<%@ page import="servletContainer.DBConnection"%>
	<%@ page import="java.sql.DriverManager"%>
	<%@ page import="java.sql.ResultSet"%>
	<%@ page import="java.sql.Statement"%>
	
	<%
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
 	  String select,make,model;
      select = "Select * from cars "+
 			  "where fuel=\"" + session.getAttribute("fuel") + "\" " +
 			  "and gear=\"" + session.getAttribute("gear") + "\" " +
 			  " and year>=" + session.getAttribute("year")+
 			  " and price<=" + session.getAttribute("price");
 	  System.out.println(select);
 	  ResultSet rs = statement.executeQuery(select);
 	  if(!rs.next()){
 		 System.out.println("No Data Found");
 		 %> <h3> There are no available cars matching your criteria. </h3> 
 		 <%
 	  } else do {
 		 %>
 	 	  <h3>Available cars matching your preferences:</h3>
 	  	  <table style='width:40%' border='1px'><tr><th>ID</th><th>Producer</th><th>Model</th><th>Year</th><th>Price</th></tr><tr><td>  
 	 	  <tr><td><%= rs.getString("id") %></td>
 	 	  <td><%= rs.getString("make") %></td>
 	 	  <td><%= rs.getString("model") %></td>
 	 	  <td><%= rs.getString("year") %></td>
 	 	  <td><%= rs.getString("price") %></td></tr>
 	 	  </table><br>
 	 	  <% 		  
 	  } while(rs.next()) ; 	    
 	  
 	  db.closeConn();
      } catch(Exception sqle) {
     	   sqle.printStackTrace();
     	   System.err.println("Error with connection: " + sqle);
     	   System.out.println("Connection to MySQL 'javacourse' database has failed");
    }
	%>
	<button onclick = "window.location.href = '/AR_WebApp/pref1.html' "> Try again </button><br><br>
	<button onclick = "window.location.href = '/AR_WebApp/api1' "> Home </button>
			
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert results</title>
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
	<%@ page import="java.sql.PreparedStatement"%>
	<%@ page import="java.sql.SQLException"%>
	
	<h3>Available cars in the system:</h3>
 	  	  <table style='width:40%' border='1px'><tr><th>ID</th><th>Producer</th><th>Model</th><th>Gear</th><th>Fuel</th><th>Year</th><th>Price</th></tr><tr><td>  
	<%
	DBConnection db = new DBConnection();
	try {
	  Class.forName("com.mysql.cj.jdbc.Driver");
 	  db.setConn(DriverManager.getConnection("jdbc:mysql://localhost:3306/javacourse","root",""));
 	  if (db.getConn().isValid(10)) {
 		  System.out.println("Connected to MySQL 'javacourse' database");
 		  } else {
 			  System.out.println("Connection to MySQL 'javacourse' database has failed");
 			  }
 	  Statement statement = db.getConn().createStatement();
 	  PreparedStatement ps;
 	  String select,insert,make,model;
 	  select = "Select * from cars";
      insert = "insert into cars values(?,?,?,?,?,?,?)";
      ps = db.getConn().prepareStatement(insert);
      ps.setInt(1, 3);//(Integer) session.getAttribute("id"));
      ps.setString(2, "\""+session.getAttribute("make").toString() + "\"");
      ps.setString(3, "\""+session.getAttribute("model").toString() + "\"");
      ps.setString(4, "\""+session.getAttribute("gear").toString() + "\"");
      ps.setString(5, "\""+session.getAttribute("fuel").toString() + "\"");
      ps.setInt(6, 2015);// (Integer) session.getAttribute("year"));
      ps.setInt(7, 15000);//(Integer) session.getAttribute("price"));
      try {
			ps.executeUpdate();
			db.getConn().commit();
			ps.close();	
	  } catch (SQLException e) {
			String theError = e.getSQLState();
		    System.out.println( "Can't insert rows in table: " + theError );
		}
	  ResultSet rs = statement.executeQuery(select);
 	  if(!rs.next()){
 		 System.out.println("No Data Found");
 		 %> <h3> There are no available cars right meow. </h3> 
 		 <%
 	  } else do {
 		 %>
 	 	  <tr><td><%= rs.getString("id") %></td>
 	 	  <td><%= rs.getString("make") %></td>
 	 	  <td><%= rs.getString("model") %></td>
 	 	  <td><%= rs.getString("gear") %></td>
 	 	  <td><%= rs.getString("fuel") %></td>
 	 	  <td><%= rs.getString("year") %></td>
 	 	  <td><%= rs.getString("price") %></td></tr>
 	 	  <% 		  
 	  } while(rs.next()) ; 	    
 	  
 	  db.closeConn();
      } catch(Exception sqle) {
     	   sqle.printStackTrace();
     	   System.err.println("Error with connection: " + sqle);
     	   System.out.println("Connection to MySQL 'javacourse' database has failed");
    }
	%>
	</table><br>
	<button onclick = "window.location.href = '/AR_WebApp/newCar.html' "> Add new </button><br><br>
	<button onclick = "window.location.href = '/AR_WebApp/LoginMsg2' "> Home </button>
			
</body>
</html>
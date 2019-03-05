<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete the sentences:</title>
</head>
<body>

	<span> Your first answer was: <%= session.getAttribute("answer1") %></span>
	
	<% 
	if (session.getAttribute("answer1").equals("live")) {
	%>
	<span>. This is CORRECT. </span><br><br>
	<% } else { %>
	<span>. This is INCORRECT. The right answer is "live". </span><br><br>
	<% } %>
	
	<span> Your second answer was: <%= session.getAttribute("answer2") %></span>
	
	<% 
	if(session.getAttribute("answer2").equals("see"))
	{
	%> 	
	<span>. This is CORRECT. </span><br><br>	
	<% } else { %>
	<span>. This is INCORRECT. The right answer is "see". </span><br><br>
	<% } %>
	
	<% 
	if(session.getAttribute("answer2").equals("see")&&session.getAttribute("answer1").equals("live"))
	{
	%> 	
	<span> Your English grammar rocks. </span><br><br>	
	<% } else { %>
	<span> You need to practice more on your English grammar. </span><br><br>
	<button onclick = "window.location.href = '/AR_WebApp/question1.html' "> Try again </button><br><br>
	<% } %>
	
	<button onclick = "window.location.href = '/AR_WebApp/api1' "> Home </button>
			
</body>
</html>
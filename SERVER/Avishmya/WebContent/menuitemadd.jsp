<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% 
//String s=request.getParameter("type");
//String s="1";
//String s="sipusoumya8@gmail.com";
	out.print("<form action='webupdatemenu.jsp' method='post'><input type='submit' name='b' value='Back'></form>");
	out.print("<h3><center>ADD ITEM INTO MENU</center></h3><hr><marquee><b>Avishmya Restaurant Add Item</b></marquee><hr>");
	out.print("<form action=\"menuitemadd1.jsp\" method=\"post\"><h5>&nbsp&nbsp&nbsp&nbsp&nbspId: <input type=\"text\" name=\"id\" value=\"av\"></input><br><center>(eg. format av--)</center><br>Name: <input type=\"text\" name=\"name\"></input><br><br>&nbspPrice: <input type=\"number\" name=\"price\"min=\"1\" max=\"1000\"></input><br><br>&nbspType: <input list=\"browsers\" name=\"type\" /><datalist id=\"browsers\"><option value=\"starter\"><option value=\"Rice\"><option value=\"Non Veg\"><option value=\"Veg\"><option value=\"Dessert\"></datalist></h5><h5>Image: <input type=\"text\" name=\"image\"value=\"menu/av\"></input><br><center>(eg. format menu/av--.jpg)</center><br><input type=\"submit\" value=\"Add Item\"></input></h5></form>");

%>




</body>
</html>
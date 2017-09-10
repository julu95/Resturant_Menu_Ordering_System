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
String un=request.getParameter("user");
String psw=request.getParameter("pass");
if(un.equals("manager") && psw.equals("manager")){
	
	out.print("<iframe name=\"manager\" frameborder=\"0\" src=\"managermainhome.jsp\" height=\"650\" width=\"100%\"></iframe>");
	
}
else{
	out.print("incorrect username and password");
}
%>



</body>
</html>
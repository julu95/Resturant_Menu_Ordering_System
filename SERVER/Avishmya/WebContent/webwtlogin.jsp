<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link  href="boot/bootstrap.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/JQuery.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
<script>
function goBack() {
    window.history.back();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-image:url(images/bgr.jpg)">

<% 
String un=request.getParameter("userid");
String psw=request.getParameter("password");
if(un.trim().toCharArray().length!=0 && psw.trim().toCharArray().length!=0){
if(un.equals("waiter") && psw.equals("waiter")){

	out.print("<button onclick=\"goBack()\">Logout</button><div class=\"container\"><div class=\"row\"><div class=\"col-sm-8\"><iframe name=\"order\" frameborder=\"0\" src=\"forwttable.jsp\" height=\"400\" width=\"100%\"></iframe></div><div class=\"col-sm-4\"><iframe name='manager' frameborder='0' src='updatestatus.jsp' height='300' width='100%'></iframe></div></div></div>");

}
else{
	out.print("<h2><center>ORDER DETAILS</center></h2><hr><marquee><b>Avishmya Restaurant Waiter System</b></marquee><hr>");
	out.print("<h3><center>Plz Enter Correct username and password<br>");
	out.print("<form action='waiter.jsp' method='post'><input type='submit' name='b' value='Back'></form></center></h3>");
}
}
else{
	out.print("<h2><center>ORDER DETAILS</center></h2><hr><marquee><b>Avishmya Restaurant Waiter System</b></marquee><hr>");
	out.print("<h3><center>Plz fill all field<br>");
	out.print("<form action='waiter.jsp' method='post'><input type='submit' name='b' value='Back'></form></center></h3>");
}
	
	

%>



</body>
</html>
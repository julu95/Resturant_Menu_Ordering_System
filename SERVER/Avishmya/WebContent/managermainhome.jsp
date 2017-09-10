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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function goback(){
	window.history.back();
}</script>
</head>
<body style="background-image:url(images/bgr.jpg)">
<h3><center>MANAGER MANAGEMENT SYSTEM</center></h3><hr><marquee><b>Avishmya Restaurant Manager System</b></marquee><hr>


<div class="container">
		<div class="row">
			<div class="col-sm-8">
				<iframe name="order" frameborder="0" src="avltablests.jsp" height="450" width="100%"></iframe>							
			</div>
			<div class="col-sm-4">
			<center><form action="gen.jsp" method="post"><button type="submit" > Generating Login code </button></form><br>
			<form action="webmanlogin.jsp" method="post"><button type="submit" > Show Costomer Details </button></form><br>
			<form action="updtsts.jsp" method="post"><button type="submit"> Update Status </button></form><br>
			<form action="ourmenu.jsp" method="post"><button type="submit"> Show Menu </button></form><br>
			<form action='mng.jsp' method='post'><input type='submit' name='b' value='Logout'></form>
			</center>
			</div>
		</div>
	</div>
	

</body>
</html>
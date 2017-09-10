<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%out.print("<form action='webupdatemenu.jsp' method='post'><input type='submit' name='b' value='Back'></form>"); %>
<h3><center>EDIT ITEM FROM MENU</center></h3><hr><marquee><b>Avishmya Restaurant Update Item</b></marquee><hr>
	<center><form action="menuitemedit1.jsp" method="post">
	<h5>Id: <input type="text" name="id"><br><br>
	<input type="submit" value="Update Item"></input></h5>
	</form>
	</center>
</body>
</html>
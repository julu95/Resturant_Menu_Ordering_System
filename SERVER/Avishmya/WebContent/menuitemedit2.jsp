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
String id=request.getParameter("id");
String name=request.getParameter("name");
String price=request.getParameter("price");
String type=request.getParameter("type");
String img=request.getParameter("image");
//String s="1";
//String s="sipusoumya8@gmail.com";
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
		if(id.trim().toCharArray().length!=0 && name.trim().toCharArray().length!=0 && price.trim().toCharArray().length!=0 && type.trim().toCharArray().length!=0 && img.trim().toCharArray().length!=0 ){
			if(id.substring(0, 2).equals("av") && img.substring(0,7).equals("menu/av")){
	String str="";
	if(type.equals("starter")) str="1";
	else if(type.equals("Rice")) str="2";
	else if(type.equals("Non Veg")) str="3";
	else if(type.equals("Veg")) str="4";
	else str="5";
	String q="UPDATE avishmya SET name = ?,price=?,type=?,item_image=? where menuid=?";
	PreparedStatement pst;
	pst = con.prepareStatement(q);
	pst.setString(1, name);
	pst.setString(2, price);
	pst.setString(3, str);
	pst.setString(4, img);
	pst.setString(5, id);	
	int st=pst.executeUpdate();
		if(st==1)
		{
			out.print("<h3><center>UPDATE ITEM OF MENU</center></h3><hr><marquee><b>Avishmya Restaurant Update Item</b></marquee><hr>");
			out.print("<center><h3>sucessfully updated</h3><br><br>");
			out.print("<form action='menuitemedit.jsp' method='post'><input type='submit' name='b' value='Back'></form>");
		
	    }
			else{
				out.print("<h3><center>UPDATE ITEM OF MENU</center></h3><hr><marquee><b>Avishmya Restaurant Update Item</b></marquee><hr>");
				out.print("<center><h3>Plz enter Correct data</h3><br><br>");
				out.print("<form action='menuitemedit1.jsp' method='post'><input type='submit' name='b' value='Back'></form>");
			}
	}
	else{
		out.print("<h3><center>UPDATE ITEM OF MENU</center></h3><hr><marquee><b>Avishmya Restaurant Update Item</b></marquee><hr>");
		out.print("<center><h3>Plz fill correct format</h3><br><br>");
		out.print("<form action='menuitemedit1.jsp' method='post'><input type='submit' name='b' value='Back'></form>");
		}
	
	
	}
		else{
			out.print("<h3><center>UPDATE ITEM OF MENU</center></h3><hr><marquee><b>Avishmya Restaurant Update Item</b></marquee><hr>");
			out.print("<center><h3>Plz enter all field</h3><br><br>");
			out.print("<form action='menuitemedit1.jsp' method='post'><input type='submit' name='b' value='Back'></form>");
			}
}
catch(Exception e){
	out.print("<h3><center>UPDATE ITEM OF MENU</center></h3><hr><marquee><b>Avishmya Restaurant Update Item</b></marquee><hr>");
	out.print("<center><h3>"+e+"</h3><br><br>");
	out.print("<form action='menuitemedit.jsp' method='post'><input type='submit' name='b' value='Back'></form>");
}

%>
</body>
</html>
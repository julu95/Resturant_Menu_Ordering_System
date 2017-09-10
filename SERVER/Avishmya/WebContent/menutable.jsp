<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <META HTTP-EQUIV="refresh" CONTENT="10">-->
<title>Insert title here</title>
</head>
<body>
<% 
try {
	Statement st,stt,sttt;
	ResultSet rs,rss,rsss;
	String q,qq,qqq,kk,id,no;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	 q="select * from avishmya";
	 st=con.createStatement();
	 rs=st.executeQuery(q);
	out.print("<INPUT TYPE=\"button\" onClick=\"history.go(0)\" VALUE=\"Refresh\"><h2><center>MENU DETAILS</center></h2><hr><marquee><b>Avishmya Restaurant Menu</b></marquee><hr>");
	out.print("<left><table border='1'> <tr><th>ITEM-ID</th><th>PHOTO</th><th>NAME</th><th>PRICE</th><th>TYPE</th></tr>");
	while(rs.next())
	{
		kk="";
		if(rs.getString(4).equals("1")){
			kk="Starter";
		}
		else if(rs.getString(4).equals("2")){
			kk="Rice";
		}
		else if(rs.getString(4).equals("3")){
			kk="Non Veg";
		}
		else if(rs.getString(4).equals("4")){
			kk="Veg";
		}
		else if(rs.getString(4).equals("5")){
			kk="Desert";
		}
		
		out.print("<tr><th><center>"+rs.getString(1)+"</center></th><td><center><img src=\""+rs.getString(5)+"\" style=\"width:150px ;height:100px;\"></center></td><td><center>"+rs.getString(2)+"</center></td><td><center>"+rs.getString(3)+"</center></td><td><center>"+kk+"</center></td></tr>");
		
		
	}
	out.print("</table></left>");	
	//out.print("<form action=\"managermainhome.jsp\" method=\"post\"><input type=\"submit\" value=\" Back \"></input></h3></form>");
}
catch(Exception e){e.printStackTrace();out.print(e);}
%>



</body>
</html>
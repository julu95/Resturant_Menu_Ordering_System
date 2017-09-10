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
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="select seat from avishmyaadmin";
	String t="";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	String arr[];
	boolean b=false;
	while(rs.next())
	{
		if(b){
			t=t+",";
		}
			t=t+rs.getString(1);
			b=true;
		
	}
	
	arr=t.split(",");	
	out.print("<h3><center>TABLE STATUS</center></h3><hr><marquee><b>Avishmya Hotel Table Status</b></marquee><hr>");
	out.print("<h4>Total Seat : 60</h4>");
	out.print("<h4>Total Booked Seat :"+arr.length+" </h4>");
	out.print("<h4>Booked Seat List :"+t+" </h4>");
	out.print("<h4>Total Vaccant seat :"+(60-arr.length)+" </h4>");

	con.close();
}
catch(Exception e){e.printStackTrace();}
%>
</body>
</html>
<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String s=request.getParameter("type");
//String s="1";
//String s="sipusoumya8@gmail.com";
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="select * from avishmya where type=1";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	String str="";
	while(rs.next())
	{
		str=str+rs.getString(2)+"-----Rs."+rs.getString(3)+"=";
	}
	out.print(str);
	con.close();
	
}
catch(Exception e){e.printStackTrace();}

%>

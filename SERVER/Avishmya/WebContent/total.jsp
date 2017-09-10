<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String s=request.getParameter("code");
//String s="1";
//String s="sipusoumya8@gmail.com";
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="select total from avishmyaadmin where code='"+s+"'";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	int str=0;
	while(rs.next())
	{
		str=rs.getInt(1);
	}
	out.print(""+str);
	con.close();
	
}
catch(Exception e){e.printStackTrace();}

%>

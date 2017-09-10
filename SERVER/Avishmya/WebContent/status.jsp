<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String s=request.getParameter("code");
//String s="1234";
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="select status from avishmyaadmin where code='"+s+"'";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	String sk="";
	while(rs.next())
	{
		sk=rs.getString(1);
	}
	
 out.print(sk);
	
	
	///////////////////
	
	con.close();
	
}
catch(Exception e){e.printStackTrace();
out.print(e.toString());}

%>

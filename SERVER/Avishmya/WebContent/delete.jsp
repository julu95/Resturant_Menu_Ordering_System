<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String s=request.getParameter("code");
//String s="1234";
try {
	
	///////////////////
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	
	String q1="delete from avishmyaadmin where code=?";
	PreparedStatement pst;
	pst = con.prepareStatement(q1);
	pst.setString(1, s);
	int status=pst.executeUpdate();
	
	String q11="delete from avishmyaitemorder where code=?";
	PreparedStatement pst1;
	pst1 = con.prepareStatement(q11);
	pst1.setString(1, s);
	int statu2s=pst.executeUpdate();
	
	///////////////////
	
	con.close();
	
}
catch(Exception e){e.printStackTrace();}

%>

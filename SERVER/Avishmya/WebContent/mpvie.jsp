<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String s=request.getParameter("user");
String p=request.getParameter("pass");
//String s="1234";
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="select count(*) from movielogin where username='"+s+"'"+"and password='"+p+"'";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	int sk=0;
	while(rs.next())
	{
		sk=rs.getInt(1);
	}
	if(sk==1){
		out.print("true");
	}
	else out.print("flase");
	
	
	///////////////////
	
	con.close();
	
}
catch(Exception e){e.printStackTrace();}

%>

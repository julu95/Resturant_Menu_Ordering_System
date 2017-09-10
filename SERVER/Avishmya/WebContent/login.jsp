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
	
	String q="select * from avishmyalogin";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	int c=0;
	String sk="";
	while(rs.next())
	{
		sk=rs.getString(1);
		if(sk.equals(s.trim().toLowerCase())){c=1;break;};
	}
	
	if(c==1)out.print("true");
	else out.print("false");
	
	///////////////////
	
	String q1="delete from avishmyalogin where code=?";
	PreparedStatement pst;
	pst = con.prepareStatement(q1);
	pst.setString(1, sk);
	int status=pst.executeUpdate();
	
	///////////////////
	
	con.close();
	
}
catch(Exception e){e.printStackTrace();}

%>

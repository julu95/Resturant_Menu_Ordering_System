<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
String code=request.getParameter("scode");
String id=request.getParameter("id");
String no=request.getParameter("no");
Statement st;
ResultSet rs;
Connection con;
try {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="SELECT COUNT(*) FROM AVISHMYAITEMORDER WHERE code ='"+code+ "' AND item_id ='"+id+"'";
	 st=con.createStatement();
     rs=st.executeQuery(q);
	while(rs.next())
	{
		if(rs.getInt(1)==0&&!no.equals("0")){
			String qq="INSERT INTO AVISHMYAITEMORDER VALUES ('"+code+"','"+id+"','"+no+"')";
			st=con.createStatement();
			st.executeUpdate(qq);
		}
		else{
			if(no.equals("0")){
				String qqq="delete from AVISHMYAITEMORDER  WHERE code ='"+code+ "' AND item_id ='"+id+"'";
				st=con.createStatement();
				st.executeUpdate(qqq);
			}
			else{
			String qqq="update AVISHMYAITEMORDER  set NO_OF_ITEM='"+no+"' WHERE code ='"+code+ "' AND item_id ='"+id+"'";
			st=con.createStatement();
			st.executeUpdate(qqq);
			}
		}
	}
	out.print("ok");
	con.close();
	
}
catch(Exception e){e.printStackTrace();out.print(e);}

%>

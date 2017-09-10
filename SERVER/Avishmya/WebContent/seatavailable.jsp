<%@page import="java.io.PrintWriter"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
//String s=request.getParameter("type");
//String s="1";
//String s="sipusoumya8@gmail.com";
try {
	String a[]=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
	String ak[]=new String[20];
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String q="select * from avishmyaadmin";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	String str="";
	while(rs.next())
	{
		String k=rs.getString(3);
		for(int i=0;i<a.length;i++){
			if(a[i].equals(k)){
				a[i]="111";
			}
		}
	}
	for(int i=0;i<a.length;i++){
		if(!a[i].equals("111")){
			str=str+a[i]+"=";
			
		}
	}
	out.print(str);
	con.close();
	
}
catch(Exception e){e.printStackTrace();}

%>

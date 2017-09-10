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
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","7205290903");
	
	String a[]=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
	String q="select seat from avishmyaadmin";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(q);
	String str="";
	boolean b=false;
	while(rs.next())
	{
		if(b){str=str+",";}
		str=str+rs.getString(1);
		b=true;
	}
	
	String bookseat[]=str.split(",");
	for(int i=0;i<a.length;i++){
		for(int j=0;j<bookseat.length;j++){
			if(a[i].equals(bookseat[j])){
				a[i]="111";
			}
		}
	}
		
	String strr="";
	boolean l=false;
	for(int i=0;i<a.length;i++){
		if(a[i].equals("111")){
			if(l){strr=strr+"=";}
			strr=strr+(i+1);
			l=true;
		}
	}
	out.print(strr);
	con.close();
	
}
catch(Exception e){e.printStackTrace();}

%>
